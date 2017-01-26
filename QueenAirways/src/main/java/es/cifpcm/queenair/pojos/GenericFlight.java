/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.pojos;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author macar
 */
public class GenericFlight implements Serializable {
    private Integer flightNumber;
    private Time departureHour;
    private Time arrivalHour;
    private Integer price;
    private Integer capacity;
    private Airport origin;
    private Airport destination;
    private Airline airline;

    public GenericFlight() {
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Time getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Time departureHour) {
        this.departureHour = departureHour;
    }

    public Time getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(Time arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    
}
