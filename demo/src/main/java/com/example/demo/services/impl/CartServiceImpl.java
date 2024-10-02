package com.example.demo.services.impl;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.CartRepository;
import com.example.demo.request.AddItemRequest;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    @Override
    public Cart createCart(User user) throws Exception {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws Exception {
        Cart cart = cartRepository.findByUserId(userId);
        if(cart == null) {
            throw new Exception("Cart not found");
        }

        Product product = productService.findProductById(req.getProductId());

        CartItem isExist = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);


        if (isExist == null) {
            if (product == null) {
                throw new Exception("Product not found");
            }
            CartItem cartItem = new CartItem();

            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setSize(req.getSize());
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            double price = product.getDiscountPrice() * req.getQuantity();
            cartItem.setPrice(price);

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);

            Set<CartItem> cartItems = cart.getCartItems();
            cartItems.add(createdCartItem);
            cart.setCartItems(cartItems);
        }
        return "Item added to cart successfully";
    }

    @Override
    public Cart findUserCart(Long userId) throws Exception {
        Cart cart = cartRepository.findByUserId(userId);
        double totalPrice = 0;
        double totalDiscountPrice = 0;
        int totalItem = 0;

        for (CartItem cartItem : cart.getCartItems()) {
            totalPrice += cartItem.getPrice();
            totalDiscountPrice += cartItem.getProduct().getDiscountPrice()*cartItem.getQuantity();
            totalItem += cartItem.getQuantity();
        }

        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountPrice(totalDiscountPrice);
        cart.setTotalItem(totalItem);

        return cart;
    }
}
