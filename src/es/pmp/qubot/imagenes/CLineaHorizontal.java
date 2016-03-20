/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pmp.qubot.imagenes;

/**
 * Define una línea horizontal.
 * 
 * @author pmpreciado
 */
public class CLineaHorizontal {

    /** Coordenadas relativas */
    public double x0;
    public double x1;
    public double y;
    
    
    
    /**
     * Crea una nueva línea.
     * 
     * @param x0                                Coordenada X izquierda
     * @param x1                                Coordenada X derecha
     * @param y                                 Coordenada Y
     */
    public CLineaHorizontal(double x0, double x1, double y) {
        this.x0 = x0;
        this.x1 = x1;
        this.y = y;
    }
    
    
    /**
     * Obtiene el ancho de la línea.
     * 
     * @return 
     */
    public double getAncho() {
        double ancho = x1 - x0;
        return ancho;
    }


    /**
     * Obtiene los puntos correspondientes a los dos extremos de la línea.
     * 
     * @return
     */
    public CPunto [] getExtremos() {
        
        CPunto punto_izquierdo = new CPunto(x0, y);
        CPunto punto_derecho = new CPunto(x1, y);
        
        CPunto [] arr_puntos = {
            punto_izquierdo,
            punto_derecho
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
        String s = "x0: " + x0 + ", x1: " + x1 + ", y: "+ y;
        return s;
    }
    
}
