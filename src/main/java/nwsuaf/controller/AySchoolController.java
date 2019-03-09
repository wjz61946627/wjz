package nwsuaf.controller;

import nwsuaf.model.AySchool;
import nwsuaf.model.AyUserAddress;
import nwsuaf.service.AySchoolService;
import nwsuaf.service.AyUserAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 描述：地址控制层
 * @author Ay
 * @create 2018/05/01
 **/
@Controller
@RequestMapping(value = "/school")
public class AySchoolController {

    @Resource
    private AySchoolService aySchoolService;

    @GetMapping("/findById")
    public String findById(Model model){
        AySchool aySchool = aySchoolService.findById(1);
        return "success";
    }
}
