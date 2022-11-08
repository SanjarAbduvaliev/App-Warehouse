package com.example.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp saleDate;
    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Currency currency;
    private String factureNumber;
    @Column(unique = true,nullable = false)
    private String code;
}
