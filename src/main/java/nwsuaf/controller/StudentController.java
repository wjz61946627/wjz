package nwsuaf.controller;

import nwsuaf.model.Student;
import nwsuaf.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/9
 * @describe
 */
@Controller
@RequestMapping("/learn")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/index")
    public ModelAndView index(){
        List<Student> studentList = studentService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",studentList);
        mv.setViewName("studentList");
        return mv;
    }

    @GetMapping("/requestInsert")
    public String requestInsert(){
        return "insert";
    }

    @GetMapping("/insert")
    public ModelAndView insert(Student student){
        ModelAndView mv = new ModelAndView();
        int result  = studentService.insert(student);

        if(result != 1){
            mv.setViewName("error");
            return mv;
        }

        mv.addObject("stu",student);
        mv.setViewName("insertSuccess");
        return mv;
    }

    @GetMapping("/delete")
    public ModelAndView delete(int id){
        ModelAndView mv = new ModelAndView();
        int result = studentService.delete(id);

        if(result != 1){
            mv.setViewName("error");
            return mv;
        }

        mv.setViewName("success");
        return mv;
    }

    @GetMapping("/requestUpdate")
    public ModelAndView requestUpdate(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("stu",student);
        mv.setViewName("update");
        return mv;
    }

    @GetMapping("/update")
    public ModelAndView update(Student student){
        int result = studentService.update(student);
        ModelAndView mv = new ModelAndView();

        if(result != 1){
            mv.setViewName("error");
            return mv;
        }

        mv.addObject("stu",student);
        mv.setViewName("updateSuccess");
        return mv;
    }

    @GetMapping("/requestFindById")
    public String requestFindById(){
        return "findById";
    }

    @GetMapping("/findById")
    public ModelAndView findById(int id){
        Student stu = studentService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("stu",stu);
        mv.setViewName("findByIdSuccess");
        return mv;
    }

    @GetMapping("/requestFindByName")
    public String requestFindByName(){
        return "findByName";
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(String name){
        List<Student> studentList= studentService.findByName(name);
        ModelAndView mv = new ModelAndView();
        mv.addObject("stu",studentList);
        mv.setViewName("findByNameSuccess");
        return mv;
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

}