package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.payload.ClientDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @PostMapping
    public Result add(@RequestBody ClientDto clientDto){
        return clientService.add(clientDto);
    }
    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Client getId(@PathVariable Integer id){
        return clientService.getId(id);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody ClientDto clientDto, @PathVariable Integer id){
        return clientService.edit(clientDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return clientService.delete(id);
    }

}
