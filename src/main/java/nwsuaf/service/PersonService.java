package nwsuaf.service;

import nwsuaf.model.Person;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface PersonService {

    public int personInsert(Person person);

    public int personDelete(int id);

    public int personUpdate(Person person);

    public Person personFindById(int id);

    public List<Person> personFindByName(String name);

    public List<Person> personFindAll();
}
