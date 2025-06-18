package com.productoservice.producto_service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private static final List<Producto> PRODUCTOS = List.of(
            new Producto(1L, "Computadora Portatil", 1900.000),
            new Producto(2L, "Iphone", 800.00),
            new Producto(3L, "Bafle estereo", 543.000),
            new Producto(4L, "Tv LG", 1200.000)
    );

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return PRODUCTOS.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("")  
    public List<Producto> listarProductos() {  
        return PRODUCTOS;
    }  
}