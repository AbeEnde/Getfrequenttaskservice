package com.example.demo.feature;

import com.example.demo.model.ServiceTimestamp;
import com.example.demo.repository.ServiceTaskRepository;

import java.util.List;


public class ServiceTaskPersist {
    public ServiceTaskPersist(){}

    private ServiceTaskRepository servicetaskrepositary;

    public ServiceTaskPersist(ServiceTaskRepository servicetaskrepositary) {
        this.servicetaskrepositary = servicetaskrepositary;
    }


    public ServiceTimestamp createServiceTimestamp(ServiceTimestamp serviceTimestamp) {
        return servicetaskrepositary.save(serviceTimestamp);
    }

    public List<ServiceTimestamp> getAllServiceTimestamp(){
        return servicetaskrepositary.findAll();
    }
}
