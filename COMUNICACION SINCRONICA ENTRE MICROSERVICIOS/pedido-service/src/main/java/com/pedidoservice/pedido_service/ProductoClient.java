package com.pedidoservice.pedido_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "producto-service")
public interface ProductoClient {

    @GetMapping("/productos")
    List<ProductoDTO> obtenerProductos();
}