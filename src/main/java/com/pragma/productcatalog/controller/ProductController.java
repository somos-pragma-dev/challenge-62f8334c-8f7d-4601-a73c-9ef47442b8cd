package com.pragma.productcatalog.controller;

import com.pragma.productcatalog.dto.ProductRequest;
import com.pragma.productcatalog.dto.ProductResponse;
import com.pragma.productcatalog.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> registrarProducto(@Valid @RequestBody ProductRequest request) {
        ProductResponse productoCreado = productService.crearProducto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> obtenerProductoPorId(@PathVariable Long id) {
        ProductResponse producto = productService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ProductResponse> buscarPorNombre(@RequestParam String nombre) {
        ProductResponse producto = productService.buscarPorNombre(nombre);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductResponse>> buscarPorCategoria(@PathVariable String categoria) {
        List<ProductResponse> productos = productService.buscarPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/rango-precio")
    public ResponseEntity<List<ProductResponse>> buscarPorRangoPrecio(
            @RequestParam Double precioMin,
            @RequestParam Double precioMax) {
        List<ProductResponse> productos = productService.buscarPorRangoPrecio(precioMin, precioMax);
        return ResponseEntity.ok(productos);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listarTodosLosProductos() {
        List<ProductResponse> productos = productService.listarTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<ProductResponse>> productosConStockBajo(@RequestParam(defaultValue = "10") Integer stockMinimo) {
        List<ProductResponse> productos = productService.productosConStockBajo(stockMinimo);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/ordenar-precio-asc")
    public ResponseEntity<List<ProductResponse>> listarOrdenadosPorPrecioAsc() {
        List<ProductResponse> productos = productService.listarOrdenadosPorPrecioAsc();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/ordenar-precio-desc")
    public ResponseEntity<List<ProductResponse>> listarOrdenadosPorPrecioDesc() {
        List<ProductResponse> productos = productService.listarOrdenadosPorPrecioDesc();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<String>> listarCategorias() {
        List<String> categorias = productService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {
        ProductResponse productoActualizado = productService.actualizarProducto(id, request);
        return ResponseEntity.ok(productoActualizado);
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductResponse> actualizarStock(
            @PathVariable Long id,
            @RequestParam Integer stock) {
        ProductResponse productoActualizado = productService.actualizarStock(id, stock);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}