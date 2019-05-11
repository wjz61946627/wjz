package nwsuaf.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import nwsuaf.model.Project;
import nwsuaf.model.User;
import nwsuaf.service.ProjectService;
import nwsuaf.service.UserService;
import nwsuaf.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private ProjectService projectService;

    @Resource
    private UserService userService;

    @GetMapping("/createproject")
    public ModelAndView createProject(Project project) {
        projectService.projectUpdate(project);
        return null;
    }

    @GetMapping("/index")
    public String index() {
        return "admin";
    }

    /**
     * 创建一个账号
     */
    @ResponseBody
    @PostMapping(value = "/addUser", produces = "application/json;charset=utf-8")
    public String addUser(User user) {
        JsonObject result = new JsonObject();

        if (!Utils.checkPassword(user.getPassword())) {
            result.addProperty("result", "false");
            return result.toString();
        }

        user.setPassword(Utils.securityMD5(user.getPassword()));

        user.init();
        userService.insert(user);

        result.addProperty("result", "true");
        return result.toString();
    }

    /**
     * 删除一个账号
     */
    @ResponseBody
    @PostMapping("/deleteByUid")
    public String deleteUser(int uid) {
        userService.deleteByUid(uid);

        JsonObject result = new JsonObject();
        result.addProperty("result", "true");
        return result.toString();
    }

    /**
     * 更新一个账号
     */
    @ResponseBody
    @PostMapping("/updateByUid")
    public String deleteUser(User user) {
        userService.updateByUid(user);

        JsonObject result = new JsonObject();
        result.addProperty("result", "true");
        return result.toString();
    }

    /**
     * 请求所有账号
     */
    @ResponseBody
    @PostMapping("/findAll")
    public String findAll() {
        JsonArray result = new JsonArray();

        List<User> allUser = userService.findAllNoPassword();
        for (User user : allUser) {
            result.add(Utils.objectToJson(user));
        }

        return result.toString();
    }
}
