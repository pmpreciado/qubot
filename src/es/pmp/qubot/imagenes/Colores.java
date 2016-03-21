/**
 * Colores.java
 *
 * Creado el 17-mar-2016, 19:51:19
 */

package es.pmp.qubot.imagenes;

import java.awt.Color;

/**
 * Colores usados por la aplicación.
 * 
 * @author pmpreciado
 */
public class Colores {
    
    /** Colores */
    public static final Color COLOR_NEGRO_FONDO_PREGUNTAS       = hex2Color("010001");
    public static final Color COLOR_BLANCO_FONDO_PREGUNTA       = hex2Color("ffffff");
    public static final Color COLOR_VERDE_ACIERTO               = hex2Color("037c46");
    public static final Color COLOR_ROJO_FALLO                  = hex2Color("9a3234");
    
    public static final Color COLOR_VERDE_REVANCHA              = COLOR_VERDE_ACIERTO;
    public static final Color COLOR_ROJO_OTRO_ADVERSARIO        = hex2Color("ff5557");
    public static final Color COLOR_CIAN_VER_RESULTADOS         = hex2Color("02b5db");
    
    public static final Color COLOR_SALMON_TEXTO_BOTON_JUGAR    = hex2Color("ff7879");
    
    public static final Color COLOR_NEGRO_FONDO_JUGAR           = hex2Color("242224");
    
    public static final Color COLOR_AZUL_MARCO_VYSOR            = hex2Color("468FCC");

    
    /** Máxima distancia permitida en cada uno de los tres componentes para que dos colores se consideren similares */
    public static final int MAX_DISTANCIA_COLORES_SIMILARES = 10;

  
    
    /**
     * Obtiene una cadena con la representación hexadecimal del color dado por sus componentes.
     *
     * @param r                             Componente rojo (0-255)
     * @param g                             Componente verde (0-255)
     * @param b                             Componente azul (0-255)
     *
     * @return                              Cadena generada (por ejemplo, "0F0A16"
     */
    public static String rgb2Hex(int r, int g, int b) {
        String s = "";

        String sr = Integer.toHexString(r);
        String sg = Integer.toHexString(g);
        String sb = Integer.toHexString(b);

        while (sr.length() < 2) sr = "0" + sr;
        while (sg.length() < 2) sg = "0" + sg;
        while (sb.length() < 2) sb = "0" + sb;

        s = sr + sg + sb;
        return s;
    }
    
    /**
     * Obtiene la representación hexadecimal RGB de un color dado.
     *
     * @param color                         Objeto de tipo Color
     *
     * @return                              Representación hexadecimal RGB del color, por ejemplo "0F0A16"
     */
    public static String color2Hex(Color color) {

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        String hex = rgb2Hex(r, g, b);
        return hex;
    }
    
    
    /**
     * Obtiene un color a partir de una cadena con su representación hexadecimal.
     *
     * @param color_hex_rgb                 Color hexadecimal RGB, por ejemplo "0F0A16"
     *
     * @return                              Objeto de tipo Color
     */
    public static Color hex2Color(String color_hex_rgb) {
            
        String r = color_hex_rgb.substring(0, 2);
        String g = color_hex_rgb.substring(2, 4);
        String b = color_hex_rgb.substring(4, 6);
        
        int i_r = Integer.parseInt(r, 16);
        int i_g = Integer.parseInt(g, 16);
        int i_b = Integer.parseInt(b, 16);
        
        Color c = new Color(i_r, i_g, i_b);
        return c;
    }

    
    /**
     * Compara si un color es igual o similar a otro dado.
     * 
     * @param color_1                           Primer color a comparar
     * @param color_2                           Segundo color a comparar
     * @param max_distancia                     Máxima distancia permitida en cada uno de los tres componentes (en valor absoluto, 0-255)
     * 
     * @return                                  'true' si los colores son iguales o se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(Color color_1, Color color_2, int max_distancia) {
        
        int r_1 = color_1.getRed();
        int g_1 = color_1.getGreen();
        int b_1 = color_1.getBlue();
        
        int r_2 = color_2.getRed();
        int g_2 = color_2.getGreen();
        int b_2 = color_2.getBlue();

        int dist_r = Math.abs(r_1 - r_2);
        int dist_g = Math.abs(g_1 - g_2);
        int dist_b = Math.abs(b_1 - b_2);
        
        if (dist_r > max_distancia || dist_g > max_distancia || dist_b > max_distancia) {
            return false;
        }
        
        return true;
    }
    
    
    /**
     * Compara si un color es igual o similar a otro dado.
     * 
     * @param color_1                           Primer color a comparar
     * @param color_2                           Segundo color a comparar
     * 
     * @return                                  'true' si los colores son iguales o se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(Color color_1, Color color_2) {
        int max_distancia = MAX_DISTANCIA_COLORES_SIMILARES;
        boolean similares = similares(color_1, color_2, max_distancia);
        return similares;
    }
    
}
