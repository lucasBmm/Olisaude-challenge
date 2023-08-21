CREATE TABLE cliente (
  id BIGINT IDENTITY(1,1) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  genero CHAR(1) NOT NULL,
  problema_saude BIGINT NOT NULL,
  data_criacao DATETIME NOT NULL,
  data_atualizacao DATETIME NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY(problema_saude) REFERENCES problema_saude(id)
);
