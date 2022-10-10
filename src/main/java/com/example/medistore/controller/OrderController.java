package com.example.medistore.controller;

import com.example.medistore.model.Order;
import com.example.medistore.service.OrderService;
import com.example.medistore.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    ////////////////////////////////// Add Orders ///////////////////////////
    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order Order){
        return orderService.addOrder(Order);
    }


    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders){
        return orderService.addOrders(orders);
    }

    ////////////////////////////////// Get Orders ///////////////////////////
    @GetMapping("/get")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/get/{id}")
    public Order getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }




    ////////////////////////////// update Order ///////////////////////////
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }


    ////////////////////////////// delete Order ///////////////////////////
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable long id){
        return orderService.deleteOrder(id);
    }




}
