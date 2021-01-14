package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
/*
@NoArgsConstructor
@AllArgsConstructor
*/
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userRoles", targetEntity = User.class)
    private Set<User> users = new HashSet<>();

    public Role(String name){
        this.name = name;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }
}
