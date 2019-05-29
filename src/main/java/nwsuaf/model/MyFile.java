package nwsuaf.model;

import java.sql.Timestamp;

/**
 * @auther LazyMan
 * @date 2019-05-28
 * @describe
 */
public class MyFile {
    /**
     * 文件唯一标识
     */
    private int fid;

    /**
     * 文件名
     */
    private String fname;

    /**
     * 上传时间
     */
    private Timestamp uploadTime;

    /**
     * 上传者id
     */
    private int uploadId;

    /**
     * 所属项目
     */
    private int pid;

    public void init() {
        setUploadTime(new Timestamp(System.currentTimeMillis()));
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
