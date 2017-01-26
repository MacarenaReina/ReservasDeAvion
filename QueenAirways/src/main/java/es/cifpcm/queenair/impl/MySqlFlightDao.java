/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.impl;

import es.cifpcm.queenair.connection.DaoFactory;
import es.cifpcm.queenair.interfaces.FlightDao;
import es.cifpcm.queenair.pojos.Flight;
import es.cifpcm.queenair.pojos.GenericFlight;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macar
 */
public class MySqlFlightDao implements FlightDao {

    public MySqlFlightDao(DaoFactory aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Flight> find(GenericFlight genericFlight) {
        List<Flight> flights = new ArrayList<>();
        return flights;
    }
    
}
