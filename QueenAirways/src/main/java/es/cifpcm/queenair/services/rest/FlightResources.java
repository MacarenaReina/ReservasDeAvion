/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.services.rest;

import es.cifpcm.queenair.connection.DaoFactory;
import es.cifpcm.queenair.pojos.Flight;
import es.cifpcm.queenair.pojos.GenericFlight;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author macar
 */
@Path("flights")
public class FlightResources {
    private final Logger LOGGER = LoggerFactory.getLogger(GenericFlightResources.class);
    private static List<Flight> flights;
    private static Flight flight;
    
    static {
        flights = new ArrayList<>();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Flight> get() {
        return flights;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public void select(GenericFlight gf) {
        flights = DaoFactory.getInstance().getFlightDao().find(gf);
    }
    
    @GET
    @Path("flight")
    @Produces({MediaType.APPLICATION_JSON})
    public Flight getFlight() {
        return flight;
    }
    
    @POST
    @Path("flight")
    @Produces({MediaType.APPLICATION_JSON})
    public void selectFlight(Flight f) {
        flight = DaoFactory.getInstance().getFlightDao().select(f);
    }
}
