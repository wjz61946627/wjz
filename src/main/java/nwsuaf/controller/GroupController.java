package nwsuaf.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nwsuaf.model.Group;
import nwsuaf.model.User;
import nwsuaf.service.GroupService;
import nwsuaf.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupService groupService;

    /**
     * 获取所有组
     */
    @ResponseBody
    @GetMapping("/findAll")
    public String findAll() {
        JsonArray result = new JsonArray();

        List<Group> groups = groupService.findAll();

        for (Group group : groups) {
            result.add(Utils.objectToJson(group));
        }

        return result.toString();
    }

    /**
     * 创建一个组
     */
    @ResponseBody
    @PostMapping("/create")
    public String create(Group group) {
        JsonObject result = new JsonObject();

        groupService.insert(group);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 创建一个组
     */
    @ResponseBody
    @PostMapping("/update")
    public String update(Group group) {
        JsonObject result = new JsonObject();

        groupService.update(group);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 添加一个成员
     */
    @ResponseBody
    @PostMapping("/addMember")
    public String addMember(int gid, int uid) {
        int num = groupService.addMember(gid, uid);
        System.out.println(num);

        JsonObject result = new JsonObject();
        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 获取所有成员
     */
    @ResponseBody
    @GetMapping("/members")
    public String members(int gid) {
        JsonArray result = new JsonArray();

        List<User> users = groupService.members(gid);

        for (User user : users) {
            result.add(Utils.objectToJson(user));
        }

        return result.toString();
    }

}
