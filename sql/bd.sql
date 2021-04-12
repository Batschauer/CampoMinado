create database CampoMinado;
use CampoMinado;

create table Historico(
	id int not null auto_increment,
	data date not null,
	duracao time not null,
	dificuldade enum ('Facil', 'Medio', 'Dificil'),
	primary key(id)
);

desc Historico;
select * from Historico order by data;

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-10',
    '00:25',
    'Dificil'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-10',
    '00:15',
    'Dificil'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-11',
    '00:05',
    'Facil'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-12',
    '00:02',
    'Medio'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-13',
    '00:06',
    'Dificil'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-14',
    '00:10',
    'Medio'
);

insert into Historico (data, duracao, dificuldade) values (
	'2021-04-15',
    '00:25',
    'Dificil'
);
