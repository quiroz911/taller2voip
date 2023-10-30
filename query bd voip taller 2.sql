-- Crear tabla de usuario

CREATE TABLE usuario (

  id INT PRIMARY KEY,

  nombre VARCHAR(50),

  apellido VARCHAR(50),

  email VARCHAR(100),

  direccion VARCHAR(100)

);

 

-- Crear tabla de cuenta bancaria

CREATE TABLE cuenta_bancaria (

  id INT PRIMARY KEY,

  id_usuario INT,

  tipo VARCHAR(20),

  saldo DECIMAL(10,2),

  FOREIGN KEY (id_usuario) REFERENCES usuario(id)

);

 

-- Crear tabla de transacciones bancarias

CREATE TABLE transacciones_bancarias (

  id INT PRIMARY KEY,

  id_cuenta_origen INT,

  id_cuenta_destino INT,

  monto DECIMAL(10,2),

  fecha TIMESTAMP,

  FOREIGN KEY (id_cuenta_origen) REFERENCES cuenta_bancaria(id),

  FOREIGN KEY (id_cuenta_destino) REFERENCES cuenta_bancaria(id)

);


INSERT INTO usuario (id, nombre, apellido, email, direccion) VALUES
(1, 'Juan', 'Pérez', 'juan@email.com', 'Calle 123, Ciudad X'),
(2, 'Ana', 'Gómez', 'ana@email.com', 'Avenida ABC, Ciudad Y'),
(3, 'Carlos', 'Martínez', 'carlos@email.com', 'Calle 456, Ciudad Z'),
(4, 'Laura', 'Sánchez', 'laura@email.com', 'Calle 789, Ciudad W'),
(5, 'Pedro', 'López', 'pedro@email.com', 'Avenida XYZ, Ciudad V');


INSERT INTO cuenta_bancaria (id, id_usuario, tipo, saldo) VALUES
(1, 1, 'Corriente', 1000.00),
(2, 2, 'Ahorro', 2500.50),
(3, 3, 'Corriente', 1500.25),
(4, 4, 'Ahorro', 3000.75),
(5, 5, 'Corriente', 200.00);



-- Supongamos que las siguientes transacciones son entre las cuentas 1 y 2
INSERT INTO transacciones_bancarias (id, id_cuenta_origen, id_cuenta_destino, monto, fecha) VALUES
(1, 1, 2, 500.00, '2023-10-28 09:30:00'),
(2, 2, 1, 300.00, '2023-10-28 10:15:00'),
(3, 1, 2, 200.00, '2023-10-28 11:45:00'),
(4, 2, 1, 100.50, '2023-10-28 12:20:00'),
(5, 1, 2, 350.00, '2023-10-28 14:00:00');
