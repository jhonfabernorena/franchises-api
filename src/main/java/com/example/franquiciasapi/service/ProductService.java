package com.example.franquiciasapi.service;

import com.example.franquiciasapi.entity.Product;
import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private VendorService vendorService;

    @Autowired
    public ProductService(ProductRepository productRepository, VendorService vendorService) {
        this.productRepository = productRepository;
        this.vendorService = vendorService;
    }

    public Product addProduct(Product product, Integer vendorId) {
        return vendorService.findVendorById(vendorId)
            .map(vendor -> {
                product.setVendor(vendor);
                return productRepository.save(product);})
            .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        
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
