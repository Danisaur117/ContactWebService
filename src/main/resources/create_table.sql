CREATE TABLE agenda.contact(
	contactId INTEGER AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    postalCode VARCHAR(5),
    city VARCHAR(25),
    phone1 VARCHAR(10),
    phone2 VARCHAR(10),
    email1 VARCHAR(50),
    email2 VARCHAR(50));