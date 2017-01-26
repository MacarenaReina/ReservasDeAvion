/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.interfaces;

import es.cifpcm.queenair.pojos.Flight;
import es.cifpcm.queenair.pojos.GenericFlight;
import java.util.List;

/**
 *
 * @author macar
 */
public interface FlightDao {
    List<Flight> find(GenericFlight genericFlight);
}
