package com.pragma.productcatalog.service;

import com.pragma.productcatalog.dto.ProductRequest;
import com.pragma.productcatalog.dto.ProductResponse;
import com.pragma.productcatalog.exception.InvalidProductException;
import com.pragma.productcatalog.exception.ProductAlreadyExistsException;
import com.pragma.productcatalog.exception.ProductNotFoundException;
import com.pragma.productcatalog.model.Product;
import com.pragma.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse crearProducto(ProductRequest request) {
        validarProducto(request);
        verificarNombreUnico(request.nombre(), null);

        Product producto = new Product();
        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());
        producto.setCategoria(request.categoria());

        Product productoGuardado = productRepository.save(producto);
        return mapearAResponse(productoGuardado);
    }

    @Transactional(readOnly = true)
    public ProductResponse obtenerProductoPorId(Long id) {
        return productRepository.findById(id)
                .map(this::mapearAResponse)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    public ProductResponse buscarPorNombre(String nombre) {
        return productRepository.findByNombreIgnoreCase(nombre)
                .map(this::mapearAResponse)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado: " + nombre));
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> buscarPorCategoria(String categoria) {
        List<Product> productos = productRepository.findByCategoria(categoria);
        if (productos.isEmpty()) {
            throw new ProductNotFoundException("No se encontraron productos en la categoría: " + categoria);
        }
        return productos.stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> buscarPorRangoPrecio(Double precioMin, Double precioMax) {
        if (precioMin < 0 || precioMax < 0) {
            throw new InvalidProductException("Los precios no pueden ser negativos");
        }
        if (precioMin > precioMax) {
            throw new InvalidProductException("El precio mínimo no puede ser mayor al máximo");
        }
        List<Product> productos = productRepository.findByRangoPrecio(precioMin, precioMax);
        return productos.stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> listarTodosLosProductos() {
        return productRepository.findAll().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> productosConStockBajo(Integer stockMinimo) {
        if (stockMinimo < 0) {
            throw new InvalidProductException("El stock mínimo no puede ser negativo");
        }
        return productRepository.findByStockMenorQue(stockMinimo).stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> listarOrdenadosPorPrecioAsc() {
        return productRepository.findAllOrderByPrecioAsc().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> listarOrdenadosPorPrecioDesc() {
        return productRepository.findAllOrderByPrecioDesc().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> listarCategorias() {
        return productRepository.findDistinctCategorias();
    }

    @Transactional
    public ProductResponse actualizarProducto(Long id, ProductRequest request) {
        Product productoExistente = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con ID: " + id));

        validarProducto(request);
        verificarNombreUnico(request.nombre(), id);

        productoExistente.setNombre(request.nombre());
        productoExistente.setDescripcion(request.descripcion());
        productoExistente.setPrecio(request.precio());
        productoExistente.setStock(request.stock());
        productoExistente.setCategoria(request.categoria());

        Product productoActualizado = productRepository.save(productoExistente);
        return mapearAResponse(productoActualizado);
    }

    @Transactional
    public ProductResponse actualizarStock(Long id, Integer nuevoStock) {
        if (nuevoStock < 0) {
            throw new InvalidProductException("El stock no puede ser negativo");
        }

        Product producto = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con ID: " + id));

        producto.setStock(nuevoStock);
        Product productoActualizado = productRepository.save(producto);
        return mapearAResponse(productoActualizado);
    }

    @Transactional
    public void eliminarProducto(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }

    private void validarProducto(ProductRequest request) {
        if (request.nombre() == null || request.nombre().isBlank()) {
            throw new InvalidProductException("El nombre del producto es obligatorio");
        }
        if (request.nombre().length() > 100) {
            throw new InvalidProductException("El nombre no puede exceder 100 caracteres");
        }
        if (request.precio() == null || request.precio().doubleValue() < 0) {
            throw new InvalidProductException("El precio no puede ser negativo");
        }
        if (request.stock() == null || request.stock() < 0) {
            throw new InvalidProductException("El stock no puede ser negativo");
        }
        if (request.categoria() == null || request.categoria().isBlank()) {
            throw new InvalidProductException("La categoría es obligatoria");
        }
    }

    private void verificarNombreUnico(String nombre, Long idExcluir) {
        boolean existe;
        if (idExcluir != null) {
            existe = productRepository.existsByNombreAndIdNot(nombre, idExcluir);
        } else {
            existe = productRepository.existsByNombre(nombre);
        }
        if (existe) {
            throw new ProductAlreadyExistsException("Ya existe un producto con el nombre: " + nombre);
        }
    }

    private ProductResponse mapearAResponse(Product producto) {
        return ProductResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .categoria(producto.getCategoria())
                .fechaCreacion(producto.getFechaCreacion())
                .build();
    }
}