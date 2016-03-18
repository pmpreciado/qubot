/**
 * CPuntosColor.java
 *
 * Creado el 17-mar-2016, 19:34:03
 */

package es.pmp.qubot.imagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para agrupar un conjunto de puntos de la imagen junto con los colores que deben tener.
 * 
 * @author pmpreciado
 */
public class CPuntosColor {
    
    List <CPunto> l_puntos;
    List <Color> l_colores;
    

    public Color color_actual;
    
    
    /**
     * Crea la instancia de la clase.
     */
    public CPuntosColor() {
        l_puntos = new ArrayList <> ();
        l_colores = new ArrayList <> ();
        color_actual = Color.BLACK;
    }
    
    /**
     * Crea la instancia de la clase.
     * Establece el color a utilizar, por omisión, a partir de ahora.
     * 
     * @param color
     */
    public CPuntosColor(Color color) {
        this();
        this.color_actual = color;
    }
    
    
    /**
     * Establece el color a utilizar, por omisión, a partir de ahora.
     * 
     * @param color
     */
    public void setColor(Color color) {
        this.color_actual = color;
    }
    
    /**
     * Añade un punto al conjunto.
     * El punto debe figurar en el color especificado.
     * 
     * @param punto                             Punto
     * @param color                             Color que debe tener el punto
     */
    public void addPunto(CPunto punto, Color color) {
        l_puntos.add(punto);
        l_colores.add(color);
        this.color_actual = color;
    }
    
    
    /**
     * Añade un punto al conjunto.
     * El punto debe figurar en el último color utilizado.
     * 
     * @param punto                             Punto
     */
    public void addPunto(CPunto punto) {
        this.addPunto(punto, color_actual);
    }
    
    
    /**
     * Añade un punto al conjunto.
     * El punto debe figurar en el último color utilizado.
     * 
     * @param x                                 Coordenada relativa X (%)
     * @param y                                 Coordenada relativa Y (%)
     */
    public void addPunto(double x, double y) {
        CPunto punto = new CPunto(x, y);
        this.addPunto(punto);
    }
    
    
    /**
     * Añade varios puntos en horizontal al conjunto, en intervalos de a 1.
     * El punto debe figurar en el último color utilizado.
     * 
     * @param x0                                Coordenada relativa X inicial (%)
     * @param x1                                Coordenada relativa X final (%)
     * @param y                                 Coordenada relativa Y (%)
     */
    public void addPuntosHorizontales(double x0, double x1, double y) {
        
        for (double x = x0; x < x1; x++) {
            addPunto(x, y);
        }
    }
    
    
    /**
     * Añade varios puntos en vertical al conjunto, en intervalos de a 1.
     * El punto debe figurar en el último color utilizado.
     * 
     * @param x                                 Coordenada relativa X (%)
     * @param y0                                Coordenada relativa Y inicial (%)
     * @param y1                                Coordenada relativa Y final (%)
     */
    public void addPuntosVerticales(double x, double y0, double y1) {
        
        for (double y = y0; y < y1; y++) {
            addPunto(x, y);
        }
    }
    
    
    /**
     * Añade varios puntos al conjunto.
     * Los puntos deben figurar en el color especificado.
     * 
     * @param l_puntos                          Puntos a añadir
     * @param color                             Color que deben tener los puntos
     */
    public void addPuntos(List <CPunto> l_puntos, Color color) {
        for (CPunto punto : l_puntos) {
            addPunto(punto, color);
        }
    }
    
    
    /**
     * Comprueba que, en la imagen dada, el punto dado tenga el color dado.
     * 
     * @param imagen                            Imagen
     * @param x_abs                             Coordenada X del punto absoluta
     * @param y_abs                             Coordenada Y del punto absoluta
     * @param color                             Color a comprobar
     * 
     * @return                                  'true' si el punto dado tiene el color dado
     *                                          'false' en caso contrario
     */
    public static boolean validarPunto(BufferedImage imagen, int x_abs, int y_abs, Color color) {
        
        int rgb = color.getRGB();
        int color_detectado = imagen.getRGB(x_abs, y_abs);
        
        if (rgb == color_detectado) {
            return true;
        }
        
        return false;
    }
    
    
    
    /**
     * Comprueba que, en la imagen dada, el punto dado tenga el color dado.
     * 
     * @param imagen                            Imagen
     * @param punto                             Punto a comprobar
     * @param color                             Color a comprobar
     * 
     * @return                                  'true' si el punto dado tiene el color dado
     *                                          'false' en caso contrario
     */
    public static boolean validarPunto(BufferedImage imagen, CPunto punto, Color color) {
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        int x_abs = CPunto.getCoordAbs(punto.x, ancho);
        int y_abs = CPunto.getCoordAbs(punto.y, alto);
        boolean punto_tiene_color = validarPunto(imagen, x_abs, y_abs, color);
        
        return punto_tiene_color;
    }
    
//    
//    /**
//     * Comprueba que, en la imagen dada, los puntos dados tengan el color dado.
//     * 
//     * @param imagen                            Imagen
//     * @param l_puntos                          Puntos a comprobar
//     * @param color                             Color a comprobar
//     * 
//     * @return                                  'true' si el punto dado tiene el color dado
//     *                                          'false' en caso contrario
//     */
//    public static boolean puntosTienenColor(BufferedImage imagen, List <CPunto> l_puntos, Color color) {
//        
//        int ancho = imagen.getWidth();
//        int alto = imagen.getHeight();
//
//        for (CPunto punto : l_puntos) {
//            int x_abs = CPunto.getCoordAbs(punto.x, ancho);
//            int y_abs = CPunto.getCoordAbs(punto.y, alto);
//            
//            boolean punto_tiene_color = puntoTieneColor(imagen, x_abs, y_abs, color);
//            if (!punto_tiene_color) {
//                return false;
//            }
//        }
//        
//        return true;
//    }
    
    
    
    /**
     * Comprueba que los puntos de la instancia tengan sus colores asignados.
     * 
     * @param imagen                            Imagen
     * 
     * @return                                  'true' si los puntos de la instancia tienen sus colores asignados
     *                                          'false' en caso contrario
     */
    public boolean validar(BufferedImage imagen) {
        
        for (int i = 0; i < l_puntos.size(); i++) {
            CPunto punto = l_puntos.get(i);
            Color color = l_colores.get(i);
            
            boolean punto_validado = validarPunto(imagen, punto, color);
            if (!punto_validado) {
                return false;
            }
        }
        
        return true;
    }
}
