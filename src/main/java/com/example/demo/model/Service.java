package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "serviceid")
    private Long serviceid;


    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "catagory")
    private String catagory;

    public Service(){}
    public Service(String serviceName, String catagory) {
        this.serviceName = serviceName;
        this.catagory = catagory;
    }

    public Long getId() {
        return serviceid;
    }

    public void setId(Long id) {
        this.serviceid = id;
    }

    public long getServiceid() {
        return serviceid;
    }

    public void setServiceid(long serviceid) {
        this.serviceid = serviceid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}
