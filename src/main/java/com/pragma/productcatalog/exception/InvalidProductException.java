package com.pragma.productcatalog.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Excepción personalizada que se lanza cuando los datos de un producto
 * no cumplen con las validaciones establecidas. Esta excepción encapsulate
 * múltiples errores de validación para proporcionar retroalimentación completa
 * al cliente sobre qué campos están incorrectos y por qué.
 */
public class InvalidProductException extends RuntimeException {

    private final String fieldName;
    private final Object invalidValue;
    private final String validationRule;
    private final List<ValidationError> validationErrors;

    /**
     * Constructor con un solo error de validación.
     * Se utiliza cuando falla una única validación en un campo específico.
     *
     * @param fieldName el nombre del campo que falló la validación
     * @param invalidValue el valor que no pasó la validación
     * @param validationRule la regla de validación que no se cumplió
     */
    public InvalidProductException(String fieldName, Object invalidValue, String validationRule) {
        super(String.format("Validación fallida para el campo '%s': %s", fieldName, validationRule));
        this.fieldName = fieldName;
        this.invalidValue = invalidValue;
        this.validationRule = validationRule;
        this.validationErrors = new ArrayList<>();
        this.validationErrors.add(new ValidationError(fieldName, invalidValue, validationRule));
    }

    /**
     * Constructor con mensaje personalizado.
     * Se utiliza cuando se necesita un mensaje de error específico.
     *
     * @param message el mensaje de error personalizado
     */
    public InvalidProductException(String message) {
        super(message);
        this.fieldName = null;
        this.invalidValue = null;
        this.validationRule = null;
        this.validationErrors = new ArrayList<>();
    }

    /**
     * Constructor con lista de errores de validación.
     * Se utiliza cuando hay múltiples errores de validación que reportar.
     *
     * @param validationErrors lista de errores de validación
     */
    public InvalidProductException(List<ValidationError> validationErrors) {
        super("La validación del producto falló: " + validationErrors.size() + " error(es) encontrado(s)");
        this.fieldName = null;
        this.invalidValue = null;
        this.validationRule = null;
        this.validationErrors = validationErrors != null ? new ArrayList<>(validationErrors) : new ArrayList<>();
    }

    /**
     * Constructor completo con todos los detalles.
     * Se utiliza para máxima flexibilidad en el reporte de errores.
     *
     * @param fieldName el nombre del campo que falló la validación
     * @param invalidValue el valor que no pasó la validación
     * @param validationRule la regla de validación que no se cumplió
     * @param message mensaje personalizado
     */
    public InvalidProductException(String fieldName, Object invalidValue, String validationRule, String message) {
        super(message);
        this.fieldName = fieldName;
        this.invalidValue = invalidValue;
        this.validationRule = validationRule;
        this.validationErrors = new ArrayList<>();
        this.validationErrors.add(new ValidationError(fieldName, invalidValue, validationRule));
    }

    /**
     * Obtiene el nombre del campo que falló la validación.
     * Puede ser null si hay múltiples errores.
     *
     * @return el nombre del campo, o null si no aplica
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Obtiene el valor que no pasó la validación.
     * Puede ser null si hay múltiples errores.
     *
     * @return el valor inválido, o null si no aplica
     */
    public Object getInvalidValue() {
        return invalidValue;
    }

    /**
     * Obtiene la regla de validación que no se cumplió.
     * Puede ser null si hay múltiples errores.
     *
     * @return la regla de validación, o null si no aplica
     */
    public String getValidationRule() {
        return validationRule;
    }

    /**
     * Obtiene la lista completa de errores de validación.
     * Proporciona acceso a todos los errores cuando hay múltiples falhas.
     *
     * @return lista de errores de validación (nunca null)
     */
    public List<ValidationError> getValidationErrors() {
        return new ArrayList<>(validationErrors);
    }

    /**
     * Agrega un nuevo error de validación a la lista.
     * Método utilitario para construir excepciones con múltiples errores.
     *
     * @param error el error de validación a agregar
     */
    public void addValidationError(ValidationError error) {
        if (error != null) {
            this.validationErrors.add(error);
        }
    }

    /**
     * Verifica si hay múltiples errores de validación.
     *
     * @return true si hay más de un error, false en caso contrario
     */
    public boolean hasMultipleErrors() {
        return validationErrors.size() > 1;
    }

    /**
     * Obtiene el número total de errores de validación.
     *
     * @return la cantidad de errores
     */
    public int getErrorCount() {
        return validationErrors.size();
    }

    /**
     * Proporciona información adicional para el debugging.
     * Incluye el campo, valor, regla y lista de errores en la representación.
     *
     * @return cadena con detalles de la excepción
     */
    @Override
    public String toString() {
        return "InvalidProductException{" +
                "fieldName='" + fieldName + '\'' +
                ", invalidValue=" + invalidValue +
                ", validationRule='" + validationRule + '\'' +
                ", validationErrors=" + validationErrors +
                ", message='" + getMessage() + '\'' +
                '}';
    }

    /**
     * Clase interna que representa un error de validación individual.
     * Encapsula la información de un campo específico que no pasó validación.
     */
    public static class ValidationError {
        private final String fieldName;
        private final Object invalidValue;
        private final String validationRule;

        /**
         * Constructor del error de validación.
         *
         * @param fieldName el nombre del campo que falló
         * @param invalidValue el valor que no pasó la validación
         * @param validationRule la regla que no se cumplió
         */
        public ValidationError(String fieldName, Object invalidValue, String validationRule) {
            this.fieldName = fieldName;
            this.invalidValue = invalidValue;
            this.validationRule = validationRule;
        }

        public String getFieldName() {
            return fieldName;
        }

        public Object getInvalidValue() {
            return invalidValue;
        }

        public String getValidationRule() {
            return validationRule;
        }

        @Override
        public String toString() {
            return "ValidationError{" +
                    "fieldName='" + fieldName + '\'' +
                    ", invalidValue=" + invalidValue +
                    ", validationRule='" + validationRule + '\'' +
                    '}';
        }
    }
}