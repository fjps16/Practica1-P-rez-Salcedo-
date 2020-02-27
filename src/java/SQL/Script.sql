mysql -u root -p

password: mysqladmin

show databases;

CREATE TABABASE Platillos;

use Platillos;

CREATE TABLE platos(id_platos int,nombre varchar(30),precio numeric,categoria varchar(30));

INSERT INTO platos VALUES (1,"Papa Rellena", 25, "Entrada");
INSERT INTO platos VALUES (2,"Tallarines Rojos", 15, "Almuerzo");
INSERT INTO platos VALUES (3,"Ají Gallina", 10, "Almuerzo");
INSERT INTO platos VALUES (4,"Tacu Tacu", 30, "Almuerzo");
INSERT INTO platos VALUES (5,"Arroz con Pato", 20, "Almuerzo");
INSERT INTO platos VALUES (6,"Ceviche", 15, "Entrada");
INSERT INTO platos VALUES (7,"Pan con Torreja", 2, "Entrada");
INSERT INTO platos VALUES (8,"Ensaladas", 5, "Entrada");
INSERT INTO platos VALUES (9,"Locro", 10, "Almuerzo");
INSERT INTO platos VALUES (10,"Arroz Chaufa", 7, "Almuerzo");


SELECT * FROM platos;
