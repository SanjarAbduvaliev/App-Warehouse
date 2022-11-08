package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Sale;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.SaleDto;
import com.example.appwarehouse.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService service;

    @PostMapping
    public Result add(@RequestBody SaleDto saleDto){
        return service.addSale(saleDto);
    }
    @GetMapping
    public List<Sale> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Sale getId(@PathVariable Integer id){
        return service.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody SaleDto saleDto,@PathVariable Integer id){
        return service.edit(saleDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
