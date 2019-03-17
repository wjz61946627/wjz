package nwsuaf.controller;

import nwsuaf.model.Person;
import nwsuaf.model.ProjectLog;
import org.apache.ibatis.annotations.ResultMap;
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
@RequestMapping("/person")
public class PersonController {
    /**
     * 请求个人信息主页
     */
    @GetMapping("/index")
    public ModelAndView person(String projectId) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("personInfo");
        return mv;
    }

    /**
     * 请求修改个人信息
     */
    @GetMapping("/update")
    public ModelAndView update(Person person) {
        List<ProjectLog> logs = new ArrayList<ProjectLog>();

        ModelAndView mv = new ModelAndView();
        mv.addObject("logs", logs);
        mv.setViewName("projectLog");
        return mv;
    }
}
