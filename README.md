# Desarrollo de un microservicio REST para gestión de productos

Necesitas crear un microservicio REST que gestione productos en un catálogo. El sistema debe registrar productos con nombre, precio, stock y categoría. Los productos no pueden tener precios negativos ni nombres duplicados. Debes decidir cómo estructurar la información y qué hacer cuando una validación falla.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Creación de microservicios REST |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Registro de productos

**Objetivo:** Crear un endpoint que permita registrar productos en el catálogo.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Diseña un endpoint REST que acepte productos con nombre, precio, stock y categoría.
- Implementa validaciones para asegurar que los productos no tengan precios negativos ni nombres duplicados.

**Entregable:** Endpoint REST funcional para registrar productos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo estructurar la información para facilitar las validaciones.
- Piensa en cómo manejar los errores de validación.

</details>

### Fase 2: Consulta de productos

**Objetivo:** Crear un endpoint que permita consultar productos por nombre o categoría.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Diseña un endpoint REST que permita consultar productos por nombre o categoría.
- Implementa la lógica necesaria para realizar las consultas.

**Entregable:** Endpoint REST funcional para consultar productos por nombre o categoría.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo optimizar las consultas para mejorar el rendimiento.
- Piensa en cómo manejar los casos en los que no se encuentren productos.

</details>

### Fase 3: Actualización de productos

**Objetivo:** Crear un endpoint que permita actualizar la información de los productos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Diseña un endpoint REST que permita actualizar la información de los productos.
- Implementa las validaciones necesarias para asegurar la integridad de los datos.

**Entregable:** Endpoint REST funcional para actualizar la información de los productos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar las actualizaciones parciales de los productos.
- Piensa en cómo asegurar la consistencia de los datos durante las actualizaciones.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un microservicio REST y cuáles son sus características?
- **paraQueSirve**: ¿Para qué sirve el endpoint de registro de productos en el contexto del catálogo?
- **comoSeUsa**: ¿Cómo se usa el endpoint de consulta de productos para obtener información?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir al registrar o consultar productos y cómo se manejan?

## Criterios de Evaluacion

- Implementación correcta del endpoint de registro de productos.
- Implementación correcta del endpoint de consulta de productos.
- Implementación correcta del endpoint de actualización de productos.
- Manejo adecuado de las validaciones y errores.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
