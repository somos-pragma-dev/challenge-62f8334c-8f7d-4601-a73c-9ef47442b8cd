package com.pragma.productcatalog.repository;

import com.pragma.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNombre(String nombre);

    List<Product> findByCategoria(String categoria);

    @Query("SELECT p FROM Product p WHERE p.precio BETWEEN :precioMin AND :precioMax")
    List<Product> findByRangoPrecio(@Param("precioMin") Double precioMin, @Param("precioMax") Double precioMax);

    @Query("SELECT p FROM Product p WHERE LOWER(p.nombre) = LOWER(:nombre)")
    Optional<Product> findByNombreIgnoreCase(@Param("nombre") String nombre);

    boolean existsByNombre(String nombre);

    boolean existsByNombreAndIdNot(String nombre, Long id);

    @Query("SELECT p FROM Product p WHERE p.stock < :stockMinimo")
    List<Product> findByStockMenorQue(@Param("stockMinimo") Integer stockMinimo);

    @Query("SELECT p FROM Product p ORDER BY p.precio ASC")
    List<Product> findAllOrderByPrecioAsc();

    @Query("SELECT p FROM Product p ORDER BY p.precio DESC")
    List<Product> findAllOrderByPrecioDesc();

    @Query("SELECT DISTINCT p.categoria FROM Product p ORDER BY p.categoria ASC")
    List<String> findDistinctCategorias();
}