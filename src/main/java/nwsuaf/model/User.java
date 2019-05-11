package nwsuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
public class User implements Serializable {
    /**
     * 主键
     */
    private int uid;

    /**
     * 昵称
     */
    private String name;

    /**
     * 密码md5值
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 令牌
     */
    private String token;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;

    private Timestamp timecreate;

    /**
     * 此用户所属的组
     */
    private List<Group> groups;

    public void init() {
        setTimecreate(new Timestamp(System.currentTimeMillis()));
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Timestamp getTimecreate() {
        return timecreate;
    }

    public void setTimecreate(Timestamp timecreate) {
        this.timecreate = timecreate;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
