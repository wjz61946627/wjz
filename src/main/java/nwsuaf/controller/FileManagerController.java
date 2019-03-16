package nwsuaf.controller;

import nwsuaf.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户控制层
 *@author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/file")
public class FileManagerController {

    @Resource
    private AyUserService ayUserService;

    @GetMapping("/upliad")
    public String save(Model model){
        System.out.println("AyUserController.save");
        return "saveUser";
    }

}
