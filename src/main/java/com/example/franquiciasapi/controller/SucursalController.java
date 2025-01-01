package com.example.franquiciasapi.controller;

import com.example.franquiciasapi.model.Sucursal;
import com.example.franquiciasapi.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private VendorService sucursalService;

    @PostMapping("/{franquiciaId}")
    public ResponseEntity<Sucursal> addSucursal(@PathVariable String franquiciaId, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.addSucursal(franquiciaId, sucursal));
    }
}