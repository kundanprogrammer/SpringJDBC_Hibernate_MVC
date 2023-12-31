package main.javaa.dao;

import main.javaa.api.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> loadStudents();

    void saveStudent(Student student);

    Student getStudent(int id);

    void update(Student student);


    void deleteStudent(int id);
}
