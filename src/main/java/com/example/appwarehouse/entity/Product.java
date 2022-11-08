package com.example.appwarehouse.entity;

import com.example.appwarehouse.payload.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {
    @ManyToOne(optional = false)
    private Category category;
    @OneToOne
    private Attachment attachment;
    private String code;
    @ManyToOne(optional = false)
    private Measurement measurement;
}
