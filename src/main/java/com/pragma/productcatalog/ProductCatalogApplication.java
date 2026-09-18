package com.pragma.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada principal del microservicio de catálogo de productos.
 * Esta clase configura y arranca el contexto de Spring Boot con todas las
 * configuraciones automáticas para Web, JPA, Validación y H2.
 * 
 * La anotación @SpringBootApplication es una combinación de tres anotaciones:
 * - @Configuration: marca la clase como fuente de definiciones de beans
 * - @EnableAutoConfiguration: habilita la configuración automática de Spring Boot
 * - @ComponentScan: escanea el paquete actual y subpaquetes para componentes
 * 
 * Al ejecutar este método main, Spring Boot inicia un servidor embebido (por defecto Tomcat)
 * y despliega todos los controladores, servicios y repositorios encontrados en el paquete.
 */
@SpringBootApplication
public class ProductCatalogApplication {
    
    /**
     * Método principal que inicia la aplicación Spring Boot.
     * El método run() recibe dos argumentos:
     * - Esta clase (ProductCatalogApplication.class): indica qué configuración cargar
     * - args: argumentos de línea de comandos que pueden pasarse a la aplicación
     * 
     * Spring Boot realiza las siguientes operaciones automáticamente:
     * 1. Crea un ApplicationContext (contenedor de beans)
     * 2. Configura el datasource H2 en memoria según application.yml
     * 3. Escanea y registra todos los @Component, @Service, @Repository, @Controller
     * 4. Configura el servidor embebido (Tomcat por defecto en el puerto 8080)
     * 5. Ejecuta inicializaciones definidas en @PostConstruct
     * 6. Arranca el servidor y queda escuchando peticiones HTTP
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApplication.class, args);
    }
}