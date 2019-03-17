package nwsuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class ProjectLog implements Serializable {

    private Integer id;

    private Integer proId;

    private Person person;

    private String describe;

    private Timestamp optionTime;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Timestamp getOptionTime() {
        return optionTime;
    }

    public void setOptionTime(Timestamp optionTime) {
        this.optionTime = optionTime;
    }
}
