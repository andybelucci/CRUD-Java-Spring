package com.example.crud.aplication.java.controllers;

import com.example.crud.aplication.java.domain.product.Product;
import com.example.crud.aplication.java.domain.product.ProductRepository;
import com.example.crud.aplication.java.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data) {
        Product product = repository.getReferenceById(data.id());
        return ResponseEntity.ok(product);
    }
}
