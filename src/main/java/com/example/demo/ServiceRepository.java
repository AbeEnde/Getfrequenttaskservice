package com.example.demo;

import com.example.demo.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ServiceRepository extends JpaRepository<Service, Long> {

}