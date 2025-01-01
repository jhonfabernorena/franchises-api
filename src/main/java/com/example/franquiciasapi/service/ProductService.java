
package com.example.franquiciasapi.service;

import com.example.franquiciasapi.entity.Product;
import com.example.franquiciasapi.entity.Vendor;
import com.example.franquiciasapi.exceptions.ResourceNotFoundException;
import com.example.franquiciasapi.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private VendorRepository vendorRepository;

    @Autowired
    public ProductService(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }

    public Product addProduct(Integer vendorId, Product product) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        vendor.getProducts().add(product);
        vendorRepository.save(vendor);
        return product;
    }

    public void deleteProduct(Integer vendorId, String productName) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        vendor.getProducts().removeIf(p -> p.getNombre().equalsIgnoreCase(productName));
        vendorRepository.save(vendor);
    }

    public Producto updateStock(String sucursalId, String productoNombre, int stock) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        Producto producto = sucursal.getProductos().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(productoNombre))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        producto.setStock(stock);
        sucursalRepository.save(sucursal);
        return producto;
    }
}
