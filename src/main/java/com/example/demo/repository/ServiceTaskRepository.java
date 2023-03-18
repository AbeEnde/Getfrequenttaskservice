package com.example.demo.repository;
import com.example.demo.model.ServiceTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTaskRepository extends JpaRepository<ServiceTimestamp, Long>{
    @Query(value = "SELECT new com.example.demo.model.ServiceTimestamp(s.serviceID)from ServiceTimestamp s")
    List<Long> getServiceID();
}
