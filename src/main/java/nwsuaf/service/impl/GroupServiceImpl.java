package nwsuaf.service.impl;

import nwsuaf.dao.GroupDao;
import nwsuaf.dao.UserDao;
import nwsuaf.model.Group;
import nwsuaf.model.User;
import nwsuaf.service.GroupService;
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
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupDao groupDao;


    public List<Group> findAll() {
        return groupDao.findAll();
    }

    public int insert(Group group) {
        return groupDao.insert(group);
    }

    public int update(Group group) {
        return groupDao.update(group);
    }

    public int addMember(int gid, int uid) {
        return groupDao.addMember(gid, uid);
    }

    public List<User> members(int gid) {
        return groupDao.members(gid);
    }
}
