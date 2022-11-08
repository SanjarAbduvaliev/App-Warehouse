package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.WarehouseService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WarehoseController {
    @Autowired
    WarehouseService warehouseService;
    @PostMapping
    public Result add(@RequestBody Warehouse warehouseDto){
        return warehouseService.add(warehouseDto);
    }
    @GetMapping
    public List<Warehouse> getAll(){
        return warehouseService.geAll();
    }
    @GetMapping("/{id}")
    private Warehouse getId(@PathVariable Integer id){
        return warehouseService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody Warehouse warehouseDto, @PathVariable Integer id){
        return warehouseService.editWarehose(warehouseDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return warehouseService.deleteWarehose(id);
    }
}
