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
    public ResponseEntity<Product> addProduct(@PathVariable Integer vendorId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product, vendorId));
    }

    @DeleteMapping("/{vendorId}/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer vendorId, @PathVariable Integer productId) {
        productService.deleteProduct(vendorId, productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{vendorId}/{productId}")
    public ResponseEntity<Product> updateStock(@PathVariable Integer vendorId, @PathVariable Integer productId, @RequestParam Integer stock) {
        return ResponseEntity.ok(productService.updateStock(vendorId, productId, stock));
    }
}
