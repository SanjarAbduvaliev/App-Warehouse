package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.SuplierRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SuplierRepository suplierRepository;
    public Result addSupplier(Supplier supplierDto){
        Supplier supplier=new Supplier();
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setName(supplierDto.getName());
        suplierRepository.save(supplier);
        return new Result("Saqlandi",true);
    }
    public List<Supplier> getAll(){
        return suplierRepository.findAll();
    }
    public Supplier getIdSupplier(Integer id){
        Optional<Supplier> optionalSupplier = suplierRepository.findById(id);
        if (!optionalSupplier.isPresent()){
            return null;
        }
        return optionalSupplier.get();
    }
    public Result edit(Supplier supplierDto,Integer id){
        Optional<Supplier> optionalSupplier = suplierRepository.findById(id);

        if (!optionalSupplier.isPresent()){
            return new Result("Bunaqa ismlik yetkazuvchi mavjud emas",false);
        }
        Supplier supplier = optionalSupplier.get();
        supplier.setName(supplierDto.getName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        suplierRepository.save(supplier);
        return new Result("Yetkazuvchi o'zgartirildi",true);
    }
    public Result delete(Integer id){
        suplierRepository.deleteById(id);
        return new Result("Yetkazuvchi o'chirildi",true);
    }

}
