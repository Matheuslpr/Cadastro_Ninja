--Migrations para adicionar a coluna de dificuldade na tabela missoes

ALTER TABLE tb_missoes
ADD COLUMN dificuldade VARCHAR(255);