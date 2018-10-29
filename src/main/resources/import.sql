INSERT INTO public.estado (id, nome) VALUES (1,'Rondônia');
INSERT INTO public.estado (id, nome) VALUES (2,'Acre');
INSERT INTO public.estado (id, nome) VALUES (3,'Amazonas');
INSERT INTO public.estado (id, nome) VALUES (4,'Roraima');
INSERT INTO public.estado (id, nome) VALUES (5,'Pará');
INSERT INTO public.estado (id, nome) VALUES (6,'Amapá');
INSERT INTO public.estado (id, nome) VALUES (7,'Tocantins');
INSERT INTO public.estado (id, nome) VALUES (8,'Maranhão');
INSERT INTO public.estado (id, nome) VALUES (9,'Piauí');
INSERT INTO public.estado (id, nome) VALUES (10,'Ceará');
INSERT INTO public.estado (id, nome) VALUES (11,'Rio Grande do Norte');
INSERT INTO public.estado (id, nome) VALUES (12,'Paraíba');
INSERT INTO public.estado (id, nome) VALUES (13,'Pernambuco');
INSERT INTO public.estado (id, nome) VALUES (14,'Alagoas');
INSERT INTO public.estado (id, nome) VALUES (15,'Sergipe');
INSERT INTO public.estado (id, nome) VALUES (16,'Bahia');
INSERT INTO public.estado (id, nome) VALUES (17,'Minas Gerais');
INSERT INTO public.estado (id, nome) VALUES (18,'Espírito Santo');
INSERT INTO public.estado (id, nome) VALUES (19,'Rio de Janeiro');
INSERT INTO public.estado (id, nome) VALUES (20,'São Paulo');
INSERT INTO public.estado (id, nome) VALUES (21,'Paraná');
INSERT INTO public.estado (id, nome) VALUES (22,'Santa Catarina');
INSERT INTO public.estado (id, nome) VALUES (23,'Rio Grande do Sul (*)');
INSERT INTO public.estado (id, nome) VALUES (24,'Mato Grosso do Sul');
INSERT INTO public.estado (id, nome) VALUES (25,'Mato Grosso');
INSERT INTO public.estado (id, nome) VALUES (26,'Goiás');
INSERT INTO public.estado (id, nome) VALUES (27,'Distrito Federal');

INSERT INTO public.cidade (id, nome, estado_id) VALUES (1, 'Alta Floresta D''Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (2, 'Ariquemes',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (3, 'Cabixi',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (4, 'Cacoal',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (5, 'Cerejeiras',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (6, 'Colorado do Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (7, 'Corumbiara',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (8, 'Costa Marques',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (9, 'Espigão D''Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (10, 'Guajará-Mirim',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (11, 'Jaru',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (12, 'Ji-Paraná',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (13, 'Machadinho D''Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (14, 'Nova Brasilândia D''Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (15, 'Ouro Preto do Oeste',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (16, 'Pimenta Bueno',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (17, 'Porto Velho',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (18, 'Presidente Médici',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (19, 'Rio Crespo',1);
INSERT INTO public.cidade (id, nome, estado_id) VALUES (20, 'Rolim de Moura',1);

INSERT INTO public.cliente (id, cpf_ou_cnpj, email, nome, password, tipo) VALUES (1, '39771451855', 'guilhermemonteirolourenco@gmail.com', 'Guilherme Lourenco', '$2a$10$cyKQ6F5T8b7vEDo.a6ZT7uSZPKAsYf6.jmosngwOfEKjZ2.PCIVfS', 1);

INSERT INTO public.endereco (id, bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) VALUES (1, 'Vila Formosa', '13045047', 'Apto 210', 'Rua Jesus Sales da Silva', '66', 2, 1);

INSERT INTO public.cliente_file (id, bucket, content_disposition, content_encoding, content_type, crc32c, download_tokens, download_url, etag, generation, md5hash, metageneration, name, path, size, storage_class, time_created, updated, cliente_id) VALUES (1, null, null, null, null, null, null, 'assets/imgs/avatar-blank.png', null, null, null, null, null, null, null, null, null, null, 1);

INSERT INTO public.perfis (cliente_id, perfis) VALUES (1, 1);

INSERT INTO public.telefone (cliente_id, telefones) VALUES (1, '9993769893');
INSERT INTO public.telefone (cliente_id, telefones) VALUES (1, '99937698');
