package com.pragma.productcatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.productcatalog.dto.ProductRequest;
import com.pragma.productcatalog.dto.ProductResponse;
import com.pragma.productcatalog.exception.GlobalExceptionHandler;
import com.pragma.productcatalog.exception.ProductAlreadyExistsException;
import com.pragma.productcatalog.exception.ProductNotFoundException;
import com.pragma.productcatalog.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@Import(GlobalExceptionHandler.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private ProductRequest productRequest;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        productRequest = new ProductRequest(
            "Laptop Gaming",
            "Laptop para gaming de alta gama",
            new BigDecimal("1499.99"),
            15,
            "Electrónica"
        );

        productResponse = ProductResponse.builder()
            .id(1L)
            .nombre("Laptop Gaming")
            .descripcion("Laptop para gaming de alta gama")
            .precio(new BigDecimal("1499.99"))
            .stock(15)
            .categoria("Electrónica")
            .build();
    }

    @Test
    @DisplayName("POST /products - Debe crear un producto exitosamente")
    void crearProducto_DeberiaRetornar201YProductoCreado() throws Exception {
        when(productService.crearProducto(any(ProductRequest.class)))
            .thenReturn(productResponse);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Laptop Gaming"))
            .andExpect(jsonPath("$.precio").value(1499.99))
            .andExpect(jsonPath("$.categoria").value("Electrónica"));
    }

    @Test
    @DisplayName("POST /products - Debe retornar 400 cuando el nombre está vacío")
    void crearProducto_NombreVacio_DeberiaRetornar400() throws Exception {
        ProductRequest requestInvalida = new ProductRequest(
            "",
            "Descripción",
            new BigDecimal("100.00"),
            10,
            "Categoría"
        );

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInvalida)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /products - Debe retornar 400 cuando el precio es negativo")
    void crearProducto_PrecioNegativo_DeberiaRetornar400() throws Exception {
        ProductRequest requestInvalida = new ProductRequest(
            "Producto",
            "Descripción",
            new BigDecimal("-50.00"),
            10,
            "Categoría"
        );

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInvalida)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /products - Debe retornar 409 cuando el producto ya existe")
    void crearProducto_Duplicado_DeberiaRetornar409() throws Exception {
        when(productService.crearProducto(any(ProductRequest.class)))
            .thenThrow(new ProductAlreadyExistsException("Ya existe un producto con ese nombre"));

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("GET /products - Debe retornar todos los productos")
    void listarProductos_DeberiaRetornar200YListaDeProductos() throws Exception {
        ProductResponse producto2 = ProductResponse.builder()
            .id(2L)
            .nombre("Mouse")
            .descripcion("Mouse inalámbrico")
            .precio(new BigDecimal("29.99"))
            .stock(100)
            .categoria("Electrónica")
            .build();

        when(productService.listarTodosLosProductos())
            .thenReturn(Arrays.asList(productResponse, producto2));

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].nombre").value("Laptop Gaming"))
            .andExpect(jsonPath("$[1].nombre").value("Mouse"));
    }

    @Test
    @DisplayName("GET /products - Debe retornar lista vacía cuando no hay productos")
    void listarProductos_SinProductos_DeberiaRetornar200YListaVacia() throws Exception {
        when(productService.listarTodosLosProductos())
            .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    @DisplayName("GET /products/{id} - Debe retornar producto por ID")
    void obtenerProductoPorId_DeberiaRetornar200YProducto() throws Exception {
        when(productService.obtenerProductoPorId(1L))
            .thenReturn(productResponse);

        mockMvc.perform(get("/products/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Laptop Gaming"));
    }

    @Test
    @DisplayName("GET /products/{id} - Debe retornar 404 cuando el producto no existe")
    void obtenerProductoPorId_NoExiste_DeberiaRetornar404() throws Exception {
        when(productService.obtenerProductoPorId(999L))
            .thenThrow(new ProductNotFoundException("Producto no encontrado"));

        mockMvc.perform(get("/products/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /products/buscar?nombre=X - Debe buscar productos por nombre")
    void buscarPorNombre_DeberiaRetornar200YListaDeProductos() throws Exception {
        when(productService.buscarPorNombre("Laptop"))
            .thenReturn(Arrays.asList(productResponse));

        mockMvc.perform(get("/products/buscar")
                .param("nombre", "Laptop"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].nombre").value("Laptop Gaming"));
    }

    @Test
    @DisplayName("GET /products/categoria/{categoria} - Debe buscar productos por categoría")
    void buscarPorCategoria_DeberiaRetornar200YListaDeProductos() throws Exception {
        ProductResponse producto2 = ProductResponse.builder()
            .id(2L)
            .nombre("Teclado")
            .descripcion("Teclado mecánico")
            .precio(new BigDecimal("89.99"))
            .stock(50)
            .categoria("Electrónica")
            .build();

        when(productService.buscarPorCategoria("Electrónica"))
            .thenReturn(Arrays.asList(productResponse, producto2));

        mockMvc.perform(get("/products/categoria/Electrónica"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("PUT /products/{id} - Debe actualizar un producto exitosamente")
    void actualizarProducto_DeberiaRetornar200YProductoActualizado() throws Exception {
        ProductRequest requestActualizado = new ProductRequest(
            "Laptop Gaming Actualizado",
            "Nueva descripción",
            new BigDecimal("1599.99"),
            20,
            "Electrónica"
        );

        ProductResponse responseActualizado = ProductResponse.builder()
            .id(1L)
            .nombre("Laptop Gaming Actualizado")
            .descripcion("Nueva descripción")
            .precio(new BigDecimal("1599.99"))
            .stock(20)
            .categoria("Electrónica")
            .build();

        when(productService.actualizarProducto(eq(1L), any(ProductRequest.class)))
            .thenReturn(responseActualizado);

        mockMvc.perform(put("/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestActualizado)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Laptop Gaming Actualizado"))
            .andExpect(jsonPath("$.precio").value(1599.99));
    }

    @Test
    @DisplayName("PUT /products/{id} - Debe retornar 404 cuando el producto no existe")
    void actualizarProducto_NoExiste_DeberiaRetornar404() throws Exception {
        when(productService.actualizarProducto(eq(999L), any(ProductRequest.class)))
            .thenThrow(new ProductNotFoundException("Producto no encontrado"));

        mockMvc.perform(put("/products/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /products/{id} - Debe eliminar un producto exitosamente")
    void eliminarProducto_DeberiaRetornar204() throws Exception {
        mockMvc.perform(delete("/products/1"))
            .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /products/{id} - Debe retornar 404 cuando el producto no existe")
    void eliminarProducto_NoExiste_DeberiaRetornar404() throws Exception {
        doThrow(new ProductNotFoundException("Producto no encontrado"))
            .when(productService).eliminarProducto(999L);

        mockMvc.perform(delete("/products/999"))
            .andExpect(status().isNotFound());
    }
}