package main.javaa.com.studentManagement.controllers;
import main.javaa.api.StudentDTO;
import main.javaa.dao.StudentDAOimpl;
import main.javaa.api.Student;
import main.javaa.dao.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    //here i changed StudentDAO to StudentDAOimpl
    @Autowired
    private StudentDAOimpl studentDAO;
//    @RequestMapping(value="/show" , method= RequestMethod.GET)
    @GetMapping("/show")
    public String  showStudentList(Model model){
        System.out.println("here m rowmap1 it");
        List<Student> studentList= studentDAO.loadStudents();
        System.out.println("hello m rowmap2 here");
        for(Student temp:studentList){
            System.out.println(temp);
        }
        model.addAttribute("students",studentList);
        return "student-list";
    }

    @GetMapping("/updateStudent")
    public String update(@RequestParam("userId") int id,Model model){
        Student stu=new Student();


        Student theStudent = studentDAO.getStudent(id);
        System.out.println(theStudent);

        stu.setId(theStudent.getId());
        stu.setName(theStudent.getName());
        stu.setMobile(theStudent.getMobile());
        stu.setCountry(theStudent.getCountry());
        model.addAttribute("student",stu);
        return "student-add";
    }

//    @GetMapping("/updateStudent")
//    public String updateStudent(@RequestParam("userId") int id,Model model){
//        Student theStudent= studentDAO.getStudent(id);
//        model.addAttribute("student",theStudent);
//        return "add-student";
//    }


    @GetMapping("/showAdd")
    public String addStudent(Model model){
        Student studentDTO=new Student();
        model.addAttribute("student",studentDTO);
        return "student-add";
    }


//    @ResponseBody # if we want return Direct string inspite of string appending url


    @PostMapping("/save-student")
    public String saveStudent(Student studentDTO){

        System.out.println(studentDTO);
        if(studentDTO.getId()==0){
            studentDAO.saveStudent(studentDTO);
        }else{
            studentDAO.update(studentDTO);
        }


        return "redirect:/show";
    }


    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id){
        studentDAO.deleteStudent(id);

        return "redirect:/show";
    }



}
