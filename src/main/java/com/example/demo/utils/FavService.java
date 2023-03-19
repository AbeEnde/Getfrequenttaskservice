package com.example.demo.utils;

public class FavService {
    private Long serviceid;
    private String serviceName;
    private String userID;

    public FavService(){}

    public FavService(Long serviceId, String serviceName, String userID) {
        this.serviceid = serviceId;
        this.serviceName = serviceName;
       // this.tasks = tasks;
        this.userID = userID;
    }

    public Long getServiceId() {
        return serviceid;
    }

    public void setServiceId(Long serviceId) {
        this.serviceid = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
