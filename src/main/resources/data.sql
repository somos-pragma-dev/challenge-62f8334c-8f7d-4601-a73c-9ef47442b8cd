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