package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

public interface OrderService {
    public Order createOrder(User user) throws Exception;
}
