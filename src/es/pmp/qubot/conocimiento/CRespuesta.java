/**
 * CRespuesta.java
 *
 * Creado el 21-mar-2016, 11:39:02
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.Comun;
import es.pmp.qubot.imagenes.Imagenes;
import java.awt.image.BufferedImage;

/**
 *
 * @author pmpreciado
 */
public class CRespuesta {

    private static final String SEP = "|";
    
    /** Máxima diferencia permitida para que identificadores de preguntas se consideren similares (%) */
    public static final int MAX_DISTANCIA_ID_SIMILARES = 5;

    /** Umbral para considerar un píxel negro */
    public static final double UMBRAL_NEGRO = 10;

    
    
    BufferedImage imagen;
    
    
    
    /**
     * Identificador único para la respuesta. Es una cadena con este formato:
     *      PB0|PN0|PB1|PN1
     * 
     *      PB0: Suma de píxeles blancos mitad izquierda
     *      PN0: Suma de píxeles negros mitad izquierda
     *      PB1: Suma de píxeles blancos mitad derecha
     *      PN1: Suma de píxeles negros mitad derecha
     */
    String id_unico;
    
    
    
    /**
     * Crea una instancia de la clase.
     * 
     * @param imagen 
     */
    public CRespuesta(BufferedImage imagen) {
        id_unico = generarIdUnico(imagen);
        this.imagen = imagen;
    }

    
    /**
     * Genera un identificador único para la pregunta.
     * 
     * @param imagen                            Imagen de la pregunta
     * 
     * @return                                  Identificador único
     */
    public static String generarIdUnico(BufferedImage imagen) {        
        int [] bn = Imagenes.getSumaBnDobleVertical(imagen, UMBRAL_NEGRO);
        
        String id = bn[0] + SEP + bn[1] + SEP + bn[2] + SEP + bn[3];
        return id;
    }
    

    /**
     * Obtiene el identificador único para la pregunta.
     * 
     * @return                                  Identificador único para la pregunta
     */
    public String getIdUnico() {
        return id_unico;
    }

    
    /**
     * Obtiene la suma de píxeles blancos y negros a partir del identificador único.
     * 
     * @param id_unico
     * 
     * @return 
     */
    public static int [] getBn(String id_unico) {
        String [] sp = id_unico.split(SEP);
        int b0 = Integer.parseInt(sp[0]);
        int n0 = Integer.parseInt(sp[1]);
        int b1 = Integer.parseInt(sp[2]);
        int n1 = Integer.parseInt(sp[3]);
        
        int [] result = {b0, n0, b1, n1};
        return result;
    }
    
    
    
    /**
     * Compara dos identificadores únicos de preguntas.
     * 
     * @param id_unico_1
     * @param id_unico_2
     * @param max_distancia                     Máxima distancia permitida en cada uno de los tres componentes (en %, de 0 a 100)
     * 
     * @return                                  'true' si los identificadores se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean idSimilares(String id_unico_1, String id_unico_2, int max_distancia) {
        
        int [] bn_1 = getBn(id_unico_1);
        int [] bn_2 = getBn(id_unico_2);
        boolean bn_similares = Comun.similares(bn_1, bn_2, max_distancia);
        if (!bn_similares) {
            return false;
        } 

        return true;
    }

    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = "id_unico: " + id_unico;
        return s;
    }
}
