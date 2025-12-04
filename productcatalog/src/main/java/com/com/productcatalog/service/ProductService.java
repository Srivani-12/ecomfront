package com.com.productcatalog.service;

import com.com.productcatalog.model.Product;
import com.com.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getProductByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
}
