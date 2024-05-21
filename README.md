# clientes_spring_rest
La construcción del proyecto está basado en la arquitectura N-Capas 


## Script de la ddbb

create database db_clientes_springboot;

CREATE TABLE `db_clientes_springboot`.`clientes` (

   `id_cliente` INT ZEROFILL NOT NULL AUTO_INCREMENT,  
   `nombre` VARCHAR(45) NOT NULL,  
   `apellido` VARCHAR(45) NOT NULL,  
   `correo` VARCHAR(45) NOT NULL,  
   `fecha_registro` date  NOT NULL,  
   PRIMARY KEY (`id_cliente`));
  
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Joel', 'Jurado', 'juradoec@yahoo.com', '2023-08-01');   
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Carlos', 'Miranda', 'mirandaTr98@gmail.com', '2023-08-02');   
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Marcela', 'Sanchez', 'schMarce@itb.com', '2023-08-03');   
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');   

El proyecto permite el registro de clientes a una db mysql usando el framework springboot,
la finalidad del proyecto esta en aplicar buenas prácticas sobre el framework,
inclye documentación mediante swagger (ya que se uso java 11), sin embargo, se puede modificar para ser documentado con: springdoc, si se usa java 17 o superior.

