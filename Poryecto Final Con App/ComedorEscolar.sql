CREATE DATABASE RecetasDB;
USE RecetasDB;

GO
-- Creación de la tabla Padres
CREATE TABLE Padres (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  telefono_celular VARCHAR(20),
  lugar_trabajo VARCHAR(100)
);
GO

-- Creación de la tabla Alimentos
CREATE TABLE Alimentos (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  tipo_Alimento VARCHAR(20),
  calorias INT,
  carbohidratos INT,
  grasas INT,
  proteinas INT,
  precio DECIMAL(10, 2),
  cobro_extra INT
);
GO

-- Creación de la tabla Ingrediente
CREATE TABLE Ingrediente (
  id INT PRIMARY KEY,
  nombre VARCHAR(50)
);
GO

-- Creación de la tabla Alergias
CREATE TABLE Alergias (
  id INT PRIMARY KEY,
  alergia VARCHAR(50)
);
GO

-- Creación de la tabla Niños
CREATE TABLE Niños (
  id INT PRIMARY KEY,
  nombre VARCHAR(50),
  edad INT,
  nivel VARCHAR(20),
  grado INT,
  padre_id INT,
  FOREIGN KEY (padre_id) REFERENCES Padres(id)
);
GO

-- Creación de la tabla Niños_Alergias
CREATE TABLE Niños_Alergias (
  niño_id INT,
  alergia_id INT,
  PRIMARY KEY (niño_id, alergia_id),
  FOREIGN KEY (niño_id) REFERENCES Niños(id),
  FOREIGN KEY (alergia_id) REFERENCES Alergias(id)
);
GO

-- Creación de la tabla Compras
CREATE TABLE Compras (
  id INT PRIMARY KEY,
  ingrediente_id INT,
  cantidad INT,
  fechaCompra DATE,
  caducidad DATE,
  FOREIGN KEY (ingrediente_id) REFERENCES Ingrediente(id)
);
GO

-- Creación de la tabla InventarioEscuela
CREATE TABLE InventarioEscuela (
  id INT PRIMARY KEY,
  ingrediente_id INT,
  cantidadDisponible INT,
  FOREIGN KEY (ingrediente_id) REFERENCES Ingrediente(id)
);
GO

-- Creación de la tabla Recetas
CREATE TABLE Recetas (
  id INT PRIMARY KEY,
  alimento_id INT,
  procedimiento VARCHAR(100),
  porciones INT,
  FOREIGN KEY (alimento_id) REFERENCES Alimentos(id)
);
GO

-- Creación de la tabla DetalleReceta
CREATE TABLE DetalleReceta (
  id INT PRIMARY KEY,
  receta_id INT,
  ingrediente_id INT,
  alimento_id INT,
  cantidad INT,
  FOREIGN KEY (receta_id) REFERENCES Recetas(id),
  FOREIGN KEY (alimento_id) REFERENCES Alimentos(id),
  FOREIGN KEY (ingrediente_id) REFERENCES Ingrediente(id)
);
GO

-- Creación de la tabla PedidosMenu
CREATE TABLE PedidosMenu (
  id INT PRIMARY KEY,
  padre_id INT,
  semanaAsignada INT,
  diaAsignado VARCHAR(50),
  fecha DATE,
  pago_total DECIMAL(10, 2),
  pagado INT,
  FOREIGN KEY (padre_id) REFERENCES Padres(id)
);
GO

-- Creación de la tabla DetallePedido
CREATE TABLE DetallePedido (
  id INT PRIMARY KEY,
  pedido_id INT,
  alimento_id INT,
  tipo VARCHAR(20),
  FOREIGN KEY (pedido_id) REFERENCES PedidosMenu(id),
  FOREIGN KEY (alimento_id) REFERENCES Alimentos(id)
);

GO
-- Creación de los índices
CREATE INDEX idx_Niños_padre_id ON Niños (padre_id);
CREATE INDEX idx_Recetas_alimento_id ON Recetas (alimento_id);
CREATE INDEX idx_PedidosMenu_padre_id ON PedidosMenu (padre_id);
CREATE INDEX idx_PedidosMenu_fecha ON PedidosMenu (fecha);

-------------------------------------------------INSERTS--------------------------------------

GO
-- Insertar valores en la tabla Padres
INSERT INTO Padres (id, nombre, telefono_celular, lugar_trabajo)
VALUES
  (1, 'Juan', '555-1234', 'SEP'),
  (2, 'María', '555-5678', 'COPPEL'),
  (3, 'Carlos', '555-9012', 'JAPAC'),
  (4, 'Laura', '555-3456', 'SEP'),
  (5, 'Pedro', '555-7890', 'INTEL');
  SELECT * FROM Padres
-- Insertar valores en la tabla Alimentos
INSERT INTO Alimentos (id, nombre, tipo_Alimento, calorias, carbohidratos, grasas, proteinas, precio, cobro_extra)
VALUES
  (1, 'Manzana', 'POSTRE', 52, 14, 0, 0.3, 1.99, 0),
  (2, 'Pollo', 'COMIDA', 165, 0, 7, 24, 5.99, 0),
  (3, 'Arroz', 'COMIDA', 130, 28, 0.5, 2.7, 2.99, 0),
  (4, 'Leche', 'BEBIDA', 103, 12, 3.2, 8, 3.49, 0),
  (5, 'Espinaca', 'COMIDA', 23, 3.6, 0.4, 2.9, 1.49, 0),
  (6, 'Pera', 'POSTRE', 57, 15, 0, 0.6, 2.49, 0),
  (7, 'Pescado', 'COMIDA', 198, 0, 10, 22, 8.99, 0),
  (8, 'Frijoles', 'COMIDA', 120, 22, 0.5, 7, 1.99, 0),
  (9, 'Jugo de Naranja', 'BEBIDA', 112, 26, 0.5, 2, 2.99, 0),
  (10, 'Zanahoria', 'COMIDA', 41, 10, 0.2, 0.9, 1.29, 0),
  (11, 'Pasta', 'COMIDA', 131, 25, 1.2, 5.5, 3.49, 0),
  (12, 'Lechuga', 'COMIDA', 5, 1, 0.1, 0.5, 0.99, 0),
  (13, 'Plátano', 'POSTRE', 96, 23, 0.2, 1.2, 0.99, 0),
  (14, 'Pan', 'COMIDA', 264, 49, 3.6, 8.5, 4.99, 0),
  (15, 'Cebolla', 'COMIDA', 40, 9, 0.1, 1.1, 1.49, 0);

-- Insertar valores en la tabla Ingrediente
INSERT INTO Ingrediente (id, nombre)
VALUES
  (1, 'Azúcar'),
  (2, 'Sal'),
  (3, 'Aceite'),
  (4, 'Harina'),
  (5, 'Tomate'),
  (6, 'Limón'),
  (7, 'Canela'),
  (8, 'Vinagre'),
  (9, 'Mantequilla'),
  (10, 'Cilantro'),
  (11, 'Azúcar morena'),
  (12, 'Yogur'),
  (13, 'Pimienta'),
  (14, 'Queso'),
  (15, 'Ajo');

-- Insertar valores en la tabla Alergias
INSERT INTO Alergias (id, alergia)
VALUES
  (0, 'NINGUNA'),
  (1, 'maní'),
  (2, 'gluten'),
  (3, 'mariscos'),
  (4, 'lactosa'),
  (5, 'huevo');

-- Insertar valores en la tabla Niños
INSERT INTO Niños (id, nombre, edad, nivel, grado, padre_id)
VALUES
  (1, 'Luis', 8, 'Primaria', 3, 1),
  (2, 'Ana', 3, 'Kinder', 1, 3),
  (3, 'Pedro', 10, 'Primaria', 5, 2),
  (4, 'María', 7, 'Primaria', 2, 4),
  (5, 'Laura', 9, 'Primaria', 4, 5);

-- Insertar valores en la tabla Niños_Alergias
INSERT INTO Niños_Alergias (niño_id, alergia_id)
VALUES
  (1, 1),
  (2, 3),
  (3, 0),
  (4, 0),
  (5, 5);

-- Insertar valores en la tabla Compras
INSERT INTO Compras (id, ingrediente_id, cantidad, fechaCompra, caducidad)
VALUES
  (1, 1, 500, '2023-06-01', '2023-07-01'),
  (2, 3, 800, '2023-06-02', '2023-07-02'),
  (3, 5, 150, '2023-06-03', '2023-07-03'),
  (4, 2, 640, '2023-06-04', '2023-07-04'),
  (5, 4, 298, '2023-06-05', '2023-07-05');

-- Insertar valores en la tabla InventarioEscuela
INSERT INTO InventarioEscuela (id, ingrediente_id, cantidadDisponible)
VALUES
  (1, 1, 200),
  (2, 2, 500),
  (3, 3, 458),
  (4, 4, 364),
  (5, 5, 886),
   (6,6, 150),
  (7, 7, 700),
  (8, 8, 512),
  (9, 9, 420),
  (10, 10, 724),
  (11, 11, 180),
  (12, 12, 650),
  (13, 13, 390),
  (14, 14, 598),
  (15, 15, 942);
  select * from InventarioEscuela;
  UPDATE InventarioEscuela
  SET cantidadDisponible = 0;


-- Insertar valores en la tabla Recetas
INSERT INTO Recetas (id, alimento_id,porciones, procedimiento)
VALUES
  (1, 2, 4,'Cocinar el pollo a la parrilla'),
  (2, 3, 2, 'Cocinar el arroz en agua hirviendo'),
  (3, 5, 2, 'Preparar la ensalada de espinacas'),
  (4, 1, 4, 'Cortar la manzana en rodajas'),
  (5, 6, 2, 'Exprimir el jugo de limón sobre la ensalada'),
  (6, 7, 4, 'Agregar canela en polvo a la mezcla'),
  (7, 8, 6, 'Incorporar vinagre al aderezo'),
  (8, 9, 2, 'Derretir la mantequilla en una sartén'),
  (9, 10, 4, 'Picar cilantro fresco y añadirlo al plato'),
  (10, 11, 6, 'Sustituir el azúcar blanca por azúcar morena'),
  (11, 12, 2, 'Mezclar yogur natural con frutas'),
  (12, 13, 4, 'Agregar pimienta negra molida al guiso'),
  (13, 14, 6, 'Rallar queso parmesano sobre la pasta'),
  (14, 15, 2, 'Añadir ajo picado finamente al sofrito');
 
-- Insertar valores en la tabla DetalleReceta
INSERT INTO DetalleReceta (id, receta_id, alimento_id, ingrediente_id, cantidad)
VALUES
  (1, 1,2, 2, 500),
  (2, 1,2, 4, 100),
  (3, 2,3, 3, 20),
  (4, 3,5, 5, 320),
  (5, 4,1, 1, 50),
  (6, 1, 3, 3, 150),
  (7, 1, 5, 6, 200),
  (8, 2, 2, 7, 80),
  (9, 2, 4, 9, 150),
  (10, 3, 1, 10, 70),
  (11, 3, 3, 11, 30),
  (12, 4, 5, 12, 280),
  (13, 4, 1, 13, 30),
  (14, 1, 4,14, 80),
  (15, 2, 5, 15, 180);
  

-- Insertar valores en la tabla PedidosMenu
INSERT INTO PedidosMenu (id, padre_id, semanaAsignada, diaAsignado, fecha, pago_total, pagado)
VALUES
  (1, 1, 1, 'Lunes', '2023-06-05', 15.99, 1),
  (2, 2, 1, 'Martes', '2023-06-06', 12.99, 0),
  (3, 3, 1, 'Miércoles', '2023-06-07', 10.99, 1),
  (4, 4, 1, 'Jueves', '2023-06-08', 11.99, 0),
  (5, 5, 1, 'Viernes', '2023-06-09', 14.99, 1),
  (6, 2, 2, 'Viernes', '2023-06-16', 20.45, 0),
  (7, 4, 3, 'Viernes', '2023-06-23', 11.98, 0),
  (8, 1, 4, 'Viernes', '2023-06-30', 14.00, 1),
  (9, 3, 5, 'Viernes', '2023-07-07', 16.45, 0),
  (10,5, 6, 'Viernes', '2023-07-14', 9.00, 0),
  (11,1, 7, 'Viernes', '2023-06-21', 10.95, 0),
  (12, 3, 2, 'Lunes', '2023-06-12', 13.99, 0),
  (13, 4, 2, 'Martes', '2023-06-13', 10.99, 0),
  (14, 1, 2, 'Miércoles', '2023-06-14', 9.99, 1),
  (15, 2, 2, 'Jueves', '2023-06-15', 12.99, 0),
  (16, 5, 2, 'Viernes', '2023-06-16', 14.99, 1),
  (17, 3, 3, 'Lunes', '2023-06-19', 11.99, 1),
  (18, 4, 3, 'Martes', '2023-06-20', 9.99, 0),
  (19, 1, 3, 'Miércoles', '2023-06-21', 10.99, 1),
  (20, 2, 3, 'Jueves', '2023-06-22', 13.99, 1),
  (21, 5, 3, 'Viernes', '2023-06-23', 15.99, 0);

-- Insertar valores en la tabla DetallePedido
INSERT INTO DetallePedido (id, pedido_id, alimento_id, tipo)
VALUES
  (1, 1, 2, 'Comida'),
  (2, 1, 4, 'Bebida'),
  (3, 2, 3, 'Comida'),
  (4, 3, 5, 'Comida'),
  (5, 4, 1, 'Postre'),
  (6, 6, 3, 'Comida'),
  (7, 6, 4, 'Bebida'),
  (8, 6, 1, 'Postre'),
  (9, 7, 2, 'Comida'),
  (10, 7, 1, 'Postre'),
  (11, 8, 3, 'Comida'),
  (12, 9, 4, 'Bebida'),
  (13, 10, 1, 'Postre'),
  (14, 11, 1, 'Postre'),
  (15, 12, 2, 'Comida'),
  (16, 12, 4, 'Bebida'),
  (17, 13, 3, 'Comida'),
  (18, 14, 5, 'Comida'),
  (19, 14, 1, 'Postre'),
  (20, 15, 3, 'Comida'),
  (21, 15, 4, 'Bebida'),
  (22, 15, 1, 'Postre'),
  (23, 16, 2, 'Comida'),
  (24, 16, 1, 'Postre');

---------------------------------------TRIGGERS---------------------------------


--1. Se ejecuta después de insertar un nuevo registro en la tabla "Padres" 
--y agrega automáticamente un nuevo registro en la tabla "Niños" relacionado con el ID del padre.

GO
CREATE TRIGGER TR_Padres_Insert
ON Padres
AFTER INSERT
AS
BEGIN
  SET NOCOUNT ON;

  INSERT INTO Niños (id, nombre, edad, nivel, grado, padre_id)
  SELECT id, CONCAT('Niño de ', nombre), 0, '', 0, id
  FROM inserted;
END;

--2 Crear el trigger para eliminar los niños y los pedidos relacionados
GO
CREATE TRIGGER eliminar_relaciones
ON Padres
INSTEAD OF DELETE
AS
BEGIN
  -- Eliminar los niños relacionados
  DELETE FROM Niños WHERE padre_id IN (SELECT id FROM deleted);

  -- Eliminar los pedidos relacionados
  DELETE FROM PedidosMenu WHERE padre_id IN (SELECT id FROM deleted);

  -- Eliminar los padres
  DELETE FROM Padres WHERE id IN (SELECT id FROM deleted);
END;

----------------------------------------------PROCEDIMIENTOS ALMACENADOS-------------------------------------



--1. genera una lista de compras en una tabla vacía, 
--donde se indiquen los ingredientes faltantes para realizar las recetas según la tabla "PedidosMenu", 
--y también se registre el día en que se realizaron las compras.
GO
CREATE PROCEDURE GenerarListaCompras
AS
BEGIN
  -- Crear una tabla temporal para almacenar los ingredientes faltantes y el día de compras
  CREATE TABLE #IngredientesFaltantes (
    id INT,
    nombre VARCHAR(50),
    cantidad INT,
    diaCompra VARCHAR(20),
  );


  -- Insertar los ingredientes faltantes en la tabla temporal
  INSERT INTO #IngredientesFaltantes (id, nombre, cantidad, diaCompra)
  SELECT i.id, i.nombre, SUM(dr.cantidad) AS cantidad, CASE
    WHEN pm.diaAsignado = 'Martes' THEN 'Lunes'
    WHEN pm.diaAsignado = 'Miércoles' THEN 'Lunes'
	WHEN pm.diaAsignado = 'Jueves' THEN 'Lunes'
    WHEN pm.diaAsignado = 'Viernes' THEN 'Jueves'
	WHEN pm.diaAsignado = 'Lunes' THEN 'Jueves'
  END AS diaCompra
  FROM DetallePedido dp
  INNER JOIN DetalleReceta dr ON dp.alimento_id = dr.alimento_id
  LEFT JOIN InventarioEscuela ie ON dr.ingrediente_id = ie.ingrediente_id
  INNER JOIN Ingrediente i ON dr.ingrediente_id = i.id
  INNER JOIN PedidosMenu pm ON dp.pedido_id = pm.id
  WHERE dp.pedido_id IN (
    SELECT id
    FROM PedidosMenu 
	WHERE semanaAsignada = (SELECT DATEPART(WEEK, GETDATE()) AS Semana)
  )
  AND (ie.cantidadDisponible IS NULL OR dr.cantidad > ie.cantidadDisponible)
  GROUP BY i.id, i.nombre, pm.diaAsignado;

  -- Actualizar la cantidad de ingredientes utilizados en la tabla InventarioEscuela
  UPDATE ie
  SET cantidadDisponible = ie.cantidadDisponible - dr.cantidad
  FROM InventarioEscuela ie
  INNER JOIN DetalleReceta dr ON ie.ingrediente_id = dr.ingrediente_id
  INNER JOIN #IngredientesFaltantes f ON f.id = dr.ingrediente_id;

  -- Insertar los ingredientes faltantes en la tabla de compras
  INSERT INTO Compras (id, ingrediente_id, cantidad, fechaCompra, caducidad)
  SELECT ROW_NUMBER() OVER (ORDER BY id) AS id, id, cantidad, GETDATE(), DATEADD(DAY, 7, GETDATE())
  FROM #IngredientesFaltantes;

  -- Eliminar la tabla temporal
  SELECT * FROM #IngredientesFaltantes;
  DROP TABLE #IngredientesFaltantes;
END;
SELECT * FROM PedidosMenu WHERE semanaAsignada=23;
EXECUTE GenerarListaCompras
DROP PROCEDURE GenerarListaCompras;

SELECT * FROM VistaInventarioEscuela
--2. suma la cantidad de ingredientes de la tabla "Compras" a la tabla "InventarioEscuela" 
--y borra todos los datos de la tabla "Compras" en SQL Server
GO
CREATE PROCEDURE ActualizarInventario
AS
BEGIN
  -- Actualizar el inventario sumando la cantidad de ingredientes comprados
		UPDATE InventarioEscuela
		SET cantidadDisponible = cantidadDisponible + COALESCE(S.cantidad_total, 0)
		FROM InventarioEscuela IE
		LEFT JOIN (
			SELECT ingrediente_id, SUM(cantidad) as cantidad_total
			FROM Compras
			GROUP BY ingrediente_id
		) S ON IE.ingrediente_id = S.ingrediente_id;

  -- Borrar todos los datos de la tabla Compras
  DELETE FROM Compras;
  SELECT * FROM VistaInventarioEscuela;
  UPDATE InventarioEscuela
  SET cantidadDisponible = 0;
END;

EXECUTE ActualizarInventario
use RecetasDB
----------------------------------------------VISTAS-------------------------------------
--1. Se ve la vista de la tabla Inventario escuela con el nombre del ingrediente para no confundirnos
GO
CREATE VIEW VistaInventarioEscuela AS
SELECT i.id, i.nombre AS nombre_ingrediente, ie.cantidadDisponible
FROM InventarioEscuela ie
JOIN Ingrediente i ON i.id = ie.ingrediente_id;
 
 SELECT * FROM VistaInventarioEscuela


--2. Muestra el nombre del ingrediente en la tabla DetalleReceta para no batallar
 GO
CREATE VIEW VistaDetalleReceta AS
SELECT dr.id, r.id AS receta_id, r.procedimiento, i.id AS ingrediente_id, i.nombre AS nombre_ingrediente, dr.cantidad
FROM DetalleReceta dr
JOIN Recetas r ON dr.receta_id = r.id
JOIN Ingrediente i ON dr.ingrediente_id = i.id;

SELECT * FROM VistaDetalleReceta;
--------------------consultas--------------------------------------
--1 Obtener todos los padres que trabajan en un lugar específico:
SELECT * FROM Padres WHERE lugar_trabajo = 'COPPEL';

--2 Obtener los nombres de los niños y sus respectivas alergias:
SELECT Niños.nombre, Alergias.alergia
FROM Niños
INNER JOIN Niños_Alergias ON Niños.id = Niños_Alergias.niño_id
INNER JOIN Alergias ON Niños_Alergias.alergia_id = Alergias.id;

--3 Obtener los nombres de los alimentos junto con su cantidad de ingredientes:
SELECT Alimentos.nombre, COUNT(DetalleReceta.ingrediente_id) AS cantidad_ingredientes
FROM Alimentos
INNER JOIN Recetas ON Alimentos.id = Recetas.alimento_id
INNER JOIN DetalleReceta ON Recetas.id = DetalleReceta.receta_id
GROUP BY Alimentos.nombre;

--4 Obtener el total de calorías, carbohidratos, grasas y proteínas de todos los alimentos:
SELECT SUM(calorias) AS total_calorias, SUM(carbohidratos) AS total_carbohidratos, SUM(grasas) AS total_grasas, SUM(proteinas) AS total_proteinas
FROM Alimentos;

--5 Obtener el nombre del padre y la cantidad de pedidos realizados por cada uno:
SELECT Padres.nombre, COUNT(PedidosMenu.id) AS cantidad_pedidos
FROM Padres
INNER JOIN PedidosMenu ON Padres.id = PedidosMenu.padre_id
GROUP BY Padres.nombre;

--6 Obtener los nombres de los alimentos que contienen un ingrediente específico:
SELECT Alimentos.nombre
FROM Alimentos
INNER JOIN DetalleReceta ON Alimentos.id = DetalleReceta.alimento_id
INNER JOIN Ingrediente ON DetalleReceta.ingrediente_id = Ingrediente.id
WHERE Ingrediente.nombre = 'Ajo';

--7Obtener la cantidad disponible de un ingrediente en el inventario de la escuela:
SELECT cantidadDisponible
FROM InventarioEscuela
WHERE ingrediente_id = 5;

--8 Obtener los nombres de los alimentos que tienen un precio mayor a cierto valor:
SELECT nombre
FROM Alimentos
WHERE precio > 5;

--9 Obtener la fecha de compra y la fecha de caducidad de los ingredientes ordenados por la fecha de compra:
SELECT fechaCompra, caducidad
FROM Compras
ORDER BY fechaCompra;

--10 Obtener el nombre del padre y la suma de los precios de los alimentos en sus pedidos:
SELECT Padres.nombre, SUM(Alimentos.precio) AS suma_precios
FROM Padres
INNER JOIN PedidosMenu ON Padres.id = PedidosMenu.padre_id
INNER JOIN DetallePedido ON PedidosMenu.id = DetallePedido.pedido_id
INNER JOIN Alimentos ON DetallePedido.alimento_id = Alimentos.id
GROUP BY Padres.nombre;

--11 Obtener los nombres de los niños y la suma de las calorías de los alimentos en sus pedidos:
SELECT Niños.nombre, SUM(Alimentos.calorias) AS suma_calorias
FROM Niños
INNER JOIN PedidosMenu ON Niños.padre_id = PedidosMenu.padre_id
INNER JOIN DetallePedido ON PedidosMenu.id = DetallePedido.pedido_id
INNER JOIN Alimentos ON DetallePedido.alimento_id = Alimentos.id
GROUP BY Niños.nombre;

--12 Obtener los nombres de los niños y la cantidad de alergias que tienen:
SELECT Niños.nombre, COUNT(Niños_Alergias.alergia_id) AS cantidad_alergias
FROM Niños
LEFT JOIN Niños_Alergias ON Niños.id = Niños_Alergias.niño_id
GROUP BY Niños.nombre;

--13 Obtener el nombre del alimento y el total de pedidos realizados por cada uno:
SELECT Alimentos.nombre, COUNT(DetallePedido.pedido_id) AS total_pedidos
FROM Alimentos
INNER JOIN DetallePedido ON Alimentos.id = DetallePedido.alimento_id
GROUP BY Alimentos.nombre;

--14 Obtener el nombre del alimento y la cantidad de veces que aparece en las recetas:
SELECT Alimentos.nombre, COUNT(DetalleReceta.receta_id) AS cantidad_recetas
FROM Alimentos
INNER JOIN DetalleReceta ON Alimentos.id = DetalleReceta.alimento_id
GROUP BY Alimentos.nombre;

--15 Obtener el nombre del padre y el total de pagos realizados por cada uno:
SELECT Padres.nombre, SUM(pago_total) AS total_pagos
FROM Padres
INNER JOIN PedidosMenu ON Padres.id = PedidosMenu.padre_id
WHERE pagado = 1
GROUP BY Padres.nombre;



