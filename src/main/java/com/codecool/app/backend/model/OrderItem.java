package com.codecool.app.backend.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class OrderItem {
    @Id
    private UUID id;
    private String itemName;
    private BigDecimal itemPrice;
    private int count;
    private BigDecimal totalPrice;

    public OrderItem(String itemName, BigDecimal itemPrice, int count, BigDecimal totalPrice) {
        this.id = UUID.randomUUID();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public OrderItem(){
        this.id = UUID.randomUUID();
    }
}
