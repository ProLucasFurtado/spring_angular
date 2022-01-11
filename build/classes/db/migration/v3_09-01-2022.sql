INSERT INTO usuario (id, login, senha, ativo) VALUES (1, 'lucas', '123', true);

INSERT INTO acesso (id) VALUES (1);

CREATE TABLE usuario_acesso (
    usuario_id bigint NOT NULL,
    acesso_id bigint NOT NULL,
    acesso character varying(70)
);

ALTER TABLE ONLY usuario_acesso
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES usuario(id);
    
ALTER TABLE ONLY usuario_acesso
    ADD CONSTRAINT acesso_fk FOREIGN KEY (acesso_id) REFERENCES acesso(id);

ALTER TABLE ONLY usuario_acesso
    ADD CONSTRAINT unique_usuario_acesso UNIQUE (usuario_id, acesso_id);


INSERT INTO usuario_acesso (usuario_id, acesso_id, acesso) VALUES (1, 1, 'ADMIN');