package com.example.demo.services;

import com.example.demo.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product findProductById(Long id) throws Exception;

    public List<Product> findProductsByCategory(String category) throws Exception;

    public Page<Product> getAllProducts(String category, List<String> colors, List<String> sizes, double minPrice, double maxPrice, double minDiscount, String sort, String stock, int pageNumber, int pageSize) throws Exception;
}
