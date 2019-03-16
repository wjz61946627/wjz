package nwsuaf.dao;

import nwsuaf.model.Project;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface ProjectDao {

    public int projectInsert(Project project);

    public int projectDelete(int proId);

    public int projectUpdate(Project project);

    public Project projectFindByProId(int proId);

    public Project projectFindByProName(String proName);
}
