USE colegio_arquitectos_valencia;

/* Maestras */  
	/* PeriodosArquitectonicos */  
	INSERT IGNORE INTO PeriodosArquitectonicos VALUES (1,"PeriodoArquitectonico 1");
	INSERT IGNORE INTO PeriodosArquitectonicos VALUES (2,"PeriodoArquitectonico 2");
	INSERT IGNORE INTO PeriodosArquitectonicos VALUES (3,"PeriodoArquitectonico 3");

	/* Tipologias */  
	INSERT IGNORE INTO Tipologias VALUES (1,"Tipologia 1");
	INSERT IGNORE INTO Tipologias VALUES (2,"Tipologia 2");
	INSERT IGNORE INTO Tipologias VALUES (3,"Tipologia 3");

	/* TiposItenerarios */  
	INSERT IGNORE INTO TiposItenerarios VALUES (1,"TipoItenerario 1");
	INSERT IGNORE INTO TiposItenerarios VALUES (2,"TipoItenerario 2");
	INSERT IGNORE INTO TiposItenerarios VALUES (3,"TipoItenerario 3");

	/* EstilosArquitectonicos */  
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (1,"Contemporáneo");
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (2,"Moderno");
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (3,"Renacentista");
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (4,"Barroco");
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (5,"Gótico");
	INSERT IGNORE INTO EstilosArquitectonicos VALUES (6,"Clásico");

	/* IndicadoresVisuales */  
	INSERT IGNORE INTO IndicadoresVisuales VALUES (1,"Destacada");
	INSERT IGNORE INTO IndicadoresVisuales VALUES (2,"Normal");


/* Principales */  
	/* Edificios */  
	INSERT INTO `colegio_arquitectos_valencia`.`edificios` (`id`, `nombre`, `id_periodo`, `anyo`, `id_tipologia`, `descripcion`, `web`, `direccion`, `geo_referencia`) VALUES 
	(1, 'El Escorial', 2, '1980/02/12', 3, 'El Real Monasterio de San Lorenzo de El Escorial es un complejo que incluye un palacio real, una basílica, un panteón, una biblioteca, un colegio y un monasterio. Se encuentra en la localidad española de San Lorenzo de El Escorial, en la Comunidad de Madrid, y fue construido en el siglo xvi entre 1563 y 1584.', 'http://www.elescorial.es/', '28200 San Lorenzo de El Escorial, Madrid', '40°35′21″N 4°08′52″O﻿ / ﻿40.589167, -4.147778');
	INSERT INTO `colegio_arquitectos_valencia`.`edificios` (`id`, `nombre`, `id_periodo`, `anyo`, `id_tipologia`, `descripcion`, `web`, `direccion`, `geo_referencia`) VALUES 
	(2, 'Sagrada Familia', 2, '1980-02-12', 2, 'El Templo Expiatorio de la Sagrada Familia (en catalán, Temple Expiatori de la Sagrada Família), conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona (España), diseñada por el arquitecto', 'https://sagradafamilia.org/es/home', 'C/ de Mallorca, 401, 08013 Barcelona', 'C53F+FP Barcelona');

	/* Itinerarios */  
	INSERT INTO `colegio_arquitectos_valencia`.`itinerarios` (`id`, `nombre`, `tipo_itinerario`, `descripcion`) VALUES 
	('1', 'Itinerario1', '1', NULL);
	INSERT INTO `colegio_arquitectos_valencia`.`itinerarios` (`id`, `nombre`, `tipo_itinerario`, `descripcion`) VALUES 
	('2', 'Itinerario2', '2', NULL);

	/* Eventos */  
	INSERT INTO `colegio_arquitectos_valencia`.`eventos` (`id`, `nombre`, `fecha`, `descripcion`, `web`) VALUES 
	('1', 'Evento1', '1980/02/12', 'Desc1', 'https://evento1.com');
	INSERT INTO `colegio_arquitectos_valencia`.`eventos` (`id`, `nombre`, `fecha`, `descripcion`, `web`) VALUES 
	('2', 'Evento2', '1980/02/12', 'Desc2', 'https://evento2.com');

/* Many To Many */ 
	/* EdificiosEstilos */ 
	INSERT IGNORE INTO EdificiosEstilos (id, id_edificio, id_estilo) VALUES (1,1,3);
    INSERT IGNORE INTO EdificiosEstilos (id, id_edificio, id_estilo) VALUES (2,1,4);
    INSERT IGNORE INTO EdificiosEstilos (id, id_edificio, id_estilo) VALUES (3,2,2);
	INSERT IGNORE INTO EdificiosEstilos (id, id_edificio, id_estilo) VALUES (4,2,1);
    
    /* EdificiosIndicadoresVisuales */ 
	INSERT IGNORE INTO EdificiosIndicadoresVisuales (id, id_edificio, id_indicador_visual) VALUES (1,1,1);
    INSERT IGNORE INTO EdificiosIndicadoresVisuales (id, id_edificio, id_indicador_visual) VALUES (2,1,2);
    INSERT IGNORE INTO EdificiosIndicadoresVisuales (id, id_edificio, id_indicador_visual) VALUES (3,2,1);
	INSERT IGNORE INTO EdificiosIndicadoresVisuales (id, id_edificio, id_indicador_visual) VALUES (4,2,2);
    
    /* EdificiosItinerarios */ 
	INSERT IGNORE INTO EdificiosItinerarios (id, id_edificio, id_itinerario) VALUES (1,1,1);
    INSERT IGNORE INTO EdificiosItinerarios (id, id_edificio, id_itinerario) VALUES (2,1,2);
    INSERT IGNORE INTO EdificiosItinerarios (id, id_edificio, id_itinerario) VALUES (3,2,1);
	INSERT IGNORE INTO EdificiosItinerarios (id, id_edificio, id_itinerario) VALUES (4,2,2);


