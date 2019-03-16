package nwsuaf.service.impl;

import nwsuaf.dao.ProjectFileRalationDao;
import nwsuaf.model.ProjectFileRalation;
import nwsuaf.service.ProjectFileRalationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/17
 * @describe
 */
@Service
public class ProjectFileRalationImpl implements ProjectFileRalationService {

    @Resource
    private ProjectFileRalationDao projectFileRalationDao;

    public int ProjectFileRalationInsert(ProjectFileRalation projectFileRalation){
        return projectFileRalationDao.ProjectFileRalationInsert(projectFileRalation);
    }

    public int ProjectFileRalationDelete(int proId,int fileId){
        return projectFileRalationDao.ProjectFileRalationDelete(proId,fileId);
    }

    public int ProjectFileRalationUpdate(ProjectFileRalation projectFileRalation){
        return projectFileRalationDao.ProjectFileRalationUpdate(projectFileRalation);
    }

    public List<ProjectFileRalation> ProjectFileRalationFindByProId(int proId){
        return projectFileRalationDao.ProjectFileRalationFindByProId(proId);
    }

    public List<ProjectFileRalation> ProjectFileRalationFindByFileId(int fileId){
        return projectFileRalationDao.ProjectFileRalationFindByFileId(fileId);
    }
}
