package nwsuaf.service;

import nwsuaf.model.Group;
import nwsuaf.model.User;
import nwsuaf.model.UserToGroup;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface GroupService {

    /**
     * 获取所有组信息
     */
    public List<Group> findAll();

    /**
     * 创建一个组
     */
    public int insert(Group group);

    /**
     * 删除一个组
     * */
    public int deleteByGid(int gid);

    /**
     * 跟新一个组的信息
     * */
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
}
