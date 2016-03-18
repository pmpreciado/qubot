/**
 * CRectangulo.java
 *
 * Creado el 16-mar-2016, 17:17:58
 */

package es.pmp.qubot.imagenes;

/**
 * Define un rectángulo.
 * 
 * @author pmpreciado
 */
public class CRectangulo {

    /** Coordenadas relativas (%) de la esquina superior izquierda */
    public double x0;
    public double y0;
    
    /** Coordenadas relativas (%) de la esquina inferior derecha (%) */
    public double x1;
    public double y1;
    
    
    /**
     * Crea un nuevo rectángulo.
     * 
     * @param x0                                Coordenada X de la esquina superior izquierda
     * @param y0                                Coordenada Y de la esquina superior izquierda
     * @param x1                                Coordenada X de la esquina inferior derecha
     * @param y1                                Coordenada Y de la esquina inferior derecha
     */
    public CRectangulo(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }
    
    
    /**
     * Crea un nuevo rectángulo.
     * 
     * @param esquina_si                        Punto de la esquina superior izquierda
     * @param esquina_id                        Punto de la esquina inferior derecha
     */
    public CRectangulo(CPunto esquina_si, CPunto esquina_id) {
        this(esquina_si.x, esquina_si.y, esquina_id.x, esquina_si.y);
    }

    
    /**
     * Obtiene el ancho del rectángulo.
     * 
     * @return 
     */
    public double getAncho() {
        double ancho = x1 - x0;
        return ancho;
    }
    
    
    /**
     * Obtiene el alto del rectángulo.
     * 
     * @return 
     */
    public double getAlto() {
        double alto = y1 - y0;
        return alto;
    }


    /**
     * Obtiene los puntos correspondientes a las cuatro esquinas del rectángulos.
     * 
     * @return
     */
    public CPunto [] getEsquinas() {
        
        CPunto punto_si = new CPunto(x0, y0);
        CPunto punto_sd = new CPunto(x1, y0);
        CPunto punto_ii = new CPunto(x0, y1);
        CPunto punto_id = new CPunto(x1, y1);
        
        CPunto [] arr_puntos = {
            punto_si,
            punto_sd,
            punto_ii,
            punto_id
        };
        
        return arr_puntos;
    }
    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = "x0: " + x0 + ", y0: " + y0 + ", x1: " + x1 + ", y1: "+ y1;
        return s;
    }
    
}
