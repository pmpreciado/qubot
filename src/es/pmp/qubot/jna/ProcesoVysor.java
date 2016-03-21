package es.pmp.qubot.jna;

import es.pmp.qubot.Comun;
import es.pmp.qubot.QubotView;
import es.pmp.qubot.control.Clic;
import es.pmp.qubot.imagenes.CPunto;
import es.pmp.qubot.imagenes.CRectangulo;
import es.pmp.qubot.imagenes.Imagenes;
import es.pmp.qubot.tipos.CProceso;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Funciones relacionadas con el proceso Vysor.
 * 
 * @author Pedro
 */
public class ProcesoVysor {

    QubotView qubot_view;
    Jna jna;
    
    /**
     * Crea una instancia de la clase.
     * 
     * @param qubot_view
     */
    public ProcesoVysor(QubotView qubot_view) {
        this.qubot_view = qubot_view;
        jna = new Jna();
    }
    
    
    /**
     * Obtiene el proceso visor.
     * 
     * @return                                  Proceso Vysor
     *                                          'null' si no se detecta
     */
    public CProceso getProcesoVysor() {
        String titulo_ventana = qubot_view.getTituloVentanaVysor();
        CProceso proceso = jna.getProcesoTitulo(titulo_ventana);
        return proceso;
    }
    
    

    /**
     * Envia el proceso Vysor al frente.
     * 
     * @param proceso_vysor                     Proceso vysor
     */
    public void enviarProcesoVysorAlFrente(CProceso proceso_vysor) {
        if (proceso_vysor != null) {
            jna.enviarAlFrente(proceso_vysor.hwnd);
        }
    }
    
    
    /**
     * Envia el proceso Vysor al frente.
     */
    public void enviarProcesoVysorAlFrente() {
        CProceso proceso_vysor = getProcesoVysor();
        if (proceso_vysor != null) {
            jna.enviarAlFrente(proceso_vysor.hwnd);
        }
    }
    
    
    /**
     * Envía un clic a la pantalla del vysor.
     * 
     * @param punto                             Coordenadas donde se enviará al clic, en tanto por ciento relativo a la ventana del Vysor
     */
    public void enviarClicAVysor(CPunto punto) {
        
        try {
            CProceso proceso_vysor = getProcesoVysor();
            Clic clic = new Clic();
            clic.clic(proceso_vysor, punto);
            
        } catch (Throwable th) {
            qubot_view.mostrarError(th);
        }

        
        // Test enviar 100 clics al azar
        /*
        try {
            CProceso proceso_vysor = getProcesoVysor();
            enviarProcesoVysorAlFrente(proceso_vysor);
            CRectangulo rect = new CRectangulo(4, 12, 96, 50);
            Clic clic = new Clic();
            
            for (int i = 0; i < 100; i++) {
                clic.clic(proceso_vysor, rect);
            }
        } catch (Throwable th) {
            mostrarError(th);
        }
        */
    }

    

    /**
     * Envía N clics al azar a la pantalla del vysor.
     * 
     * @param n                                 Número de clics
     */
    public void enviarClicsAVysor(int n) {
        
        try {
            CProceso proceso_vysor = getProcesoVysor();
            enviarProcesoVysorAlFrente(proceso_vysor);
            CRectangulo rect = new CRectangulo(4, 12, 96, 50);
            Clic clic = new Clic();
            
            for (int i = 0; i < n; i++) {
                clic.clic(proceso_vysor, rect);
            }
        } catch (Throwable th) {
            qubot_view.mostrarError(th);
        }
    }

    
    /**
     * Obtiene la pantalla del proceso visor.
     * 
     * La pantalla se obtiene sin escalar.
     * 
     * @return                                  Pantalla del proceso visor
     *                                          'null' si no se puede obtener
     */
    public BufferedImage capturarPantallaVysor() {
        try {
            CProceso proceso_vysor = getProcesoVysor();
            if (proceso_vysor != null) {
                jna.enviarAlFrente(proceso_vysor.hwnd);
                Thread.sleep(100);

                Rectangle rectangle = proceso_vysor.getRectangle();
                jna.getRect(proceso_vysor.hwnd);
            
                Robot robot = new Robot();
                BufferedImage img = robot.createScreenCapture(rectangle);
                return img;
            }
        
        } catch (InterruptedException | AWTException th) {
            qubot_view.mostrarError(th);
        }
        
        return null;
    }
    
    
    
    /**
     * Guarda en disco la pantalla del proceso Vysor y la muestra en el formulario.
     * 
     * @param ruta_fichero_generado         Salida. Guardará la ruta del fichero generado
     * 
     * @return                              Imagen guardada
     *                                      'null' si no se ha podido capturar
     */
    public BufferedImage guardarPantallaVysor(StringBuilder ruta_fichero_generado) {
        
        BufferedImage img = null;
        CProceso proceso_vysor = getProcesoVysor();
        if (proceso_vysor != null) {

            img = capturarPantallaVysor();
            String ruta_fichero = Comun.RUTA_FICHERO_CAPTURAS;
            ruta_fichero = Comun.getNombreFicheroInexistente(ruta_fichero);
            
            try {
                String r = Imagenes.guardarImagenPng(img, ruta_fichero);
                ruta_fichero_generado.setLength(0);
                ruta_fichero_generado.append(r);
                
            } catch (IOException ex) {
                qubot_view.mostrarError(ex);
            }
        }
        
        return img;
    }
    
}
