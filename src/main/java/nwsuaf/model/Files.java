package nwsuaf.model;

import java.util.Date;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public class Files {

    private Integer fileId;

    private String fileName;

    private Date upload;

    private Integer proId;

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

    public Date getUpload() {
        return upload;
    }

    public void setUpload(Date upload) {
        this.upload = upload;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}
