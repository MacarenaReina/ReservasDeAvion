/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.connection;

import es.cifpcm.queenair.impl.MySqlAirlineDao;
import es.cifpcm.queenair.impl.MySqlBookingsDao;
import es.cifpcm.queenair.impl.MySqlFlightDao;
import es.cifpcm.queenair.impl.MySqlGenericFlightDao;
import es.cifpcm.queenair.interfaces.AirlineDao;
import es.cifpcm.queenair.interfaces.BookingsDao;
import es.cifpcm.queenair.interfaces.FlightDao;
import es.cifpcm.queenair.interfaces.GenericFlightDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author macar
 */
public class DaoFactory implements ConnectionProvider {
    private InitialContext ctx;
    private DataSource ds;

    private static DaoFactory instance;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);
    
    private DaoFactory() {
        try {
            this.ctx = new InitialContext();
            LOGGER.debug("Pidiendo datasource jdbc/BookingFlights");
            this.ds = (DataSource) ctx.lookup("jdbc/BookingFlights");
            
        } catch (NamingException ex) {
            LOGGER.error("Error al buscar el recurso JDBC ---> DaoFactory", ex);
        }
    }
    
    public static synchronized DaoFactory getInstance() {
        if (instance == null)
            instance =  new DaoFactory();
        
        return instance;
    }
    
    public BookingsDao getBookingsDao() {
        return new MySqlBookingsDao(this);
    }
    
    public FlightDao getFlightDao() {
        return new MySqlFlightDao(this);
    }
    
    public GenericFlightDao getGenericFlightDao() {
        return new MySqlGenericFlightDao(this);
    }
    
    public AirlineDao getAirlineDao() {
        return new MySqlAirlineDao(this);
    }

    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Error al obtener la conexión ---> DaoFactory", ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                LOGGER.error("Error al cerrar la conexión ---> DaoFactory", ex);
            }
        }
    }
    
}
