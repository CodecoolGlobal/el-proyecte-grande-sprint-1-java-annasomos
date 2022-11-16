package com.codecool.app.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table (name = "orderBy")
public class Order {

    @Id
    private UUID id;
    @OneToOne
    private User payer;
    @OneToOne
    private User receiver;
    @OneToMany
    private Set<OrderItem> orderItems;
    private String message;
    private boolean consumed;
    private BigDecimal orderTotalPrice;
    @OneToOne
    private Pub pub;

    public Order() {
        this.id = UUID.randomUUID();
    }

    public Order(User payer, User receiver, Set<OrderItem> orderItems, String message, boolean consumed, BigDecimal orderTotalPrice, Pub pub) {
        this.id = UUID.randomUUID();
        this.payer = payer;
        this.receiver = receiver;
        this.orderItems = orderItems;
        this.message = message;
        this.consumed = consumed;
        this.orderTotalPrice = orderTotalPrice;
        this.pub = pub;
    }
}
