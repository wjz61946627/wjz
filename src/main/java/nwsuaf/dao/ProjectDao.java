package nwsuaf.dao;

import nwsuaf.model.Project;
import nwsuaf.model.ProjectToGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther LazyMan
 * @date 2019-05-06
 * @describe
 */
@Repository
public interface ProjectDao {
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
     * 插入组权限
     */
    public int insertAccess(ProjectToGroup ptg);

    /**
     * 更新组权限
     */
    public int updateVisited(Project project);
}
