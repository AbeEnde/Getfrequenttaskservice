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
    private Long id;


    @Column(name = "serviceName")
    private String name;

    @Column(name = "service_type" )
    private String type = "1";

    @Column(name = "link" )
    private String link;

    @Column(name = "is_browser_link" )
    private String isBrowserLink;

    @Column(name = "icon" )
    private String icon;

    @Column(name = "color" )
    private String color;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Task> tasks;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    public Service(){}

    public Service(Long id, String name, String type, String link, String isBrowserLink, String icon, String color, List<Task> tasks, Category category) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.link = link;
        this.isBrowserLink = isBrowserLink;
        this.icon = icon;
        this.color = color;
        this.tasks = tasks;
        this.category = category;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceid(Long serviceid) {
        this.id = serviceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIsBrowserLink() {
        return isBrowserLink;
    }

    public void setIsBrowserLink(String isBrowserLink) {
        this.isBrowserLink = isBrowserLink;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
