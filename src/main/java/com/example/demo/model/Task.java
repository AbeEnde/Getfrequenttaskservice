package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import javax.persistence.Table;
@Entity
@Table(name = "task")
public class Task {


    @Id
    @jakarta.persistence.Column(name = "task_id", nullable = false)
    private Long taskID;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "catagory")
    private String catagory;


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

}
