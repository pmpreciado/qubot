/**
 * Pantallas.java
 *
 * Creado el 15-mar-2016, 18:32:00
 */

package es.pmp.qubot.imagenes;

import es.pmp.qubot.Comun;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Identificación de pantallas
 * 
 * @author pmpreciado
 */
public class Pantallas {

    /** Tipos de pantallas */
    public static final int ID_PANTALLA_DESCONOCIDA                 = 0;
    public static final int ID_PANTALLA_PREGUNTAS_TEXTO             = 1;
    public static final int ID_PANTALLA_PREGUNTAS_TEXTO_E_IMAGENES  = 2;
    
    /** Coordenadas de las pantallas (en %) */
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_1_X = 50;
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_1_Y = 100;
    
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_2_X = 10;
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_2_Y = 150;

    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_3_X = 10;
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_3_Y = 200;

    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_4_X = 10;
    private static final int COORD_PREGUNTAS_TEXTO_INICIO_RESP_4_Y = 250;

    
    /** Colores */
    private static final String COLOR_RGB_NEGRO_FONDO               = "010001";
    private static final String COLOR_RGB_BLANCO_FONDO_PREGUNTA     = "ffffff";

    private static final String COLOR_RGB_AZUL_MARCO_VYSOR          = "468FCC";
    
    
    private void test(BufferedImage imagen) {
    }
    
    
    /**
     * Obtiene la coordenada absoluta a partir de la coordenada relativa (en %) y la dimensión de la imagen (ancho o alto).
     * 
     * @param coordenada_relativa               Coordenada relativa X o Y (en %)
     * @param dimension_imagen                  Ancho o alto de la imagen
     * 
     * @return                                  Coordenada absoluta
     */
    private static int getCoord(int coordenada_relativa, int dimension_imagen) {
        float f_coordenada_absoluta = (float) coordenada_relativa * (float) dimension_imagen / (float) 100;
        int coordenada_absoluta = (int) f_coordenada_absoluta;
        return coordenada_absoluta;
    }
    
    
    
    /**
     * Trata de identificar el tipo de pantalla suministrada en la imagen,
     * 
     * @param imagen                            Imagen con la pantalla
     * 
     * @return                                  Tipo de pantalla (Pantallas.ID_PANTALLA_xxx)
     */
    public static int identificarPantalla(BufferedImage imagen) {
        
        Color color_naranja = Color.ORANGE;
        
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        for (int x = 0; x < 100; x+=4) {
            
            int abs_x = getCoord(x, ancho);
            
            System.out.println(Comun.NL);
            System.out.println("absx: " + abs_x + ", x: " + x);
            System.out.println(Comun.NL);
            
            for (int y = 0; y < 100; y+=1) {
                int abs_y = getCoord(y, alto);

                int rgb = imagen.getRGB(x, y);
                Color color = new Color(rgb);
                String hex_color = Imagen.color2Hex(color);

                String s = "absx: " + abs_x + ", absy: " + abs_y + ", x: " + x + ", y: " + y +", rgb: " + hex_color;
                System.out.println(s);
                
                
                    imagen.setRGB(abs_x, abs_y, color_naranja.getRGB());
                
            }
            
        }
imagen.flush();
        return 0;
    }
    
}
