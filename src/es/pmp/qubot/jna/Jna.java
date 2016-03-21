/**
 * Jna.java
 *
 * Creado el 15-mar-2016, 9:15:40
 */

package es.pmp.qubot.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.IntByReference;
import es.pmp.qubot.tipos.CProceso;
import java.util.ArrayList;
import java.util.List;


/**
 * Funciones nativas de Windows.
 * 
 * @author pmpreciado
 */
public class Jna {

    /** Longitud del byte [] para leer el título de las ventanas */
    private static final int MAX_TITLE_LENGTH = 1024;
    
    /** Clase para interactuar con las funciones nativas de Windows */
    final User32 user32 = User32.INSTANCE;

    
    private List <CProceso> _l_procesos_activos;
    
    
    /**
     * Obtiene el identificador del proceso asociado a la ventana dada por su handle.
     * 
     * @param hwnd                              Handle de la ventana
     * 
     * @return                                  Identificador del proceso;
     */
    public int getIdProceso(HWND hwnd) {
        IntByReference pid = new IntByReference();
        User32.INSTANCE.GetWindowThreadProcessId(hwnd, pid);
        int id_proceso = pid.getValue();
        return id_proceso;
    }
    
    
    
    /**
     * Función auxiliar usada por getProcesos
     */
    WNDENUMPROC wndenumproc = new WNDENUMPROC() {
        
        @Override
        public boolean callback(HWND hwnd, Pointer arg1) {

            byte [] b_texto_ventana = new byte[MAX_TITLE_LENGTH];
            user32.GetWindowTextA(hwnd, b_texto_ventana, MAX_TITLE_LENGTH);
            
            int id_proceso = getIdProceso(hwnd);
            String texto_ventana = Native.toString(b_texto_ventana);
            CProceso proceso = new CProceso(id_proceso, hwnd, texto_ventana);
            int [] rect = getRect(hwnd);
            proceso.setPosicion(rect);

            _l_procesos_activos.add(proceso);
            
            return true;
        }
    };
        
        
    /**
     * Obtiene la lista de procesos activos en el sistema.
     * 
     * @return                                  Lista de procesos activos
     */
    public List <CProceso> getListaProcesos() {
        
        _l_procesos_activos = new ArrayList <> ();
        user32.EnumWindows(wndenumproc, null);
        
        List <CProceso> l_procesos = new ArrayList();
        
        for (CProceso proceso : _l_procesos_activos) {
            boolean es_ventana = user32.IsWindow(proceso.hwnd);
            if (es_ventana) {
                l_procesos.add(proceso);
            }
        }
        
        //l_procesos.addAll(_l_procesos_activos);
        
        return l_procesos;
    }
    
    
    /**
     * Obtiene el proceso asociado a la ventana dada por su handle.
     * 
     * @param hwnd                              Handle de la venta
     * 
     * @return                                  Proceso asociado
     */
    public CProceso getProcesoVentana(HWND hwnd) {
        byte [] chr_window_text = new byte[MAX_TITLE_LENGTH];
        user32.GetWindowTextA(hwnd, chr_window_text, MAX_TITLE_LENGTH);
        String titulo = Native.toString(chr_window_text);
        
        int id_proceso = getIdProceso(hwnd);
        CProceso proceso = new CProceso(id_proceso, hwnd, titulo);
        
        int [] rect = getRect(hwnd);
        proceso.setPosicion(rect);
        
        return proceso;
    }
    
    
    /**
     * Obtiene la información del proceso en cuyo título aparezca la cadena suministrada.
     * Si hubiera más de uno, retorna el primero.
     * 
     * @param titulo                            Título o parte del título de la ventan
     * 
     * @return                                  Proceso
     *                                          'null' si no se encuentra
     */
    public CProceso getProcesoTitulo(String titulo) {
        List <CProceso> l_procesos = getListaProcesos();
        
        for (CProceso proceso : l_procesos) {
            if (proceso.nombre_ventana.contains(titulo)) {
                return proceso;
            }
        }
        
        return null;
    }
    
    
    /**
     * Obtiene el handle de la ventana activa.
     * 
     * @return                                  Handle de la ventana activa
     */
    public HWND getHandleVentanaActiva() {
        HWND hwnd_ventana_activa = user32.GetForegroundWindow();
        return hwnd_ventana_activa;
    }

    
    /**
     * Obtiene el proceso asociado a la ventana activa.
     * 
     * @return                                  Proceso asociado a la ventana activa
     */
    public CProceso tituloVentanaActiva() {

        HWND hwnd_ventana_activa = getHandleVentanaActiva();
        CProceso proceso = this.getProcesoVentana(hwnd_ventana_activa);
        return proceso;
    }
    
    
    /**
     * Obtiene el rectángulo que identifica la posición de una ventana dada por su handle.
     * 
     * @param hwnd                              Handle de la ventana
     * 
     * @return                                  Posición
     */
    public int[] getRect(HWND hwnd) {
        int [] rect = {0, 0, 0, 0};
        User32.INSTANCE.GetWindowRect(hwnd, rect);
        return rect;
    }
    
    
    /**
     * Envía al frente una ventana dada por su handle.
     * 
     * @param hwnd                              Handle de la ventana
     * 
     * @return                                  'true' en caso de éxito
     *                                          'false' en caso de error
     */
    public boolean enviarAlFrente(HWND hwnd) {
        int result = user32.SetForegroundWindow(hwnd);
        if (result != 0) {
            return true;
        }
        
        return false;
    }
    
    

    
}
