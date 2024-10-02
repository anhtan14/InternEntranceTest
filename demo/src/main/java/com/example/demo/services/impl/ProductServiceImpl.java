package com.example.demo.services.impl;

import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product findProductById(Long id) throws Exception {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new Exception("Product not found");
    }

    @Override
    public List<Product> findProductsByCategory(String category) throws Exception {
        return List.of();
    }

    @Override
    public Page<Product> getAllProducts(String category, List<String> colors, List<String> sizes, double minPrice, double maxPrice, double minDiscount, String sort, String stock, int pageNumber, int pageSize) throws Exception {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        List<Product> products = productRepository.filterProducts(category, (int) minPrice, (int) maxPrice, (int) minDiscount, sort);

        if (!colors.isEmpty()){
            products = products.stream().filter(p->colors.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor()))).toList();
        }

        if(stock!=null){
            if (stock.equals("in_stock")){
                products = products.stream().filter(p->p.getQuantity()>0).toList();
            }
            else if (stock.equals("out_of_stock")){
                products = products.stream().filter(p->p.getQuantity()<1).toList();
            }
        }
        int startIndex = (int) pageable.getOffset();
        int endIndex = Math.min((startIndex + pageable.getPageSize()), products.size());

        List<Product> pageContent = products.subList(startIndex, endIndex);

        Page<Product> page = new PageImpl<>(pageContent, pageable, products.size());

        return page;
    }
}
