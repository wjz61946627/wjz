package nwsuaf.service;

import nwsuaf.model.Group;
import nwsuaf.model.User;

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
     * 跟新一个组的信息
     * */
    public int update(Group group);

    /**
     * 获取所有组信息
     */
    public int addMember(int gid, int uid);

    /**
     * 获取所有成员
     */
    public List<User> members(int gid);
}
