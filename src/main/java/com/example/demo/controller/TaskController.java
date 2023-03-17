package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/addTask")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @GetMapping("/getTask")
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }
}
