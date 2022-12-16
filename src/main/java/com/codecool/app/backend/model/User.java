package com.codecool.app.backend.model;

import ch.qos.logback.classic.db.names.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table (name = "appUser")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @ManyToMany
    @JsonIgnore
    private Set<User> friends;
    @ManyToMany
    private Set<Pub> likedPubs;
    private String email;
    @OneToMany
    private Set<Order> pastOrders;
    private boolean isOwner;
}
