package nwsuaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/index")
    public String index() {
        return "admin";
    }
}
