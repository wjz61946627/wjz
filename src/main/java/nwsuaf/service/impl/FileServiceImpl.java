package nwsuaf.service.impl;

import nwsuaf.dao.MyFileDao;
import nwsuaf.model.MyFile;
import nwsuaf.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private MyFileDao fileDao;

    /**
     * 创建一个项目
     */
    public List<MyFile> findByPid(int pid) {
        return fileDao.findByPid(pid);
    }

    /**
     * 统计指定项目下指定文件名个数
     */
    public int countByPidFname(MyFile myFile) {
        return fileDao.countByPidFname(myFile);
    }

    /**
     * 新增一个文件
     */
    public int insert(MyFile myFile) {
        return fileDao.insert(myFile);
    }


    /**
     * 删除文件
     */
    public int deleteByPidFid(MyFile myFile) {
        return fileDao.deleteByPidFid(myFile);
    }

    /**
     * 读取一个文件
     */
    public MyFile readByFidPid(MyFile myFile) {
        return fileDao.readByFidPid(myFile);
    }

    public int countByPid(int pid) {
        return fileDao.countByPid(pid);
    }

    /**
     * 读取一个文件
     */
    public MyFile readByFid(int fid) {
        return fileDao.readByFid(fid);
    }
}
