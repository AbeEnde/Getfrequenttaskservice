package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/*

This is an entity for our ServiceAndTaskTimestamp
store here userId serviceID taskID and timestamp then
we count and see which service and task are used frequently.

 */
@Entity
@Table(name = "ServiceTimestamp")
public class ServiceTimestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userID")
    private String userID;


    @Column(name = "serviceID")
    private Long serviceID;

    @Column(name = "taskID")
    private Long taskID;

    @Column(name = "timestamp")
    private Date timestamp;

    public ServiceTimestamp(){}
    public ServiceTimestamp( String userID, Long serviceID, Long taskID) {
        this.userID = userID;
        this.serviceID = serviceID;
        this.taskID = taskID;
        this.timestamp = Calendar.getInstance().getTime();
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
}
