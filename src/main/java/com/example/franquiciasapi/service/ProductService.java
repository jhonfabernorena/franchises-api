package com.example.franquiciasapi.service;

import com.example.franquiciasapi.entity.Product;
import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer vendorId, Integer productId) {
        productRepository.findById(productId)
            .ifPresent(product -> productRepository.delete(product));
    }

    public Product updateStock(Integer vendorId, Integer productId, int stock) {
        return productRepository.findById(productId)
            .map(product -> {
                product.setStock(stock);
                return productRepository.save(product);  
            })
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
