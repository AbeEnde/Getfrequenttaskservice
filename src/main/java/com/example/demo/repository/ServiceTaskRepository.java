package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ServiceTimestamp;

@Repository
public interface ServiceTaskRepository extends JpaRepository<ServiceTimestamp, Long>{

}
