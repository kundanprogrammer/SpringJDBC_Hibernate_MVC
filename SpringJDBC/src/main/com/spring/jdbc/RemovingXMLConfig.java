package com.spring.jdbc;

import StudentDao.StudentDaoImplement;
import StudentDao.StudentDaoInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class RemovingXMLConfig {


    @Bean("ds")
    public DriverManagerDataSource getDataSources(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springJdbc");
        ds.setPassword("root");
        ds.setUsername("root");

        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSources());
        return jdbcTemplate;
    }

    @Bean(name={"studentDao"})
    public StudentDaoInterface getStudentDao(){
        StudentDaoImplement sdi=new StudentDaoImplement();
        sdi.setJdbcTemplate(getTemplate());
        return sdi;

    }

}
