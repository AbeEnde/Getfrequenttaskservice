package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.model.ServiceTimestamp;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.ServiceTaskRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServiceController {

    private ServiceRepository serviceRepositary;
    private ServiceTaskRepository serviceTaskRepository;


    public ServiceController(ServiceRepository serviceRepositary,ServiceTaskRepository serviceTaskRepository) {
        this.serviceRepositary = serviceRepositary;
        this.serviceTaskRepository = serviceTaskRepository;
    }


    @PostMapping("/addService")
    public Service createService(@RequestBody Service service) {
        return serviceRepositary.save(service);
    }


    @GetMapping("/getService")
    public List<Service> getAllService(){
        return serviceRepositary.findAll();
    }


    @GetMapping("/getService/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable("id") Long id) {
        Service service = serviceRepositary.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not exist with id :" + id));

        if(getAvailableService()!=null) {
            if(getAvailableService().contains(service.getServiceid())){
                ServiceTimestamp servTime =findAllServiceTime(service.getServiceid());
                servTime.setCount(servTime.getCount()+1);
                addServiceTimestamp(servTime);
            } else {
                addServiceTimestamp(new ServiceTimestamp("ab1",id,0L,1));
            }
        } else {
            addServiceTimestamp(new ServiceTimestamp("ab1",id,0L,1));
        }

        return ResponseEntity.ok(service);
    }

    @PutMapping("/update")
    public void addServiceTimestamp(ServiceTimestamp serviceTimestamp) {
        serviceTaskRepository.save(serviceTimestamp);
    }

    List<Long> getAvailableService(){
        List<ServiceTimestamp> availableService = serviceTaskRepository.findAll();
        List<Long> listServiceId = new ArrayList<>();

       for (ServiceTimestamp service: availableService ) {
           listServiceId.add(service.getServiceID());
       }

       return listServiceId;
    }

    ServiceTimestamp findAllServiceTime(Long serviceId) {

        return serviceTaskRepository.findByServiceID(serviceId);
    }

}
