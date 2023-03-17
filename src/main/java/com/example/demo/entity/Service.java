package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceid")
    private long serviceid;

    @Column(name = "serviceName")
    private String serviceName;


}
