package nwsuaf.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Project implements Serializable {

    private Integer proId;

    private String proName;

    private Date date;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
