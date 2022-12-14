package com.example.appwarehouse.service;

import com.example.appwarehouse.controller.CategoryController;
import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.payload.CategoryDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParrenCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParrenCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("Bunday kategoriya mavjud emas", false);
            category.setParrentCategoryId(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Categoriya qo'shildi", true);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryId(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return category;

        }
        return null;
    }

    public Result edit(CategoryDto categoryDto, Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            return new Result("Bazada bunday kategoriya mavjud emas", false);
        }
        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        if (categoryDto.getParrenCategoryId() != null) {
            Optional<Category> byId = categoryRepository.findById(categoryDto.getParrenCategoryId());
            if (!byId.isPresent()){
                return new Result("Omborda bunay kategoriya mavjud emas",false);
            }
            category.setParrentCategoryId(byId.get());
        }
        return new Result("Categoriya tahrirlandi",true);
    }
    public Result delete(Integer id){
        String name = categoryRepository.findById(id).get().getName();
        categoryRepository.deleteById(id);
        return new Result(name+" categoriya bazadan olib tashlandi",true);
    }
}
