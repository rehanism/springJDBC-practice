package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program Started..." );
        //spring jdbc=> Jdbc Template
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
     
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
       
//        //INSERT
//        Student student= new Student();
//        student.setId(666);
//        student.setName("Ken adams");
//        student.setCity("Australia");
//        
//        int r = studentDao.insert(student);
//        System.out.println("Student added "+ r);
        
        //UPDATE
//        Student student= new Student();
//        student.setId(222);
//        student.setName("Md Rehan");
//        student.setCity("Delhi");
//        
//        int r = studentDao.update(student);
//        System.out.println("Student updated "+ r);
        
        
        //DELETE
//        Student student= new Student();
//        student.setId(666);
//        
//        int r = studentDao.delete(student);
//        System.out.println("Student deleted "+ r);
        
        //to fetch one row
//        Student student = studentDao.getStudent(222);
//        System.out.println(student);
        
        
        //to fetch multiple rows
        List <Student> student1 = studentDao.getAllSudent();
        for(Student s: student1) {
        	System.out.println(s);
        }
        
       }
}
