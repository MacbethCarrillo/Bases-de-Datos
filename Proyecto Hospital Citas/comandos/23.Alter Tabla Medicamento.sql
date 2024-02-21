USE Hospital;

ALTER table medicamento
add CantidadMedicamento int;

ALTER TABLE Medicamento 
drop column CantidadMedicamento;

select*FROM Medicamento