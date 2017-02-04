/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.services.rest;

import es.cifpcm.queenair.connection.DaoFactory;
import es.cifpcm.queenair.pojos.Bookings;
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
@Path("bookings")
public class BookingResources {
    private final Logger LOGGER = LoggerFactory.getLogger(GenericFlightResources.class);
    private static Bookings booking;
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Bookings insert(Bookings b) {
        return DaoFactory.getInstance().getBookingsDao().insert(b);
    }
}
