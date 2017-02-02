/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.impl;

import es.cifpcm.queenair.connection.ConnectionProvider;
import es.cifpcm.queenair.interfaces.FlightDao;
import es.cifpcm.queenair.pojos.Flight;
import es.cifpcm.queenair.pojos.GenericFlight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author macar
 */
public class MySqlFlightDao implements FlightDao {
    
    ConnectionProvider provider;
    Connection con;
    
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlGenericFlightDao.class);

    public MySqlFlightDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.con = provider.getConnection();
    }

    @Override
    public List<Flight> find(GenericFlight genericFlight) {
        List<Flight> flights = new ArrayList<>();
        
        String query = "SELECT f.day, gf.flight_number, gf.price "
                     + "FROM flight f INNER JOIN generic_flight gf ON f.generic_flight = gf.flight_number "
                     + "WHERE gf.departure_hour = ? AND gf.arrival_hour = ? AND gf.origin = ? AND gf.destination = ? AND gf.airline = ? AND gf.price = ? AND f.free_places > 0";
        
        try(PreparedStatement st = con.prepareStatement(query)) {
            st.setTime(1, genericFlight.getDepartureHour());
            st.setTime(2, genericFlight.getArrivalHour());
            st.setString(3, genericFlight.getOrigin().getId());
            st.setString(4, genericFlight.getDestination().getId());
            st.setString(5, genericFlight.getAirline().getId());
            st.setInt(6, genericFlight.getPrice());
            
            try(ResultSet rs = st.executeQuery()) {
                while(rs.next()) {
                    Flight f = new Flight();
                    f.setDay(rs.getDate(1));
                    
                    GenericFlight gf = new GenericFlight();
                    gf.setFlightNumber(rs.getInt(2));
                    gf.setPrice(rs.getInt(3));
                    f.setGenericFlight(gf);
                    
                    flights.add(f);
                }
            }            
        } catch(SQLException ex) {
            LOGGER.error("****** Error al hacer la consulta de fechas del vuelo genérico seleccionado --> "+ex+" ******");
            flights = null;
        }
        
        return flights;
    }
    
    @Override
    public Flight select(Flight flight) {
        String query = "SELECT f.day, gf.flight_number, gf.price "
                     + "FROM flight f INNER JOIN generic_flight gf ON f.generic_flight = gf.flight_number "
                     + "WHERE gf.flight_number = ? LIMIT 1";
        
        try(PreparedStatement st = con.prepareStatement(query)) {
            st.setInt(1, flight.getGenericFlight().getFlightNumber());
            
            try(ResultSet rs = st.executeQuery()) {
                if(rs.next()) {
                    flight.setDay(rs.getDate(1));
                    
                    GenericFlight gf = new GenericFlight();
                    gf.setFlightNumber(rs.getInt(2));
                    gf.setPrice(rs.getInt(3));
                    
                    flight.setGenericFlight(gf);
                }
            }
            
        } catch (SQLException ex) {
            LOGGER.error("****** Error al hacer la consulta del vuelo final --> "+ex+" ******");
            flight = null;
        }
        
        return flight;
    }
}
