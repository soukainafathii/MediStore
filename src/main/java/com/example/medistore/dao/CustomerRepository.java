package com.example.medistore.dao;

import com.example.medistore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findByName(String name);
}
