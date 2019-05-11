package nwsuaf.controller;

import com.google.gson.JsonObject;
import nwsuaf.model.User;
import nwsuaf.service.UserService;
import nwsuaf.util.MathUtils;
import nwsuaf.util.UtilConfig;
import nwsuaf.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/sign", produces = "application/json;charset=utf-8")
    public String signIn(User user) {
        JsonObject result = new JsonObject();
        user.setPassword(Utils.securityMD5(user.getPassword()));

        int count = userService.countByNamePass(user);
        if (1 != count) {
            result.addProperty("result", "false");
            result.addProperty("msg", "用户名或密码不正确");
        } else {
            result.addProperty("result", "true");
        }

        return result.toString();
    }


    @PostMapping(value = "/welcome", produces = "application/json;charset=utf-8")
    public String welcome(User user, HttpSession session) {
        user.setPassword(Utils.securityMD5(user.getPassword()));
        user = userService.loginByNamePass(user);

        long timeout = System.currentTimeMillis() + UtilConfig.VALIDITY * MathUtils.SEC;
        user.setToken(Utils.securityMD5(String.valueOf(timeout)));

        session.setAttribute("token", user.getToken());
        session.setAttribute("timeout",timeout);
        session.setAttribute("user", user);

        return "welcome";
    }
}
