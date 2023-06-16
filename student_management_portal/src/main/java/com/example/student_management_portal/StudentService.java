package com.example.student_management_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


     @Autowired

    StudentRepo studentRepo;

     public Student getStudent1(int admissionNo){

            return studentRepo.getStudent1(admissionNo);
     }

    public String addStudent(Student student) {


         return studentRepo.addStudent(student);
    }


    public Student getStudent2(int admissionNo) {


         return studentRepo.getStudent2(admissionNo);
    }

    public String removeStudent(int admissionNo) {

         return  studentRepo.removeStudent(admissionNo);

    }

    public String updateStudentCourse(int admissonNo, String course) {

          return studentRepo.updateStudentCourse(admissonNo,course);
    }

    public String totalNumofStudents(int age) {

          return studentRepo.totalNumofStudents(age);
    }
}
