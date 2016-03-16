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
