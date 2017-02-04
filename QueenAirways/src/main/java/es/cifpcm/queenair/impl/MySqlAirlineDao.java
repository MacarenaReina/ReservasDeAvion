/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.impl;

import es.cifpcm.queenair.connection.ConnectionProvider;
import es.cifpcm.queenair.interfaces.AirlineDao;
import es.cifpcm.queenair.pojos.Airline;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author macar
 */
public class MySqlAirlineDao implements AirlineDao {
    
    ConnectionProvider provider;
    Connection con;
    
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlGenericFlightDao.class);
    
    public MySqlAirlineDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.con = provider.getConnection();
    }
    
    @Override
    public List<Airline> selectAll() {
        List<Airline> airlines = new ArrayList<>();
        
        String query = "SELECT id, name FROM airline";
        
        try(Statement st = con.createStatement()) {
            try(ResultSet rs = st.executeQuery(query)) {
                while(rs.next()) {
                    Airline a = new Airline();
                    a.setId(rs.getString(1));
                    a.setName(rs.getString(2));

                    airlines.add(a);
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("****** Error al hacer la consulta de aerolíneas --> "+ex+" ******");
            airlines = null;
        }
        
        return airlines;
    }
    
}
