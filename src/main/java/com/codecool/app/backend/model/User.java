package com.codecool.app.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @ManyToMany
    private Set<User> friends;
    @ManyToMany
    private Set<Pub> likedPubs;
    private String email;
    @OneToMany
    private Set<Order> pastOrders;
    private boolean isOwner;

    public User(String firstName, String lastName, String userName, String password, Set<User> friends, Set<Pub> likedPubs, String email, Set<Order> pastOrders, boolean isOwner) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.friends = friends;
        this.likedPubs = likedPubs;
        this.email = email;
        this.pastOrders = pastOrders;
        this.isOwner = isOwner;
    }

    public User(){
        this.id = UUID.randomUUID();
    }
}
