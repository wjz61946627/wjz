package nwsuaf.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import nwsuaf.model.Teacher;
import nwsuaf.service.TeacherService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/10
 * @describe
 */
@Controller
@RequestMapping("/practice")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/index")
    public ModelAndView index(){
        List<Teacher> teacherList = teacherService.teacherFindAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("teacherList",teacherList);
        mv.setViewName("teacherList");
        return mv;
    }

    @GetMapping("requestTeacherInsert")
    public String requestTeacherInsert(){
        return "teacherInsert";
    }

    @GetMapping("teacherInsert")
    public ModelAndView teacherInsert(Teacher teacher){
        ModelAndView mv = new ModelAndView();
        teacherService.teacherInsert(teacher);
        mv.addObject("teacher",teacher);
        mv.setViewName("teacherInsertSuccess");
        return mv;
    }

    @GetMapping("/teacherDelete")
    public ModelAndView teacherDelete(int id){
        ModelAndView mv = new ModelAndView();
        teacherService.teacherDelete(id);
        mv.setViewName("success");
        return mv;
    }

    @GetMapping("/requestTeacherUpdate")
    public String requestTeacherUpdate(Teacher teacher){
//        ModelAndView mv = new ModelAndView();
//        teacherService.teacherUpdate(teacher);
//        mv.addObject("teacher",teacher);
//        mv.setViewName("teacherUpdate");
//        return mv;
        return "teacherUpdate";
    }

    @GetMapping("/teacherUpdate")
    public ModelAndView teacherUpdate(Teacher teacher){
        ModelAndView mv = new ModelAndView();
        teacherService.teacherUpdate(teacher);
        mv.addObject("teacher",teacher);
        mv.setViewName("teacherUpdateSuccess");
        return mv;
    }

    @GetMapping("/find")
    public String find(){
        return "find";
    }

//    @GetMapping("/requestTeacherFindById")
//    public String requestTeacherFindById(){
//        return "teacherFindById";
//    }

    @GetMapping("/teacherFindById")
    public ModelAndView teacherFindById(int id){
        Teacher teacher = teacherService.teacherFindById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("teacher",teacher);
        mv.setViewName("teacherFindByIdSuccess");
        return mv;
    }

//    @GetMapping("/requestTeacherFindByName")
//    public String requestTeacherFindByName(){
//        return "teacherFindByName";
//    }

    @GetMapping("/teacherFindByName")
    public ModelAndView teacherFindByName(String name){
        List<Teacher> teacherList = teacherService.teacherFindByName(name);
        ModelAndView mv = new ModelAndView();
        mv.addObject("teacherList",teacherList);
        mv.setViewName("teacherFindByNameSuccess");
        return mv;
    }

    @GetMapping("/teacherFindAll")
    public List<Teacher> teacherFindAll(){
        return teacherService.teacherFindAll();
    }
}
