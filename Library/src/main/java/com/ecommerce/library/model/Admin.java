package com.ecommerce.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long id;
    private String firstNAme;
    private String lastName;
    private String username;
    private String password;
    @Lob //for storing large Objects
    @Column(columnDefinition = "MEDIUMLOB")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "admins_roles",joinColumns = @JoinColumn(name = "admin_id",referencedColumnName = "admin_id"),
    inverseJoinColumns = @JoinColumn(name ="role_id",referencedColumnName = "role_id"))
    private Collection<Role> roles;
}
