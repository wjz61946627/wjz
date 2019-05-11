package nwsuaf.service.impl;

import nwsuaf.dao.UserDao;
import nwsuaf.model.User;
import nwsuaf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public int countByNamePass(User user) {
        return userDao.countByNamePass(user);
    }

    public User loginByNamePass(User user) {
        return userDao.loginByNamePass(user);
    }

    public List<User> findAllNoPassword() {
        return userDao.findAllNoPassword();
    }

    public int insert(User user) {
        return userDao.insert(user);
    }

    public int deleteByUid(int uid) {
        return userDao.deleteByUid(uid);
    }

    public int updateByUid(User user) {
        return userDao.updateByUid(user);
    }
}
