DROP DATABASE IF EXISTS libros;
Go

CREATE DATABASE libros;
GO

USE libros;

CREATE TABLE Autores
(
   IDAutor int NOT NULL IDENTITY PRIMARY KEY,
   NombrePila varchar(30) NOT NULL,
   ApellidoPaterno varchar(30) NOT NULL
)                 ;

CREATE TABLE Titulos
(
   ISBN varchar(20) NOT NULL PRIMARY KEY,
   Titulo varchar(100) NOT NULL,
   NumeroEdicion int NOT NULL,
   Copyright varchar(4) NOT NULL
)             ;

CREATE TABLE ISBNAutor
(
   IDAutor int NOT NULL,
   ISBN varchar(20) NOT NULL,
   FOREIGN KEY (IDAutor) REFERENCES Autores(IDAutor),
   FOREIGN KEY (ISBN) References Titulos(ISBN)
)            ;

INSERT INTO Autores (NombrePila,ApellidoPaterno) VALUES ('Harvey','Deitel')           ;
INSERT INTO Autores (NombrePila,ApellidoPaterno) VALUES ('Paul','Deitel')     ;
INSERT INTO Autores (NombrePila,ApellidoPaterno) VALUES ('Andrew','Goldberg')    ;
INSERT INTO Autores (NombrePila,ApellidoPaterno) VALUES ('David','Choffnes')     ;


INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0131869000','Visual Basic 2005 How to Program',3,'2006')          ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0131869000')     ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0131869000') ;
INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0131525239','Visual C# 2005 How to Program',2,'2006')  ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0131525239')      ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0131525239')      ;

INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0132222205','Java How to Program',7,'2007')   ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0132222205')                                               ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0132222205')                                       ;

INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0131857576','C++ How to Program',5,'2005')     ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0131857576')                                                  ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0131857576')                                                 ;

INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0132404168','C How to Program',5,'2007')     ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0132404168')                                             ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0132404168')                                       ;

INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0131450913','Internet & World Wide Web How to Program',3,'2004')    ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0131450913')                                                                 ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0131450913')                                            ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (3,'0131450913')                                   ;

INSERT INTO Titulos (ISBN,Titulo,NumeroEdicion,Copyright) VALUES ('0131828274','Operating Systems',3,'2004')        ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (1,'0131828274')                                                    ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (2,'0131828274')                                                    ;
INSERT INTO ISBNAutor (IDAutor,ISBN) VALUES (4,'0131828274')                                                    ;
