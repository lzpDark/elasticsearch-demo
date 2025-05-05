package com.github.lzpdark.elasticsearchdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @author lzp
 */
@Document(indexName = "products")
@Data
public class Product {
    @Id
    private int productId;
    private String name;
    private String description;
    private String brand;
    private String category;
    private double price;
    private int stock;
    private List<String> tags;
    private String created_at;
}
