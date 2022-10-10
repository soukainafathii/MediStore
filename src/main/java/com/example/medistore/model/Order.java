package com.example.medistore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private long id;

    @Column(nullable = false)
    private float amount;


    @Column(nullable = false)
    private LocalDate date;



    @Column(nullable = false)
    private String address;



    @JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private Set<Medicine> medicines = new HashSet<>();





}
