package com.example.medistore.service.impl;


import com.example.medistore.dao.CustomerRepository;
import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl() {
    }

    @Autowired
    CustomerRepository customerRepository;



    ////////////////////////////////// save customer ///////////////////////////////
    //Save one customer
    public Customer addCustomer(Customer customer){

        System.out.println("im here ");
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
        //Customer existingCustomer= customerRepository.findById(customer.getId()).orElse(null);

        /*
        customer.setId(customer.getId());
        customer.setName(customer.getName());
        customer.setAddress(customer.getAddress());
        customer.setPhone(customer.getPhone());
        customer.setUsername(customer.getUsername());
        customer.setPassword(customer.getPassword());*/

        return customerRepository.save(customer);
    }

    //method for aspect
    public String getData(){
        return "get data of customer service is called successfully";
    }

    public void setData(String data){
        System.out.println(data);
    }






}
