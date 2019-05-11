package nwsuaf.service;

import nwsuaf.model.Person;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface PersonService {

    public Person getByName(String name);

    /** 根据用户名和密码获取个数 */
    public int getCountByNamePass(String name,String password);

    /** 根据用户名和密码获取登陆用的信息 */
    public Person getLoginByNamePass(String name,String password);
}
