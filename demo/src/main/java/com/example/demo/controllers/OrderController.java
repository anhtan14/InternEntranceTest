package com.example.demo.controllers;


import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder (
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserByJwt(jwt);
            Order newOrder = orderService.createOrder(user);

            return ResponseEntity.ok(newOrder);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }
}
