package com.codecool.app.backend.model;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
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

    public Pub(String name, Set<Product> products, String address, Set<User> owner) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.products = products;
        this.address = address;
        this.owner = owner;
    }

    public Pub() {
        this.id = UUID.randomUUID();
    }

    public void addProducts(Collection<Product> products) {
        this.products.addAll(products);
    }
}
