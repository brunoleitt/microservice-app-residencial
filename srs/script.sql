USE SEGUROS;
USE SEGUROS_CONSULTA;

/*DROP DATABASE*/
DROP DATABASE SEGUROS;

/*CREATE DATABASE*/
CREATE DATABASE SEGUROS;

/*DROP*/
DROP TABLE COTACAO;
DROP TABLE item;
DROP TABLE QUESTIONARIO;
DROP TABLE TIPO_CALCULO;

/*SELECT*/

insert into cotacao values (30,'1d987106-68b0-4514-964c-e4354fac5983',NOW() ,now(),now(),'CALCULADA',1,1);

select * from cotacao;
/*where codigo_cotacao = '1d987106-68b0-4514-964c-e4354fac5983';*/

select * from item;

insert into item value(1,'3d987106-68b0-4514-964c-e4354fac5983');

SELECT * FROM COTACAO 
where codigo_cotacao = 'e7fed408-2f23-4cc3-a45b-7770ca6748f0'; 
SELECT * FROM QUESTIONARIO;
SELECT * FROM TIPO_CALCULO;
SELECT * FROM TIPO_VIGENCIA;

select * from cliente;
select * from cliente_endereco;


select * from pacote_cobertura;
select * from cobertura;

select * from pacote_cobertura as a 
/*inner join cobertura as b
on a.id_pacote_cobertura = b.id_pacote_cobertura */
right join coberturas_servicos as c 
on a.id_pacote_cobertura = c.id_pacote_cobertura
where c.id_pacote_cobertura = 2;

/*------------TIPO_CALCULO---------------*/
select * from TIPO_CALCULO ; 
select * from tipo_risco;
INSERT INTO TIPO_CALCULO  VALUE (1,'Cotacao');
INSERT INTO TIPO_CALCULO  VALUE (2,'Proposta');
INSERT INTO TIPO_VIGENCIA VALUE (1,'ANUAL');
INSERT INTO TIPO_VIGENCIA VALUE (2,'BIANUAL');

insert into tipo_risco values (1,'Casa');
insert into tipo_risco values (2,'Apto');

/*------------pacote_cobertura---------------*/

insert into pacote_cobertura values (1,'Básica',1000,100,1);
insert into pacote_cobertura values (2,'Plus',1000,100,1);
insert into pacote_cobertura values (3,'Top Plus',1000,100,1);
insert into pacote_cobertura values (4,'Básica',1000,100,2);
insert into pacote_cobertura values (5,'Plus',1000,100,2);
insert into pacote_cobertura values (6,'Top Plus',1000,100,2);

/*------------cobertura---------------*/
/*Basica - Casa */
insert into cobertura values (1,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',100,1);

/*Plus - Casa */
insert into cobertura values (2,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',200,2);
insert into cobertura values (3,'Vendaval, Ciclone ou Chuva de Granizo','http://hosto/imagem/teste',354,2);
insert into cobertura values (4,'Substracão de Bens','http://hosto/imagem/teste',354,2);

/*Top Plus - Casa */
insert into cobertura values (5,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',1244,3);
insert into cobertura values (6,'Vendaval, Ciclone ou Chuva de Granizo','http://hosto/imagem/teste',700,3);
insert into cobertura values (7,'Substracão de Bens','http://hosto/imagem/teste',658,3);
insert into cobertura values (8,'Responsabilidade Civil Familiar','http://hosto/imagem/teste',2510,3);
insert into cobertura values (9,'Roubo e Furto','http://hosto/imagem/teste',3254,3);

/*Basico - Apto*/
insert into cobertura values (10,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',3254,4);

/*Plus - Apto*/
insert into cobertura values (11,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',256,5);
insert into cobertura values (12,'Vendaval, Ciclone ou Chuva de Granizo','http://hosto/imagem/teste',250,5);
insert into cobertura values (13,'Substracão de Bens','http://hosto/imagem/teste',454,5);

/*Top Plus - Apto */
insert into cobertura values (14,'Incêndio, Explosão e Fumaça','http://hosto/imagem/teste',1244,6);
insert into cobertura values (15,'Vendaval, Ciclone ou Chuva de Granizo','http://hosto/imagem/teste',700,6);
insert into cobertura values (16,'Substracão de Bens','http://hosto/imagem/teste',658,6);
insert into cobertura values (17,'Responsabilidade Civil Familiar','http://hosto/imagem/teste',2510,6);
insert into cobertura values (18,'Roubo e Furto','http://hosto/imagem/teste',3254,6);

/*------------Coberturas Serviços---------------*/
select * from coberturas_servicos;

/*Basica - Casa */
insert into coberturas_servicos values (1,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','http://hosto/imagem/teste',1);

/*Plus - Casa */
insert into coberturas_servicos values (2,'Reparos Elétricos','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','http://hosto/imagem/teste',2);

/*Top Plus - Casa */
insert into coberturas_servicos values (3,'Hidráulica','Conte com a mão de obra especializada de encanadores da Porto Seguro para reparar problemas de vazamento de torneiras, sifões, cubas, conexões de chuveiros entre outros.','http://hosto/imagem/teste',3);


INSERT INTO COTACAO (DATA_COTACAO,DATA_VIGENCIA_FINAL,DATA_VIGENCIA_INICIAL,ID_TIPO_CALCULO,ID_TIPO_VIGENCIA) 
VALUE('2014/05/01','2014/05/01','2014/05/01',1,1);

INSERT INTO QUESTIONARIO (POSSUI_ANTI_FURTO,ID_COTACAO) VALUES(0,3);

select * from tipo_risco;
select * from pacote_cobertura;

select * from cotacao;


/*DELETE*/
DELETE FROM TOKEN_ENTRY WHERE PROCESSOR_NAME != '';
DELETE FROM COTACAO WHERE ID != '';
DELETE FROM COTACAO_QUERY WHERE ID != '';








