package com.pragma.productcatalog.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(
    Long id,
    String nombre,
    BigDecimal precio,
    Integer stock,
    String categoria,
    String descripcion,
    LocalDateTime fechaCreacion,
    LocalDateTime fechaActualizacion,
    Boolean activo
) {
    public static ProductResponseBuilder builder() {
        return new ProductResponseBuilder();
    }

    public static class ProductResponseBuilder {
        private Long id;
        private String nombre;
        private BigDecimal precio;
        private Integer stock;
        private String categoria;
        private String descripcion;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaActualizacion;
        private Boolean activo;

        public ProductResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ProductResponseBuilder precio(BigDecimal precio) {
            this.precio = precio;
            return this;
        }

        public ProductResponseBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductResponseBuilder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public ProductResponseBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ProductResponseBuilder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public ProductResponseBuilder fechaActualizacion(LocalDateTime fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public ProductResponseBuilder activo(Boolean activo) {
            this.activo = activo;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(id, nombre, precio, stock, categoria, descripcion, fechaCreacion, fechaActualizacion, activo);
        }
    }
}