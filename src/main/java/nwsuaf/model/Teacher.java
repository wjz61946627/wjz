package nwsuaf.model;

import java.io.Serializable;

/**
 * @author wjz
 * @date 2019/3/10
 * @describe
 */
public class Teacher implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
