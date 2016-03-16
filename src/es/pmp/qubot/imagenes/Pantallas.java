/**
 * Pantallas.java
 *
 * Creado el 16-mar-2016, 18:53:17
 */

package es.pmp.qubot.imagenes;

import java.awt.image.BufferedImage;

/**
 * Identificación de pantallas.
 * 
 * @author pmpreciado
 */
public class Pantallas {

    /** Tipos de pantallas */
    public static final int ID_PANTALLA_DESCONOCIDA                             = 0;
    public static final int ID_PANTALLA_PREGUNTA_NORMAL_SIN_CONTESTAR           = 1;
    public static final int ID_PANTALLA_PREGUNTA_LARGA_SIN_CONTESTAR            = 2;
    public static final int ID_PANTALLA_PREGUNTA_NORMAL_CONTESTADA              = 3;
    public static final int ID_PANTALLA_PREGUNTA_LARGA_CONTESTADA               = 4;
    public static final int ID_PANTALLA_REVANCHA                                = 5;
    
    

    
    /**
     * 
     * 
     * Comprueba si la pantalla es la de preguntas de tipo texto aún sin contestar.
     * 
     * @param imagen
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static int esPantallaPregutasTextoSinContestar(BufferedImage imagen) {
        return 0;
    }
    
    
    
    
    /**
     * Trata de identificar el tipo de pantalla suministrada en la imagen,
     * 
     * @param imagen                            Imagen con la pantalla
     * 
     * @return                                  Tipo de pantalla (Pantallas.ID_PANTALLA_xxx)
     */
    public static int identificarPantalla(BufferedImage imagen) {
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
              return 0;
    }
    
    
}
