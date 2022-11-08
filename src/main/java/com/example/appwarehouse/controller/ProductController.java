package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.payload.Productdto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Result add(@RequestBody Productdto productdto){
        return productService.addProduct(productdto);
    }
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getId(@PathVariable Integer id){
        return productService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody Productdto productdto,@PathVariable Integer id){
        return productService.edit(productdto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return productService.delete(id);
    }
}
