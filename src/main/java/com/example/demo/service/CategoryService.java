package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<String> save(Category category){
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body("Category Added Successfully");
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
