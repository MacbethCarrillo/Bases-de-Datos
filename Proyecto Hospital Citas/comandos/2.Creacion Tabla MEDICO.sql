USE Hospital;

CREATE TABLE Medicos (
id_Medicos varchar(10) NOT NULL,
Nombre varchar(64) NOT NULL,
Apellidos varchar(64) NOT NULL,
Sexo varchar(1) NOT NULL,
Edad int NOT NULL,
Especialidad varchar(100) NOT NULL,
Turno varchar(16) NOT NULL,
Sueldo int NOT NULL,
primary key (id_Medicos)
);