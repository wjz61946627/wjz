package nwsuaf.model;

import java.io.Serializable;

/**
 * @author wjz
 * @date 2019/3/9
 * @describe
 */
public class Student implements Serializable {

    private Integer id;

    private String name;

    private boolean sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
