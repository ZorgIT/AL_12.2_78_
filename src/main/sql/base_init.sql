CREATE TABLE Person (
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY ,
    username varchar(100) not null,
    year_of_birth int NOT NULL,
    password varchar NOT NULL
);

INSERT INTO Person (username, year_of_birth, "password") VALUES ('test_user1', 1960, 'testpass');

INSERT INTO Person (username, year_of_birth, "password") VALUES ('test_user2', 1960, 'testpass');