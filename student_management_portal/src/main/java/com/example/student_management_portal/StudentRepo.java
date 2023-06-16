package com.example.student_management_portal;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepo {

    Map<Integer,Student> studentMap = new HashMap<>();

    public Student getStudent1(int admissionNo){


        return  studentMap.get(admissionNo);
    }


    public String addStudent(Student student) {


        if(studentMap.get(student.getAdmissionNo())!= null) {

            return  "This student is already exists";
        }

         studentMap.put(student.getAdmissionNo(),student);

        return "Congrats! new student added Sucessfully";
    }

    public Student getStudent2(int admissionNo) {


          return  studentMap.get(admissionNo);
    }

    public String removeStudent(int admissionNo) {


        if(studentMap.get(admissionNo)==null)  return  "";

         studentMap.remove(admissionNo);

         return "Student get removed successfull with admissionNo "+ admissionNo;



    }

    public String updateStudentCourse(int admissonNo, String course) {


           Student student = studentMap.get(admissonNo);

           if(student == null) return "";

           else{

                student.setCourse(course);

                studentMap.put(admissonNo,student);

                return  "Course is updated successfully to this admissionNo "+admissonNo;
           }





    }

    public String totalNumofStudents(int age) {

        int count=0;

            for(int key: studentMap.keySet()){

                if(studentMap.get(key).getAge()> age) count++;
            }

            return "Total number of students who has greater than the give "+age+ " is " + count;


    }
}
