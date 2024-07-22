package com.database.mongodb.service;

import java.util.*;

import com.database.mongodb.model.StudentRequest;
import com.database.mongodb.model.StudentResponse;

public interface StudentService {
    
    StudentResponse create(StudentRequest request);
    List<StudentResponse> getAll();
    String deleteById(String id);

}
