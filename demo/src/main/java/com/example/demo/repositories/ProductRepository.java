package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p" +
//    "WHERE (p.category.name = :category OR :category='') " +
//    "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountPrice BETWEEN :minPrice AND :maxPrice))" +
//    "AND (:minDiscount IS NULL OR p.discountPrice >= :minDiscount)" +
//    "ORDER BY " +
//    "CASE WHEN :sort = 'price_low' THEN p.discountPrice END ASC," +
//    "CASE WHEN :sort = 'price_high' THEN p.discountPrice END DESC"
//    )
    @Query("SELECT p FROM Product p \n" +
            "WHERE (p.category.name = :category OR :category = '') \n" +
            "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountPrice BETWEEN :minPrice AND :maxPrice)) \n" +
            "AND (:minDiscount IS NULL OR p.discountPrice >= :minDiscount) \n" +
            "ORDER BY \n" +
            "    CASE WHEN :sort = 'price_low' THEN p.discountPrice END ASC, \n" +
            "    CASE WHEN :sort = 'price_high' THEN p.discountPrice END DESC")
    public List<Product> filterProducts(
            @Param("category") String category,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice,
            @Param("minDiscount") double minDiscount,
            @Param("sort") String sort
    );
}
