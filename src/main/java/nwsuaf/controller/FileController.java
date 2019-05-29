package nwsuaf.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import nwsuaf.model.MyFile;
import nwsuaf.service.FileService;
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
import java.io.*;
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

    @GetMapping("/world")
    public String index(Model model, HttpServletRequest request) {

        String path = request.getServletContext().getRealPath("");

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setServerPage(request.getContextPath() + "/poserver.zz");//设置服务页面
        poCtrl.addCustomToolButton("保存", "Save", 1);//添加自定义保存按钮
        poCtrl.addCustomToolButton("盖章", "AddSeal", 2);//添加自定义盖章按钮
        poCtrl.setSaveFilePage("save");//设置处理文件保存的请求方法
        //打开word
        poCtrl.webOpen("/Users/wangtong/workspace/9/test.docx", OpenModeType.docReadOnly, "张三");
        model.addAttribute("pageoffice", poCtrl.getHtmlCode("PageOfficeCtrl1"));

        return "world";
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

        byte[] body = null;
        try {
            InputStream reader = new FileInputStream(Utils.absolutePath(myFile.getPid(), myFile.getFname()));
            body = new byte[reader.available()];
            reader.read(body);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 防止中文乱码
        String fileName = myFile.getFname();
        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        HttpHeaders headers = new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename=" + fileName);


        return new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
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
        File fileTest = new File(Utils.absolutePath(pid, fileinput.getOriginalFilename()));
        try {
            if (!fileTest.exists()) {
                if (!fileTest.getParentFile().exists()) {
                    fileTest.getParentFile().mkdirs();
                }

                fileTest.createNewFile();
            }

            fileinput.transferTo(fileTest);
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
