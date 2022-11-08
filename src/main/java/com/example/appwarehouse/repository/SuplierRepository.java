package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.service.SupplierService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuplierRepository extends JpaRepository<Supplier,Integer> {
}
