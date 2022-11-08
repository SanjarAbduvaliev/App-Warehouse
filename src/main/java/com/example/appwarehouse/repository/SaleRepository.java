package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Sale;
import com.example.appwarehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    Warehouse findByWarehouse_Id(Integer warehouse_id);
    Client findByClient_Id(Integer client_id);
    Currency findByCurrency_Id(Integer currency_id);
}
