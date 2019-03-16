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

    public int personInsert(Person person){
        return personDao.personInsert(person);
    }

    public int personDelete(int id){
        return personDao.personDelete(id);
    }

    public int personUpdate(Person person){
        return personDao.personUpdate(person);
    }

    public Person personFindById(int id){
        return personDao.personFindById(id);
    }

    public List<Person> personFindByName(String name){
        return personDao.personFindByName(name);
    }

    public List<Person> personFindAll(){
        return personDao.personFindAll();
    }
}
