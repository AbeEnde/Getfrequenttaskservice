package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private  CategoryService categoryService;
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }


    @GetMapping("/getCategory")
    public List<Category> getAllCatagory(){
        return categoryService.findAll();
    }

}
