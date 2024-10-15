package com.v1.tut.service;

import com.v1.tut.exception.ResourceNotFoundException;
import com.v1.tut.model.Product;
import com.v1.tut.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProduct(int prodId) {
        return repository.findById(prodId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + prodId + " not found"));
    }

    public Product addProduct(Product product) {
        if(product.getProdReleaseDate()==null){
            product.setProdReleaseDate(new Date());
        }
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getProdId())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + product.getProdId() + " not found"));

        existingProduct.setProdName(product.getProdName());
        existingProduct.setProdPrice(product.getProdPrice());

        return repository.save(existingProduct);
    }

    public void deleteProduct(int prodId) {
        Product existingProduct = repository.findById(prodId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + prodId + " not found"));

        repository.delete(existingProduct);
    }
}
