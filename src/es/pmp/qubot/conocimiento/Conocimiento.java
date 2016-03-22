/**
 * Conocimiento.java
 *
 * Creado el 22-mar-2016, 15:05:40
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.Comun;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestión del conocimiento adquirido.
 * 
 * @author pmpreciado
 */
public class Conocimiento {

    
    
    List <CPreguntaYRespuestas> l_preguntas_y_respuestas;
    
    
    /**
     * Crea la instancia de la clase.
     */
    public Conocimiento() {
        l_preguntas_y_respuestas = new ArrayList <> ();
    }
    
    
    /**
     * Carga la base de conocimiento.
     */
    public void loadConocimiento() {
        String ruta_fichero = Comun.RUTA_FICHERO_CONOCIMIENTO;
        
    }
    
    
    
    
    
}
