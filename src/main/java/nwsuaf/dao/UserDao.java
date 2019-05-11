package nwsuaf.dao;

import nwsuaf.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
@Repository
public interface UserDao {

    /**
     * 根据用户名和密码确认用户身份
     */
    public int countByNamePass(User user);

    /**
     * 获取登陆需要用的信息
     */
    public User loginByNamePass(User user);

    /**
     * 获取所有账号信息,但不包括密码
     */
    public List<User> findAllNoPassword();

    /**
     * 插入一个角色
     */
    public int insert(User user);

    public int deleteByUid(int uid);

    public int updateByUid(User user);
}
