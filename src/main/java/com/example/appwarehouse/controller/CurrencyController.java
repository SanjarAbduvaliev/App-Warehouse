package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping("/addCurrency")
    public Result add(@RequestBody Currency currencydto){
        Result result = currencyService.addCurrency(currencydto);
        return result;
    }
    @GetMapping
    public List<Currency> getAllCurrency(){
        return currencyService.getAll();
    }
    @GetMapping("/{currencyId}")
    public Currency getId(@PathVariable Integer currencyId){
        return currencyService.getId(currencyId);
    }
    @PutMapping("/{id}")
    public Result edit(@RequestBody Currency currencyDto,@PathVariable Integer id){
        return currencyService.edit(currencyDto, id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return currencyService.delete(id);
    }

}
