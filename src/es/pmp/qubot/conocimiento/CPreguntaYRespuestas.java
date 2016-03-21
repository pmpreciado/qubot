/**
 * CPreguntaYRespuestas.java
 *
 * Creado el 21-mar-2016, 14:41:18
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.imagenes.Imagenes;
import es.pmp.qubot.imagenes.Regiones;
import java.awt.image.BufferedImage;

/**
 * Pantalla de pregunta y respuestas.
 * 
 * @author pmpreciado
 */
public class CPreguntaYRespuestas {

    CPregunta pregunta;
    CRespuesta [] arr_respuestas = new CRespuesta[4];
    
    BufferedImage imagen_full;
    //BufferedImage imagen_pregunta;
    //BufferedImage [] imagen_respuesta = new BufferedImage[4];
    
    
    /**
     * Crea una instancia de la clase.
     * 
     * @param imagen_full                       Imagen de toda la pantalla
     * @param es_pregunta_larga                 'true' para indicar que la pregunta es larga (texto largo o texto con imágenes)
     *                                          'false' si es normal
     * 
     */
    public CPreguntaYRespuestas(BufferedImage imagen_full, boolean es_pregunta_larga) {
        extraerPreguntaYRespuestas(imagen_full, es_pregunta_larga);
    }
    
    
    /**
     * Extrae las regiones significativas de la pantalla de pregunta y respuestas.
     * 
     * @param imagen_full
     * @param es_pregunta_larga 
     */
    private void extraerPreguntaYRespuestas(BufferedImage imagen_full, boolean es_pregunta_larga) {
        if (es_pregunta_larga) {
            BufferedImage imagen_pregunta = Imagenes.extraerSubimagen(imagen_full, Regiones.PPREG_RECT_ENUNCIADO_LARGA);
            pregunta = new CPregunta(imagen_pregunta);
            for (int i = 0; i < arr_respuestas.length; i++) {
                BufferedImage imagen_respuesta = Imagenes.extraerSubimagen(imagen_full, Regiones.ARR_PPREG_RECT_RESP_LARGA[i]);
                arr_respuestas[i] = new CRespuesta(imagen_respuesta);
            }
        } else {
            BufferedImage imagen_pregunta = Imagenes.extraerSubimagen(imagen_full, Regiones.PPREG_RECT_ENUNCIADO_NORMAL);
            pregunta = new CPregunta(imagen_pregunta);
            for (int i = 0; i < arr_respuestas.length; i++) {
                BufferedImage imagen_respuesta = Imagenes.extraerSubimagen(imagen_full, Regiones.ARR_PPREG_RECT_RESP_NORMAL[i]);
                arr_respuestas[i] = new CRespuesta(imagen_respuesta);
            }
        }
    }
}
