package nwsuaf.controller;

import nwsuaf.model.Person;
import nwsuaf.model.ProjectLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Controller
@RequestMapping("/group")
public class GroupController {
    /**
     * 创建一个组
     */
    @GetMapping("/create")
    public ModelAndView create(Person person) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 新增一个成员
     */
    @GetMapping("/add")
    public ModelAndView add(Person person) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 移除一个成员
     */
    @GetMapping("/remove")
    public ModelAndView remove(Person person) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 赋予一个组某个项目的某个权限
     */
    @GetMapping("/permissions")
    public ModelAndView permissions(Person person) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }
}
