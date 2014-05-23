drop database if exists españabaloncesto;
create database españabaloncesto;

use españabaloncesto;
create table equipo
(
	IdEquipo int(2) auto_increment primary key,
	Equipo varchar(30)
);

create table jugadores
(
	IdJugador int(2) auto_increment primary key,
	Nombre varchar(15),
	Apellidos varchar(20),
	FechaNacimiento date,
	Posicion varchar(10),
        Dorsal int(2),
	Sueldo float(5),
	IdEquipo int(2),
	foreign key (IdEquipo) references equipo(IdEquipo)
	on delete cascade on update cascade
);

insert equipo(IdEquipo, Equipo) values
(1,'Futbol Club Barcelona Basket'),
(2,'Real Madrid Baloncesto'),
(3,'Los Angeles Lakers'),
(4,'Minnesota Timberwolves'),
(5,'Portland Trail Blazers'),
(6,'Dallas Mavericks'),
(7,'Oklahoma City Thunder'),
(8,'Saski Baskonia'),
(9,'Memphis Grizzlies');

insert jugadores(IdJugador, Nombre, Apellidos, FechaNacimiento, Posicion, Dorsal,IdEquipo, Sueldo) values
(1,'Pau','Gasol','1980-07-06','Pívot',4,3,19.000),
(2,'Rudy','Fernandez','1985-04-04','Alero',5,2,2.700),
(3,'Sergio','Rodriguez','1986-06-12','Base',6,2,2.500),
(4,'Juan Carlos','Navarro','1980-06-13','Escolta',7,1,2.500),
(5,'Jose Manuel','Calderon','1981-09-28','Base',8,6,9.781),
(6,'Ricky','Rubio','1990-10-29','Base',9,4,3.480),
(7,'Victor','Claver','1988-08-30','Alero',10,5,1.300),
(8,'Fernando','San Emeterio','1984-01-01','Alero',11,8,2.500),
(9,'Sergio','Llull','1987-11-15','Escolta',12,2,3.000),
(10,'Marc','Gasol','1985-01-29','Pívot',13,9,12.920),
(11,'Serge','Ibaka','1989-09-18','Ala-Pívot',14,7,2.180),
(12,'Felipe','Reyes','1980-03-16','Ala-Pívot',15,2,3.000);