package nwsuaf.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import nwsuaf.model.Group;
import nwsuaf.model.Project;
import nwsuaf.model.ProjectAccess;
import nwsuaf.model.ProjectToGroup;
import nwsuaf.service.GroupService;
import nwsuaf.service.ProjectService;
import nwsuaf.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @Resource
    private GroupService groupService;

    /**
     * 创建一个项目
     */
    @ResponseBody
    @PostMapping("/create")
    public String create(Project project) {
        JsonObject result = new JsonObject();

        int count = projectService.countByName(project.getPname());

        if (count > 0) {
            result.addProperty(Utils.RESULT, Utils.FALSE);
            result.addProperty(Utils.MSG, "项目名称已被使用");
            return result.toString();
        }

        System.out.println(Utils.objectToJson(project));

        project.init();

        projectService.insert(project);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 删除一个项目
     */
    @ResponseBody
    @GetMapping("/deleteByPid")
    public String deleteByPid(int pid) {
        JsonObject result = new JsonObject();

        projectService.delByPid(pid);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 更新一个项目
     */
    @ResponseBody
    @PostMapping("/updateByPid")
    public String updateByPid(Project project) {
        JsonObject result = new JsonObject();

        projectService.updateByPid(project);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 查询所有项目
     */
    @ResponseBody
    @GetMapping(value = "/findAll", produces = "application/json;charset=utf-8")
    public String findAll() {
        JsonArray result = new JsonArray();

        List<Project> projects = projectService.findAll();

        for (Project project : projects) {
            result.add(Utils.objectToJson(project));
        }

        return result.toString();
    }

    /**
     * 查询所有组权限
     */
    @ResponseBody
    @GetMapping(value = "/accessList", produces = "application/json;charset=utf-8")
    public String accessList(int pid) {
        JsonArray result = new JsonArray();

        List<ProjectToGroup> projects = projectService.accessList(pid);
        List<Group> groups = groupService.findAll();

        Map<Integer, ProjectAccess> accessMap = new HashMap<Integer, ProjectAccess>();

        for (Group group : groups) {
            accessMap.put(group.getGid(), new ProjectAccess(group.getGid(), group.getGname()));
        }

        for (ProjectToGroup ptg : projects) {
            accessMap.get(ptg.getGid()).setAccess(ptg.getAccess());
        }

        for (ProjectAccess pa : accessMap.values()) {
            result.add(Utils.objectToJson(pa));
        }

        return result.toString();
    }

    /**
     * 更新组权限
     */
    @ResponseBody
    @GetMapping("/updateAccess")
    public String updateAccess(ProjectToGroup ptg) {
        JsonObject result = new JsonObject();

        System.out.println(Utils.objectToJson(ptg));

        projectService.updateAccess(ptg);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }

    /**
     * 更新项目可见性
     */
    @ResponseBody
    @GetMapping("/updateVisited")
    public String updateVisited(Project project) {
        JsonObject result = new JsonObject();

        projectService.updateVisited(project);

        result.addProperty(Utils.RESULT, Utils.TRUE);
        return result.toString();
    }
}
