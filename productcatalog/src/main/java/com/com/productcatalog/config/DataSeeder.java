package com.com.productcatalog.config;


import com.com.productcatalog.model.Category;
import com.com.productcatalog.model.Product;
import com.com.productcatalog.repository.CategoryRepository;
import com.com.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // creating Categories

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        // creating Products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model Smartphone with amazing features");
        phone.setImageUrl("https://placehold.co/400x400");
        phone.setPrice(6999.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High Performance Laptop");
        laptop.setImageUrl("https://placehold.co/400x400");
        laptop.setPrice(69999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("WinterJacket");
        jacket.setDescription("Warm and Cozy Jacket for Winter");
        jacket.setImageUrl("https://placehold.co/400x400");
        jacket.setPrice(599.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-Speed Blender for Smoothies and more.");
        blender.setImageUrl("https://placehold.co/400x400");
        blender.setPrice(1299.99);
        blender.setCategory(home);


        productRepository.saveAll(Arrays.asList(phone,laptop,blender,jacket));
    }
}
