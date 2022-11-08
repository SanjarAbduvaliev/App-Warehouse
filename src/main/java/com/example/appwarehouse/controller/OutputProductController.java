package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.SaleProduct;
import com.example.appwarehouse.payload.OutputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;
    @PostMapping
    public Result add(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.add(outputProductDto);
    }
    @GetMapping
    public List<SaleProduct> getAll(){
        return outputProductService.getAll();
    }
    @GetMapping("/{id}")
    public SaleProduct getId(@PathVariable Integer id){
        return outputProductService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody OutputProductDto outputProductDto,@PathVariable Integer id){
        return outputProductService.edit(outputProductDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return outputProductService.delete(id);
    }
}
