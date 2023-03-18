package com.example.demo.model;

import javax.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

/*

Based on the new requirement this class may no more needed

 */
@Entity
@Table(name = "servicetmestamp")
public class ServiceTimestamp {

    @Id
    @jakarta.persistence.Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Column(name = "userID")
    private String userID;


    @Column(name = "serviceID")
    private Long serviceID;

    @Column(name = "taskID")
    private Long taskID;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "count")
    private int count;

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceTimestamp(){}
    public ServiceTimestamp( String userID, Long serviceID, Long taskID,int count) {
        this.userID = userID;
        this.serviceID = serviceID;
        this.taskID = taskID;
        this.timestamp = Calendar.getInstance().getTime();
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
