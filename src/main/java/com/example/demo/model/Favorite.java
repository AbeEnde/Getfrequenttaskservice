package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "userID")
    private String userID;
    @Column(name = "serviceID")
    private Long serviceID;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "catagory")
    private String catagory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceID() {
        return serviceID;
    }

    public void setServiceID(Long serviceID) {
        this.serviceID = serviceID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public Favorite(){}

    public Favorite(Long id, String userID, Long serviceID, String serviceName, String catagory) {
        this.id = id;
        this.userID = userID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.catagory = catagory;
    }
}
