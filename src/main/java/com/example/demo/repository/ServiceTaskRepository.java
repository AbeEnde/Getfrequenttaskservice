package com.example.demo.repository;
import com.example.demo.utils.FrequentService;
import com.example.demo.model.ServiceTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTaskRepository extends JpaRepository<ServiceTimestamp, Long> {
    @Query(value = "SELECT new com.example.demo.utils.FrequentService(t.userID, t.count, s.serviceid , s.serviceName, s.catagory) from ServiceTimestamp t " +
            "INNER JOIN Service s ON s.serviceid = t.serviceID ORDER BY t.count DESC"
    )
    List<FrequentService> getFrequent();

    ServiceTimestamp findByServiceID(Long serviceID);
}
