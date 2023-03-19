package com.example.demo.controller;

import com.example.demo.repository.ServiceTaskRepository;
import com.example.demo.utils.FrequentTask;
import com.example.demo.model.ServiceTimestamp;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private int topN = 5;
    private TaskRepository taskRepository;

    @Autowired
    private ServiceTaskRepository serviceTaskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/getFrequentTask")
    public List<FrequentTask> getFrequent(){

        return taskRepository.getFrequentTask();
    }

    @GetMapping("/getTopnTasks")
    public List<FrequentTask> getTop_n_Tasks(){
        return findTopNtasks();
    }

    List<FrequentTask> findTopNtasks(){
        List<FrequentTask> frequentTasks = taskRepository.getFrequentTask();
        List<FrequentTask> topNtasks = new ArrayList<>();
        for(FrequentTask frequentTask:frequentTasks){
            if(topNtasks.size()>=topN){
                break;
            }
            topNtasks.add(frequentTask);
        }
        return topNtasks;
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
    public ResponseEntity<Task> getTaskByID(@PathVariable("id") Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not exist with id :" + id));
        if(getAvailableTaskId()!=null){
            if(getAvailableTaskId().contains(task.getTaskID())){
                ServiceTimestamp servTime =findAllServiceTime(task.getTaskID());
                servTime.setCount(servTime.getCount()+1);
                addUpdateServiceTimestamp(servTime);
            } else {
                addUpdateServiceTimestamp(new ServiceTimestamp("ab1",0l,id,1));
            }
        }else{
            addUpdateServiceTimestamp(new ServiceTimestamp("ab1",0l,id,1));
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping("/updateTask")
    public void addUpdateServiceTimestamp(ServiceTimestamp serviceTimestamp) {
        serviceTaskRepository.save(serviceTimestamp);
    }

    List<Long> getAvailableTaskId(){
        List<ServiceTimestamp> availableService = serviceTaskRepository.findAll();
        List<Long> listTaskId = new ArrayList<>();

        for (ServiceTimestamp task: availableService ) {
            listTaskId.add(task.getTaskID());
        }

        return listTaskId;
    }

    ServiceTimestamp findAllServiceTime(Long taskID) {

        return serviceTaskRepository.findByTaskID(taskID);
    }

}
