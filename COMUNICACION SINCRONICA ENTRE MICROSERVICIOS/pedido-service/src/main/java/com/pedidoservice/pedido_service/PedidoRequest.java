package com.pedidoservice.pedido_service;

public record PedidoRequest(Long productoId, int cantidad) {}