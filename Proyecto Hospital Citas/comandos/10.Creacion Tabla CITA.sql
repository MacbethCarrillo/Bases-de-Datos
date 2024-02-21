USE Hospital;

CREATE TABLE Citas (
id_Cita varchar (10) NOT NULL,
id_Cliente varchar (10) NOT NULL,
id_Medico varchar (10) NOT NULL,
id_Enfermero varchar (10) NOT NULL,
Sala_Consultorio int NOT NULL,
Fecha datetime NOT NULL,
id_Medicamento varchar(10) NOT NULL,
Precio int NOT NULL,
Primary key (id_Cita)
);