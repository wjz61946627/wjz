package nwsuaf.dao;

import nwsuaf.model.Group;
import nwsuaf.model.User;
import nwsuaf.model.UserToGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
@Repository
public interface GroupDao {
    /**
     * 获取所有组信息
     */
    public List<Group> findAll();

    /**
     * 创建一个组
     */
    public int insert(Group group);
    public int deleteByGid(int gid);

    public int update(Group group);

    /**
     * 添加一个成员
     */
    public int addMember(UserToGroup userToGroup);

    /**
     * 删除一个成员
     */
    public int delMember(UserToGroup userToGroup);

    /**
     * 获取所有成员
     */
    public List<User> members(int gid);

    /**
     * 获取不是gid成员的所有成员
     */
    public List<User> findUnselectByGid(int gid);

    /**
     * 添加一个组员到一个组
     * */
    public int addUserToGroup(int uid, int gid);
}
