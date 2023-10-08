package StudentDao;

import Entities.Student;

import java.util.List;

public interface StudentDaoInterface {
    public int insert(Student student);
    public int change(Student student);

    public Student getStudent(int studentId);

    public List<Student> getAllStudents();
}
