package com.example.todoapp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String summary;
    private Boolean is_done = false;

    // constructor
    public Task(){}
}
