package com.v1.tut.controllers;

import com.v1.tut.model.Product;
import com.v1.tut.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v0/products")
public class OldProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        return ResponseEntity.ok(products);
        // Returns 200 OK with the list of products
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = service.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        // Returns 201 Created with the created product
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int prodId) {
        Product product = service.getProduct(prodId);
        if (product != null) {
            return ResponseEntity.ok(product);
            // Returns 200 OK with the found product
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // Returns 404 Not Found if the product is not found
        }
    }
}
