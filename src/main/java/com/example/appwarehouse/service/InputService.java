package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.InputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.CurrencyRepository;
import com.example.appwarehouse.repository.InputRepository;
import com.example.appwarehouse.repository.SuplierRepository;
import com.example.appwarehouse.repository.WarehoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SuplierRepository suplierRepository;
    @Autowired
    WarehoseRepository warehoseRepository;
    @Autowired
    InputRepository inputRepository;


    public Result add(InputDto inputDto){
        Input input=new Input();
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        Optional<Supplier> optionalSupplier = suplierRepository.findById(inputDto.getSupplierId());
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(inputDto.getWarehoseid());
        input.setCurrency(optionalCurrency.get());
        input.setSupplier(optionalSupplier.get());
        input.setWarehouse(optionalWarehouse.get());
        input.setCode("1");
        input.setFactureNumber("1");
        inputRepository.save(input);
        return  new Result("Saqlandi",true);
    }
    public List<Input> getAll(){
        return inputRepository.findAll();
    }
    public Input getID(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        return optionalInput.get();
    }
    public Result edit(InputDto inputDto, Integer id){
        Warehouse warehouseId = inputRepository.findByWarehouse_Id(inputDto.getCurrencyId());
        Currency currencyId = inputRepository.findByCurrency_Id(inputDto.getCurrencyId());
        Supplier supplierId = inputRepository.findBySupplier_Id(inputDto.getSupplierId());

        Optional<Input> optionalInput = inputRepository.findById(id);
        Input input = optionalInput.get();
        input.setTimestamp(inputDto.getTimestamp());
        input.setCode("1");
        input.setFactureNumber("1");
        input.setWarehouse(warehouseId);
        input.setCurrency(currencyId);
        input.setSupplier(supplierId);
        return new Result("Kirim o'zgartirildi",true);
    }
    public Result delete(Integer id){
        inputRepository.deleteById(id);
        return new Result("Kirim olib tashlandi",true);
    }
}
