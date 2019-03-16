package nwsuaf.service;

import nwsuaf.model.ProjectFileRalation;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/17
 * @describe
 */
public interface ProjectFileRalationService {
    public int ProjectFileRalationInsert(ProjectFileRalation projectFileRalation);

    public int ProjectFileRalationDelete(int proId,int fileId);

    public int ProjectFileRalationUpdate(ProjectFileRalation projectFileRalation);

    public List<ProjectFileRalation> ProjectFileRalationFindByProId(int proId);

    public List<ProjectFileRalation> ProjectFileRalationFindByFileId(int fileId);
}
