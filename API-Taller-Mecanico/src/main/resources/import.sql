-- Inserción en la tabla 'impuesto'
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (0, 'Impuesto 1', 0, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (1, 'Impuesto 2', 7, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (2, 'Impuesto 3', 15, false);

-- Inserción en la tabla 'estado'
INSERT INTO estado (id, nombre, eliminado) VALUES (0, 'Pendiente', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (1, 'Terminada', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (2, 'Pendiente de cobro', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (3, 'Finalizado', false);

-- Inserción en la tabla 'marca'
INSERT INTO marca (id, nombre,impuesto, eliminado) VALUES (0, 'Renault',0, false);
INSERT INTO marca (id, nombre,impuesto, eliminado) VALUES (1, 'Fiat',1, false);
INSERT INTO marca (id, nombre,impuesto, eliminado) VALUES (2, 'Ford',2, false);

-- Inserción en la tabla 'modelo'
INSERT INTO modelo (id, id_marca, nombre, eliminado) VALUES (0, 0, 'Clio', false);
INSERT INTO modelo (id, id_marca, nombre, eliminado) VALUES (1, 1, 'Cronos', false);
INSERT INTO modelo (id, id_marca, nombre, eliminado) VALUES (2, 2, 'Fiesta', false);

-- Inserción en la tabla 'cliente'
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) 
VALUES (0, 'Mosca', 'Corrientes 2127', 'Villa Maria', 'seba@gmail.com', 'Sebastian', '3532439218', false);

INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) 
VALUES (1, 'Zegatti', 'Juarez 333', 'Bell Ville', 'tomi@gmail.com', 'Tomas', '3413124123', false);

INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) 
VALUES (2, 'Gabetta', 'Lopes 123', 'Villa Nueva', 'martin@gmail.com', 'Martin', '312314412', false);

-- Inserción en la tabla 'tecnico'
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) 
VALUES (0, 'Doffo', 'Gomez 123', '30432312', 'Marcelo', '3143412424', false);

INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) 
VALUES (1, 'Achetta', 'Hipolito Yrigoyen 321', '42312312', 'Mauricio', '3221312314', false);

INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) 
VALUES (2, 'Simonin', 'Yugusman 999', '41331231', 'Eloy', '321312634', false);


