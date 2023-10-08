package com.spring.jdbc;

import Entities.Student;
import StudentDao.StudentDaoImplement;
import StudentDao.StudentDaoInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("hello");
//        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

          ApplicationContext context = new AnnotationConfigApplicationContext(RemovingXMLConfig.class);


//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        System.out.println(template);
//        String query="insert into student(id,name,city) values(?,?,?)";
//
//        int result=template.update(query,102,"Manish Kumar","karpur");
//        System.out.println("numbers of records inserted : "+result);

        StudentDaoInterface element=context.getBean("studentDao",StudentDaoInterface.class);

//        Student s1=new Student();
//        s1.setId(104);
//        s1.setName("Aashish Foji");
//        s1.setCity("Panipat Ka Tha");
//        int result =element.change(s1);
//
//        System.out.println("student added "+ result);




          Student vidhyarthi= element.getStudent(102);
        System.out.println(vidhyarthi);


        List<Student> studentlist=element.getAllStudents();
        for(Student s: studentlist){

        System.out.println(s);
        }




    }
}
