DROP DATABASE if EXISTS dailyApp;

CREATE DATABASE dailyStandApp;

CREATE TABLE usuarios(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50),
apellidos VARCHAR(50),
rut VARCHAR(50),
fechaDeNac DATE,
edad INT,
correo VARCHAR(50),
constraseña PASSWORD(20)
);

CREATE TABLE grupo(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombres VARCHAR(50),
observaciones VARCHAR(500)
);

CREATE TABLE daily(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
fecha DATE,
grupo_id int NOT NULL,
notas varchar(200),
FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE grupos_usuarios (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	grupo_id INT NOT NULL,
	usuario_id INT NOT NULL,
	FOREIGN KEY (grupo_id) REFERENCES grupos(id),
	FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)DEFAULT CHARSET=UTF8;

CREATE TABLE daily_usuarios(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    daily_id int NOT NULL,
    usuario_id int NOT NULL,
    mensajeAyer varchar(200),
    mensajeHoy varchar(200),
    mensajeObstaculo varchar(200),
    FOREIGN KEY (daily_id) REFERENCES daily(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);