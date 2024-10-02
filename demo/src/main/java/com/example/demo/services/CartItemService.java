package com.example.demo.services;


import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Product;
import org.springframework.stereotype.Service;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem) throws Exception;

    public void deleteCartItem(Long userId, Long cartItemId) throws Exception;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) throws Exception;
}