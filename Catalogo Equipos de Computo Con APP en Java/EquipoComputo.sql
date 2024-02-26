DROP DATABASE IF EXISTS Evaluacion;
Go

CREATE DATABASE Evaluacion;
GO

USE Evaluacion;

CREATE TABLE Equipos
(
	IDClave INT NOT NULL IDENTITY,
	TipoComputadora VARCHAR (15) NOT NULL,
	Marca VARCHAR (30) NOT NULL,
	Modelo VARCHAR (30) NOT NULL,
	Procesador VARCHAR (15) NOT NULL,
	Memoria VARCHAR (15) NOT NULL,
	Almacenamiento VARCHAR (15) NOT NULL
);

INSERT INTO Equipos (TipoComputadora,Marca,Modelo,Procesador,Memoria,Almacenamiento)
	VALUES ('Servidor','DELL','Poweredge T140','Intel Xeon','16 GB','4 TB'),
	('Escritorio','HP','EliteDesk','Core i7','16 GB','2 TB'),
	('Laptop','Acer','Aspire 5', 'Core i5','8 GB', '1 TB');