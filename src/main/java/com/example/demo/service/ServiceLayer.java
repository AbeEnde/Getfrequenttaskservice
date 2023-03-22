package com.example.demo.service;

import com.example.demo.model.Service;
import com.example.demo.model.ServiceTimestamp;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.ServiceTaskRepository;
import com.example.demo.utils.FrequentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class ServiceLayer {
    @Autowired
   private ServiceRepository serviceRepository;

    @Autowired
   private ServiceTaskRepository serviceTaskRepository;

    private  int topN = 5;

    public  ResponseEntity<String> save(Service service){
        if(service.getType().equals("0")){
            Service result = serviceRepository.save(decideExternalLinkType(service));
        }else{
            Service result = serviceRepository.save(service);
        }

        return ResponseEntity.ok().body("A service Added Successfully!!");
    }

    com.example.demo.model.Service decideExternalLinkType(com.example.demo.model.Service service){
        if(service.getLink().startsWith("http://www")||service.getLink().startsWith("https://www")){
            service.setIsBrowserLink("br");
        }else{
            service.setIsBrowserLink("app");
        }
        return service;
    }

    public List<Service> findAll(){
        return serviceRepository.findAll();
    }

    public Service findById(Long id){

        Service service = serviceRepository.findById(id)
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

        return service;

    }

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

    public List<FrequentService> getFrequent(){
        return serviceTaskRepository.getFrequent();
    }

   public List<FrequentService> findTopNservices(){
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


}
