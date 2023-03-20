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

    @Column(name = "task_type" )
    private String taskType = "1";

    @Column(name = "link" )
    private String link;

    @Column(name = "is_browser_link" )
    private String isBrowserLink;

    @Column(name = "icon" )
    private String icon;

    @Column(name = "color" )
    private String color;
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "serviceid")
    private Service service;
    public Task(){}

    public Task(Long taskID, String taskName, String taskType, String link, String isBrowserLink, String icon, String color, Service service) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskType = taskType;
        this.link = link;
        this.isBrowserLink = isBrowserLink;
        this.icon = icon;
        this.color = color;
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

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIsBrowserLink() {
        return isBrowserLink;
    }

    public void setIsBrowserLink(String isBrowserLink) {
        this.isBrowserLink = isBrowserLink;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JsonBackReference
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
