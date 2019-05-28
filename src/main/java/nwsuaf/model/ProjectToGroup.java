package nwsuaf.model;

/**
 * @auther LazyMan
 * @date 2019-05-27
 * @describe
 */
public class ProjectToGroup {
    /**
     * 主键
     */
    private int id;

    /**
     * 项目id
     */
    private int pid;

    /**
     * 组id
     */
    private int gid;

    /**
     * 项目权限
     */
    private int access;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
