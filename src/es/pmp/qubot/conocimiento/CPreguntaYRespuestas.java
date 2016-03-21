/**
 * CPreguntaYRespuestas.java
 *
 * Creado el 21-mar-2016, 14:41:18
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.Comun;
import es.pmp.qubot.imagenes.Imagenes;
import es.pmp.qubot.imagenes.Pantallas;
import es.pmp.qubot.imagenes.Regiones;
import java.awt.image.BufferedImage;

/**
 * Pantalla de pregunta y respuestas.
 * 
 * @author pmpreciado
 */
public class CPreguntaYRespuestas {

    public static final int FORMATO_DESCONOCIDO     = 0;
    public static final int FORMATO_NORMAL          = 1;
    public static final int FORMATO_LARGO           = 2;

    public static final int RESPONDIDA_DESCONOCIDO  = 0;
    public static final int RESPONDIDA_NO           = 1;
    public static final int RESPONDIDA_SI           = 2;
    
    
    public CPregunta pregunta;
    public CRespuesta [] arr_respuestas = new CRespuesta[4];
    BufferedImage imagen_full_sin_responder;
    BufferedImage imagen_full_respondida;
    
    public int formato;
    public int respondida;
    public String id_respuesta_correcta;
    public int tipo_pregunta;
    
//    
//    /**
//     * Crea una instancia de la clase.
//     * 
//     * @param imagen_full                       Imagen de toda la pantalla
//     * @param es_pregunta_larga                 'true' para indicar que la pregunta es larga (texto largo o texto con imágenes)
//     *                                          'false' si es normal
//     * 
//     */
//    public CPreguntaYRespuestas(BufferedImage imagen_full, boolean es_pregunta_larga) {
//        extraerPreguntaYRespuestas(imagen_full, es_pregunta_larga);
//        
//        this.respondida = RESPONDIDA_DESCONOCIDO;
//        this.id_respuesta_correcta = "";
//        
//        this.imagen_full = imagen_full;
//    }
    
    
   /**
     * Crea una instancia de la clase.
     * 
     * @param imagen_full                       Imagen de toda la pantalla
     * @param tipo_pantalla                     Tipo de pantalla de la pregunta:
     *                                              - Pantallas.TIPO_PANT_PREGUNTA_NORMAL_xxx
     *                                              - Pantallas.TIPO_PANT_PREGUNTA_LARGA_xxx
     * 
     */
    public CPreguntaYRespuestas(BufferedImage imagen_full, int tipo_pantalla) {

        this.formato = FORMATO_DESCONOCIDO;
        this.respondida = RESPONDIDA_DESCONOCIDO;
        this.id_respuesta_correcta = "";

        switch (tipo_pantalla) {
            case Pantallas.TIPO_PANT_PREGUNTA_NORMAL_SIN_RESPONDER:
                formato = FORMATO_NORMAL;
                respondida = RESPONDIDA_NO;
                imagen_full_sin_responder = imagen_full;
                break;
                
            case Pantallas.TIPO_PANT_PREGUNTA_NORMAL_RESPONDIDA:
                formato = FORMATO_NORMAL;
                respondida = RESPONDIDA_SI;
                imagen_full_respondida = imagen_full;
                break;
                
            case Pantallas.TIPO_PANT_PREGUNTA_LARGA_SIN_RESPONDER:
                formato = FORMATO_LARGO;
                respondida = RESPONDIDA_NO;
                imagen_full_sin_responder = imagen_full;                
                break;
                
            case Pantallas.TIPO_PANT_PREGUNTA_LARGA_RESPONDIDA:
                formato = FORMATO_LARGO;
                respondida = RESPONDIDA_SI;
                imagen_full_respondida = imagen_full;                
                break;

            default:
                return;
        }
        
        extraerPreguntaYRespuestas(imagen_full, formato);
    }
    
    
    /**
     * Extrae las regiones significativas de la pantalla de pregunta y respuestas.
     * 
     * @param imagen_full
     * @param formato
     */
    private void extraerPreguntaYRespuestas(BufferedImage imagen_full, int formato) {
        if (formato == FORMATO_LARGO) {
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
    
    
    /**
     * Genera información de la pregunta y las respuestas.
     * 
     * @return 
     */
    public String getInfo() {
        StringBuilder s = new StringBuilder();
        
        String id_pregunta = pregunta.getIdUnico();
        s.append("Id pregunta: " + id_pregunta + Comun.NL);
        
        for (int i = 0; i < 4; i++) {
            String n = Integer.toString(i + 1);
            s.append("  - Respuesta " + n + ". Id: " + arr_respuestas[i].getIdUnico() + ", Estado: " + arr_respuestas[i].getDescripcionEstado() + Comun.NL);
        }
        
        return s.toString();
    }
    
}
