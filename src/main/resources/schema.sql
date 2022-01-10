DROP TABLE IF EXISTS cards;
CREATE TABLE cards(
    "id" SERIAL,
    "number" VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS clientstypes;
CREATE TABLE clientstypes(
   "id" SERIAL,
   "title" VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS clients;
CREATE TABLE clients(
    "id" SERIAL,
    "fio" VARCHAR(300) NOT NULL,
    "type_id" INTEGER NOT NULL
);

DROP TABLE IF EXISTS client_card;
CREATE TABLE client_card(
     "client_id" INT NOT NULL,
     "card_id" INT NOT NULL
);