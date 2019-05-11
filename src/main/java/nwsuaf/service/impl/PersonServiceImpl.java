package nwsuaf.service.impl;

import nwsuaf.dao.PersonDao;
import nwsuaf.model.Person;
import nwsuaf.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    public Person getByName(String name) {
        return null;
    }

    public int getCountByNamePass(String name, String password) {
        return 0;
    }

    public Person getLoginByNamePass(String name, String password) {
        return null;
    }
}
