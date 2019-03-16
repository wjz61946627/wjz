package nwsuaf.service;

import nwsuaf.model.Teacher;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/10
 * @describe
 */
public interface TeacherService {

    public int teacherInsert(Teacher teacher);

    public int teacherDelete(int id);

    public int teacherUpdate(Teacher teacher);

    public Teacher teacherFindById(int id);

    public List<Teacher> teacherFindByName(String name);

    public List<Teacher> teacherFindAll();
}
