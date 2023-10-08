package StudentDao;

import Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImplement implements StudentDaoInterface{

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";

        int update=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        System.out.println("numbers of records inserted : "+update);

        return update;
    }

    @Override
    public int change(Student student) {
        String query="update student set name=?, city=? where id=?";
        int up=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return up;
    }

    @Override
    public Student getStudent(int studentId) {
        String query="select * from student where id=?";

        RowMapper<Student> rowMapper =new RowMapperImpl();
        Student student =this.jdbcTemplate.queryForObject(query,rowMapper,studentId);



        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query="select * from student;";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        List<Student> student= this.jdbcTemplate.query(query,rowMapper);
        return student;
    }
}
