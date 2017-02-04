/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.interfaces;

import es.cifpcm.queenair.pojos.Airline;
import java.util.List;

/**
 *
 * @author macar
 */
public interface AirlineDao {
    List<Airline> selectAll();
}
