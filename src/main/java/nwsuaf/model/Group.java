package nwsuaf.model;

import java.util.List;
import java.util.Map;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
public class Group {

    /** 主键*/
    private int gid;

    /** 组名*/
    private String gname;

    /** 组id*/
    private List<Integer> projectIds;

    /** 组id->权限*/
    private Map<Integer,Integer> projectAccess;

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

    public List<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }

    public Map<Integer, Integer> getProjectAccess() {
        return projectAccess;
    }

    public void setProjectAccess(Map<Integer, Integer> projectAccess) {
        this.projectAccess = projectAccess;
    }
}
