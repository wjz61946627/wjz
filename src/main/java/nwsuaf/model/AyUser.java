package nwsuaf.model;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 用户实体
 * @author Ay
 * @date  2018/04/02
 */
public class AyUser implements Serializable{

    private Integer id;
    @NotBlank(message = "name不能为空")
    private String name;
    @Length(min = 3, max = 16, message = "密码长度必须在3~16位之间")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
