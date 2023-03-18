package com.example.demo.utils;

public class FrequentService {
    private String userID;
    private  Long serviceID;
    private String serviceName;
    private String catagory;
    private int count;

    public FrequentService(){}
    public FrequentService( String userID,int count, Long serviceID, String serviceName,String catagory) {
        this.userID = userID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.catagory = catagory;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
