package tw.com.xvpower.sqlite_project.dao;

import java.util.List;

import tw.com.xvpower.sqlite_project.bean.Student;

public interface StudentDao {
    int insert(Student st);
    Student queryStudentById(int id);
    List<Student> queryAllStudent();
    int update(Student st);
    int delete(Student st);



}
