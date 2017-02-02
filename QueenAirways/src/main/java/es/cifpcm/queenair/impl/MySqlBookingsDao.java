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

/**
 *
 * @author macar
 */
public class MySqlBookingsDao implements BookingsDao {
    
    ConnectionProvider provider;
    Connection con;
    
    public MySqlBookingsDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.con = provider.getConnection();
    }

    @Override
    public void insert(Bookings booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
