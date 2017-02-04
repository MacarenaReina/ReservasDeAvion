DROP DATABASE IF EXISTS BookingFlights;
CREATE DATABASE BookingFlights;

USE BookingFlights;

DROP TABLE IF EXISTS city;
CREATE TABLE city(
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    country varchar(30) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO city (name, country) VALUES ("Barcelona", "España");
INSERT INTO city (name, country) VALUES ("Madrid", "España");
INSERT INTO city (name, country) VALUES ("Roma", "Italia");
INSERT INTO city (name, country) VALUES ("Venecia", "Italia");


DROP TABLE IF EXISTS caterogy;
CREATE TABLE category(
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO category (name) VALUES ("Nacional");
INSERT INTO category (name) VALUES ("Internacional");


DROP TABLE IF EXISTS airport;
CREATE TABLE airport(
    id varchar(10) NOT NULL,
    name varchar(30) NOT NULL,
    category integer,
    city integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (city) REFERENCES city(id)
);

INSERT INTO airport VALUES ("BCN", "El Prat", 2, 1);
INSERT INTO airport VALUES ("MD", "Barajas", 2, 2);
INSERT INTO airport VALUES ("RM", "Fiumicino", 2, 3);
INSERT INTO airport VALUES ("VN", "Venecia NA", 1, 4);


DROP TABLE IF EXISTS airline;
CREATE TABLE airline(
    id varchar(10) NOT NULL,
    name varchar(30) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO airline VALUES ("VL", "Vueling");
INSERT INTO airline VALUES ("AE", "Air Europa");
INSERT INTO airline VALUES ("RY", "Ryanair");
INSERT INTO airline VALUES ("EM", "Emirates");


DROP TABLE IF EXISTS generic_flight;
CREATE TABLE generic_flight(
    flight_number integer NOT NULL AUTO_INCREMENT,
    departure_hour time NOT NULL,
    arrival_hour time NOT NULL,
    price integer NOT NULL,
    capacity integer,
    origin varchar(10) NOT NULL,
    destination varchar(10) NOT NULL,
    airline varchar(10),
    PRIMARY KEY (flight_number),
    FOREIGN KEY (origin) REFERENCES airport(id),
    FOREIGN KEY (destination) REFERENCES airport(id),
    FOREIGN KEY (airline) REFERENCES airline(id)
);

INSERT INTO generic_flight (departure_hour, arrival_hour, price, capacity, origin, destination, airline) VALUES ("12:30", "15:30", 121, 100, "BCN", "MD", "VL");
INSERT INTO generic_flight (departure_hour, arrival_hour, price, capacity, origin, destination, airline) VALUES ("20:00", "22:15", 150, 120, "BCN", "RM", "AE");
INSERT INTO generic_flight (departure_hour, arrival_hour, price, capacity, origin, destination, airline) VALUES ("15:25", "17:30", 100, 75, "RM", "VN", "RY");
INSERT INTO generic_flight (departure_hour, arrival_hour, price, capacity, origin, destination, airline) VALUES ("07:30", "10:00", 200, 100, "RM", "MD", "EM");


DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
    day date NOT NULL,
    free_places integer NOT NULL,
    generic_flight integer,
    FOREIGN KEY (generic_flight) REFERENCES generic_flight(flight_number),
    PRIMARY KEY (generic_flight)
);

INSERT INTO flight VALUES (STR_TO_DATE("20/01/2017", "%d/%m/%Y"), 10, 1);
INSERT INTO flight VALUES (STR_TO_DATE("02/09/2016", "%d/%m/%Y"), 5, 2);
INSERT INTO flight VALUES (STR_TO_DATE("10/11/2016", "%d/%m/%Y"), 28, 3);
INSERT INTO flight VALUES (STR_TO_DATE("30/03/2017", "%d/%m/%Y"), 50, 4);


DROP TABLE IF EXISTS bookings;
CREATE TABLE bookings(
    num_booking integer NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    surname varchar(30) NOT NULL,
    phone varchar(9) NOT NULL,
    credit_card varchar(16) NOT NULL,
    amount float NOT NULL,
    flight integer NOT NULL,
    PRIMARY KEY (num_booking),
    FOREIGN KEY (flight) REFERENCES flight(generic_flight)
);

INSERT INTO bookings (name, surname, phone, credit_card, amount, flight) VALUES ("Macarena", "Reina", "666777888", "ABCD123443211234", 50, 1);
INSERT INTO bookings (name, surname, phone, credit_card, amount, flight) VALUES ("Omar", "Lorenzo", "654321987", "ACCD123443211234", 70, 2);
INSERT INTO bookings (name, surname, phone, credit_card, amount, flight) VALUES ("Joshua", "Hernández", "666555444", "ABCD123443219876", 20, 3);
INSERT INTO bookings (name, surname, phone, credit_card, amount, flight) VALUES ("Mónica", "Pérez", "666888777", "ABCDCDEF43211234", 10, 4);
