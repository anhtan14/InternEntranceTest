package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.User;
import com.example.demo.request.AddItemRequest;
import org.springframework.stereotype.Service;

public interface CartService {

    public Cart createCart(User user) throws Exception;

    public String addCartItem(Long userId, AddItemRequest req) throws Exception;

    public Cart findUserCart(Long userId) throws Exception;
}
