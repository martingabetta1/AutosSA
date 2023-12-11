-- Inserción en la tabla 'impuesto'
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (0, 'Impuesto 1', 0, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (1, 'Impuesto 2', 7, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (2, 'Impuesto 3', 15, false);

-- Inserción en la tabla 'Estado' 
INSERT INTO estado (id, nombre, eliminado) VALUES (0, 'Iniciado', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (1, 'Pendiente', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (2, 'En revisión', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (3, 'Finalizado', false);

-- Inserción en la tabla 'Marca'
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (0, 'Fiat',0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (1, 'Audi',1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (2, 'Chevrolet',2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (3, 'Volkswagen',1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (4, 'Ford',0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (5, 'Citröen',1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (6, 'Toyota',1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (7, 'Peugeot',2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (8, 'Nissan',2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (9, 'Honda',0, false);

-- Inserción en la tabla 'Modelo'
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (0, 'Corsa', 2, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (1, 'Ecosport',4, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (2, 'Cronos',0, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (3, 'Etios',6, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (4, 'Civic',9, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (5, 'Peugeot',7, false);

-- Inserción en la tabla 'cliente'
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (0, 'Mosca', 'Corrientes 2127', 'Villa Maria', 'seba@gmail.com', 'Sebastian', '3532439218', false);

INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (1, 'Zegatti', 'Juarez 333', 'Bell Ville', 'tomi@gmail.com', 'Tomas', '3413124123', false);

INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (2, 'Gabetta', 'Lopes 123', 'Villa Nueva', 'martin@gmail.com', 'Martin', '312314412', false);

INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (3, 'Pedro', 'Pérez','Street 123',46546,'pedro@gmail.com','Rosario',false);

INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (4, 'Juan', 'López','Street 123',111111,'juanlopez@gmail.com','Buenos Aires',false);

-- Inserción en la tabla 'tecnico'
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (0, 'Doffo', 'Gomez 123', '30432312', 'Marcelo', '3143412424', false);

INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (1, 'Achetta', 'Hipolito Yrigoyen 321', '42312312', 'Mauricio', '3221312314', false);

INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (2, 'Simonin', 'Yugusman 999', '41331231', 'Eloy', '321312634', false);