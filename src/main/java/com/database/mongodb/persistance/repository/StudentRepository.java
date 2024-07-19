package com.database.mongodb.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.database.mongodb.persistance.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    
}
