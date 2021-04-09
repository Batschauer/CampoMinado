create database CampoMinado;
use CampoMinado;

create table Historico(
	id int not null auto_increment,
	data datetime not null,
	duracao timestamp not null,
	dificuldade enum ('Facil', 'Medio', 'Dificil'),
	primary key(id)
);

desc Historico;
select * from Historico;