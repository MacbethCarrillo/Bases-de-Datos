CREATE DATABASE escuela_de_gastronomia
--Carrillo Ibarra Macbeth Adolfo

GO
on primary
(NAME = EscuelaGastronomia_Data,
 FILENAME = 'C:\Data\EscuelaGastronomia.mdf',
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB),
FILEGROUP Grupo1
(NAME = Grupo1,
 FILENAME = 'D:\Data\Grupo1.ndf', 
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB),
 FILEGROUP Grupo2
(NAME = Grupo2,
 FILENAME = 'D:\Data\Grupo2.ndf', 
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB),
 FILEGROUP Grupo3
(NAME = Grupo3,
 FILENAME = 'D:\Data\Grupo3.ndf', 
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB),
 FILEGROUP Grupo4
(NAME = Grupo4,
 FILENAME = 'D:\Data\Grupo4.ndf', 
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB)
 LOG ON
(NAME = EscuelaGastronomia_Log,
 FILENAME = 'E:\Data\EscuelaGastronomia_Log.ldf', 
 SIZE = 50MB,
 MAXSIZE = UNLIMITED,
 FILEGROWTH = 5MB);
 
GO
CREATE TABLE Docente
 (
 Cedula_Docente INT IDENTITY (1,1) PRIMARY KEY,
 Nombre VARCHAR(25) NOT NULL,
 Apellidos VARCHAR(50) NOT NULL,
 Telefonos TINYINT,
 Direccion VARCHAR(100),
 FOREIGN KEY (Cedula_Docente) REFERENCES Titulo(Codigo_Titulo),
 FOREIGN KEY (Cedula_Docente) REFERENCES Clase(Codigo_Clase),
 FOREIGN KEY (Cedula_Docente) REFERENCES Curso(Codigo_Curso),
 FOREIGN KEY (Cedula_Docente) REFERENCES Evaluacion(Codigo_Evaluacion)

 ) ON EsquemaParticionPorValor(Cedula_Docente)
CREATE TABLE ALUMNO
 (
 Cedula_Alumno INT IDENTITY (1,1) PRIMARY KEY,
 Nombre VARCHAR(25) NOT NULL,
 Apellidos VARCHAR(50) NOT NULL,
 Telefonos TINYINT,
 Direccion VARCHAR(100),
 FOREIGN KEY (Cedula_Alumno) REFERENCES Curso(Codigo_Curso),
 FOREIGN KEY (Cedula_Alumno) REFERENCES Clase(Codigo_Clase),
 FOREIGN KEY (Cedula_Alumno) REFERENCES Evaluacion(Codigo_Evaluacion)
)
CREATE TABLE Titulo
 (
 Codigo_Titulo INT IDENTITY (1,1) PRIMARY KEY,
 Año DATE NOT NULL,
 Instituto VARCHAR(50),
 Pais VARCHAR(25),
 FOREIGN KEY (Codigo_Titulo) REFERENCES Docente(Cedula_Docente)
 )
CREATE TABLE Curso
 (
 Codigo_Curso INT IDENTITY (1,1) PRIMARY KEY,
 Nombre VARCHAR(20),
 Duracion TINYINT,
 Costo FLOAT,
 FOREIGN KEY (Codigo_Curso) REFERENCES Docente(Cedula_Docente),
 FOREIGN KEY (Codigo_Curso) REFERENCES Alumno(Cedula_Alumno),
 FOREIGN KEY (Codigo_Curso) REFERENCES Programa(Cedula_Programa),
 FOREIGN KEY (Codigo_Curso) REFERENCES Clase(Cedula_Clase)
 )
CREATE TABLE Evaluacion
 (
 Codigo_Evaluacion INT IDENTITY (1,1) PRIMARY KEY,
 Nota FLOAT NOT NULL,
 Comentarios VARCHAR(100),
 FOREIGN KEY (Codigo_Evaluacion) REFERENCES Docente(Cedula_Docente),
 FOREIGN KEY (Codigo_Evaluacion) REFERENCES Alumno(Cedula_Alumno),
 FOREIGN KEY (Codigo_Evaluacion) REFERENCES Clase(Codigo_Clase)
 )
CREATE TABLE Clase
 (
 Codigo_Clase INT IDENTITY (1,1) PRIMARY KEY,
 Nombre VARCHAR(50),
 Fecha DATE,
 Hora TIME,
 FOREIGN KEY (Codigo_Clase) REFERENCES Docente(Cedula_Docente),
 FOREIGN KEY (Codigo_Clase) REFERENCES Alumno(Cedula_Alumno),
 FOREIGN KEY (Codigo_Clase) REFERENCES Curso(Codigo_Curso),
 FOREIGN KEY (Codigo_Clase) REFERENCES Evaluacion(Codigo_Evaluacion)
 )
CREATE TABLE Programa
 (
 Codigo_Programa INT IDENTITY (1,1) PRIMARY KEY,
 Descripcion VARCHAR(200),
 FOREIGN KEY (Codigo_Programa) REFERENCES Curso(Codigo_Curso),
 FOREIGN KEY (Codigo_Programa) REFERENCES Tema(Codigo_Tema)
 )
CREATE TABLE Tema
 (
 Codigo_Tema INT IDENTITY (1,1) PRIMARY KEY,
 Nombre VARCHAR(25),
 Subtema VARCHAR(50),
 FOREIGN KEY (Codigo_Tema) REFERENCES Programa(Codigo_Programa)
 )
 USE escuela_de_gastronomia;
GO

-- Crear función de partición
CREATE PARTITION FUNCTION ParticionPorValor (INT)
AS RANGE RIGHT FOR VALUES (500 ,750, 1000);

-- Crear esquema de partición en la tabla Docente
CREATE PARTITION SCHEME EsquemaParticionPorValor
AS PARTITION ParticionPorValor
TO (Grupo1, Grupo2, Grupo3, Grupo4);


