-- Insercion en la tabla 'impuesto'
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (0, 'Impuesto 1', 0, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (1, 'Impuesto 2', 5, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (2, 'Impuesto 3', 10, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (3, 'Impuesto 4', 15, false);
INSERT INTO impuesto (id, nombre, porcentaje, eliminado) VALUES (4, 'Impuesto 5', 20, false);

-- -- Insercion en la tabla 'Estado' 
INSERT INTO estado (id, nombre, eliminado) VALUES (0, 'Iniciado', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (1, 'En proceso', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (2, 'Pendiente de cobro', false);
INSERT INTO estado (id, nombre, eliminado) VALUES (3, 'Finalizado', false);

-- Insercion en la tabla 'Marca'
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (0, 'Motorola', 0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (1, 'Toyota', 0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (2, 'Honda', 1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (3, 'Chevrolet', 2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (4, 'Ford', 3, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (5, 'Nissan', 4, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (6, 'Volkswagen', 0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (7, 'Hyundai', 1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (8, 'Mercedes-Benz', 2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (9, 'BMW', 3, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (10, 'Audi', 4, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (11, 'Mazda', 0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (12, 'Subaru', 1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (13, 'Kia', 2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (14, 'Volvo', 3, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (15, 'Jeep', 4, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (16, 'Porsche', 0, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (17, 'Lexus', 1, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (18, 'Acura', 2, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (19, 'Jaguar', 3, false);
INSERT INTO marca (id, nombre, impuesto, eliminado) VALUES (20, 'Land Rover', 4, false);


-- -- Insercion en la tabla 'Modelo'
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (0, 'Platita', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (1, 'Focus', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (2, 'Civic', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (3, 'Camry', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (4, 'Accord', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (5, 'Golf', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (6, 'Mazda3', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (7, 'Outback', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (8, 'Tiguan', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (9, 'F-150', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (10, 'Camaro', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (11, 'X5', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (12, 'CR-V', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (13, 'Sorento', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (14, 'S60', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (15, 'Cherokee', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (16, '911', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (17, 'RX', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (18, 'RDX', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (19, 'XF', random() * 20 , false);
INSERT INTO modelo (id, nombre, id_marca, eliminado) VALUES (20, 'Discovery', random() * 20 , false);


-- -- Insercion en la tabla 'cliente'
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (0, 'Mosca', 'Corrientes 2127', 'Cordoba', 'seba@gmail.com', 'Sebastian', '341413213', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (1, 'Lopez', 'San Martin 150', 'Cordoba', 'lopez@gmail.com', 'Juan', '3512345678', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (2, 'Gomez', 'Belgrano 432', 'Rosario', 'gomez@gmail.com', 'Maria', '3412345678', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (3, 'Rodriguez', '25 de Mayo 789', 'Buenos Aires', 'rodriguez@gmail.com', 'Carlos', '1145678901', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (4, 'Fernandez', 'Rivadavia 654', 'Mendoza', 'fernandez@gmail.com', 'Laura', '2613456789', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (5, 'Perez', 'Sarmiento 987', 'San Juan', 'perez@gmail.com', 'Pedro', '2645678901', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (6, 'Gutierrez', 'Urquiza 321', 'Salta', 'gutierrez@gmail.com', 'Ana', '3876543210', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (7, 'Diaz', '9 de Julio 234', 'Tucuman', 'diaz@gmail.com', 'Martin', '3812345678', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (8, 'Martinez', 'Independencia 876', 'La Plata', 'martinez@gmail.com', 'Silvia', '2213456789', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (9, 'Sanchez', 'San Juan 543', 'Santa Fe', 'sanchez@gmail.com', 'Javier', '3425678901', false);
INSERT INTO cliente (id, apellido, direccion, localidad, mail, nombre, telefono, eliminado) VALUES (10, 'Romero', 'Mitre 432', 'Mar del Plata', 'romero@gmail.com', 'Natalia', '2234567890', false);




-- -- Insercion en la tabla 'Vehiculo'
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (0, 'ABC123', random() * 20 , random() * 10, 2023, 20000, 'Observacion 0', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (1, 'DEF456', random() * 20 , random() * 10, 2021, 12000, 'Observacion 1', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (2, 'GHI789', random() * 20 , random() * 10, 2019, 8000, 'Observacion 2', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (3, 'JKL012', random() * 20 , random() * 10, 2020, 15000, 'Observacion 3', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (4, 'MNO345', random() * 20 , random() * 10, 2022, 9000, 'Observacion 4', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (5, 'PQR678', random() * 20 , random() * 10, 2018, 11000, 'Observacion 5', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (6, 'STU901', random() * 20 , random() * 10, 2023, 7000, 'Observacion 6', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (7, 'VWX234', random() * 20 , random() * 10, 2017, 13000, 'Observacion 7', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (8, 'YZA567', random() * 20 , random() * 10, 2021, 10000, 'Observacion 8', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (9, 'BCD89', random() * 20 , random() * 10, 2019, 12000, 'Observacion 9', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (10, 'EFG123', random() * 20 , random() * 10, 2020, 14000, 'Observacion 10', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (11, 'HIJ456', random() * 20 , random() * 10, 2018, 8000, 'Observacion 11', false);
INSERT INTO vehiculo (id, patente, id_modelo, id_cliente, anio, kilometros, observaciones, eliminado) VALUES (12, 'KLM789', random() * 20 , random() * 10, 2022, 11000, 'Observacion 12', false);


-- -- Insercion en la tabla 'tecnico'
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (0, 'Doffo', 'Sarmiento 123', '23141231', 'Marcelo', '3141343141', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (1, 'Garcia', 'Sarmiento 456', '28765432', 'Lucia', '3112345678', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (2, 'Lopez', 'Belgrano 789', '39876543', 'Eduardo', '3223456789', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (3, 'Martinez', 'San Martin 012', '45678901', 'Laura', '3334567890', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (4, 'Rodriguez', 'Mitre 345', '56789012', 'Carlos', '3445678901', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (5, 'Sanchez', 'Rivadavia 678', '67890123', 'Valeria', '3556789012', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (6, 'Fernandez', '9 de Julio 901', '78901234', 'Diego', '3667890123', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (7, 'Gomez', 'Independencia 234', '89012345', 'Sofia', '3778901234', false);
INSERT INTO tecnico (id, apellido, direccion, documento, nombre, telefono, eliminado) VALUES (8, 'Perez', 'Urquiza 567', '90123456', 'Javier', '3889012345', false);


-- -- Insercion en la tabla 'orden_trabajo'
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (0, '2023-11-11', '2023-11-15', random() * 12, random() * 8, random() * 3, 'Comentario 0', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (1, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 1', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (2, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 2', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (3, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 3', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (4, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 4', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (5, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 5', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (6, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 6', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (7, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 7', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (8, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 8', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (9, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 9', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (10, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 10', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (11, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 11', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (12, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 12', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (13, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 13', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (14, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 14', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (15, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 15', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (16, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 16', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (17, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 17', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (18, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 18', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (19, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 19', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (20, '2023-12-12', '2023-12-15', random() * 12, random() * 8, random() * 3, 'Comentario 20', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (21, '2023-12-16', '2023-12-18', random() * 12, random() * 8, random() * 3, 'Comentario 21', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (22, '2023-12-19', '2023-12-21', random() * 12, random() * 8, random() * 3, 'Comentario 22', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (23, '2023-12-22', '2023-12-24', random() * 12, random() * 8, random() * 3, 'Comentario 23', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (24, '2023-12-25', '2023-12-27', random() * 12, random() * 8, random() * 3, 'Comentario 24', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (25, '2023-12-28', '2023-12-30', random() * 12, random() * 8, random() * 3, 'Comentario 25', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (26, '2024-01-02', '2024-01-04', random() * 12, random() * 8, random() * 3, 'Comentario 26', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (27, '2024-01-05', '2024-01-07', random() * 12, random() * 8, random() * 3, 'Comentario 27', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (28, '2024-01-08', '2024-01-10', random() * 12, random() * 8, random() * 3, 'Comentario 28', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (29, '2024-01-11', '2024-01-13', random() * 12, random() * 8, random() * 3, 'Comentario 29', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (30, '2024-01-14', '2024-01-16', random() * 12, random() * 8, random() * 3, 'Comentario 30', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (31, '2024-01-17', '2024-01-19', random() * 12, random() * 8, random() * 3, 'Comentario 31', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (32, '2024-01-20', '2024-01-22', random() * 12, random() * 8, random() * 3, 'Comentario 32', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (33, '2024-01-23', '2024-01-25', random() * 12, random() * 8, random() * 3, 'Comentario 33', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (34, '2024-01-26', '2024-01-28', random() * 12, random() * 8, random() * 3, 'Comentario 34', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (35, '2024-01-29', '2024-01-31', random() * 12, random() * 8, random() * 3, 'Comentario 35', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (36, '2024-02-01', '2024-02-03', random() * 12, random() * 8, random() * 3, 'Comentario 36', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (37, '2024-02-04', '2024-02-06', random() * 12, random() * 8, random() * 3, 'Comentario 37', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (38, '2024-02-07', '2024-02-09', random() * 12, random() * 8, random() * 3, 'Comentario 38', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (39, '2024-02-10', '2024-02-12', random() * 12, random() * 8, random() * 3, 'Comentario 39', 0, random() * 10, false);
INSERT INTO orden_trabajo (id, fecha_inicio, fecha_fin, id_vehiculo, id_tecnico, estado, comentario, totalcosto, id_cliente, eliminado) VALUES (40, '2024-02-13', '2024-02-15', random() * 12, random() * 8, random() * 3, 'Comentario 40', 0, random() * 10, false);


-- -- Insercion en la tabla 'servicio'
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (0, 'Pintado', 100000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (1, 'Secado', 30000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (2, 'Alineacion y balanceo', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (3, 'Cambio de frenos', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (4, 'Cambio de bujias', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (5, 'Rotacion de neumaticos', 4000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (6, 'Cambio de filtro de aire', 3000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (7, 'Revision de suspension', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (8, 'Cambio de correa de distribucion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (9, 'Recarga de aire acondicionado', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (10, 'Cambio de bateria', 9000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (11, 'Diagnostico de motor', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (12, 'Cambio de amortiguadores', 11000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (13, 'Cambio de filtro de aceite', 2500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (14, 'Cambio de liquido de frenos', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (15, 'Cambio de bujias de encendido', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (16, 'Reparacion de escape', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (17, 'Cambio de termostato', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (18, 'Reparacion de sistema de direccion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (19, 'Cambio de bomba de agua', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (20, 'Diagnostico de transmision', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (21, 'Cambio de filtro de combustible', 3500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (22, 'Cambio de sensor de oxigeno', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (23, 'Cambio de aceite', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (24, 'Alineacion y balanceo', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (25, 'Cambio de frenos', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (26, 'Cambio de bujias', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (27, 'Rotacion de neumaticos', 4000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (28, 'Cambio de filtro de aire', 3000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (29, 'Revision de suspension', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (30, 'Cambio de correa de distribucion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (31, 'Recarga de aire acondicionado', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (32, 'Cambio de bateria', 9000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (33, 'Diagnostico de motor', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (34, 'Cambio de amortiguadores', 11000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (35, 'Cambio de filtro de aceite', 2500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (36, 'Cambio de liquido de frenos', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (37, 'Cambio de bujias de encendido', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (38, 'Reparacion de escape', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (39, 'Cambio de termostato', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (40, 'Reparacion de sistema de direccion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (41, 'Cambio de bomba de agua', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (42, 'Diagnostico de transmision', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (43, 'Cambio de filtro de combustible', 3500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (44, 'Cambio de aceite', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (45, 'Alineacion y balanceo', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (46, 'Cambio de frenos', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (47, 'Cambio de bujias', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (48, 'Rotacion de neumaticos', 4000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (49, 'Cambio de filtro de aire', 3000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (50, 'Revision de suspension', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (51, 'Cambio de correa de distribucion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (52, 'Recarga de aire acondicionado', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (53, 'Cambio de bateria', 9000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (54, 'Diagnostico de motor', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (55, 'Cambio de amortiguadores', 11000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (56, 'Cambio de filtro de aceite', 2500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (57, 'Cambio de liquido de frenos', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (58, 'Cambio de bujias de encendido', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (59, 'Reparacion de escape', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (60, 'Cambio de termostato', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (61, 'Reparacion de sistema de direccion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (62, 'Cambio de bomba de agua', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (63, 'Diagnostico de transmision', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (64, 'Cambio de filtro de combustible', 3500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (65, 'Cambio de aceite', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (66, 'Alineacion y balanceo', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (67, 'Cambio de frenos', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (68, 'Cambio de bujias', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (69, 'Rotacion de neumaticos', 4000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (70, 'Cambio de filtro de aire', 3000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (71, 'Revision de suspension', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (72, 'Cambio de correa de distribucion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (73, 'Recarga de aire acondicionado', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (74, 'Cambio de bateria', 9000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (75, 'Diagnostico de motor', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (76, 'Cambio de amortiguadores', 11000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (77, 'Cambio de filtro de aceite', 2500, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (78, 'Cambio de liquido de frenos', 7000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (79, 'Cambio de bujias de encendido', 5000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (80, 'Reparacion de escape', 8000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (81, 'Cambio de termostato', 6000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (82, 'Reparacion de sistema de direccion', 10000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (83, 'Cambio de bomba de agua', 12000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (84, 'Diagnostico de transmision', 15000, false, random() * 40 );
INSERT INTO servicio (id, tipo_servicio, precio, eliminado, id_orden) VALUES (85, 'Cambio de filtro de combustible', 3500, false, random() * 40 );

