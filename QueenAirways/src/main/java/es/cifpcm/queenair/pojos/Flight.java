/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author macar
 */
public class Flight implements Serializable {
    private Date day;
    private Integer freePlaces;
    private GenericFlight genericFlight; //Es la clave primaria

    public Flight() {
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    public GenericFlight getGenericFlight() {
        return genericFlight;
    }

    public void setGenericFlight(GenericFlight genericFlight) {
        this.genericFlight = genericFlight;
    }
    
}
