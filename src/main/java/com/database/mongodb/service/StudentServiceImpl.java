package com.database.mongodb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.mongodb.model.StudentRequest;
import com.database.mongodb.model.StudentResponse;
import com.database.mongodb.persistance.entity.Student;
import com.database.mongodb.persistance.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    // cria o Student com nome, documento e aniversario. O Id é gerado automatico no mongo.
    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDocument(request.getDocument());
        student.setBirthdate(request.getBirthdate());

        repository.save(student);

        return createResponse(student);
    }

    // pra retornar o student sempre que precisar
    private StudentResponse createResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthdate(student.getBirthdate());

        return response;
    }

    @Override
    public List<StudentResponse> getAll() {
        //inicializa um array das reponses
        List<StudentResponse> responses = new ArrayList<>();

        // vai no banco e procura todos students
        List<Student> students = repository.findAll();

        // se retornar alguma coisa, adiciona cada um no array de responses
        if(!students.isEmpty()){
            for (Student student : students) {
                responses.add(createResponse(student));
            }
        }

        return responses;
    }

}
