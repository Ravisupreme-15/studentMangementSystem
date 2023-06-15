package com.example.student_management_portal;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    // i need to store the student info
    // so i prefer use hashtable
    // i have set key -int- admno     val - student


    Map<Integer,Student> studentMap = new HashMap<>();

    // get info of student
    // i need to make student info get api
    // so that i need to make api endpoint aswell

     @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admissionNo){

        return  studentMap.get(admissionNo);
    }



    // add new student obj into database
    // fot that i need to make post api


    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

          studentMap.put(student.getAdmissionNo(),student);
          return "Congrats! new student added Sucessfully";
    }

    @GetMapping("/get/{id}")
    public Student getStudentByPathVariable(@PathVariable("id")  int admissionNo){

        return studentMap.get(admissionNo);

     }

     // to delete the student instance from the database
     @DeleteMapping("/del")
     public String delStudentInfo(@RequestParam("id") int admissionNo){


            studentMap.remove(admissionNo);
            return   admissionNo+" is removed from the db, you can check with getApi if you want ";
     }


     // update the course name with admission number


    @PutMapping("/put/{id}/{course}")
    public String updateStuendInfo(@PathVariable("id") int admissonNo, @PathVariable("course") String course){

                Student student = studentMap.get(admissonNo);

               student.setCourse(course);
               studentMap.put(admissonNo,student);
               return "you have successfully update"+ course+ " to " + " admission no"+ admissonNo;
    }



    // get the total number of student age greater the given age by client

   @GetMapping("/noOfstudentsage>")
    public String  totalNumofstudnets(@RequestParam("id") int age){


         int count=0;

         for(int key : studentMap.keySet()){

              if(studentMap.get(key).getAge()>age) count++;
         }

         return "Total number of students whose age > "+ age+" is "+ count;
    }







    
    



}
