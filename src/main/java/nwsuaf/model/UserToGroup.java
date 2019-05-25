package nwsuaf.model;

import java.util.List;
import java.util.Map;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
public class UserToGroup {

    /**
     * 主键
     */
    private int id;

    /**
     * 用户id
     */
    private int uid;

    /**
     * 组id
     */
    private int gid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
