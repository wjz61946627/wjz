package nwsuaf.service.impl;

import nwsuaf.dao.AySchoolDao;
import nwsuaf.dao.AyUserAddressDao;
import nwsuaf.model.AySchool;
import nwsuaf.model.AyUserAddress;
import nwsuaf.service.AySchoolService;
import nwsuaf.service.AyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ay
 * @create 2018/05/01
 **/
@Service
public class AySchoolServiceImpl implements AySchoolService {

    @Resource
    private AySchoolDao aySchoolDao;

    public AySchool findById(Integer id) {
        return aySchoolDao.findById(id);
    }
}
