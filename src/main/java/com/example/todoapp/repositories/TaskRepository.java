package com.example.todoapp.repositories;

import com.example.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//いまいち役割がわからない
public interface TaskRepository extends JpaRepository<Task, Long> {
}
