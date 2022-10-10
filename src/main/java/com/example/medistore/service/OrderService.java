package com.example.medistore.service;

import com.example.medistore.model.Order;

import java.util.List;

public interface OrderService {

    public Order addOrder(Order order);
    public List<Order> addOrders(List<Order> orders);
    public List<Order> getOrders();
    public Order getOrderById(long id);
    public String deleteOrder(long id);
    public Order updateOrder(Order order);
}
