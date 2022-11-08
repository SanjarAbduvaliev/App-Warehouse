package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.entity.ReceiptProduct;
import com.example.appwarehouse.payload.InputDto;
import com.example.appwarehouse.payload.InputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.InputProductRepository;
import com.example.appwarehouse.repository.InputRepository;
import com.example.appwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    public Result add(InputProductDto inputProductDto){
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());

        ReceiptProduct receiptProduct=new ReceiptProduct();
        receiptProduct.setProduct(optionalProduct.get());
        receiptProduct.setReceipt(optionalInput.get());
        receiptProduct.setAmount(12.2);
        receiptProduct.setDate(new Date());

        inputProductRepository.save(receiptProduct);
        return new Result("Saqlandi",true);
    }
    public List<ReceiptProduct> getAll(){
        return inputProductRepository.findAll();
    }
    public ReceiptProduct getId(Integer id){
        Optional<ReceiptProduct> byId = inputProductRepository.findById(id);
        return byId.get();
    }
    public Result edit(InputProductDto inputProductDto, Integer id){
        Product product = inputProductRepository.findByProduct_Id(inputProductDto.getProductId());
        Input input = inputProductRepository.findByReceiptId(inputProductDto.getInputId());

        Optional<ReceiptProduct> optionalReceiptProduct = inputProductRepository.findById(id);
        ReceiptProduct receiptProduct = optionalReceiptProduct.get();
        receiptProduct.setProduct(product);
        receiptProduct.setReceipt(input);
        receiptProduct.setAmount(123.3);
        receiptProduct.setDate(new Date());
        return new Result("Kirim o'zgartirildi",true);
    }
    public Result delete(Integer id){
        inputProductRepository.deleteById(id);
        return  new Result("Kirim o'chirildi",true);
    }
}
