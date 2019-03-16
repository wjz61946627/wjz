package nwsuaf.model;

import java.io.Serializable;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Team implements Serializable {

    private Integer key;

    private Integer teamId;

    private Integer id;

    private Integer proId;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}
