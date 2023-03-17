package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepositary;
    @Autowired
    private ServiceTaskController serviceTaskController;

    @PostMapping("/addService")
    public Service createService(@RequestBody Service service) {
        return serviceRepositary.save(service);
    }
    @GetMapping("/getService")
    public List<Service> getAllService(){
        return serviceRepositary.findAll();
    }
}
