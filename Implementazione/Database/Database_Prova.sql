DROP TABLE IF EXISTS disponibilita CASCADE;
DROP TABLE IF EXISTS abilita CASCADE;
DROP TABLE IF EXISTS statistiche CASCADE;
DROP TABLE IF EXISTS players CASCADE;
DROP TABLE IF EXISTS utenti CASCADE;
DROP TABLE IF EXISTS classi CASCADE;
DROP TABLE IF EXISTS livelli CASCADE;



CREATE TABLE utenti(
email varchar(256) PRIMARY KEY,
username varchar(256) not null,
pass varchar(266) not null
);



CREATE TABLE classi(
name varchar(256) PRIMARY KEY,
hp integer not null,
attack integer not null,
defence integer not null,
armor integer not null,
ability varchar(256) 

);



CREATE TABLE livelli(
lv integer PRIMARY KEY,
attacklv integer not null,
defencelv integer not null,
armorlv integer not null

);


CREATE TABLE players(
name varchar(256) PRIMARY KEY,
email varchar(256) not null,
lv integer not null,
nameclass varchar(256) not null,
FOREIGN KEY (lv) REFERENCES livelli(lv),
FOREIGN KEY (email) REFERENCES utenti(email),
FOREIGN KEY (nameclass) REFERENCES classi(name)

);


CREATE TABLE disponibilita(
nameplayers varchar(256),
connected boolean not null,
FOREIGN KEY (nameplayers) REFERENCES players(name),
PRIMARY KEY (nameplayers)
);



CREATE TABLE abilita(
name varchar(256) PRIMARY KEY,
classname varchar(256),
damage integer not null,
frequency integer not null,
FOREIGN KEY (classname) REFERENCES classi(name)
);


CREATE TABLE statistiche(
nameplayers varchar(256),
kills integer not null,
deaths integer not null,
FOREIGN KEY (nameplayers) REFERENCES players(name),
PRIMARY KEY(nameplayers)
);

