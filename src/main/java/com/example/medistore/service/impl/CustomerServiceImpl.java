package com.example.medistore.service.impl;


import com.example.medistore.dao.CustomerRepository;
import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    ////////////////////////////////// save customer ///////////////////////////////
    //Save one customer
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //save many customers
    public List<Customer> addCustomers(List<Customer> customers){
        return (List<Customer>) customerRepository.saveAll(customers);
    }

    ////////////////////////////////// get customer ///////////////////////////////
    //Get customers
    public List<Customer> getCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    // get customer by id
    public Customer getCustomerById(long id){
        return customerRepository.findById(id).orElse(null);
    }

    //get customer by name
    public Customer getCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    ////////////////////////////////// delete customer ///////////////////////////////
    // delete customer by id
    public String deleteCustomer(long id){
        customerRepository.deleteById(id);
        return "customer has been deleted";
    }


    ////////////////////////////////// update customer ///////////////////////////////
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer= customerRepository.findById(customer.getId()).orElse(null);

        existingCustomer.setId(customer.getId());
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPhone(customer.getPhone());

        return customerRepository.save(existingCustomer);
    }




}
