package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Sale;
import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.SaleDto;
import com.example.appwarehouse.repository.ClientRepository;
import com.example.appwarehouse.repository.CurrencyRepository;
import com.example.appwarehouse.repository.SaleRepository;
import com.example.appwarehouse.repository.WarehoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    WarehoseRepository warehoseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addSale(SaleDto saleDto){
        Optional<Warehouse> optionalWarehouse = warehoseRepository.findById(saleDto.getWarehoseId());
        Optional<Client> optionalClient = clientRepository.findById(saleDto.getClientId());
        Optional<Currency> optionalCurrency = currencyRepository.findById(saleDto.getCurrencyId());

        if (!optionalWarehouse.isPresent())
            return new Result("Bunaqa ombor mavjud emas",false);
        if (!optionalClient.isPresent())
            return new Result("Bunday haridor mavjud emas",true);
        if (!optionalCurrency.isPresent())
            return new Result("Valyuta noto'g' kiritildi",false);
        Sale sale=new Sale();
        sale.setSaleDate(saleDto.getTimesDate());
        sale.setWarehouse(optionalWarehouse.get());
        sale.setClient(optionalClient.get());
        sale.setCurrency(optionalCurrency.get());
        saleRepository.save(sale);
        return new Result("Chiqim saqlandi",true);
    }
    public List<Sale> getAll(){
        return saleRepository.findAll();
    }
    public Sale getId(Integer id){
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (!optionalSale.isPresent())
            return null;
        return optionalSale.get();
    }
    public Result edit(SaleDto saleDto, Integer id){
        Optional<Sale> optionalSale = saleRepository.findById(id);
        Sale sale = optionalSale.get();

        Client byClient_id = saleRepository.findByClient_Id(saleDto.getClientId());
        Currency byCurrency_id = saleRepository.findByCurrency_Id(saleDto.getCurrencyId());
        Warehouse byWarehouse_id = saleRepository.findByWarehouse_Id(saleDto.getWarehoseId());



        sale.setWarehouse(byWarehouse_id);
        sale.setClient(byClient_id);
        sale.setCurrency(byCurrency_id);
        sale.setSaleDate(saleDto.getTimesDate());
        sale.setCode("1");
        sale.setFactureNumber("1");
        saleRepository.save(sale);
        return new Result("Chiqim o'zgaritildi",true);

    }
    public Result delete(Integer id){
        saleRepository.deleteById(id);
        return  new Result("Chiqimlar tarixidan 'chirildi",true);
    }
}
