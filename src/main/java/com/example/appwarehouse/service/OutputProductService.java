package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.entity.ReceiptProduct;
import com.example.appwarehouse.entity.Sale;
import com.example.appwarehouse.entity.SaleProduct;
import com.example.appwarehouse.payload.OutputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.OutputProductRepository;
import com.example.appwarehouse.repository.ProductRepository;
import com.example.appwarehouse.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SaleRepository outpuRepository;
    public Result add(OutputProductDto outputProductDto){

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getOutputId());
        Optional<Sale> optionalSale = outpuRepository.findById(outputProductDto.getOutputId());
        SaleProduct saleProduct=new SaleProduct();
        saleProduct.setProduct(optionalProduct.get());
        saleProduct.setSale(optionalSale.get());
        saleProduct.setAmount(25.0);
        outputProductRepository.save(saleProduct);
        return new Result("Chiqim saqlandi",true);
    }
    public List<SaleProduct> getAll(){
        return outputProductRepository.findAll();
    }
    public SaleProduct getId(Integer id){
        Optional<SaleProduct> saleProductOptional = outputProductRepository.findById(id);
        return saleProductOptional.get();
    }
    public Result edit(OutputProductDto outputProductDto,Integer id){
        Product product = outputProductRepository.findByProduct_Id(outputProductDto.getProductId());
        Sale sale = outputProductRepository.findBySale_Id(outputProductDto.getOutputId());
        Optional<SaleProduct> optionalSaleProduct = outputProductRepository.findById(id);
        SaleProduct saleProduct = optionalSaleProduct.get();
        saleProduct.setProduct(product);
        saleProduct.setSale(sale);
        saleProduct.setAmount(23.0);
        outputProductRepository.save(saleProduct);
        return  new Result("Sotilgan mahsulot tahrirlandi",true);
    }
    public Result delete(Integer id){
        outputProductRepository.deleteById(id);
        return new Result("Chiqimlar tarixidan ochirildi",true);
    }
}
