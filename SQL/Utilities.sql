CREATE DATABASE colegio_arquitectos_valenciarolrol;
USE colegio_arquitectos_valencia;

DROP TABLE token;
DROP TABLE rol_permiso;
DROP TABLE usuario_permiso;
DROP TABLE permiso;
DROP TABLE evento;
DROP TABLE usuario;
DROP TABLE rol;

USE colegio_arquitectos_valencia;
INSERT IGNORE INTO Permisos VALUES (1,"LEER_EDIFICIOS");
INSERT IGNORE INTO Permisos VALUES (2,"CREAR_EDIFICIOS");
INSERT IGNORE INTO Permisos VALUES (3,"ELIMINAR_EDIFICIOS");

INSERT IGNORE INTO Roles VALUES (1,"ADMINISTRADOR");
INSERT IGNORE INTO Roles VALUES (2,"USUARIO");

INSERT IGNORE INTO rol_permiso VALUES (1,1);
INSERT IGNORE INTO rol_permiso VALUES (1,2);
INSERT IGNORE INTO rol_permiso VALUES (1,3);
INSERT IGNORE INTO rol_permiso VALUES (2,1);

INSERT IGNORE INTO Usuarios VALUES (1,"admin", "1234", 1);
INSERT IGNORE INTO Usuarios VALUES (2,"user", "1234", 2);

