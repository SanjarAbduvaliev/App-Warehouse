package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.Attachment;
import com.example.appwarehouse.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
