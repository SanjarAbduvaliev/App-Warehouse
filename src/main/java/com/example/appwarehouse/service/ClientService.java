package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.payload.ClientDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public Result add(ClientDto clientDto){
        Client client=new Client();
        client.setName(clientDto.getName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        return new Result("Xaridor saqlandi",true);
    }
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Client getId(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            return null;
        }
        return optionalClient.get();
    }
    public Result edit(ClientDto clientDto,Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            return new Result("Haridor topilmadi",false);
        }
        Client client = optionalClient.get();
        client.setName(clientDto.getName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        return new Result("Xaridor o'zgaritildi",true);
    }
    public Result delete(Integer id){
        clientRepository.deleteById(id);
        return new Result("Xaridor o'chirildi",true);
    }
}
