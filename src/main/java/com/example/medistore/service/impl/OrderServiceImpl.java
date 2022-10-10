package com.example.medistore.service.impl;


import com.example.medistore.dao.OrderRepository;
import com.example.medistore.model.Order;
import com.example.medistore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    ////////////////////////////////// save Order ///////////////////////////////
    //Save one Order
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    //save many Orders
    public List<Order> addOrders(List<Order> orders){
        return (List<Order>) orderRepository.saveAll(orders);
    }

    ////////////////////////////////// get Order ///////////////////////////////
    //Get Orders
    public List<Order> getOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    // get Order by id
    public Order getOrderById(long id){
        return orderRepository.findById(id).orElse(null);
    }


    ////////////////////////////////// delete Order ///////////////////////////////
    // delete Order by id
    public String deleteOrder(long id){
        orderRepository.deleteById(id);
        return "Order has been deleted";
    }


    ////////////////////////////////// update Order ///////////////////////////////
    public Order updateOrder(Order order){
        Order existingOrder= orderRepository.findById(order.getId()).orElse(null);

        existingOrder.setId(order.getId());
        existingOrder.setAmount(order.getAmount());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setDate(order.getDate());
        return orderRepository.save(existingOrder);
    }




}
