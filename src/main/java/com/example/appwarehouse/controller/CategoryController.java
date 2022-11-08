package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.payload.CategoryDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PutMapping
    public Result add(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAllCategory();
    }
    @GetMapping("/{id}")
    public Category getId(@PathVariable Integer id){
        return categoryService.getCategoryId(id);
    }
    @PutMapping("/edit/{id}")
    public Result edit(@RequestBody CategoryDto categoryDto, @PathVariable Integer id ){
        return categoryService.edit(categoryDto, id);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }
}
