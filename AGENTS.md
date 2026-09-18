# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Desarrollo de un microservicio REST para gestión de productos**.

| | |
|---|---|
| Tema | Creación de microservicios REST |
| Nivel | junior-l1 |
| Chapter | Generico |
| Especialidad | Inferido del contexto |
| Stack | Java / Spring Boot 3.4 |
| Patron arquitectonico | capas estándar (controller-service-repository) |
| Tiempo estimado | 8 horas |

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `el comando de build o arranque canonico del stack elegido` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `el comando de build o arranque canonico del stack elegido` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Registro de productos**: Endpoint REST funcional para registrar productos.
- **Fase 2 — Consulta de productos**: Endpoint REST funcional para consultar productos por nombre o categoría.
- **Fase 3 — Actualización de productos**: Endpoint REST funcional para actualizar la información de los productos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Boilerplate del stack (1)

Sin esto el proyecto no compila ni arranca. **Es tu trabajo crearlo**, y no toca nada de lo pedagogico: es andamiaje del stack.

- [ ] **Punto de entrada del stack elegido** — Sin un punto de entrada reconocible, el runtime no tiene por donde arrancar la aplicacion.

### 2. Referencias colgando (13)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.existsById`
      Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productcatalog/service/ProductService.java` — `ProductRepository.deleteById`
      Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/productcatalog/exception/GlobalExceptionHandler.java` — `ErrorResponse.getDefaultMessage`
      Se invoca `getDefaultMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.save`
      Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.nombre`
      Se invoca `nombre` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.precio`
      Se invoca `precio` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.findAll`
      Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.findById`
      Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductResponse.id`
      Se invoca `id` sobre `ProductResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java` — `ProductRepository.existsById`
      Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/pragma/productcatalog/ProductCatalogApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/productcatalog/repository/ProductRepository.java`
- `src/main/java/com/pragma/productcatalog/dto/ProductRequest.java`
- `src/main/java/com/pragma/productcatalog/dto/ProductResponse.java`
- `src/main/java/com/pragma/productcatalog/controller/ProductController.java`
- `src/main/java/com/pragma/productcatalog/service/ProductService.java`
- `src/main/java/com/pragma/productcatalog/exception/GlobalExceptionHandler.java`
- `src/main/java/com/pragma/productcatalog/exception/ProductAlreadyExistsException.java`
- `src/main/java/com/pragma/productcatalog/exception/ProductNotFoundException.java`
- `src/main/java/com/pragma/productcatalog/exception/InvalidProductException.java`
- `src/main/resources/data.sql`
- `src/test/java/com/pragma/productcatalog/controller/ProductControllerTest.java`
- `src/test/java/com/pragma/productcatalog/service/ProductServiceTest.java`
- `src/main/java/com/pragma/productcatalog/model/Product.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/productcatalog`
- `src/main/java/com/pragma/productcatalog/controller`
- `src/main/java/com/pragma/productcatalog/service`
- `src/main/java/com/pragma/productcatalog/repository`
- `src/main/java/com/pragma/productcatalog/dto`
- `src/main/java/com/pragma/productcatalog/exception`
- `src/main/java/com/pragma/productcatalog/config`
- `src/main/resources`
- `src/test/java/com/pragma/productcatalog`

## Verificacion

```bash
el comando de build o arranque canonico del stack elegido
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (controller-service-repository)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Crear un microservicio REST con Spring Boot, JPA y H2

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
