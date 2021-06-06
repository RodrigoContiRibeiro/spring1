select * from cargo;
select * from funcionario;
select * from projeto;
select * from projeto_funcionario;

insert into cargo (nome) value ("Programador");
insert into cargo (nome) value ("Gerente de Projetos");
insert into cargo (nome) value ("Gerente");
insert into funcionario (email, nome, telefone, cargo_id)
values ("rodrigo@gmail.com", "Rodrigo", "123123123", 1);
insert into funcionario (email, nome, telefone, cargo_id)
values ("claudio@gmail.com", "Claudio", "321321321", 1);
insert into funcionario (email, nome, telefone, cargo_id)
values ("paulo@gmail.com", "Paulo", "123456789", 2);
insert into funcionario (email, nome, telefone, cargo_id)
values ("bruno@gmail.com", "Bruno", "123456789", 3);
insert into projeto (descricao, dt_fim, dt_inicio, nome, orcamento, risco, status, gerente_id)
values ("Projeto do Senai feito por Rodrigo", "2021-01-01",
"2021-01-01", "RodrigOSystems", 1000, "Nenhum", "Em Andamento", 1);
insert into projeto_funcionario (projeto_id, funcionario_id)
values (1,1);
insert into projeto_funcionario (projeto_id, funcionario_id)
values (1,2);

select f.* from funcionario f inner join cargo c on f.cargo_id=c.id;
select f.* from funcionario f inner join cargo c on f.cargo_id=c.id where c.nome regexp "(Gerente)";
select f.* from funcionario f inner join cargo c on f.cargo_id=c.id where c.nome not regexp "(Gerente)";