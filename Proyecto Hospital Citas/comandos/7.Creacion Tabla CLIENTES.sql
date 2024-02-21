USE Hospital;

CREATE TABLE Clientes(
id_Cliente varchar(10) NOT NULL,
Nombre varchar(64) NOT NULL,
Apellido varchar(64) NOT NULL,
Sexo varchar(1) NOT NULL,
Edad int NOT NULL,
Peso varchar(5) NOT NULL,
Altura varchar(5) NOT NULL,
Telefono varchar(10) NOT NULL,
primary key(id_Cliente)
);