package com.example.medistore.dao;

import com.example.medistore.model.Medicine;
import com.example.medistore.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
