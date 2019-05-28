package nwsuaf.model;

/**
 * @auther LazyMan
 * @date 2019-05-27
 * @describe
 */
public class ProjectAccess {
    /**
     * 组id
     */
    private int gid;

    /**
     * 组名称
     */
    private String gname;

    /**
     * 权限
     */
    private int access = 0;

    public ProjectAccess(int gid, String gname) {
        this.gid = gid;
        this.gname = gname;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
