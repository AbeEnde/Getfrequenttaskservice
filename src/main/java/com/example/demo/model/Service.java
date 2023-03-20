package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "serviceid")
    private Long serviceid;


    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "service_type" )
    private String serviceType = "1";

    @Column(name = "link" )
    private String link;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Task> tasks;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    public Service(){}
    public Service( Long serviceID,String serviceName,Category category) {
        this.serviceid = serviceID;
        this.serviceName = serviceName;
        this.category = category;
    }

    public Long getId() {
        return serviceid;
    }

    public void setId(Long id) {
        this.serviceid = id;
    }

    public long getServiceid() {
        return serviceid;
    }

    public void setServiceid(long serviceid) {
        this.serviceid = serviceid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceid(Long serviceid) {
        this.serviceid = serviceid;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @JsonBackReference
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonManagedReference
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
