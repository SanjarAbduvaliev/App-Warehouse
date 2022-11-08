package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @PostMapping
    public Result add(Supplier supplierDto){
        return supplierService.addSupplier(supplierDto);
    }
    @GetMapping
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }
    @GetMapping("/{id}")
    public Supplier getId(@PathVariable Integer id){
        return supplierService.getIdSupplier(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody Supplier supplierDto,@PathVariable Integer id){
        return supplierService.edit(supplierDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return supplierService.delete(id);
    }
}
