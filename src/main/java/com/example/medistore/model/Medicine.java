package com.example.medistore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="medicine")
@Data
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private long id;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;





    //relation mapping between medicine and order
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(

            name = "order_medicine",

            joinColumns = {@JoinColumn(name = "medicine_id")},

            inverseJoinColumns = {@JoinColumn(name = "order_id")}

    )
    private Set<Order> orders = new HashSet<>();



    //relation mapping between medicine and customer
    @JsonIgnore
    @ManyToMany(mappedBy = "medicines")
    private Set<Customer> customers = new HashSet<>();


}
