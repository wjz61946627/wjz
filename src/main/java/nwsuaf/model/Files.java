package nwsuaf.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Files implements Serializable {

    private Integer fileId;

    private String fileName;

    private Date uploadTime;

    private String uploader;

    private String remark;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadtime() {
        return uploadTime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadTime = uploadtime;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
