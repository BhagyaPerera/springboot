package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.repo.StudentRepo;

import com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    
@RestController
@RequestMapping("api/v1")

public class StudentController {
    
    @Autowired
    private StudentRepo repo;

    @PostMapping("students")
    public Student createStudent(@RequestBody final Student student){

           return  repo.save(student);

    }

   @GetMapping("students")
   public List<Student> GetallStudents(){

         return repo.findAll();

   }

   @GetMapping("students/{id}")
   public Optional<Student> GetStudentbyId(@PathVariable("id") final Integer id) {
     
          return repo.findById(id);

   }

 
   @DeleteMapping("tudents/{id}")
   public Map <String,Boolean> DeleteStudent(@PathVariable("id") final Integer id){

     repo.deleteById(id);

     Map<String,Boolean> map=new HashMap<>();
     map.put("Deleted", Boolean.TRUE);
     return map;

   }




        
        
}
    