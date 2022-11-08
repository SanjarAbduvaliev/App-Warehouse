package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehoseRepository extends JpaRepository<Warehouse,Integer> {
}
