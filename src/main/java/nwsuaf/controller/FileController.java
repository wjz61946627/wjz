package nwsuaf.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nwsuaf.model.MyFile;
import nwsuaf.service.FileService;
import nwsuaf.util.EnumFileType;
import nwsuaf.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @GetMapping("/index")
    public String index(Model model, int pid) {
        model.addAttribute("pid", pid);
        return "file";
    }

    @GetMapping("/show")
    public String show() {
        return "views";
    }

    /**
     * 读取一个文件
     */
    @GetMapping("/showpdf")
    public ResponseEntity<byte[]> showpdf(int fid) {
        MyFile file = fileService.readByFid(fid);
        String fileName = file.getFname();
        fileName = Utils.fileNameToPDF(fileName);
        return readFile(Utils.absolutePath(9, fileName), fileName);
    }

    private ResponseEntity<byte[]> readFile(String filePath, String fileName) {
        byte[] body = null;
        try {
            InputStream reader = new FileInputStream(filePath);
            body = new byte[reader.available()];
            reader.read(body);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 防止中文乱码
        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename=" + fileName);
        return new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
    }


    /**
     * 查询本项目下所有文件
     */
    @ResponseBody
    @GetMapping("/findByPid")
    public String findByPid(int pid) {
        List<MyFile> files = fileService.findByPid(pid);

        JsonArray result = new JsonArray();
        for (MyFile myFile : files) {
            result.add(Utils.objectToJson(myFile));
        }
        return result.toString();
    }

    /**
     * 读取一个文件
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(MyFile myFile) {
        myFile = fileService.readByFidPid(myFile);
        if (myFile == null) {
            return null;
        }
        return readFile(Utils.absolutePath(myFile.getPid(), myFile.getFname()), myFile.getFname());
    }

    /**
     * 删除单个文件
     */
    @ResponseBody
    @PostMapping("/deleteByPidFid")
    public String deleteByPidFid(MyFile myFile) {
        int success = fileService.deleteByPidFid(myFile);
        if (success > 0) {
            File fileTest = new File(Utils.absolutePath(myFile.getPid(), myFile.getFname()));
            if (fileTest.exists()) {
                fileTest.delete();
            }
        }

        JsonObject result = new JsonObject();
        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 检查文件名
     */
    @ResponseBody
    @GetMapping("/checkFileName")
    public String checkFileName(MyFile file) {
        JsonObject result = new JsonObject();
        result.addProperty(Utils.RESULT, Utils.FALSE);

        if (StringUtils.isBlank(file.getFname())) {
            result.addProperty(Utils.MSG, "文件名不可为空");
            return result.toString();
        }

        if (file.getFname().contains(" ")) {
            result.addProperty(Utils.MSG, "文件名不可包含空格");
            return result.toString();
        }

        File fileTemp = new File(Utils.absolutePath(file.getPid(), file.getFname()));
        if (fileTemp.exists()) {
            result.addProperty(Utils.MSG, "文件已存在");
            return result.toString();
        }

        int count = fileService.countByPidFname(file);
        if (count > 0) {
            result.addProperty(Utils.MSG, "文件已存在");
            return result.toString();
        }

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 上传一个文件
     */
    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("pid") int pid, @RequestParam("uid") int uid, @RequestParam("fileinput[]") MultipartFile fileinput, HttpServletRequest request) {
        // 文件类型不合法
        if (!EnumFileType.checkFileType(fileinput.getOriginalFilename())) {
            return "error";
        }

        String srcFilePath = Utils.absolutePath(pid, fileinput.getOriginalFilename());
        String pdfFilePath = Utils.absolutePath(pid, Utils.fileNameToPDF(fileinput.getOriginalFilename()));

        File srcFile = new File(srcFilePath);

        if (srcFile.exists()) {
            return "error";
        }

        try {

            if (!srcFile.getParentFile().exists()) {
                srcFile.getParentFile().mkdirs();
            }

            srcFile.createNewFile();


            fileinput.transferTo(srcFile);
            Utils.convertToPDF(srcFilePath, pdfFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

        MyFile myFile = new MyFile();
        myFile.setFname(fileinput.getOriginalFilename());
        myFile.setPid(pid);
        myFile.setUploadId(uid);
        myFile.init();

        fileService.insert(myFile);

        JsonObject result = new JsonObject();
        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }
}
