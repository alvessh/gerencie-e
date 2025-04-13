use gerenciee;

DROP TABLE IF EXISTS produtomovimentacao;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS empresa;

CREATE TABLE empresa (
    id char(36) PRIMARY KEY,
    nomerazao VARCHAR(250),
    apelidofantasia VARCHAR(250),
    cpfcnpj VARCHAR(250),
    bairro VARCHAR(250),
    cep VARCHAR(250),
    cidade VARCHAR(250),
    pais VARCHAR(250),
    estado VARCHAR(250),
    logradouro VARCHAR(1000),
    contato01 VARCHAR(250),
    contato02 VARCHAR(250),
    email VARCHAR(250),
    emailFinanceiro VARCHAR(250)
);


CREATE TABLE usuario (
    id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    id_empresa VARCHAR(36),
    FOREIGN KEY (id_empresa) REFERENCES empresa(id)
);


CREATE TABLE produto (
    id VARCHAR(36) PRIMARY KEY,
    descricao VARCHAR(1000),
    quantidade INT,
    valorcusto DECIMAL(10,2),
    valorvenda DECIMAL(10,2),
    id_empresa VARCHAR(36),
    quantidade_estoque INT,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id)
);

CREATE TABLE produtomovimentacao (
    id VARCHAR(36) PRIMARY KEY,
    id_produto VARCHAR(36),
    id_empresa VARCHAR(36),
    quantidade_movimentada INT,
    valor_unitario DECIMAL(10,2),
    tipo_movimentacao ENUM('compra', 'venda'),
    tipo ENUM('Entrada', 'Saída'),
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    FOREIGN KEY (id_empresa) REFERENCES empresa(id)
);