package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.entity.ReceiptProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<ReceiptProduct,Integer> {
    Input findByReceiptId(Integer receipt_id);
    Product findByProduct_Id(Integer product_id);
}
