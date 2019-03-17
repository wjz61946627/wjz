package nwsuaf.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import nwsuaf.model.Person;
import nwsuaf.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用户控制层
 *
 * @author Ay
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private AyUserService ayUserService;

    @ResponseBody
    @PostMapping(value = "/sign", produces = "application/json;charset=utf-8")
    public String signIn(Person user) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        JsonObject result = new JsonObject();


        if("test".equals(user.getName())){
            result.addProperty("result", "true");
        }else{
            result.addProperty("result", "false");
            result.addProperty("msg", "用户密码不正确");
        }

        return result.toString();
    }

    @GetMapping("/welcome")
    public String welcome(Model model){
        return "welcome";
    }

}
