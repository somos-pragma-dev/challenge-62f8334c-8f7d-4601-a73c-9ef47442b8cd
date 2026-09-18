package com.pragma.productcatalog.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequest(
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    String nombre,

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 dígitos enteros y 2 decimales")
    BigDecimal precio,

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Max(value = 999999, message = "El stock no puede exceder 999999 unidades")
    Integer stock,

    @NotBlank(message = "La categoría es obligatoria")
    @Size(min = 2, max = 50, message = "La categoría debe tener entre 2 y 50 caracteres")
    String categoria,

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    String descripcion
) {
    public ProductRequest {
        if (precio != null && precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}