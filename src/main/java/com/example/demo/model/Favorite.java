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

    public Favorite(){}
    public Favorite(Long id, String userID, Long serviceID) {
        this.id = id;
        this.userID = userID;
        this.serviceID = serviceID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
