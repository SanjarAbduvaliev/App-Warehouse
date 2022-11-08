package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.entity.Sale;
import com.example.appwarehouse.entity.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<SaleProduct,Integer> {
    Product findByProduct_Id(Integer product_id);
    Sale findBySale_Id(Integer sale_id);
}
