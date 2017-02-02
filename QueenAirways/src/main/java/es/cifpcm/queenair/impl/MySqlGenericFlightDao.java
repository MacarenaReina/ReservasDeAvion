/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.impl;

import es.cifpcm.queenair.connection.ConnectionProvider;
import es.cifpcm.queenair.connection.DaoFactory;
import es.cifpcm.queenair.interfaces.GenericFlightDao;
import es.cifpcm.queenair.pojos.Airline;
import es.cifpcm.queenair.pojos.Airport;
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
public class MySqlGenericFlightDao implements GenericFlightDao {
    
    ConnectionProvider provider;
    Connection con;
    
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlGenericFlightDao.class);
    
    public MySqlGenericFlightDao(DaoFactory aThis) {
        this.provider = aThis;
        this.con = provider.getConnection();
    }
    
    @Override
    public List<GenericFlight> find(GenericFlight genericFlight) {
        List<GenericFlight> genericFlights = new ArrayList<>();
        
        String query = "SELECT gf.flight_number, gf.departure_hour, gf.arrival_hour, gf.price, gf.origin, gf.destination, a.name "
                     + "FROM generic_flight gf INNER JOIN airline a ON gf.airline = a.id INNER JOIN flight f ON f.generic_flight = gf.flight_number "
                     + "WHERE gf.departure_hour = ? AND gf.arrival_hour = ? AND gf.airline = ? AND gf.price <= ? AND f.free_places > 0";
        
        try(PreparedStatement st = con.prepareStatement(query)) {
            st.setTime(1, genericFlight.getDepartureHour());
            st.setTime(2, genericFlight.getArrivalHour());
            st.setString(3, genericFlight.getAirline().getId());
            st.setInt(4, genericFlight.getPrice());
            
            try(ResultSet rs = st.executeQuery()) {
                while(rs.next()) {
                    GenericFlight gf = new GenericFlight();
                    gf.setFlightNumber(rs.getInt(1));
                    gf.setDepartureHour(rs.getTime(2));
                    gf.setArrivalHour(rs.getTime(3));
                    gf.setPrice(rs.getInt(4));
                    
                    Airport origin = new Airport();
                    origin.setId(rs.getString(5));
                    gf.setOrigin(origin);
                    
                    Airport destination = new Airport();
                    destination.setId(rs.getString(6));
                    gf.setDestination(destination);
                    
                    Airline airline = new Airline();
                    airline.setName(rs.getString(7));
                    gf.setAirline(airline);
                    
                    genericFlights.add(gf);
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("****** Error al hacer la consulta de vuelos genéricos --> "+ex+" ******");
            genericFlights = null;
        }
        
        return genericFlights;
    }
    
}
