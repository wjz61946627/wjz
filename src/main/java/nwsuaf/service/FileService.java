package nwsuaf.service;

import nwsuaf.model.MyFile;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface FileService {
    /**
     * 创建一个项目
     */
    public List<MyFile> findByPid(int pid);

    /**
     * 统计指定项目下指定文件名个数
     */
    public int countByPidFname(MyFile myFile);

    /**
     * 新增一个文件
     */
    public int insert(MyFile myFile);


    /**
     * 删除文件
     */
    public int deleteByPidFid(MyFile myFile);

    /**
     * 读取一个文件
     */
    public MyFile readByFidPid(MyFile myFile);

    public int countByPid(int pid);

    /**
     * 读取一个文件
     */
    public MyFile readByFid(int fid);
}
