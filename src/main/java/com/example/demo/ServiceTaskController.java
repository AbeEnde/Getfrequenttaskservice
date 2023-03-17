package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceTaskController {

    private ServiceTaskRepository servicetaskrepositary;

    @PostMapping("/addAccesedservicetask")
    public ServiceTimestamp createServiceTimestamp(@RequestBody ServiceTimestamp serviceTimestamp) {
        return servicetaskrepositary.save(serviceTimestamp);
    }
    @GetMapping("/getAccesedservicetask")
    public List<ServiceTimestamp> getAllServiceTimestamp(){
        return servicetaskrepositary.findAll();
    }
}
