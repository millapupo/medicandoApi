create table usuarios(

    id bigint not null auto_increment,
    nome varchar(200) not null,
    email varchar(100) not null unique,
    telefone varchar(30) not null unique,
    plano_saude varchar(100) not null,
    numero_carteirinha varchar(20) not null unique,

    primary key(id)
    );