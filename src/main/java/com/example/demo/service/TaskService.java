package com.example.demo.service;

import com.example.demo.model.ServiceTimestamp;
import com.example.demo.model.Task;
import com.example.demo.repository.ServiceTaskRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.utils.FrequentTask;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ServiceTaskRepository serviceTaskRepository;

    private int topN = 5;

    public Task save(Task task){
        if(task.getTaskType().equals("0")){
            return taskRepository.save(decideExternalLinkType(task));
        }

        return taskRepository.save(task);
    }

    Task decideExternalLinkType(Task task){
        if(task.getLink().startsWith("http://www")||task.getLink().startsWith("https://www")){
            task.setIsBrowserLink("br");
        }else{
            task.setIsBrowserLink("app");
        }
        return task;
    }

    public List<Task> findAll(){
       return taskRepository.findAll();
    }

    public Task findById(Long id){
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
        return task;
    }

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

  public List<FrequentTask> findTopNtasks(){
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

    public List<FrequentTask> getFrequentTask(){
        return taskRepository.getFrequentTask();
    }

}
