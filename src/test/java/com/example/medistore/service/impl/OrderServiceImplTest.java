package com.example.medistore.service.impl;

import com.example.medistore.dao.OrderRepository;
import com.example.medistore.model.Customer;
import com.example.medistore.model.Order;
import com.example.medistore.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.Column;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrderServiceImpl(orderRepository);
    }

    @Test
    void addOrder() {
        //when
        Order order= new Order();
        order.setId(1);
        order.setAmount(11.5F);
        order.setAddress("sect A rabat");
        order.setDate(LocalDate.ofEpochDay(20/11/2020));

        //when
        underTest.addOrder(order);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        //then
        verify(orderRepository).save(orderArgumentCaptor.capture());
        Order capturedOrder = orderArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(order);
    }
}