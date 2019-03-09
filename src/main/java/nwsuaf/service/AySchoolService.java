package nwsuaf.service;

import nwsuaf.model.AySchool;
import nwsuaf.model.AyUserAddress;

/**
 * 描述：地址服务接口
 * @author Ay
 * @create 2018/05/01
 **/
public interface AySchoolService {

    AySchool findById(Integer id);
}
