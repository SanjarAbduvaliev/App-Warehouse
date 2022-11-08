package com.example.appwarehouse.payload;

import com.example.appwarehouse.entity.Warehouse;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SaleDto {
    private Timestamp timesDate;
    private Integer warehoseId;
    private Integer clientId;
    private Integer currencyId;
}
