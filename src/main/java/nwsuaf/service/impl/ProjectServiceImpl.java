package nwsuaf.service.impl;

import nwsuaf.dao.ProjectDao;
import nwsuaf.model.Project;
import nwsuaf.model.ProjectToGroup;
import nwsuaf.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;


    /**
     * 创建一个项目
     */
    public int insert(Project project) {
        return projectDao.insert(project);
    }

    /**
     * 删除
     */
    public int delByPid(int pid) {
        return projectDao.delByPid(pid);
    }

    /**
     * 更新项目名称和描述
     */
    public int updateByPid(Project project) {
        return projectDao.updateByPid(project);
    }

    /**
     * 查询所有项目
     */
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    /**
     * 根据项目名称查询个数
     */
    public int countByName(String pname) {
        return projectDao.countByName(pname);
    }

    /**
     * 组权限
     */
    public List<ProjectToGroup> accessList(int pid) {
        return projectDao.accessList(pid);
    }

    /**
     * 更新组权限
     */
    public int updateAccess(ProjectToGroup ptg) {
        projectDao.insertAccess(ptg);
        return projectDao.updateAccess(ptg);
    }

    /**
     * 更新组权限
     */
    public int updateVisited(Project project) {
        return projectDao.updateVisited(project);
    }

}
