package com.example.demo.utils;

public class FrequentTask {
    private String userID;
    private  Long taskID;
    private String taskName;
    private int count;

    public FrequentTask(){}

    public FrequentTask( String userID, int count, Long taskID, String taskName ) {
        this.userID = userID;
        this.count = count;
        this.taskID = taskID;
        this.taskName = taskName;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
