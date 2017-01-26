/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.pojos;

import java.io.Serializable;

/**
 *
 * @author macar
 */
public class Bookings implements Serializable {
    private Integer numBooking;
    private String name;
    private String surname;
    private String phone;
    private Float amount;
    private Flight flight;

    public Bookings() {
    }

    public Integer getNumBooking() {
        return numBooking;
    }

    public void setNumBooking(Integer numBooking) {
        this.numBooking = numBooking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
}
