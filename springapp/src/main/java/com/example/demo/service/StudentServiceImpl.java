package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        int score=0;
        if(student.getErDiagram().equalsIgnoreCase("completed")){
            score+=50;
        }
        if(student.getUserStory1().equalsIgnoreCase("completed")){
            score+=100;
        }
        if(student.getUserStory2().equalsIgnoreCase("completed")){
            score+=150;
        }
        if(student.getUserStory3().equalsIgnoreCase("completed")){
            score+=200;
        }
        student.setIndividualScore(score);
        return studentRepository.save(student);
    }
}
