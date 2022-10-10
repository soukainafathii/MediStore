package com.example.medistore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false )
    private String password;



    // 39li 3la hadi
    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
    private Set<Order> orders = new HashSet<>();






    //relation mapping between medicine and customer
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(

            name = "order_line",

            joinColumns = {@JoinColumn(name = "customer_id")},

            inverseJoinColumns = {@JoinColumn(name = "medicine_id")}

    )
    private Set<Medicine> medicines = new HashSet<>();

}
