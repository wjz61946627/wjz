package nwsuaf.service.impl;

import nwsuaf.dao.TeacherDao;
import nwsuaf.model.Teacher;
import nwsuaf.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/10
 * @describe
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    public int teacherInsert(Teacher teacher){
        return teacherDao.teacherInsert(teacher);
    }

    public int teacherDelete(int id){
        return teacherDao.teacherDelete(id);
    }

    public int teacherUpdate(Teacher teacher){
        return teacherDao.teacherUpdate(teacher);
    }

    public Teacher teacherFindById(int id){
        return teacherDao.teacherFindById(id);
    }

    public List<Teacher> teacherFindByName(String name){
        return teacherDao.teacherFindByName(name);
    }

    public List<Teacher> teacherFindAll(){
        return teacherDao.teacherFindAll();
    }
}
