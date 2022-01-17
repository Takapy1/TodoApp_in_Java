package com.example.todoapp.controllers;

import com.example.todoapp.models.Task;
import com.example.todoapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api") // このコントローラが受け付けるリクエストのパスやメソッドやクエリパラメータを指定できる
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping(value = "/todos")
    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    @GetMapping(value = "/todo/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PostMapping(value = "/todo")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task result = taskRepository.save(task);
        return new ResponseEntity<Task>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/todo/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping(value = "/todo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
