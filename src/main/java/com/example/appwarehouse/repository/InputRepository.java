package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input,Integer> {
    Warehouse findByWarehouse_Id(Integer warehouse_id);
    Supplier findBySupplier_Id(Integer supplier_id);
    Currency findByCurrency_Id(Integer currency_id);
}
