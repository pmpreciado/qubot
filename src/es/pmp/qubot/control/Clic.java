/**
 * Clic.java
 *
 * Creado el 21-mar-2016, 9:26:47
 */

package es.pmp.qubot.control;

import es.pmp.qubot.imagenes.CPunto;
import es.pmp.qubot.imagenes.CRectangulo;
import es.pmp.qubot.tipos.CProceso;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

/**
 * Funciones para simular pulsaciones sobre la ventana controlada.
 * 
 * @author pmpreciado
 */
public class Clic {

//    /** Coordenadas de la ventana controlada */
//    int host_x;
//    int host_y;
//    int host_ancho;
//    int host_alto;

    /** Retardo entre pulsar y liberar la pulsación */
    public static final int MIN_DELAY_MOUSE_CLIC = 50;
    public static final int MAX_DELAY_MOUSE_CLIC = 200;

    Random random;
    
    
    /**
     * Crea la instancia de la clase.
     */
    public Clic() {
        random = new Random();
    }
    
    

    /**
     * Obtiene un retardo al azar, entre dos valores dados.
     * 
     * @param min_delay                         Retardo mínimo, en milisegundos
     * @param max_delay                         Retardo máximo, en milisegundos
     * 
     * @return                                  Retardo comprendido entre el mínimo y el máximo
     */
    public int getDelay(int min_delay, int max_delay) {
        int dif = max_delay - min_delay;
        int delay = random.nextInt(dif) + min_delay;
        return delay;
    }
    
    
    /**
     * Obtiene la coordenada X absoluta para un punto relativo al proceso vysor.
     * 
     * @param proceso_vysor                     Proceso visor
     * @param x_rel                             Coordenada X relativa al proceso
     * 
     * @return                                  Coordenada X absoluta
     */
    public int getCoordXAbs(CProceso proceso_vysor, double x_rel) {
        Rectangle rect = proceso_vysor.getRectangle();
        int x_abs = CPunto.getCoordAbs(x_rel, (int) rect.getWidth());
        x_abs += rect.x;
        
        return x_abs;
    }
    
    
    /**
     * Obtiene la coordenada Y absoluta para un punto relativo al proceso vysor.
     * 
     * @param proceso_vysor                     Proceso visor
     * @param y_rel                             Coordenada Y relativa al proceso
     * 
     * @return                                  Coordenada Y absoluta
     */
    public int getCoordYAbs(CProceso proceso_vysor, double y_rel) {
        Rectangle rect = proceso_vysor.getRectangle();
        int y_abs = CPunto.getCoordAbs(y_rel, (int) rect.getHeight());
        y_abs += rect.y;
        
        return y_abs;
    }
    
    
    
    /**
     * Envía un clic de ratón.
     * 
     * @param proceso_vysor                     Proceso vysor
     * @param x_rel                             Coordenadas X donde hacer el clic, relativa a la pantalla del vysor (%)
     * @param y_rel                             Coordenadas Y donde hacer el clic, relativa a la pantalla del vysor (%)
     * 
     * @throws AWTException                     No se puede enviar el punto a la ventana
     */
    public void clic(CProceso proceso_vysor, double x_rel, double y_rel) throws AWTException {
        
        int x_abs = getCoordXAbs(proceso_vysor, x_rel);
        int y_abs = getCoordYAbs(proceso_vysor, y_rel);
        
        System.out.println("Clic a " + x_abs + ", " + y_abs);
        
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point posicion_actual = pi.getLocation();
        
        Robot robot = new Robot();
        robot.mouseMove(x_abs, y_abs);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        
        int delay = getDelay(MIN_DELAY_MOUSE_CLIC, MAX_DELAY_MOUSE_CLIC);
        robot.delay(delay);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        
        robot.mouseMove(posicion_actual.x, posicion_actual.y);
    }
    
    
    
    /**
     * Envía un clic de ratón.
     * 
     * @param proceso_vysor                     Proceso vysor
     * @param punto                             Coordenadas donde hacer el clic
     * 
     * @throws AWTException                     No se puede enviar el punto a la ventana
     */
    public void clic(CProceso proceso_vysor, CPunto punto) throws AWTException {
        clic(proceso_vysor, punto.x, punto.y);
    }
    
    
    /**
     * Envía un clic de ratón a un punto aleatorio dentro de un rectángulo.
     * 
     * @param proceso_vysor                     Proceso vysor
     * @param rectangulo                        Rectángulo donde se puede hacer el clic
     * 
     * @throws AWTException                     No se puede enviar el punto a la ventana
     */
    public void clic(CProceso proceso_vysor, CRectangulo rectangulo) throws AWTException {
        CPunto punto = rectangulo.getPuntoInterno();
        clic(proceso_vysor, punto);
    }
    
}
