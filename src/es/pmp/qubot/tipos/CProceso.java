/**
 * CProceso.java
 *
 * Creado el 15-mar-2016, 11:52:11
 */

package es.pmp.qubot.tipos;

import com.sun.jna.platform.win32.WinDef.HWND;
import es.pmp.qubot.Comun;
import java.awt.Rectangle;

/**
 * Proceso de Windows.
 * 
 * @author pmpreciado
 */
public class CProceso {
    
    public int id_proceso;
    public HWND hwnd;
    public String nombre_ventana;
    
    int x0;
    int y0;
    int x1;
    int y1;

    
    public CProceso(int id_proceso, HWND hwnd, String nombre_ventana) {
        this.id_proceso = id_proceso;
        this.nombre_ventana = nombre_ventana;
        this.hwnd = hwnd;
    }
    
    public void setPosicion(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public void setPosicion(int [] rect) {
        int c = 0;
        this.x0 = rect[c++];
        this.y0 = rect[c++];
        this.x1 = rect[c++];
        this.y1 = rect[c++];
    }
    
    public int getAncho() {
        int ancho = x1 - x0;
        return ancho;
    }
    
    public int getAlto() {
        int ancho = y1 - y0;
        return ancho;
    }

    public String getPosicionS() {
        int ancho = getAncho();
        int alto = getAlto();
        
        String s = "Ancho: " + ancho + ", Alto: " + alto + ", x0: " + x0 + ", y0: " + y0 + ", x1: " + x1 + ", y1: " + y1;
        return s;
    }

    /**
     * Obtiene el rectángulo de la ventana.
     * 
     * @return 
     */
    public Rectangle getRectangle() {
        Rectangle r = new Rectangle(x0, y0, getAncho(), getAlto());
        return r;
    }
    
    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        
        
        
        String s = "";
        s += "Id. proceso: " + id_proceso + Comun.NL;
        s += "Handle ventana: " + hwnd.toString() + Comun.NL;
        s += "Nombre ventana: " + nombre_ventana + Comun.NL;
        s += "Posición: " + getPosicionS() + Comun.NL;
        return s;
    }
    
    
}
