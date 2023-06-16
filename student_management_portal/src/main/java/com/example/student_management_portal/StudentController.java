package com.example.student_management_portal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {




    @Autowired
       StudentService studentService;


    // i need to store the student info
    // so i prefer use hashtable
    // i have set key -int- admno     val - student




    // get info of student
    // i need to make student info get api
    // so that i need to make api endpoint aswell

     @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admissionNo){

        Student student =  studentService.getStudent1(admissionNo);

        if(student == null){

            return  new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(student,HttpStatus.ACCEPTED);
        }
    }



    // add new student obj into database
    // fot that i need to make post api


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){


          String s = studentService.addStudent(student);

          return new ResponseEntity(s,HttpStatus.ACCEPTED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStudent2(@PathVariable("id")  int admissionNo){

         Student student =  studentService.getStudent2(admissionNo);



          if(student!=null){
              return new ResponseEntity(student,HttpStatus.ACCEPTED);
          }
          else{
              return new ResponseEntity("The student with admissionNo "+admissionNo+" doest not exists",HttpStatus.NOT_FOUND);
          }

     }

     // to delete the student instance from the database
     @DeleteMapping("/del")
     public ResponseEntity delStudentInfo(@RequestParam("id") int admissionNo){

           String s =  studentService.removeStudent(admissionNo);

           if(s.length()==0){

               return new ResponseEntity("This student is not found",HttpStatus.NOT_FOUND);
           }
           else{
               return new ResponseEntity(s,HttpStatus.ACCEPTED);
           }


     }


     // update the course name with admission number


    @PutMapping("/put/{id}/{course}")
    public ResponseEntity updateStuendtInfo(@PathVariable("id") int admissonNo, @PathVariable("course") String course){



         String s = studentService.updateStudentCourse(admissonNo,course);

         if(s.length()==0) {

             return new ResponseEntity("you have entered wrong addmissionNo",HttpStatus.NOT_FOUND);
         }
         else{
             return new ResponseEntity(s,HttpStatus.ACCEPTED);
         }


    }



    // get the total number of student age greater the given age by client

   @GetMapping("/noOfstudentsage>")
    public ResponseEntity  totalNumofstudnets(@RequestParam("id") int age){



          String s =  studentService.totalNumofStudents(age);


          return new ResponseEntity(s,HttpStatus.FOUND);



    }







    
    



}
