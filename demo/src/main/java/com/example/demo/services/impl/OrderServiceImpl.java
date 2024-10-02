package com.example.demo.services.impl;


import com.example.demo.entities.*;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.OrderItemRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(User user) throws Exception {

        Cart cart = cartService.findUserCart(user.getId());

        System.out.println("Cart: " + cart);

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem item: cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice());
            orderItem.setSize(item.getSize());
            orderItem.setOrder(null);
            orderItem.setUserId(user.getId());
            orderItem.setDiscountPrice(item.getDiscountPrice());

            OrderItem createdOrderItem = orderItemRepository.save(orderItem);

            orderItems.add(createdOrderItem);
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotalPrice(cart.getTotalPrice());
        order.setTotalDiscountPrice(cart.getTotalDiscountPrice());
        order.setTotalItem(cart.getTotalItem());

        Order savedOrder = orderRepository.save(order);

        for (OrderItem item: savedOrder.getOrderItems()) {
            item.setOrder(savedOrder);
            orderItemRepository.save(item);
        }
        return savedOrder;
    }
}
