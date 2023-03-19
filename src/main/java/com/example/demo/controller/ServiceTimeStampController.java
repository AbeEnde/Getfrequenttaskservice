package com.example.demo.controller;

import com.example.demo.model.ServiceTimestamp;
import com.example.demo.repository.ServiceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceTimeStampController {
    @Autowired
    ServiceTaskRepository serviceTaskRepository;

    @GetMapping("/getServiceTime")
    public List<ServiceTimestamp> getServiceTimeStamp() {

        return serviceTaskRepository.findAll();
    }
    
}
