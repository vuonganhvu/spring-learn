package com.higgsup.jdbc;

import ma.glasnost.orika.MapperFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-jdbc.xml");

        StudentDAO studentDAO =
                (StudentDAO) context.getBean("studentJDBCTemplate");
        MapperFacade mapperFacade = (MapperFacade) context.getBean("mapperFacade");

//        System.out.println("------Records Creation--------" );
        /*studentDAO.create("Zara", 11);
        studentDAO.create("Nuha", 2);
        studentDAO.create("Ayan", 15);*/

        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentDAO.listStudents();

        List<StudentDTO> studentDTOs = mapperFacade.mapAsList(students, StudentDTO.class);
        for (StudentDTO record : studentDTOs) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }

//        System.out.println("----Updating Record with ID = 2 -----" );
//        studentDAO.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----");
        Student student = studentDAO.getStudent(2);
        StudentDTO studentDTO = mapperFacade.map(student, StudentDTO.class);
        System.out.print("ID : " + studentDTO.getId());
        System.out.print(", Name : " + studentDTO.getName());
        System.out.println(", Age : " + studentDTO.getAge());
    }
}
