package com.pragma.productcatalog.exception;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar un producto
 * con un nombre que ya existe en el catálogo.
 * Esta excepción indica una violación de la restricción de unicidad en el nombre del producto.
 */
public class ProductAlreadyExistsException extends RuntimeException {

    private final String productName;
    private final String category;

    /**
     * Constructor con solo el nombre del producto.
     * Se utiliza cuando se detecta un nombre duplicado sin importar la categoría.
     *
     * @param productName el nombre del producto que ya existe
     */
    public ProductAlreadyExistsException(String productName) {
        super(String.format("Ya existe un producto con el nombre '%s' en el catálogo", productName));
        this.productName = productName;
        this.category = null;
    }

    /**
     * Constructor con nombre y categoría del producto.
     * Se utiliza cuando se requiere validar unicidad por nombre dentro de una categoría específica.
     *
     * @param productName el nombre del producto que ya existe
     * @param category la categoría donde se detectó el conflicto
     */
    public ProductAlreadyExistsException(String productName, String category) {
        super(String.format("Ya existe un producto con el nombre '%s' en la categoría '%s'", productName, category));
        this.productName = productName;
        this.category = category;
    }

    /**
     * Constructor con mensaje personalizado.
     * Se utiliza cuando se necesita un mensaje de error específico para el caso de uso.
     *
     * @param message el mensaje de error personalizado
     */
    public ProductAlreadyExistsException(String productName, String category, String message) {
        super(message);
        this.productName = productName;
        this.category = category;
    }

    /**
     * Obtiene el nombre del producto que generó el conflicto.
     *
     * @return el nombre del producto duplicado
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Obtiene la categoría del producto que generó el conflicto.
     * Puede ser null si se creó con el constructor que no incluye categoría.
     *
     * @return la categoría del producto duplicado, o null si no aplica
     */
    public String getCategory() {
        return category;
    }

    /**
     * Proporciona información adicional para el debugging.
     * Incluye el nombre del producto y la categoría en la representación de la excepción.
     *
     * @return cadena con detalles de la excepción
     */
    @Override
    public String toString() {
        return "ProductAlreadyExistsException{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}