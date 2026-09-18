package com.pragma.productcatalog.exception;

import java.util.Optional;

/**
 * Excepción personalizada que se lanza cuando se intenta acceder a un producto
 * que no existe en el catálogo. Esta excepción indica que la operación de búsqueda
 * no encontró ningún resultado para los criterios de búsqueda especificados.
 */
public class ProductNotFoundException extends RuntimeException {

    private final Long productId;
    private final String productName;
    private final String searchCriteria;

    /**
     * Constructor con ID del producto.
     * Se utiliza cuando se busca un producto por su identificador único.
     *
     * @param productId el ID del producto que no se encontró
     */
    public ProductNotFoundException(Long productId) {
        super(String.format("No se encontró el producto con ID %d en el catálogo", productId));
        this.productId = productId;
        this.productName = null;
        this.searchCriteria = "id:" + productId;
    }

    /**
     * Constructor con nombre del producto.
     * Se utiliza cuando se busca un producto por su nombre.
     *
     * @param productName el nombre del producto que no se encontró
     */
    public ProductNotFoundException(String productName, boolean byName) {
        super(String.format("No se encontró ningún producto con el nombre '%s'", productName));
        this.productName = productName;
        this.productId = null;
        this.searchCriteria = "nombre:" + productName;
    }

    /**
     * Constructor genérico con criterios de búsqueda.
     * Se utiliza para cualquier tipo de búsqueda que no encuentre resultados.
     *
     * @param searchCriteria descripción de los criterios de búsqueda utilizados
     */
    public ProductNotFoundException(String searchCriteria) {
        super(String.format("No se encontró ningún producto que coincida con los criterios: %s", searchCriteria));
        this.searchCriteria = searchCriteria;
        this.productId = null;
        this.productName = null;
    }

    /**
     * Constructor con mensaje personalizado.
     * Se utiliza cuando se necesita un mensaje de error específico para el caso de uso.
     *
     * @param message el mensaje de error personalizado
     */
    public ProductNotFoundException(String message, Long productId, String productName) {
        super(message);
        this.productId = productId;
        this.productName = productName;
        this.searchCriteria = productId != null ? "id:" + productId : "nombre:" + productName;
    }

    /**
     * Obtiene el ID del producto que se buscó y no se encontró.
     * Puede ser null si la búsqueda no fue por ID.
     *
     * @return el ID del producto, o null si no aplica
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Obtiene el nombre del producto que se buscó y no se encontró.
     * Puede ser null si la búsqueda no fue por nombre.
     *
     * @return el nombre del producto, o null si no aplica
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Obtiene los criterios de búsqueda utilizados.
     * Proporciona información sobre qué parámetros se usaron en la consulta.
     *
     * @return los criterios de búsqueda como cadena
     */
    public String getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * Crea una excepción a partir de un Optional vacío.
     * Método utilitario que facilita la conversión de Optional a excepción.
     *
     * @param optional el Optional que puede estar vacío
     * @param productId el ID del producto buscado
     * @return la excepción si el Optional está vacío
     * @throws ProductNotFoundException si el Optional no tiene valor
     */
    public static <T> ProductNotFoundException fromOptional(Optional<T> optional, Long productId) {
        return optional.map(t -> (ProductNotFoundException) null)
                .orElseGet(() -> new ProductNotFoundException(productId));
    }

    /**
     * Proporciona información adicional para el debugging.
     * Incluye el ID, nombre y criterios de búsqueda en la representación de la excepción.
     *
     * @return cadena con detalles de la excepción
     */
    @Override
    public String toString() {
        return "ProductNotFoundException{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", searchCriteria='" + searchCriteria + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}