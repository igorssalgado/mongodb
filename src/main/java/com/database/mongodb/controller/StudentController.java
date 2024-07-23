package com.database.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.mongodb.model.StudentRequest;
import com.database.mongodb.model.StudentResponse;
import com.database.mongodb.persistance.entity.Student;
import com.database.mongodb.service.StudentService;

@RestController
@RequestMapping("/v1")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable String id) {
        ResponseEntity.ok(service.deleteById(id));
        return "id: " + id + " deleted";
    }

    @GetMapping(value = "{id}")
    public Optional<Student> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping(value = "/update")
    public StudentResponse update(@RequestBody StudentRequest request) {
        return service.update(request);
    }
}
