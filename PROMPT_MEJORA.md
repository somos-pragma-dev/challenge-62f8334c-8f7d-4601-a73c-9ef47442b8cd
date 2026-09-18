# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Boilerplate del stack que falta

Sin esto no compila ni arranca. Es andamiaje, no toca nada de lo pedagogico:

- **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productcatalog/exception/GlobalExceptionHandler.java` — `ErrorResponse.getDefaultMessage`: Se invoca `getDefaultMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.nombre`: Se invoca `nombre` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.precio`: Se invoca `precio` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.id`: Se invoca `id` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear un microservicio REST con Spring Boot, JPA y H2

### Reto
- Tema: Creación de microservicios REST
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de un microservicio REST para gestión de productos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Registro de productos — objetivo: Crear un endpoint que permita registrar productos en el catálogo. — entregable (NO resolver): Endpoint REST funcional para registrar productos.
- Fase 2: Consulta de productos — objetivo: Crear un endpoint que permita consultar productos por nombre o categoría. — entregable (NO resolver): Endpoint REST funcional para consultar productos por nombre o categoría.
- Fase 3: Actualización de productos — objetivo: Crear un endpoint que permita actualizar la información de los productos. — entregable (NO resolver): Endpoint REST funcional para actualizar la información de los productos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.pragma</groupId>
    <artifactId>product-catalog</artifactId>
    <version>1.0.0</version>
    <name>Product Catalog Microservice</name>
    <description>Microservicio REST para gestión de productos</description>
    
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/productcatalog/ProductCatalogApplication.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
# Configuración principal de la aplicación Spring Boot
# Este archivo define las propiedades que Spring utiliza para configurar
# el contexto de la aplicación, incluyendo datasource, JPA, servidor y propiedades personalizadas

spring:
  application:
    # Nombre de la aplicación que se muestra en logs y métricas
    name: product-catalog
  
  # Configuración del datasource (base de datos)
  datasource:
    # Driver JDBC para H2 en memoria
    driver-class-name: org.h2.Driver
    # URL de conexión a H2: modo en memoria (mem:) con nombre de base de datos (productdb)
    # La opción DB_CLOSE_DELAY=-1 mantiene la base de datos abierta mientras la JVM corre
    # MODE=MySQL activa compatibilidades con sintaxis MySQL
    url: jdbc:h2:mem:productdb;DB_CLOSE_DELAY=-1;MODE=MySQL
    # Nombre de usuario para conexión a H2 (usuario por defecto)
    username: sa
    # Contraseña vacía para H2 en memoria
    password: 
    # Configuración del pool de conexiones ( HikariCP por defecto en Spring Boot)
    hikari:
      # Tiempo máximo de espera para obtener una conexión del pool
      connection-timeout: 20000
      # Tiempo máximo que una conexión puede estar idle (sin uso) en el pool
      idle-timeout: 300000
      # Tiempo máximo que una conexión puede estar activa (en uso)
      max-lifetime: 1200000
      # Número mínimo de conexiones siempre abiertas en el pool
      minimum-idle: 2
      # Número máximo de conexiones en el pool
      maximum-pool-size: 10
  
  # Configuración de JPA/Hibernate
  jpa:
    # Implementación de JPA a utilizar (Hibernate por defecto)
    database-platform: org.hibernate.dialect.H2Dialect
    # Estrategia de generación de esquemas: create-drop crea el esquema al iniciar
    # y lo elimina al detener la aplicación (útil para desarrollo y pruebas)
    hibernate:
      ddl-auto: create-drop
    # Mostrar SQL generado por Hibernate en los logs (útil para depuración)
    show-sql: true
    # Formatear el SQL mostrado en logs para mejor legibilidad
    properties:
      hibernate:
        format_sql: true
    # Configuración para abrir/cierre automático de EntityManager
    open-in-view: false
  
  # Configuración de H2 Console (interfaz web para explorar la base de datos)
  h2:
    console:
      # Habilitar la consola web de H2 en /h2-console
      enabled: true
      # Permitir acceso desde cualquier dirección IP
      access-path: /h2-console
  
  # Configuración de SQL inicial (data.sql)
  sql:
    init:
      # No ejecutar scripts SQL de inicialización (data.sql se manejará manualmente si es necesario)
      mode: never

# Configuración del servidor embebido (Tomcat por defecto)
server:
  # Puerto donde escuchará el servidor HTTP
  port: 8080
  # Configuración de errores HTTP
  error:
    # Incluir trace de error en respuestas JSON (solo en desarrollo)
    include-stacktrace: on_param
    # Mensaje de error por defecto para respuestas
    include-message: always

# Configuración personalizada del dominio de productos
product:
  # Categorías válidas para productos del catálogo
  categories:
    - ELECTRONICS
    - CLOTHING
    - FOOD
    - BOOKS
    - HOME
    - SPORTS
    - TOYS
  # Límites de validación de negocio
  limits:
    # Precio mínimo permitido para un producto
    min-price: 0.01
    # Precio máximo permitido (límite de seguridad)
    max-price: 999999.99
    # Stock mínimo permitido
    min-stock: 0
    # Stock máximo permitido
    max-stock: 100000
    # Longitud máxima del nombre del producto
    max-name-length: 200

# Configuración de logging
logging:
  # Nivel de log para paquetes de Spring
  level:
    root: INFO
    com.pragma.productcatalog: DEBUG
    org.springframework.web: INFO
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  # Patrón de formato de logs
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

// === ARCHIVO: src/main/java/com/pragma/productcatalog/repository/ProductRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productcatalog/dto/ProductRequest.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productcatalog/dto/ProductResponse.java ===
package com.pragma.productcatalog.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(
    Long id,
    String nombre,
    BigDecimal precio,
    Integer stock,
    String categoria,
    String descripcion,
    LocalDateTime fechaCreacion,
    LocalDateTime fechaActualizacion,
    Boolean activo
) {
    public static ProductResponseBuilder builder() {
        return new ProductResponseBuilder();
    }

    public static class ProductResponseBuilder {
        private Long id;
        private String nombre;
        private BigDecimal precio;
        private Integer stock;
        private String categoria;
        private String descripcion;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaActualizacion;
        private Boolean activo;

        public ProductResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ProductResponseBuilder precio(BigDecimal precio) {
            this.precio = precio;
            return this;
        }

        public ProductResponseBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductResponseBuilder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public ProductResponseBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ProductResponseBuilder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public ProductResponseBuilder fechaActualizacion(LocalDateTime fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public ProductResponseBuilder activo(Boolean activo) {
            this.activo = activo;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(id, nombre, precio, stock, categoria, descripcion, fechaCreacion, fechaActualizacion, activo);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/productcatalog/controller/ProductController.java ===
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
// === ARCHIVO: src/main/java/com/pragma/productcatalog/service/ProductService.java ===
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
// === ARCHIVO: src/main/java/com/pragma/productcatalog/exception/GlobalExceptionHandler.java ===
package com.pragma.productcatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> manejarProductNotFoundException(ProductNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "NOT_FOUND",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> manejarProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorResponse> manejarInvalidProductException(InvalidProductException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> manejarValidacionExcepciones(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(nombreCampo, mensaje);
        });

        String mensajeError = "Error de validación en los campos: " + errores.keySet().stream()
                .collect(java.util.stream.Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                mensajeError,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionGeneral(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_SERVER_ERROR",
                "Ha ocurrido un error interno en el servidor",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    public record ErrorResponse(
            int status,
            String code,
            String message,
            LocalDateTime timestamp
    ) {}
}

// === ARCHIVO: src/main/java/com/pragma/productcatalog/exception/ProductAlreadyExistsException.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productcatalog/exception/ProductNotFoundException.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productcatalog/exception/InvalidProductException.java ===
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


// === ARCHIVO: src/main/resources/data.sql ===
-- Script de carga inicial de datos para el catálogo de productos
-- Este script se ejecuta al iniciar la aplicación en entorno de prueba

-- Deshabilitar validación de claves foráneas para permitir inserts en orden
SET FOREIGN_KEY_CHECKS = 0;

-- Limpiar tablas existentes para evitar duplicados en reinicios
TRUNCATE TABLE product;

-- Insertar productos de prueba con diferentes categorías
INSERT INTO product (id, nombre, descripcion, precio, stock, categoria, fecha_creacion) 
VALUES 
    (1, 'Laptop Pro 15', 'Laptop de alta gama con procesador Intel i7', 1299.99, 25, 'Electrónica', CURRENT_TIMESTAMP),
    (2, 'Mouse Inalámbrico', 'Mouse ergonómico con conexión Bluetooth', 29.99, 150, 'Electrónica', CURRENT_TIMESTAMP),
    (3, 'Teclado Mecánico', 'Teclado gaming con switches Cherry MX', 89.99, 75, 'Electrónica', CURRENT_TIMESTAMP),
    (4, 'Monitor 27 pulgadas', 'Monitor 4K UHD con panel IPS', 399.99, 40, 'Electrónica', CURRENT_TIMESTAMP),
    (5, 'Camiseta Algodón', 'Camiseta de algodón orgánico color blanco', 19.99, 500, 'Ropa', CURRENT_TIMESTAMP),
    (6, 'Jeans Slim Fit', 'Pantalón vaquero ajuste slim color azul', 49.99, 200, 'Ropa', CURRENT_TIMESTAMP),
    (7, 'Zapatillas Running', 'Zapatillas para correr amortiguación avanzada', 79.99, 120, 'Calzado', CURRENT_TIMESTAMP),
    (8, 'Bolso Deportivo', 'Bolso con compartimento para zapatillas', 34.99, 80, 'Accesorios', CURRENT_TIMESTAMP),
    (9, 'Gorra Baseball', 'Gorra ajustable con logo bordado', 14.99, 300, 'Accesorios', CURRENT_TIMESTAMP),
    (10, 'Café Orgánico 1kg', 'Café en grano orgánico de Colombia', 24.99, 200, 'Alimentos', CURRENT_TIMESTAMP),
    (11, 'Chocolate Dark 70%', 'Chocolate negro premium 70% cacao', 5.99, 450, 'Alimentos', CURRENT_TIMESTAMP),
    (12, 'Aceite de Oliva Extra', 'Aceite de oliva virgen extra 500ml', 12.99, 180, 'Alimentos', CURRENT_TIMESTAMP),
    (13, 'Silla Ergonomica', 'Silla de oficina con soporte lumbar', 249.99, 30, 'Muebles', CURRENT_TIMESTAMP),
    (14, 'Escritorio Madera', 'Escritorio de madera maciza 120cm', 199.99, 20, 'Muebles', CURRENT_TIMESTAMP),
    (15, 'Lampara LED Escritorio', 'Lampara LED regulable con USB', 39.99, 90, 'Muebles', CURRENT_TIMESTAMP);

-- Habilitar nuevamente validación de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

// === ARCHIVO: src/test/java/com/pragma/productcatalog/controller/ProductControllerTest.java ===
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
import java.util.List;

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

        when(productService.listarTodos())
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
        when(productService.listarTodos())
            .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    @DisplayName("GET /products/{id} - Debe retornar producto por ID")
    void obtenerProductoPorId_DeberiaRetornar200YProducto() throws Exception {
        when(productService.obtenerPorId(1L))
            .thenReturn(productResponse);

        mockMvc.perform(get("/products/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Laptop Gaming"));
    }

    @Test
    @DisplayName("GET /products/{id} - Debe retornar 404 cuando el producto no existe")
    void obtenerProductoPorId_NoExiste_DeberiaRetornar404() throws Exception {
        when(productService.obtenerPorId(999L))
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

// === ARCHIVO: src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java ===
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
    @DisplayName("listarTodos - Debe retornar todos los productos")
    void listarTodos_DeberiaRetornarListaDeProductos() {
        Product producto2 = new Product();
        producto2.setId(2L);
        producto2.setNombre("Mouse");
        producto2.setDescripcion("Mouse inalámbrico");
        producto2.setPrecio(new BigDecimal("29.99"));
        producto2.setStock(100);
        producto2.setCategoria("Electrónica");

        when(productRepository.findAll()).thenReturn(Arrays.asList(producto, producto2));

        List<ProductResponse> resultados = productService.listarTodos();

        assertEquals(2, resultados.size());
        assertEquals("Laptop Gaming", resultados.get(0).nombre());
        assertEquals("Mouse", resultados.get(1).nombre());
    }

    @Test
    @DisplayName("listarTodos - Debe retornar lista vacía cuando no hay productos")
    void listarTodos_SinProductos_DeberiaRetornarListaVacia() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<ProductResponse> resultados = productService.listarTodos();

        assertTrue(resultados.isEmpty());
    }

    @Test
    @DisplayName("obtenerPorId - Debe retornar producto por ID")
    void obtenerPorId_ProductoExiste_DeberiaRetornarProducto() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(producto));

        ProductResponse resultado = productService.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.id());
        assertEquals("Laptop Gaming", resultado.nombre());
    }

    @Test
    @DisplayName("obtenerPorId - Debe lanzar excepción cuando el producto no existe")
    void obtenerPorId_ProductoNoExiste_DeberiaLanzarExcepcion() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.obtenerPorId(999L));
    }

    @Test
    @DisplayName("buscarPorNombre - Debe buscar productos por nombre")
    void buscarPorNombre_DeberiaRetornarListaDeProductos() {
        when(productRepository.findByNombreIgnoreCase("Laptop"))
            .thenReturn(Arrays.asList(producto));

        List<ProductResponse> resultados = productService.buscarPorNombre("Laptop");

        assertEquals(1, resultados.size());
        assertEquals("Laptop Gaming", resultados.get(0).nombre());
    }

    @Test
    @DisplayName("buscarPorNombre - Debe retornar lista vacía cuando no hay resultados")
    void buscarPorNombre_SinResultados_DeberiaRetornarListaVacia() {
        when(productRepository.findByNombreIgnoreCase("XYZ"))
            .thenReturn(Collections.emptyList());

        List<ProductResponse> resultados = productService.buscarPorNombre("XYZ");

        assertTrue(resultados.isEmpty());
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
        when(productRepository.findById(1L)).thenReturn(Optional.of(producto));
        doNothing().when(productRepository).delete(producto);

        assertDoesNotThrow(() -> productService.eliminarProducto(1L));

        verify(productRepository, times(1)).delete(producto);
    }

    @Test
    @DisplayName("eliminarProducto - Debe lanzar excepción cuando el producto no existe")
    void eliminarProducto_ProductoNoExiste_DeberiaLanzarExcepcion() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, 
            () -> productService.eliminarProducto(999L));

        verify(productRepository, never()).delete(any(Product.class));
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
    @DisplayName("buscarPorStockMenorQue - Debe buscar productos con stock bajo")
    void buscarPorStockMenorQue_DeberiaRetornarListaDeProductos() {
        when(productRepository.findByStockMenorQue(20))
            .thenReturn(Arrays.asList(producto));

        List<ProductResponse> resultados = productService.buscarPorStockMenorQue(20);

        assertEquals(1, resultados.size());
    }
}


// === ARCHIVO: src/main/java/com/pragma/productcatalog/model/Product.java ===
package com.pragma.productcatalog.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Product() {
    }

    public Product(String nombre, String descripcion, BigDecimal precio, Integer stock, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
// === ARCHIVO: src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java ===
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


<!-- === ARCHIVO: pom.xml === -->
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>
    
    <groupId>com.pragma</groupId>
    <artifactId>product-catalog</artifactId>
    <version>1.0.0</version>
    <name>product-catalog</name>
    <description>Product Catalog Application</description>
    
    <properties>
        <java.version>21</java.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.18.2</version>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/test/java/com/pragma/productcatalog/controller/ProductControllerTest.java ===
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

```
