package com.com.productcatalog.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;


}
