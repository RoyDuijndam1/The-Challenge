create table meting
(
    metingID       varchar(64) not null
        primary key,
    TVOC           int         not null,
    `CO2 waarde`   int         not null,
    `Datum meting` datetime    not null,
    UserID         varchar(64) not null,
    constraint UserID
        foreign key (UserID) references account (userID)
            on delete cascade
)
    engine = InnoDB;

INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('5c2a6e2d-bf4f-4fe4-ac4c-e89837c4ee80', 250, 43, '2021-11-17 15:24:23', 'd0f2038e-556a-4c05-96e2-9eb6b84f1af6');
INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('5f083372-da29-4bc1-ab6d-b3bae8a06984', 125, 36, '2021-11-16 15:24:23', 'e6f156f6-97ec-4ff3-9efc-942cf7c1f965');
INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('a77d6997-2098-4105-add8-9799acd55130', 125, 70, '2021-11-16 15:24:23', 'b5f05860-562d-4850-b5f7-b33acaf0d3e6');
INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('ae12b746-d558-4e38-80a5-a9a9a508bdd4', 25, 36, '2021-11-21 15:24:23', 'c6532547-a38f-47a4-b1a3-588e9a3cf633');
INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('d15e5de5-d5fa-4aa1-9a32-532620fe766f', 75, 2, '2021-11-19 15:24:23', '5fb1f8be-27e6-499f-949d-f6fb997062f9');
INSERT INTO challenge.meting (metingID, TVOC, `CO2 waarde`, `Datum meting`, UserID) VALUES ('d94d3645-21f8-4f1c-aef5-64a1ae1fa8a0', 5, 25, '2021-11-20 15:24:23', '43b0ebf8-c04e-4d47-8d6f-d6dc38bbe9c1');