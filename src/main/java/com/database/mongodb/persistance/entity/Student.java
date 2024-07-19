package com.database.mongodb.persistance.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

    @Id
    private String id;
    private String name;
    private LocalDate birthdate;
    private String document;

    public Student() {
    }

    public Student(String id, String name, LocalDate birthdate, String document) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getId() {
        return null;
    }

}
