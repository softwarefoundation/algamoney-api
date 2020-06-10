CREATE TABLE TB03_LANCAMENTO (
	CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	DESCRICAO VARCHAR(50) NOT NULL,
	DATA_VENCIMENTO DATE NOT NULL,
	DATA_PAGAMENTO DATE,
	VALOR DECIMAL(10,2) NOT NULL,
	OBSERVACAO VARCHAR(100),
	TIPO VARCHAR(20) NOT NULL,
	CODIGO_CATEGORIA BIGINT(20) NOT NULL,
	CODIGO_PESSOA BIGINT(20) NOT NULL,
	FOREIGN KEY (CODIGO_CATEGORIA) REFERENCES TB01_CATEGORIA(CODIGO),
	FOREIGN KEY (CODIGO_PESSOA) REFERENCES TB02_PESSOA(CODIGO)
);

INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Top Club', '2017-06-10', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('DMAE', '2017-06-10', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Bahamas', '2017-06-10', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'DESPESA', 4, 8);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 9);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'RECEITA', 5, 10);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Café', '2017-06-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO TB03_LANCAMENTO (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Lanche', '2017-06-10', null, 10.20, null, 'DESPESA', 4, 1);
