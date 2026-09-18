package com.pragma.productcatalog.service;

import com.pragma.productcatalog.dto.ProductRequest;
import com.pragma.productcatalog.dto.ProductResponse;
import com.pragma.productcatalog.exception.ProductAlreadyExistsException;
import com.pragma.productcatalog.exception.ProductNotFoundException;
import com.pragma.productcatalog.model.Product;
import com.pragma.productcatalog.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product producto;
    private ProductRequest productRequest;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        producto = new Product();
        producto.setId(1L);
        producto.setNombre("Laptop Gaming");
        producto.setDescripcion("Laptop de alta gama para gaming");
        producto.setPrecio(new BigDecimal("1499.99"));
        producto.setStock(15);
        producto.setCategoria("Electrónica");
        producto.setFechaCreacion(LocalDateTime.now());

        productRequest = new ProductRequest(
            "Laptop Gaming",
            "Laptop de alta gama para gaming",
            new BigDecimal("1499.99"),
            15,
            "Electrónica"
        );

        productResponse = ProductResponse.builder()
            .id(1L)
            .nombre("Laptop Gaming")
            .descripcion("Laptop de alta gama para gaming")
            .precio(new BigDecimal("1499.99"))
            .stock(15)
            .categoria("Electrónica")
            .build();
    }

    @Test
    @DisplayName("crearProducto - Debe crear un producto exitosamente")
    void crearProducto_DeberiaCrearYRetornarProducto() {
        when(productRepository.existsByNombre("Laptop Gaming")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(producto);

        ProductResponse resultado = productService.crearProducto(productRequest);

        assertNotNull(resultado);
        assertEquals("Laptop Gaming", resultado.nombre());
        assertEquals(new BigDecimal("1499.99"), resultado.precio());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("crearProducto - Debe lanzar excepción cuando el nombre ya existe")
    void crearProducto_NombreDuplicado_DeberiaLanzarExcepcion() {
        when(productRepository.existsByNombre("Laptop Gaming")).thenReturn(true);

        assertThrows(ProductAlreadyExistsException.class, 
            () -> productService.crearProducto(productRequest));

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("crearProducto - Debe lanzar excepción cuando el precio es negativo")
    void crearProducto_PrecioNegativo_DeberiaLanzarExcepcion() {
        ProductRequest requestInvalida = new ProductRequest(
            "Producto",
            "Descripción",
            new BigDecimal("-100.00"),
            10,
            "Categoría"
        );

        assertThrows(IllegalArgumentException.class, 
            () -> productService.crearProducto(requestInvalida));
    }

    @Test
    @DisplayName("crearProducto - Debe lanzar excepción cuando el stock es negativo")
    void crearProducto_StockNegativo_DeberiaLanzarExcepcion() {
        ProductRequest requestInvalida = new ProductRequest(
            "Producto",
            "Descripción",
            new BigDecimal("100.00"),
            -5,
            "Categoría"
        );

        assertThrows(IllegalArgumentException.class, 
            () -> productService.crearProducto(requestInvalida));
    }

    @Test
    @DisplayName("listarTodosLosProductos - Debe retornar todos los productos")
    void listarTodos_DeberiaRetornarListaDeProductos() {
        Product producto2 = new Product();
        producto2.setId(2L);
        producto2.setNombre("Mouse");
        producto2.setDescripcion("Mouse inalámbrico");
        producto2.setPrecio(new BigDecimal("29.99"));
        producto2.setStock(100);
        producto2.setCategoria("Electrónica");

        when(productRepository.findAll()).thenReturn(Arrays.asList(producto, producto2));

        List<ProductResponse> resultados = productService.listarTodosLosProductos();

        assertEquals(2, resultados.size());
        assertEquals("Laptop Gaming", resultados.get(0).nombre());
        assertEquals("Mouse", resultados.get(1).nombre());
    }

    @Test
    @DisplayName("listarTodosLosProductos - Debe retornar lista vacía cuando no hay productos")
    void listarTodos_SinProductos_DeberiaRetornarListaVacia() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<ProductResponse> resultados = productService.listarTodosLosProductos();

        assertTrue(resultados.isEmpty());
    }

    @Test
    @DisplayName("obtenerProductoPorId - Debe retornar producto por ID")
    void obtenerPorId_ProductoExiste_DeberiaRetornarProducto() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(producto));

        ProductResponse resultado = productService.obtenerProductoPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.id());
        assertEquals("Laptop Gaming", resultado.nombre());
    }

    @Test
    @DisplayName("obtenerProductoPorId - Debe lanzar excepción cuando el producto no existe")
    void obtenerPorId_ProductoNoExiste_DeberiaLanzarExcepcion() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.obtenerProductoPorId(999L));
    }

    @Test
    @DisplayName("buscarPorNombre - Debe buscar productos por nombre")
    void buscarPorNombre_DeberiaRetornarProducto() {
        when(productRepository.findByNombreIgnoreCase("Laptop Gaming"))
            .thenReturn(Optional.of(producto));

        ProductResponse resultado = productService.buscarPorNombre("Laptop Gaming");

        assertNotNull(resultado);
        assertEquals("Laptop Gaming", resultado.nombre());
    }

    @Test
    @DisplayName("buscarPorNombre - Debe lanzar excepción cuando no hay resultados")
    void buscarPorNombre_SinResultados_DeberiaLanzarExcepcion() {
        when(productRepository.findByNombreIgnoreCase("XYZ"))
            .thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.buscarPorNombre("XYZ"));
    }

    @Test
    @DisplayName("buscarPorCategoria - Debe buscar productos por categoría")
    void buscarPorCategoria_DeberiaRetornarListaDeProductos() {
        Product producto2 = new Product();
        producto2.setId(2L);
        producto2.setNombre("Teclado");
        producto2.setDescripcion("Teclado mecánico");
        producto2.setPrecio(new BigDecimal("89.99"));
        producto2.setStock(50);
        producto2.setCategoria("Electrónica");

        when(productRepository.findByCategoria("Electrónica"))
            .thenReturn(Arrays.asList(producto, producto2));

        List<ProductResponse> resultados = productService.buscarPorCategoria("Electrónica");

        assertEquals(2, resultados.size());
    }

    @Test
    @DisplayName("buscarPorCategoria - Debe lanzar excepción cuando no hay productos en la categoría")
    void buscarPorCategoria_SinResultados_DeberiaLanzarExcepcion() {
        when(productRepository.findByCategoria("NoExistente"))
            .thenReturn(Collections.emptyList());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.buscarPorCategoria("NoExistente"));
    }

    @Test
    @DisplayName("actualizarProducto - Debe actualizar un producto exitosamente")
    void actualizarProducto_DeberiaActualizarYRetornarProducto() {
        ProductRequest requestActualizado = new ProductRequest(
            "Laptop Gaming Updated",
            "Nueva descripción",
            new BigDecimal("1599.99"),
            20,
            "Electrónica"
        );

        when(productRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(productRepository.existsByNombreAndIdNot("Laptop Gaming Updated", 1L))
            .thenReturn(false);

        producto.setNombre("Laptop Gaming Updated");
        producto.setDescripcion("Nueva descripción");
        producto.setPrecio(new BigDecimal("1599.99"));
        producto.setStock(20);

        when(productRepository.save(any(Product.class))).thenReturn(producto);

        ProductResponse resultado = productService.actualizarProducto(1L, requestActualizado);

        assertNotNull(resultado);
        assertEquals("Laptop Gaming Updated", resultado.nombre());
        assertEquals(new BigDecimal("1599.99"), resultado.precio());
    }

    @Test
    @DisplayName("actualizarProducto - Debe lanzar excepción cuando el producto no existe")
    void actualizarProducto_ProductoNoExiste_DeberiaLanzarExcepcion() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.actualizarProducto(999L, productRequest));
    }

    @Test
    @DisplayName("actualizarProducto - Debe lanzar excepción cuando el nombre ya existe en otro producto")
    void actualizarProducto_NombreDuplicado_DeberiaLanzarExcepcion() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(productRepository.existsByNombreAndIdNot("Nuevo Nombre", 1L)).thenReturn(true);

        ProductRequest requestDuplicado = new ProductRequest(
            "Nuevo Nombre",
            "Descripción",
            new BigDecimal("100.00"),
            10,
            "Categoría"
        );

        assertThrows(ProductAlreadyExistsException.class, 
            () -> productService.actualizarProducto(1L, requestDuplicado));
    }

    @Test
    @DisplayName("eliminarProducto - Debe eliminar un producto exitosamente")
    void eliminarProducto_DeberiaEliminarProducto() {
        when(productRepository.existsById(1L)).thenReturn(true);
        doNothing().when(productRepository).deleteById(1L);

        assertDoesNotThrow(() -> productService.eliminarProducto(1L));

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("eliminarProducto - Debe lanzar excepción cuando el producto no existe")
    void eliminarProducto_ProductoNoExiste_DeberiaLanzarExcepcion() {
        when(productRepository.existsById(999L)).thenReturn(false);

        assertThrows(ProductNotFoundException.class, 
            () -> productService.eliminarProducto(999L));

        verify(productRepository, never()).deleteById(any());
    }

    @Test
    @DisplayName("buscarPorRangoPrecio - Debe buscar productos en rango de precio")
    void buscarPorRangoPrecio_DeberiaRetornarListaDeProductos() {
        when(productRepository.findByRangoPrecio(1000.0, 2000.0))
            .thenReturn(Arrays.asList(producto));

        List<ProductResponse> resultados = productService.buscarPorRangoPrecio(
            new BigDecimal("1000.00"), new BigDecimal("2000.00"));

        assertEquals(1, resultados.size());
    }

    @Test
    @DisplayName("productosConStockBajo - Debe buscar productos con stock bajo")
    void buscarPorStockMenorQue_DeberiaRetornarListaDeProductos() {
        when(productRepository.findByStockMenorQue(20))
            .thenReturn(Arrays.asList(producto));

        List<ProductResponse> resultados = productService.productosConStockBajo(20);

        assertEquals(1, resultados.size());
    }
}