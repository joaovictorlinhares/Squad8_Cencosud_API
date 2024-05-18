CREATE TABLE secoes (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE promocoes (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  desconto DECIMAL(5,2) NOT NULL,
  data_inicio_promo DATE NOT NULL,
  data_fim_promo DATE NOT NULL
);

CREATE TABLE produtos (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT,
  preco DECIMAL(10,2) NOT NULL,
  data_validade DATE NOT NULL,
  data_ultima_atualizacao_preco DATE NOT NULL,
  marca VARCHAR(100) NOT NULL,
  categoria VARCHAR(100) NOT NULL,
  id_secao INT NOT NULL REFERENCES secoes(id),
  id_promocao INT REFERENCES promocoes(id)
);
