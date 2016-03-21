/**
 * CRectangulo.java
 *
 * Creado el 16-mar-2016, 17:17:58
 */

package es.pmp.qubot.imagenes;

import java.awt.Rectangle;
import java.util.Random;

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
    
    Random random;
    
    
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
        
        random = new Random();
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
     * Crea un nuevo rectángulo.
     * 
     * @param r                                 Objeto de tipo rectangle
     */
    public CRectangulo(Rectangle r) {
        this.x0 = r.x;
        this.y0 = r.y;
        this.x1 = r.x + r.width;
        this.y1 = r.y + r.width;
        
        random = new Random();
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
     * Obtiene las coordenadas del centro del rectángulo.
     * 
     * @return                                  Coordenadas del centro del rectángulo
     */
    public CPunto getCentro() {
        double x = (x1 - x0) / 2;
        double y = (y1 - y0) / 2;
        
        CPunto punto_centro = new CPunto(x, y);
        return punto_centro;
    }
    
    
    /**
     * Genera un número aleatorio, entre un mínimo y un máximo, siguiendo una distribución normal (gaussiana).
     * Es más probable que el número se ubique en posiciones centrales.
     * 
     * @param min                               Mínimo valor permitido
     * @param max                               Máximo valor permitido
     * 
     * @return                                  Número aleatorio entre el mínimo y el máximo
     */
    public double getRandomGauss(double min, double max) {
        double desviacion_tipica = (max - min) / 4;
        double offset = (max - min) / 2;
        
        double r = -999999;
        while (r < min || r > max) {
            r = random.nextGaussian() * desviacion_tipica + min + offset;
        }

        return r;
    }

    
    /**
     * Obtiene una coordenada al azar dentro del rectángulo.
     * Es más problable que la coordenada esté próxima al centro.
     * 
     * @return                                  Coordenada al azar dentro del rectángulo
     */
    public CPunto getPuntoInterno() {
        double r_x = getRandomGauss(this.x0, this.x1);
        double r_y = getRandomGauss(this.y0, this.y1);
        CPunto punto_interno = new CPunto(r_x, r_y);
        return punto_interno;
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
