insert into tb_instituicao_espirita (id, evangeliza, nome, presidente, telefone, tipo) values (1, 1, 'FEPB', 'MARCO LIMA', '83988880000', 'F');
insert into tb_instituicao_espirita (id, evangeliza, nome, presidente, telefone, tipo) values (2, 1, 'AESCA', 'JAIR', '83988880000', 'C');

insert into tb_unidade_federativa (id, descricao, sigla) values (1, 'Paraíba', 'PB')

insert into tb_cidade (id, descricao, fk_uf) values (1, 'João Pessoa', 1)

insert into tb_bairro (id, descricao, fk_cidade) values (1, 'Torre', 1)
insert into tb_bairro (id, descricao, fk_cidade) values (2, 'Pedro Gondim', 1)
