package nwsuaf.service;

import nwsuaf.model.*;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface ProjectService {

    /**
     * 创建一个项目
     */
    public int insert(Project project);

    /**
     * 删除
     */
    public int delByPid(int pid);

    /**
     * 更新项目名称和描述
     */
    public int updateByPid(Project project);

    /**
     * 查询所有项目
     */
    public List<Project> findAll();

    /**
     * 根据项目名称查询个数
     */
    public int countByName(String pname);

    /**
     * 组权限
     */
    public List<ProjectToGroup> accessList(int pid);

    /**
     * 更新组权限
     */
    public int updateAccess(ProjectToGroup ptg);

    /**
     * 更新组权限
     */
    public int updateVisited(Project project);

}
