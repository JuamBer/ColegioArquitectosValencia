CREATE DATABASE colegio_arquitectos_valencia;
USE colegio_arquitectos_valencia;



/* MAESTRAS */  
CREATE TABLE PeriodosArquitectonicos (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto VARCHAR(255)
) ENGINE=innodb;

CREATE TABLE Tipologias (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto VARCHAR(255)
) ENGINE=innodb;

CREATE TABLE TiposItenerarios (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto VARCHAR(255)
) ENGINE=innodb;
 
CREATE TABLE EstilosArquitectonicos (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto VARCHAR(255)
) ENGINE=innodb;

CREATE TABLE IndicadoresVisuales (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto VARCHAR(255)
) ENGINE=innodb;

CREATE TABLE Autores (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL
) ENGINE=innodb;



/* PRINCIPALES */  
CREATE TABLE Edificios (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  id_periodo INT,
  anyo DATE,
  id_tipologia INT,
  descripcion TEXT NOT NULL,
  web VARCHAR(255),
  direccion VARCHAR(255) NOT NULL,
  geo_referencia VARCHAR(255),
  otros TEXT,
  
  FOREIGN KEY(id_periodo) REFERENCES PeriodosArquitectonicos(id),
  FOREIGN KEY(id_tipologia) REFERENCES Tipologias(id)
  /* MANY TO MANY: Autores, Estilos, Indicadores Visuales, Itinerarios */  
) ENGINE=innodb;

CREATE TABLE Itinerarios (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  id_tipo_itinerario INT NOT NULL,
  descripcion VARCHAR(255),
  
  FOREIGN KEY(id_tipo_itinerario) REFERENCES TiposItenerarios(id)

  /* MANY TO MANY: Edificios */  
) ENGINE=innodb;

CREATE TABLE Eventos (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  fecha DATE NOT NULL,
  descripcion TEXT,
  web VARCHAR(255)
) ENGINE=innodb;

CREATE TABLE Obras (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descripcion TEXT NOT NULL,
  id_edificio INT,
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id)
) ENGINE=innodb;

CREATE TABLE Fotos (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_edificio INT,
  id_itinerario INT,
  id_evento INT,
  foto_url TEXT NOT NULL,
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id),
  FOREIGN KEY(id_itinerario) REFERENCES Itinerarios(id),
  FOREIGN KEY(id_evento) REFERENCES Eventos(id)
  /* foto BLOB */  
) ENGINE=innodb;



/* MANY TO MANY */  
CREATE TABLE EdificiosAutores (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_edificio INT,
  id_autor INT,
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id),
  FOREIGN KEY(id_autor) REFERENCES Autores(id)
) ENGINE=innodb;

CREATE TABLE EdificiosEstilos (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_edificio INT,
  id_estilo INT,
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id),
  FOREIGN KEY(id_estilo) REFERENCES EstilosArquitectonicos(id)
) ENGINE=innodb;

CREATE TABLE EdificiosIndicadoresVisuales (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_edificio INT,
  id_indicador_visual INT,
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id),
  FOREIGN KEY(id_indicador_visual) REFERENCES IndicadoresVisuales(id)
) ENGINE=innodb;

CREATE TABLE EdificiosItinerarios (
  id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_edificio INT,
  id_itinerario INT,
  ruta VARCHAR(255),
  
  FOREIGN KEY(id_edificio) REFERENCES Edificios(id),
  FOREIGN KEY(id_itinerario) REFERENCES Itinerarios(id)
) ENGINE=innodb;


