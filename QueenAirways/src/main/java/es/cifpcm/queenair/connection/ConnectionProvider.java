/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.connection;

import java.sql.Connection;

/**
 *
 * @author macar
 */
public interface ConnectionProvider {
    Connection getConnection();
    void closeConnection(Connection con);
}
