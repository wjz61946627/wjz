package nwsuaf.controller;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 用户控制层
 *
 * @author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/f")
public class FileManagerController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(description);
        System.out.println(file);

        if (file.isEmpty()) {
            return "error";
        }

        System.out.println(description);
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = "";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "error";
        }

    }

    /**
     * 根据文件名模糊检索，返回匹配到到文件列表
     */
    @GetMapping("/search")
    public String upload(Model model, @RequestParam("fileName") String fileName, @RequestParam("path") String path) throws Exception {
        JsonObject result = new JsonObject();

        return result.toString();
    }
}
