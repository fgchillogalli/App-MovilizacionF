CREATE TABLE IF NOT EXISTS conductor (
    idconductor SERIAL,
    nombre VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(100) NOT NULL,
    phone VARCHAR(14) NOT NULL,
    PRIMARY KEY (idconductor)

);

CREATE TABLE IF NOT EXISTS usuarios (
    idusuario SERIAL,
    nombre VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(100) NOT NULL,
    email VARCHAR (50) NOT NULL ,
    phone VARCHAR (14) NOT NULL,
    PRIMARY KEY (idusuario)
);

CREATE TABLE IF NOT EXISTS vehiculo (
    idvehiculo SERIAL,
    conductor_id INT NOT NULL UNIQUE,
    placa VARCHAR(8) NOT NULL,
    PRIMARY KEY (idvehiculo),
    FOREIGN KEY (conductor_id) REFERENCES conductor (idconductor)
);


