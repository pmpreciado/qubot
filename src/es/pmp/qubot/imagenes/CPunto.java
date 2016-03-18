/**
 * CPunto.java
 *
 * Creado el 16-mar-2016, 17:19:17
 */

package es.pmp.qubot.imagenes;

/**
 * Define un punto.
 * 
 * @author pmpreciado
 */
public class CPunto {
    
    public double x;
    public double y;
    
    
    /**
     * Crea un nuevo punto.
     * 
     * @param x
     * @param y
     */
    public CPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Crea un nuevo punto a partir del punto dado.
     * 
     * @param punto
     */
    public CPunto(CPunto punto) {
        this(punto.x, punto.y);
    }
    
    
    /**
     * Obtiene la coordenada absoluta a partir de la coordenada relativa (en %) y la dimensión de la imagen (ancho o alto).
     * 
     * @param coordenada_relativa               Coordenada relativa X o Y (en %)
     * @param dimension_imagen                  Ancho o alto de la imagen
     * 
     * @return                                  Coordenada absoluta
     */
    public static int getCoordAbs(double coordenada_relativa, int dimension_imagen) {
        double f_coordenada_absoluta = coordenada_relativa * (double) dimension_imagen / (double) 100;
        int coordenada_absoluta = (int) f_coordenada_absoluta;
        return coordenada_absoluta;
    }
    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = "x: " + x + ", y: " + y;
        return s;
    }
}
