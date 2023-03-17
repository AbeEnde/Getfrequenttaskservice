package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    private ServiceTaskController serviceTaskController;


    @PostMapping("/addTask")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @GetMapping("/getTask")
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not exist with id :" + id));
        if(task.getTaskID()==id){
            serviceTaskController.createServiceTimestamp(new ServiceTimestamp("1",0L,id));
        }
        return ResponseEntity.ok(task);
    }
}
