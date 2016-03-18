/**
 * CRegionesRespuestas.java
 *
 * Creado el 18-mar-2016, 12:54:07
 */

package es.pmp.qubot.imagenes;

import java.awt.image.BufferedImage;

/**
 * Funciones relacionadas con las regiones de las respuestas.
 * 
 * @author pmpreciado
 */
public class CRegionesRespuestas {
    
    /** Tipos de regiones de las respuestas */
    public static final int TREG_RESP_NINGUNA   = 0;
    public static final int TREG_RESP_BLANCO    = 1;
    public static final int TREG_RESP_ACIERTO   = 2;
    public static final int TREG_RESP_FALLO     = 3;
    
    /** Array con los cuatro tipos de regiones de las respuestas */
    int [] arr_tipo_region;
    
    
    /**
     * Inicializa la clase.
     */
    public CRegionesRespuestas() {
        arr_tipo_region = new int [4];
    }
    
    
    /**
     * Inicializa la clase.
     * 
     * @param arr_tipo_region                   Array con los cuatro tipos de regiones de las respuestas
     */
    public CRegionesRespuestas(int [] arr_tipo_region) {
        this.arr_tipo_region = arr_tipo_region;
    }
    
    
    /**
     * Establece el tipo de la región dada por su índice.
     * 
     * @param indice
     * @param tipo 
     */
    public void setTipoRegion(int indice, int tipo) {
        arr_tipo_region[indice] = tipo;
    }
    
    /**
     * Cuenta el número de regiones de respuestas del tipo dado.
     * 
     * @param tipo_region
     * 
     * @return                                  Número de regiones de respuestas del tipo dado
     */
    public int getNumeroRegiones(int tipo_region) {
        
        int n = 0;
        for (int i = 0; i < arr_tipo_region.length; i++) {
            if (arr_tipo_region[i] == tipo_region) {
                n++;
            }
        }
        
        return n;
    }


    /**
     * Cuenta el número de regiones de respuestas en blanco.
     * 
     * @return                                  Número de regiones de respuestas en blanco
     */
    public int getNumeroBlancos() {
        int n = getNumeroRegiones(TREG_RESP_BLANCO);
        return n;
    }
    
    
    /**
     * Cuenta el número de regiones de respuestas con aciertos.
     * 
     * @return                                  Número de regiones de respuestas con aciertos
     */
    public int getNumeroAciertos() {
        int n = getNumeroRegiones(TREG_RESP_ACIERTO);
        return n;
    }

    
    /**
     * Cuenta el número de regiones de respuestas con fallos.
     * 
     * @return                                  Número de regiones de respuestas con fallos
     */
    public int getNumeroFallos() {
        int n = getNumeroRegiones(TREG_RESP_FALLO);
        return n;
    }

    
    /**
     * Comprueba si las cuatro respuestas están en blanco.
     * 
     * @return                              'true' si las cuatro respuestas están en blanco
     *                                      'false' en caso contrario
     */
    public boolean esPreguntaSinResponder() {
        int nb = getNumeroBlancos();
        if (nb == 4) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si las cuatro respuestas se corresponden a una pregunta respondida.
     * Se espera:
     *    - Tres regiones en blanco y una en verde
     *    - O, tres regiones en blanco y una en rojo
     *    - O, dos regiones en blanco, una en verde y una en rojo
     * 
     * @return                              'true' si las cuatro respuestas se corresponden a una pregunta respondida.
     *                                      'false' en caso contrario
     */
    public boolean esPreguntaRespondida() {
        int nb = getNumeroBlancos();
        int na = getNumeroAciertos();
        int nf = getNumeroFallos();
        
        if (nb == 3 && na == 1 && nf == 0) {
            return true;
        }
        
        if (nb == 3 && na == 0 && nf == 1) {
            return true;
        }

        if (nb == 2 && na == 1 && nf == 1) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si las cuatro respuestas son respuestas válidas (blanco, acierto o fallo).
     * 
     * @return                              'true' si las cuatro respuestas son respuestas válidas (blanco, acierto o fallo).
     *                                      'false' si alguna región no es una respuesta
     */
    public boolean esPregunta() {
        boolean es_pregunta_sin_responder = esPreguntaSinResponder();
        if (es_pregunta_sin_responder) {
            return true;
        }
        
        boolean es_pregunta_respondida = esPreguntaRespondida();
        if (es_pregunta_respondida) {
            return true;
        }
        
        return false;
    }
}
