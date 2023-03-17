package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
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
    private String serviceID;

    @Column(name = "taskID")
    private String taskID;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

}
