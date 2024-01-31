create table medicamentos(

    id bigint not null auto_increment,
    usuario_id bigint not null,
    nome varchar(200) not null,
    dosagem varchar(200) not null,
    periodicidade varchar(200) not null,
    dataInicio date not null,
    tempoDeUso varchar(200) not null,
    dataTermino date not null,

    primary key(id),
    CONSTRAINT fk_medicamentos_usuario_id foreign key(usuario_id) references usuarios(id)
   );