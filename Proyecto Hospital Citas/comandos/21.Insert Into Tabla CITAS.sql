USE Hospital;

INSERT INTO Citas(id_Cita,id_Cliente,id_Medico,id_Enfermero,Sala_Consultorio,Fecha,id_Medicamento,Precio)
 VALUE ('CITA1','C4','MED10','ENF7',165,CURRENT_TIMESTAMP,'MEDICA09',680);

INSERT INTO Citas(id_Cita,id_Cliente,id_Medico,id_Enfermero,Sala_Consultorio,Fecha,id_Medicamento,Precio)
 VALUE ('CITA2','C1','MED4','ENF2',140,CURRENT_TIMESTAMP,'MEDICA07',150);
 
 INSERT INTO Citas(id_Cita,id_Cliente,id_Medico,id_Enfermero,Sala_Consultorio,Fecha,id_Medicamento,Precio)
 VALUE ('CITA3','C1','MED9','ENF1',122,CURRENT_TIMESTAMP,'MEDICA01',280);

INSERT INTO Citas(id_Cita,id_Cliente,id_Medico,id_Enfermero,Sala_Consultorio,Fecha,id_Medicamento,Precio)
 VALUE ('CITA4','C2','MED6','ENF6',100,CURRENT_TIMESTAMP,'MEDICA07',150),
 ('CITA5','C2','MED1','ENF3',102,CURRENT_TIMESTAMP,'MEDICA09',300),
 ('CITA6','C3','MED8','ENF5',148,CURRENT_TIMESTAMP,'MEDICA05',500);
 
 SELECT * FROM citas
 