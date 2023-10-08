package StudentDao;

import Entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student=new Student();
        student.setId(rs.getInt(1));
        student.setCity(rs.getString(3));
        student.setName(rs.getString(2));



        return student;
    }
}
