USE Hospital;

CREATE TABLE EmpleadosFarmacia (
id_EmpleadosFarmacia varchar(10) NOT NULL,
Nombre varchar(64) NOT NULL,
Apellido varchar(64) NOT NULL,
Sexo varchar(1) NOT NULL,
Edad int NOT NULL,
Turno varchar(16) NOT NULL,
Sueldo int NOT NULL,
TituloUniversitario varchar(2) NOT NULL,
primary key (id_EmpleadosFarmacia)
);