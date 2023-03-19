package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.persistence.Table;
@Entity
@Table(name = "task")
public class Task {


    @Id
    @jakarta.persistence.Column(name = "task_id", nullable = false)
    private Long taskID;

    @Column(name = "taskName")
    private String taskName;


    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "serviceid")
    private Service service;
    public Task(){}
    public Task(Long taskID, String taskName, String catagory,Service service) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.service = service;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @JsonBackReference
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
