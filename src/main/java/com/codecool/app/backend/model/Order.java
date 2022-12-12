package com.codecool.app.backend.model;


import lombok.*;

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
@NoArgsConstructor
@Entity
@Table (name = "orderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
