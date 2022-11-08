package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.payload.InputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputContoller {
    @Autowired
    InputService inputService;

    @PostMapping
    public Result add(@RequestBody InputDto inputDto){
        return inputService.add(inputDto);
    }
    @GetMapping
    public List<Input> getAll(){
        return inputService.getAll();
    }
    @GetMapping("/{id}")
    public Input getId(@PathVariable Integer id){
        return inputService.getID(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody InputDto inputDto,@PathVariable Integer id){
        return inputService.edit(inputDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return inputService.delete(id);
    }
}
