package nwsuaf.controller;

import nwsuaf.model.Person;
import nwsuaf.model.ProjectLog;
import nwsuaf.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 *
 * @author WT
 * @date 2018/04/02
 */
@Controller
@RequestMapping("/project")
public class ProjectController {


    /**
     * 请求项目操作日志
     */
    @GetMapping("/log")
    public ModelAndView optionLog(String projectId) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 请求项目人员信息
     */
    @GetMapping("/person")
    public ModelAndView members(String projectId) {
        List<Person> members = new ArrayList<Person>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", members);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 请求项目负责人详细信息
     */
    @GetMapping("/master")
    public ModelAndView master(String projectId) {
        List<Person> members = new ArrayList<Person>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", members);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 请求项目文件结构
     */
    @GetMapping("/files")
    public ModelAndView files(String projectId) {
        List<Person> members = new ArrayList<Person>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", members);
        mv.setViewName("projectLog");
        return mv;
    }

    /**
     * 请求项目主页
     */
    @GetMapping("/index")
    public ModelAndView index(String projectId) {
        List<Person> members = new ArrayList<Person>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", members);
        mv.setViewName("projectLog");
        return mv;
    }

}
