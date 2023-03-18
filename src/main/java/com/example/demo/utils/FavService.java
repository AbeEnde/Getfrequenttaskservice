package com.example.demo.utils;

public class FavService {
    private Long serviceid;
    private String serviceName;
    private String catagory;
    private String userID;

    public FavService(){}

    public FavService(Long serviceId, String serviceName, String catagory, String userID) {
        this.serviceid = serviceId;
        this.serviceName = serviceName;
        this.catagory = catagory;
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

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
