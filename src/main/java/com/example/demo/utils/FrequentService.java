package com.example.demo.utils;

public class FrequentService {
    private String userID;
    private  Long serviceID;
    private String serviceName;
    private int count;
    public FrequentService(){}
    public FrequentService( String userID,int count, Long serviceID, String serviceName ) {
        this.userID = userID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
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


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
