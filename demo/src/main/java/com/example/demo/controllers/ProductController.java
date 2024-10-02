package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam String category,
            @RequestParam List<String> color,
            @RequestParam List<String> size,
            @RequestParam(defaultValue = "0.0") double minPrice,
            @RequestParam(defaultValue = "Double.MAX_VALUE") double maxPrice,
            @RequestParam(defaultValue = "0.0") double minDiscount,
            @RequestParam String sort,
            @RequestParam String stock,
            @RequestParam int pageNumber,
            @RequestParam int pageSize
            ) throws Exception {
        Page<Product> res = productService.getAllProducts(category, color, size, minPrice, maxPrice, minDiscount, sort, stock, pageNumber, pageSize);

        System.out.println("Products fetched successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {
        Product res = productService.findProductById(id);

        System.out.println("Product fetched successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
