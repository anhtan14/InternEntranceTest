package com.example.demo.controllers;

import com.example.demo.entities.Cart;
import com.example.demo.entities.User;
import com.example.demo.request.AddItemRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.services.CartService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> getUserCart(@RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserByJwt(jwt);
            Cart cart = cartService.findUserCart(user.getId());

            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse> addCartItem(@RequestHeader("Authorization") String jwt, @RequestBody AddItemRequest req) {
        try {
            User user = userService.findUserByJwt(jwt);
            cartService.addCartItem(user.getId(), req);

            ApiResponse res = new ApiResponse();
            res.setMessage("Item added to cart successfully");
            res.setStatus(true);

            return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }
}
