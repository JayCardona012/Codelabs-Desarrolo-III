package com.pedidoservice.pedido_service;

public record Pedido(String id, ProductoDTO producto, int cantidad) {}