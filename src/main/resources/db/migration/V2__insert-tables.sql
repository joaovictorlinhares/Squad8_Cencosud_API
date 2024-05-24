INSERT INTO public.secoes(nome) VALUES ('Frios');
INSERT INTO public.secoes(nome) VALUES ('Eletrônicos');
INSERT INTO public.secoes(nome) VALUES ('Alimentos');

INSERT INTO public.promocoes(titulo, desconto, data_inicio_promo, data_fim_promo)
VALUES
    ('Desconto de Verão', 10, '2024-06-01', '2024-06-30'),
    ('Black Friday', 20, '2024-11-25', '2024-11-28');


INSERT INTO public.produtos(nome, descricao, preco, data_validade, data_ultima_atualizacao_preco, marca, categoria, id_secao, id_promocao)
VALUES
	('Queijo Minas', 'Queijo fresco e saboroso', 8.49, '2024-12-20', '2024-05-22', 'Marca C', 'Frios', 1, 2),
    ('Presunto', 'Presunto defumado fatiado', 9.49, '2024-12-20', '2024-05-22', 'Marca L', 'Frios', 1, 2),
    ('Iogurte Natural', 'Iogurte sem açúcar', 2.99, '2024-12-31', '2024-05-22', 'Marca M', 'Frios', 1, NULL),
    ('Mussarela', 'Queijo mussarela fresco', 7.99, '2024-12-20', '2024-05-22', 'Marca N', 'Frios', 1, 2),
    ('Salame', 'Salame italiano picante', 11.99, '2024-12-31', '2024-05-22', 'Marca O', 'Frios', 1, NULL);

INSERT INTO public.produtos(nome, descricao, preco, data_validade, data_ultima_atualizacao_preco, marca, categoria, id_secao, id_promocao)
VALUES
	('TV LED 55 polegadas', 'Smart TV com resolução 4K', 1999.99, '2025-01-15', '2024-05-22', 'Marca B', 'Eletrônicos', 2, NULL),
    ('Fone de Ouvido Bluetooth', 'Cancelamento de ruído ativo', 129.99, '2025-01-15', '2024-05-22', 'Marca H', 'Eletrônicos', 2, 1),
    ('Notebook Ultrabook', 'Processador Intel Core i7', 1899.99, '2025-01-15', '2024-05-22', 'Marca I', 'Eletrônicos', 2, 2),
    ('Smartphone Android', 'Tela AMOLED, câmera tripla', 799.99, '2025-01-15', '2024-05-22', 'Marca J', 'Eletrônicos', 2, 2),
    ('Câmera DSLR', 'Sensor Full Frame, 24 MP', 1499.99, '2025-01-15', '2024-05-22', 'Marca K', 'Eletrônicos', 2, NULL);

INSERT INTO public.produtos(nome, descricao, preco, data_validade, data_ultima_atualizacao_preco, marca, categoria, id_secao, id_promocao)
VALUES
	('Arroz', 'Arroz integral de alta qualidade', 12.99, '2024-12-31', '2024-05-22', 'Marca A', 'Alimentos', 3, NULL),
    ('Feijão', 'Feijão carioca de alta qualidade', 6.99, '2024-12-31', '2024-05-22', 'Marca D', 'Alimentos', 3, 1),
    ('Macarrão Espaguete', 'Massa italiana tradicional', 2.49, '2024-12-20', '2024-05-22', 'Marca E', 'Alimentos', 3, 1),
    ('Azeite de Oliva', 'Azeite extra virgem', 14.99, '2024-12-31', '2024-05-22', 'Marca F', 'Alimentos', 3, NULL),
    ('Chocolate Amargo', 'Tablete de chocolate 70% cacau', 3.79, '2024-12-20', '2024-05-22', 'Marca G', 'Alimentos', 3, 1);