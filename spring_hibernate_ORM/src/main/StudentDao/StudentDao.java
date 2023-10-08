package main.StudentDao;

import main.Entity.Student;

import org.hibernate.dialect.Dialect;


import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;


public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @org.springframework.transaction.annotation.Transactional
    public int insert (Student student){

        int result;
        result = (int) this.hibernateTemplate.save(student);
        return result;

    }

    public Student getStudent(int studentId){
        Student stu=this.hibernateTemplate.get(Student.class,studentId);
        return stu;
    }

    public List<Student>  getAllStudents(){
        List<Student> stulst=this.hibernateTemplate.loadAll(Student.class);
        return stulst;
    }
    @Transactional
    public void deteteStu(int StudentId){
        Student stu=this.hibernateTemplate.get(Student.class,StudentId);
        this.hibernateTemplate.delete(stu);
    }

    @Transactional
    public void updateStu(Student student){
        this.hibernateTemplate.saveOrUpdate(student);
    }



}
