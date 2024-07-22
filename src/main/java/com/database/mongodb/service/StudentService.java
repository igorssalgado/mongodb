package com.database.mongodb.service;

import java.util.*;

import com.database.mongodb.model.StudentRequest;
import com.database.mongodb.model.StudentResponse;
import com.database.mongodb.persistance.entity.Student;

public interface StudentService {
    
    StudentResponse create(StudentRequest request);
    List<StudentResponse> getAll();
    String deleteById(String id);
    Optional<Student> findById(String id);
}
