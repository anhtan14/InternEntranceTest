package com.example.demo.repositories;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    @Query("SELECT c FROM CartItem c WHERE c.cart = :cart AND c.product = :product AND c.size = :size AND c.cart.user.id = :userId")
    public CartItem isCartItemExist
        (@Param("cart") Cart cart,
         @Param("product") Product product,
         @Param("size") String size,
         @Param("userId") Long userId
        );

}
