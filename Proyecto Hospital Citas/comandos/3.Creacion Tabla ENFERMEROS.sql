USE Hospital;

CREATE TABLE Enfermeros (
id_Enfermeros varchar(10) NOT NULL,
Nombre varchar(64) NOT NULL,
Apellido varchar(64) NOT NULL,
Sexo varchar(1) NOT NULL,
Edad int NOT NULL,
Turno varchar(10) NOT NULL,
Sueldo varchar(10) NOT NULL,
primary key (id_Enfermeros)
);
