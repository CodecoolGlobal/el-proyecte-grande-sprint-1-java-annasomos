package com.codecool.app.backend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
public class Pub {
    @Id
    private UUID id;
    private String name;
    @OneToMany
    private Set<Product> products;
    private String address;
    @ManyToMany
    private Set<User> owner;

    public Pub( String name, Set<Product> products, String address, Set<User> owner) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.products = products;
        this.address = address;
        this.owner = owner;
    }

    public Pub(){
        this.id = UUID.randomUUID();
    }
}
