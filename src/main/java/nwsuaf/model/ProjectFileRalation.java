package nwsuaf.model;

import java.io.Serializable;

/**
 * @author wjz
 * @date 2019/3/17
 * @describe
 */
public class ProjectFileRalation implements Serializable {

    private Integer key;

    private Integer proId;

    private Integer fileId;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}
