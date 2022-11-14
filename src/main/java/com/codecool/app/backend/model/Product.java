package com.codecool.app.backend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
public class Product {
    @Id
    private UUID id;
    private String productName;
    private BigDecimal productPrice;
    @ManyToOne
    private Pub pub;

    public Product(String productName, BigDecimal productPrice, Pub pub) {
        this.id = UUID.randomUUID();
        this.productName = productName;
        this.productPrice = productPrice;
        this.pub = pub;
    }

    public Product(){
        this.id = UUID.randomUUID();
    }
}
