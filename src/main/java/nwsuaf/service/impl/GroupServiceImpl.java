package nwsuaf.service.impl;

import nwsuaf.dao.GroupDao;
import nwsuaf.dao.UserDao;
import nwsuaf.model.Group;
import nwsuaf.model.User;
import nwsuaf.model.UserToGroup;
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

    public int deleteByGid(int gid) {
        return groupDao.deleteByGid(gid);
    }

    public int update(Group group) {
        return groupDao.update(group);
    }

    public int addMember(UserToGroup userToGroup) {
        return groupDao.addMember(userToGroup);
    }

    /**
     * 删除一个成员
     */
    public int delMember(UserToGroup userToGroup){
        return groupDao.delMember(userToGroup);
    }

    public List<User> members(int gid) {
        return groupDao.members(gid);
    }

    /**
     * 获取不是gid成员的所有成员
     */
    public List<User> findUnselectByGid(int gid) {
        return groupDao.findUnselectByGid(gid);
    }

}
