DROP DATABASE IF EXISTS BookingFlights;
CREATE DATABASE BookingFlights;

USE BookingFlights;

DROP TABLE IF EXISTS city;
CREATE TABLE city(
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    country varchar(30) NOT NULL
);




DROP TABLE IF EXISTS airport;
CREATE TABLE airport(
    id varchar(10) NOT NULL,
    name varchar(30) NOT NULL,
    category integer
);




DROP TABLE IF EXISTS generic_flight;
CREATE TABLE generic_flight(
    flight_number integer NOT NULL,
    departure_hour time NOT NULL,
    arrival_hour time NOT NULL,
    price integer NOT NULL,
    capacity integer
);




DROP TABLE IF EXISTS airline;
CREATE TABLE airline(
    id varchar(10) NOT NULL,
    name varchar(30) NOT NULL
);




DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
    day date NOT NULL,
    free_places integer NOT NULL
);




DROP TABLE IF EXISTS bookings;
CREATE TABLE bookings(
    num_booking integer NOT NULL,
    name varchar(30) NOT NULL,
    apellidos varchar(30) NOT NULL,
    telefono varchar(9) NOT NULL,
    importe float NOT NULL
);