INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (0, 'Impuesto 1', 0, false );
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (1, 'Impuesto 2', 15, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (2, 'Impuesto 3', 100000, false );

INSERT INTO estado (id, nombre, eliminado) VALUES (0, 'Iniciado', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (1, 'Pendiente', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (2, 'En revisión', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (3, 'Finalizado', false);

INSERT INTO marca (id, nombre, eliminado) VALUES (0, 'Fiat', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (1, 'Audi', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (2, 'Chevrolet', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (3, 'Volkswagen', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (4, 'Ford', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (5, 'Citröen', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (6, 'Toyota', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (7, 'Peugeot', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (8, 'Nissan', false);
INSERT INTO marca (id, nombre, eliminado) VALUES (9, 'Honda', false);

INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (0, 'Corsa', 2, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (1, 'Ecosport',4, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (2, 'Cronos',0, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (3, 'Etios',6, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (4, 'Civic',9, false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (5, 'Peugeot',7, false);

INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (0, 'Martin', 'Gabetta','Calle 111',12345,'a@a.com','Villa Nueva',false);
INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (1, 'Tomás', 'Zegatti','Calle 123',987465,'b@b.com','Bell Ville',false);
INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (2, 'Mauricio', 'Achetta','Calle 654',7777,'c@gmail.com','Villa María',false);
INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (3, 'Esteban', 'Rey','Street 123',46546,'stephen@k.com','Portland',false);
INSERT INTO cliente (id, nombre, apellido, direccion, telefono, mail, localidad, eliminado) VALUES (4, 'Juan', 'López','Street 123',111111,'juanlopez@gmail.com','Buenos Aires',false);
