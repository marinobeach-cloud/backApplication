CREATE TABLE Article (
    art_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE Product (
     prod_id INT NOT NULL PRIMARY KEY,
     name VARCHAR(50) NOT NULL
);

CREATE TABLE Prod_Art (
     art_id INT NOT NULL,
     prod_id INT NOT NULL,
     amount_of INT NOT NULL,
     FOREIGN KEY (art_id) REFERENCES Article(art_id),
     FOREIGN KEY (prod_id) REFERENCES Product(prod_id)
);

INSERT INTO Article VALUES (1, 'Madera', 10);
INSERT INTO Article VALUES (2, 'Plomo', 10);
INSERT INTO Article VALUES (3, 'Hierro', 10);

INSERT INTO Product VALUES (1, 'Mesa');
INSERT INTO Product VALUES (2, 'Silla');

INSERT INTO Prod_Art VALUES (1, 1, 2);
INSERT INTO Prod_Art VALUES (2, 1, 1);
INSERT INTO Prod_Art VALUES (3, 1, 1);

INSERT INTO Prod_Art VALUES (1, 2, 1);
INSERT INTO Prod_Art VALUES (2, 2, 1);
INSERT INTO Prod_Art VALUES (3, 2, 1);