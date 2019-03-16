package nwsuaf.service.impl;

import nwsuaf.dao.ProjectDao;
import nwsuaf.model.Project;
import nwsuaf.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;

    public int projectInsert(Project project){
        return projectDao.projectInsert(project);
    }

    public int projectDelete(int proId){
        return projectDao.projectDelete(proId);
    }

    public int projectUpdate(Project project){
        return projectDao.projectUpdate(project);
    }

    public Project projectFindByProId(int proId){
        return projectDao.projectFindByProId(proId);
    }

    public Project projectFindByProName(String proName){
        return projectDao.projectFindByProName(proName);
    }
}
