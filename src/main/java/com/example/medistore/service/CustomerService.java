package com.example.medistore.service;

import com.example.medistore.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);
    public List<Customer> addCustomers(List<Customer> customers);
    public List<Customer> getCustomers();
    public Customer getCustomerById(long id);
    public Customer getCustomerByName(String name);
    public String deleteCustomer(long id);
    public Customer updateCustomer(Customer customer);





}
