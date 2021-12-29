create table account
(
    userID         varchar(64) not null
        primary key,
    username       varchar(64) not null,
    password       varchar(80) not null,
    naam           varchar(64) not null,
    email          varchar(80) not null,
    telefoonnummer varchar(16) not null,
    woonplaats     varchar(64) not null,
    score          int         not null,
    constraint email
        unique (email),
    constraint username
        unique (username)
)
    engine = InnoDB;

INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('43b0ebf8-c04e-4d47-8d6f-d6dc38bbe9c1', 'Sussiessss', 'wachtwoord!', 'Sussie-san@outlook.com', 'Suzanne Heistek', '065562973', 'Uithoorn', 73);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('5fb1f8be-27e6-499f-949d-f6fb997062f9', 'Anoniempje', 'wachtwoord123', 'Lorainetje@live.com', 'Loraine Nak', '0692376418', 'Maassluis', 99);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('b5f05860-562d-4850-b5f7-b33acaf0d3e6', 'EnergieSlurper', 'admin', 'piet jan', 'piet.jan@gmail.com', '0689562378', 'Rotterdam', 45);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('c6532547-a38f-47a4-b1a3-588e9a3cf633', 'Philip de derde', 'Philip de derde', 'Philip123@gmail.com', 'Philip Noklen', '069624750', 'Urk', 0);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('d0f2038e-556a-4c05-96e2-9eb6b84f1af6', 'Alex', 'geheim', 'avanvaarn@live.com', 'Alexander van Vaarn', '0653864215', 'Den Haag', 63);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('d45fdb79-d0f2-4ec2-ae76-e7cdf7045d5b', 'banaan', 'appel', 'Jan', 'jan@iets.com', '0623568923', 'Amsterdam', 125);
INSERT INTO challenge.account (userID, username, password, naam, email, telefoonnummer, woonplaats, score) VALUES ('e6f156f6-97ec-4ff3-9efc-942cf7c1f965', 'LegoBrickStamper', 'fb001dfcffd1c899f3297871406242f097aecf1a5342ccf3ebcd116146188e4b', 'Klaas Vaak', 'K.vaak@live.com', '+31 697526914', 'Hogeveen', 82);