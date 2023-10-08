package main.javaa.dao;

import main.javaa.RowMapper.StudentRowMapper;
import main.javaa.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudents() {
        System.out.println("inside load Student implemented DAO");

        List<Student> studentList= new ArrayList<>();

        String sql="select * from students";
        List<Student> theListOfStudent= jdbcTemplate.query(sql, new StudentRowMapper());
        System.out.println("till loading list");
        return theListOfStudent;
    }

    @Override
    public void saveStudent(Student student) {

    Object[] sqlParameters={student.getName(),student.getMobile(),student.getCountry()};
    String sql="insert into students(name,mobile,country) values(?,?,?)";
    jdbcTemplate.update(sql,sqlParameters);
        System.out.println("1 record inserted...");


    }

    @Override
    public Student getStudent(int id) {
        String sql="Select * from students where id=?";
        Student studentFetch=jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id);
        return studentFetch;
    }

    @Override
    public void update(Student student) {
        String sql="update students set name=?, mobile=?, country=? where id=?";
        jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
        System.out.println("1 row updated now");

    }

    @Override
    public void deleteStudent(int id) {
        String sql="delete from students where id=?";
        jdbcTemplate.update(sql, id);
    }
}
