package com.example.medistore.controller;

import com.example.medistore.model.Customer;
import com.example.medistore.service.CustomerService;
import com.example.medistore.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    ////////////////////////////////// Add customers ///////////////////////////
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return customerService.addCustomers(customers);
    }

    ////////////////////////////////// Get customers ///////////////////////////
    @GetMapping("/get")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/getAll/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getName/{name}")
    public Customer getCustomerByName(@PathVariable String name){
        return customerService.getCustomerByName(name);
    }


    ////////////////////////////// update customer ///////////////////////////
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }


    ////////////////////////////// delete customer ///////////////////////////
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        return customerService.deleteCustomer(id);
    }




}
