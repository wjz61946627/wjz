package nwsuaf.dao;

import nwsuaf.model.MyFile;
import nwsuaf.model.Project;
import nwsuaf.model.ProjectToGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
@Repository
public interface MyFileDao {
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
}
