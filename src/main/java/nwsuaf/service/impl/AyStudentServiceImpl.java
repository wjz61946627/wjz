package nwsuaf.service.impl;

import nwsuaf.dao.AyStudentDao;
import nwsuaf.dao.AyUserAddressDao;
import nwsuaf.model.AyStudent;
import nwsuaf.model.AyUserAddress;
import nwsuaf.service.AyStudentService;
import nwsuaf.service.AyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ay
 * @create 2018/05/01
 **/
@Service
public class AyStudentServiceImpl implements AyStudentService {

    @Resource
    private AyStudentDao ayStudentDao;

    public AyStudent findById(Integer id) {
        return ayStudentDao.findById(id);
    }
}
