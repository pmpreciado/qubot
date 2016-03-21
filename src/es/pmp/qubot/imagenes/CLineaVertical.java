/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pmp.qubot.imagenes;

/**
 * Define una línea vertical.
 * 
 * @author pmpreciado
 */
public class CLineaVertical {

    /** Coordenadas relativas */
    public double x;
    public double y0;
    public double y1;
    
    
    
    /**
     * Crea una nueva línea.
     * 
     * @param x                                 Coordenada X
     * @param y0                                Coordenada Y superior
     * @param y1                                Coordenada Y inferior
     */
    public CLineaVertical(double x, double y0, double y1) {
        this.x = x;
        this.y0 = y0;
        this.y1 = y1;
    }
    
    
    /**
     * Obtiene el alto de la línea.
     * 
     * @return 
     */
    public double getAlto() {
        double alto = y1 - y0;
        return alto;
    }


    /**
     * Obtiene los puntos correspondientes a los dos extremos de la línea.
     * 
     * @return
     */
    public CPunto [] getExtremos() {
        
        CPunto punto_superior = new CPunto(x, y0);
        CPunto punto_inferior = new CPunto(x, y1);
        
        CPunto [] arr_puntos = {
            punto_superior,
            punto_inferior
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
        String s = "x: " + x + ", y0: " + y0 + ", y1: "+ y1;
        return s;
    }
    
}
