package nwsuaf.service;

import nwsuaf.model.Student;

import java.util.List;

/**
 * @author wjz
 * @date 2019/3/9
 * @describe
 */
public interface StudentService {

    public int insert(Student student);

    public int delete(int id);

    public int update(Student student);

    public Student findById(int id);

    public List<Student> findByName(String name);

    public List<Student> findAll();
}
