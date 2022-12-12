package com.codecool.app.backend.model;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @OneToMany
    private Set<Product> products;
    private String address;
    @ManyToMany
    private Set<User> owner;

}
