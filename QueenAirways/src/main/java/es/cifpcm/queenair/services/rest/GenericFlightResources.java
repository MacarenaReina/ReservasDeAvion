/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.services.rest;

import es.cifpcm.queenair.connection.DaoFactory;
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
@Path("genericFlights")
public class GenericFlightResources {
    private final Logger LOGGER = LoggerFactory.getLogger(GenericFlightResources.class);
    private static List<GenericFlight> genericFlights;
    
    static {
        genericFlights = new ArrayList<>();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<GenericFlight> get() {
        return genericFlights;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public void select(GenericFlight gf) {
        genericFlights = DaoFactory.getInstance().getGenericFlightDao().find(gf);
    }
    
    
}
