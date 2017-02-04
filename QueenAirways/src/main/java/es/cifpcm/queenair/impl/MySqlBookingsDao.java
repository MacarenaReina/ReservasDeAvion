/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.impl;

import es.cifpcm.queenair.connection.ConnectionProvider;
import es.cifpcm.queenair.interfaces.BookingsDao;
import es.cifpcm.queenair.pojos.Bookings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author macar
 */
public class MySqlBookingsDao implements BookingsDao {
    
    ConnectionProvider provider;
    Connection con;
    
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlGenericFlightDao.class);
    
    public MySqlBookingsDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.con = provider.getConnection();
    }

    @Override
    public Bookings insert(Bookings booking) {
        String query = "INSERT INTO bookings (name, surname, phone, credit_card, amount, flight) VALUES (?,?,?,?,?,?)";
        
        try(PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, booking.getName());
            st.setString(2, booking.getSurname());
            st.setString(3, booking.getPhone());
            st.setString(4, booking.getCreditCard());
            st.setFloat(5, booking.getAmount());
            st.setInt(6, booking.getFlight().getGenericFlight().getFlightNumber());
            
            int resul = st.executeUpdate();
            if(resul == 0) {
                booking = null;
            }
        } catch (SQLException ex) {
            LOGGER.error("****** Error al insertar la reserva --> "+ex+" ******");
            booking = null;
        }
        
        return booking;
    }
    
}
