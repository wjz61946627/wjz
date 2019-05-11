package nwsuaf.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Project implements Serializable {

    /** 主键*/
    private Integer pid;

    /** 项目名称*/
    private String pname;

    /** 项目组长id*/
    private Integer leader;

    /** 项目创建日期*/
    private Date date;

    /** 项目概述 */
    private String desc;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
