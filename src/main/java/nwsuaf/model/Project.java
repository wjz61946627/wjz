package nwsuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Project implements Serializable {

    /**
     * 主键
     */
    private Integer pid;

    /**
     * 项目名称
     */
    private String pname;

    /**
     * 项目组长id
     */
    private Integer leader;

    /**
     * 项目创建日期
     */
    private Timestamp date;

    /**
     * 项目概述
     */
    private String desc;

    /**
     * 项目可见性
     */
    private int visited;

    /**
     * 文件个数
     * */
    private int fileNum;

    public void init() {
        setDate(new Timestamp(System.currentTimeMillis()));
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }
}
