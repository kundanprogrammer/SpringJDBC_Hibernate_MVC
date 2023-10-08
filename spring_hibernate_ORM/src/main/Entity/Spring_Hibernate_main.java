package main.Entity;

import main.StudentDao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class Spring_Hibernate_main {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("main/Config.xml");
        StudentDao student=context.getBean("studentDao",StudentDao.class);
        Student student1=new Student(105,"kundanJi","Delhi");

        int r=student.insert(student1);
        System.out.println(r);

    }
}
