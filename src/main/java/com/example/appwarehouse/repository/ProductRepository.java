package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByNameAndCategory_Id(String name, Integer category_id);
    Category findByCategory_Id(Integer category_id);
    Attachment findByAttachmentId(Integer attachment_id);
    Measurement findByMeasurementId(Integer measurement_id);
}
