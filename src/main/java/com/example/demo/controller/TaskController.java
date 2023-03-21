package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.utils.FrequentTask;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


     @Autowired
     private TaskService taskService;


    @GetMapping("/getFrequentTask")
    public List<FrequentTask> getFrequent(){

        return taskService.getFrequentTask();
    }

    @GetMapping("/getTopnTasks")
    public List<FrequentTask> getTop_n_Tasks(){
        return taskService.findTopNtasks();
    }



    @PostMapping("/addTask")
    public Task createTask(@RequestBody Task task) {
       return taskService.save(task);
    }


    @GetMapping("/getTask")
    public List<Task> getAllTask(){
        return taskService.findAll();
    }


    @GetMapping("/getTask/{id}")
    public Task getTaskByID(@PathVariable("id") Long id) {

        return taskService.findById(id);
    }

}
