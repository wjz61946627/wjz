package nwsuaf.service.impl;

import nwsuaf.dao.StudentDao;
import nwsuaf.model.Student;
import nwsuaf.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/9
 * @describe
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public int insert(Student student){
        return studentDao.insert(student);
    }

    public int delete(int id){
        return studentDao.delete(id);
    }

    public int update(Student student){
        return studentDao.update(student);
    }

    public Student findById(int id){
        return studentDao.findById(id);
    }

    public List<Student> findByName(String name){
        return studentDao.findByName(name);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }
}
