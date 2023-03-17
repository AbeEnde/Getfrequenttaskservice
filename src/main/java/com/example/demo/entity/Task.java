package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskID")
    private long taskID;

    @Column(name = "taskName")
    private String taskName;

}
