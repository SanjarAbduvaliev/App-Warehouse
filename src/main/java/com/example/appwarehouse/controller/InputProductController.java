package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.ReceiptProduct;
import com.example.appwarehouse.payload.InputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.InputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inputproduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;
    @PostMapping
    public Result add(InputProductDto inputProductDto){
        return inputProductService.add(inputProductDto);
    }
    @GetMapping
    public List<ReceiptProduct> getAll(){
        return inputProductService.getAll();
    }
    @GetMapping("/{id}")
    public ReceiptProduct getId(@PathVariable Integer id){
        return inputProductService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody InputProductDto inputProductDto, @PathVariable Integer id){
        return inputProductService.edit(inputProductDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return inputProductService.delete(id);
    }
}
