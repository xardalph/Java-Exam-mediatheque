CREATE TABLE Cd (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    titre varchar(100),
    reference varchar(100), 
    genreMusic varchar(100), 
    label varchar(100),
    borrow boolean
    );
    
CREATE TABLE Dvd (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    titre varchar(100),
    reference varchar(100), 
    genreFilm varchar(100), 
    prod varchar(100),
    borrow boolean
    );
    
CREATE TABLE Livre (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    titre varchar(100),
    reference varchar(100), 
    authorName varchar(100), 
    editor varchar(100),
    borrow boolean
    );
    
CREATE TABLE Magazine (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    titre varchar(100),
    reference varchar(100), 
    marque varchar(100),
    role varchar(100)
    );

INSERT INTO Cd(titre,reference,genreMusic,label) VALUES ("XEU","123AA123","Rap","CapitolRecords");
INSERT INTO Cd(titre,reference,genreMusic,label) VALUES ("Recital 1961","123EAB123","Piaf","ColumbiaRecords");
INSERT INTO Cd(titre,reference,genreMusic,label) VALUES ("Ce que je sais","123AC123","Rock","MercuryRecords");

INSERT INTO Dvd(titre,reference,genreFilm,prod) VALUES ("Rio","123AD123","Animation","CenturyFox");
INSERT INTO Dvd(titre,reference,genreFilm,prod) VALUES ("Cendrillon","123AE123","Animation","Jesaispas");
INSERT INTO Dvd(titre,reference,genreFilm,prod) VALUES ("Desenchante","123AF123","Serie","Jesaispasnonplus");

INSERT INTO Livre(titre,reference,authorName,editor) VALUES ("Livre1","123AG123","Author1","fantastique");
INSERT INTO Livre(titre,reference,authorName,editor) VALUES ("Livre2","123AH123","Author2","pasfantastique");
INSERT INTO Livre(titre,reference,authorName,editor) VALUES ("Livre3","123AI123","Author3","drole");

INSERT INTO Magazine(titre,reference,marque,role) VALUES ("AutoMoto","123AJ123","Vivelesmotos","documentaire");
INSERT INTO Magazine(titre,reference,marque,role) VALUES ("AutoMoto2","123AK123","Vivelesmotos2","fiction");
INSERT INTO Magazine(titre,reference,marque,role) VALUES ("AutoMoto3","123AL123","Vivelesmotos3","reel");