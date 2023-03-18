package com.example.demo.utils;

public class FrequentTask {
    private String userID;
    private  Long taskID;
    private String taskName;
    private String catagory;
    private int count;

    public FrequentTask(){}

    public FrequentTask(String userID, int count, Long taskID, String taskName, String catagory) {
        this.userID = userID;
        this.count = count;
        this.taskID = taskID;
        this.taskName = taskName;
        this.catagory = catagory;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
