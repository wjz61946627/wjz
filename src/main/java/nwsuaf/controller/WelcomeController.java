package nwsuaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *@author WT
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/index")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model){
        return "saveUser";
    }

}
