/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.queenair.languages;

import es.cifpcm.queenair.services.rest.GenericFlightResources;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
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
@Path("languages")
public class LanguageResources {
    private final Logger LOGGER = LoggerFactory.getLogger(GenericFlightResources.class);
    private static List<Language> ids;
    
    static {
        ids = new ArrayList<>();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Language> get() {
        return ids;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public void insert(List<Language> elements) {
        ResourceBundle rb = ResourceBundle.getBundle("Message_Bundle", new Locale("es", "ES"));
//        ResourceBundle rb = ResourceBundle.getBundle("Message_Bundle", new Locale("en", "UK"));
//        ResourceBundle rb = ResourceBundle.getBundle("Message_Bundle", new Locale("fr", "FR"));
        
        for(int i=0;i<elements.size();i++) {
            String key = elements.get(i).getKey();
            String value = rb.getString(key);
            
            Language l = new Language();
            l.setKey(key);
            l.setValue(value);
            
            ids.add(l);
        }
    }
}
