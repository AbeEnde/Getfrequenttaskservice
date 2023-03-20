package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.model.ServiceTimestamp;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.ServiceTaskRepository;
import com.example.demo.utils.FrequentService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServiceController {

    private int topN = 5;
    private ServiceRepository serviceRepositary;
    private ServiceTaskRepository serviceTaskRepository;


    public ServiceController(ServiceRepository serviceRepositary,ServiceTaskRepository serviceTaskRepository) {
        this.serviceRepositary = serviceRepositary;
        this.serviceTaskRepository = serviceTaskRepository;
    }

    @GetMapping("/getFrequentService")
    public List<FrequentService> getFrequentService(){

        return serviceTaskRepository.getFrequent();
    }

    @GetMapping("/getTopnService")
    public List<FrequentService> getTop_n_Service(){
        return findTopNservices();
    }

    List<FrequentService> findTopNservices(){
        List<FrequentService> frequentServs = serviceTaskRepository.getFrequent();
        List<FrequentService> topNservices = new ArrayList<>();
        for(FrequentService frequentServ:frequentServs){
            if(topNservices.size()>=topN){
                break;
            }
            topNservices.add(frequentServ);
        }
        return topNservices;
    }


    @PostMapping("/addService")
    public Service createService(@RequestBody Service service) {
        if(service.getType().equals("0")){
            return serviceRepositary.save(decideExternalLinkType(service));
        }

        return serviceRepositary.save(service);

    }
    Service decideExternalLinkType(Service service){
        if(service.getLink().startsWith("http://www")||service.getLink().startsWith("https://www")){
            service.setIsBrowserLink("br");
        }else{
            service.setIsBrowserLink("app");
        }
        return service;
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
            if(getAvailableService().contains(service.getId())){
                ServiceTimestamp servTime =findAllServiceTime(service.getId());
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
