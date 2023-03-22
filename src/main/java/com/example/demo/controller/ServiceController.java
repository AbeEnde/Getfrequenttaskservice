package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.service.ServiceLayer;
import com.example.demo.utils.FrequentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/getFrequentService")
    public List<FrequentService> getFrequentService(){

        return serviceLayer.getFrequent();
    }

    @GetMapping("/getTopnService")
    public List<FrequentService> getTop_n_Service(){
        return serviceLayer.findTopNservices();
    }



    @PostMapping("/addService")
    public ResponseEntity<String> createService(@RequestBody Service service) {
        return serviceLayer.save(service);
    }


    @GetMapping("/getService")
    public List<Service> getAllService(){
        return serviceLayer.findAll();
    }


    @GetMapping("/getService/{id}")
    public Service getServiceById(@PathVariable("id") Long id) {

       return serviceLayer.findById(id);
    }


}
