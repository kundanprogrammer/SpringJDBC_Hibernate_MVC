package main.javaa.RowMapper;

import main.javaa.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println("started row mapping");
        Student s=new Student();
        System.out.println("till row mapper");
        s.setId(resultSet.getInt("id"));
        s.setName(resultSet.getString("name"));
        s.setMobile(resultSet.getLong("mobile"));
        s.setCountry(resultSet.getString("country"));

        return s;
    }
}
