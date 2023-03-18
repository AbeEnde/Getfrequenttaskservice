package com.example.demo.controller;

import com.example.demo.feature.ServiceTaskPersist;
import com.example.demo.model.ServiceTimestamp;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskRepository taskRepository;
   // private ServiceTaskController serviceTaskController;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
       // this.serviceTaskController = serviceTaskController;
    }


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
        ServiceTaskPersist serviceTaskPersist = new ServiceTaskPersist();
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not exist with id :" + id));
        if(task.getTaskID()==id){
            serviceTaskPersist.createServiceTimestamp(new ServiceTimestamp("1",0L,id,1));
        }
        return ResponseEntity.ok(task);
    }
}
