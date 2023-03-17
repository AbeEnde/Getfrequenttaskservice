package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {
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

    @GetMapping("/getService/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Service service = serviceRepositary.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not exist with id :" + id));
        if(service.getServiceid()==id){
            serviceTaskController.createServiceTimestamp(new ServiceTimestamp("1",id,0L));
        }
        return ResponseEntity.ok(service);
    }
}
