DROP TABLE IF EXISTS sfide CASCADE;
DROP TABLE IF EXISTS skills CASCADE;
DROP TABLE IF EXISTS players CASCADE;
DROP TABLE IF EXISTS utenti CASCADE;
DROP TABLE IF EXISTS livelli CASCADE;
DROP TABLE IF EXISTS classi CASCADE;




CREATE TABLE utenti(
email varchar(100) PRIMARY KEY,
pass varchar(100) NOT NULL
);


CREATE TABLE classi(
nome varchar(100) PRIMARY KEY,
ind_vita integer NOT NULL,
ind_att integer NOT NULL,
ind_dif integer NOT NULL
);



CREATE TABLE livelli(
numero integer PRIMARY KEY,
max_xp integer NOT NULL,
vita integer NOT NULL,
attacco integer NOT NULL,
difesa integer NOT NULL
);


CREATE TABLE players(
nome varchar(100) PRIMARY KEY,
nome_classe varchar(100),
livello integer,
esperienza varchar(100) NOT NULL,
email varchar(100),
FOREIGN KEY (livello) REFERENCES livelli(numero),
FOREIGN KEY (email) REFERENCES utenti(email),
FOREIGN KEY (nome_classe) REFERENCES classi(nome)
);


CREATE TABLE skills(
nome varchar(100) PRIMARY KEY,
nome_classe varchar(100),
danno integer NOT NULL,
frequenza integer NOT NULL,
FOREIGN KEY (nome_classe) REFERENCES classi(nome)
);


CREATE TABLE sfide(
player1 varchar(100),
player2 varchar(100),
data_ora datetime NOT NULL,  #'YYYY-MM-DD HH:MM:SS'
vincitore boolean NOT NULL,  # 0 = falso, altri numeri = Vero
FOREIGN KEY (player1) REFERENCES players(nome),
FOREIGN KEY (player2) REFERENCES players(nome),
PRIMARY KEY (player1, player2, data_ora)
);


