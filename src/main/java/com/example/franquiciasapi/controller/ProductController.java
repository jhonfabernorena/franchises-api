package com.example.franquiciasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.franquiciasapi.service.ProductService;
import com.example.franquiciasapi.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{vendorId}")
    public ResponseEntity<Product> addProduct(@PathVariable String vendorId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @DeleteMapping("/{vendorId}/{productName}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer vendorId, @PathVariable Integer productName) {
        productService.deleteProduct(vendorId, productName);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{vendorId}/{productName}")
    public ResponseEntity<Product> updateStock(@PathVariable Integer vendorId, @PathVariable Integer productName, @RequestParam Integer stock) {
        return ResponseEntity.ok(productService.updateStock(vendorId, productName, stock));
    }
}
