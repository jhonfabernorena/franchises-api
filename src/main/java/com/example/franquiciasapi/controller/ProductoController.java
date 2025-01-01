package com.example.franquiciasapi.controller;

import com.example.franquiciasapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductoController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{sucursalId}")
    public ResponseEntity<Product> addProduct(@PathVariable String sucursalId, @RequestBody Product product) {
        return ResponseEntity.ok(productoService.addProducto(sucursalId, product));
    }

    @DeleteMapping("/{sucursalId}/{productoNombre}")
    public ResponseEntity<Void> deleteProducto(@PathVariable String sucursalId, @PathVariable String productoNombre) {
        productService.deleteProducto(sucursalId, productoNombre);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{sucursalId}/{productoNombre}")
    public ResponseEntity<Product> updateStock(@PathVariable String sucursalId, @PathVariable String productoNombre, @RequestParam int stock) {
        return ResponseEntity.ok(productoService.updateStock(sucursalId, productoNombre, stock));
    }
}