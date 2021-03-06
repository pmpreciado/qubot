/**
 * Pantallas.java
 *
 * Creado el 16-mar-2016, 18:53:17
 */

package es.pmp.qubot.imagenes;

import java.awt.image.BufferedImage;

/**
 * Identificación de pantallas.
 * 
 * @author pmpreciado
 */
public class Pantallas {

    /** Tipos de pantallas */
    public static final int TIPO_PANT_DESCONOCIDA                               = 0;
    public static final int TIPO_PANT_PREGUNTA_NORMAL_SIN_RESPONDER             = 1;
    public static final int TIPO_PANT_PREGUNTA_NORMAL_RESPONDIDA                = 2;
    public static final int TIPO_PANT_PREGUNTA_LARGA_SIN_RESPONDER              = 3;
    public static final int TIPO_PANT_PREGUNTA_LARGA_RESPONDIDA                 = 4;
    public static final int TIPO_PANT_REVANCHA_TRES_OPCIONES                    = 5;
    public static final int TIPO_PANT_REVANCHA_DOS_OPCIONES                     = 6;
    public static final int TIPO_PANT_JUGAR                                     = 7;
    public static final int TIPO_PANT_JUEGA_YA                                  = 8;

    /**
     * Obtiene la descripción del tipo de pantalla.
     * 
     * @param tipo                              Tipo (Pantallas.TIPO_PANT_xxx)
     * 
     * @return                                  Descripción
     */
    public static final String getDescripcionPantalla(int tipo) {
        switch (tipo) {
            case TIPO_PANT_DESCONOCIDA:                     return "Desconocida";
            case TIPO_PANT_PREGUNTA_NORMAL_SIN_RESPONDER:   return "Pregunta normal sin responder";
            case TIPO_PANT_PREGUNTA_NORMAL_RESPONDIDA:      return "Pregunta normal respondida";
            case TIPO_PANT_PREGUNTA_LARGA_SIN_RESPONDER:    return "Pregunta larga sin responder";
            case TIPO_PANT_PREGUNTA_LARGA_RESPONDIDA:       return "Pregunta larga respondida";
            case TIPO_PANT_REVANCHA_TRES_OPCIONES:          return "Revancha (tres opciones)";
            case TIPO_PANT_REVANCHA_DOS_OPCIONES:           return "Revancha (dos opciones)";
            case TIPO_PANT_JUGAR:                           return "Jugar";
            case TIPO_PANT_JUEGA_YA:                        return "Juega ya";
        }
        
        return Integer.toString(tipo);
    }
    
    
    /**
     * Comprueba si la pantalla es la de pregunta de tipo normal, ya sea sin responder o respondida.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaNormal(BufferedImage imagen) {

        int [] arr_tipos_regiones_normal = Regiones.getTiposRegionesRepuestaNormal(imagen);
        CRegionesRespuestas regiones_respuestas_normal = new CRegionesRespuestas(arr_tipos_regiones_normal);
        if (regiones_respuestas_normal.esPregunta()) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si la pantalla es la de pregunta de tipo normal sin responder.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaNormalSinResponder(BufferedImage imagen) {

        int [] arr_tipos_regiones_normal = Regiones.getTiposRegionesRepuestaNormal(imagen);
        CRegionesRespuestas regiones_respuestas_normal = new CRegionesRespuestas(arr_tipos_regiones_normal);
        if (regiones_respuestas_normal.esPreguntaSinResponder()) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si la pantalla es la de pregunta de tipo normal respondida.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaNormalRespondida(BufferedImage imagen) {

        int [] arr_tipos_regiones_normal = Regiones.getTiposRegionesRepuestaNormal(imagen);
        CRegionesRespuestas regiones_respuestas_normal = new CRegionesRespuestas(arr_tipos_regiones_normal);
        if (regiones_respuestas_normal.esPreguntaRespondida()) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si la pantalla es la de pregunta de tipo largo, ya sea sin responder o respondida.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaLarga(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_pregunta_larga = puntos.pc_pregunta_larga_huecos.validar(imagen);
        
        if (valido_pregunta_larga) {
            int [] arr_tipos_regiones_larga = Regiones.getTiposRegionesRepuestaLarga(imagen);
            CRegionesRespuestas regiones_respuestas_larga = new CRegionesRespuestas(arr_tipos_regiones_larga);
            if (regiones_respuestas_larga.esPregunta()) {
                return true;
            }
        }        
        return false;
    }


    /**
     * Comprueba si la pantalla es la de pregunta de tipo largo sin responder.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaLargaSinResponder(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_pregunta_larga = puntos.pc_pregunta_larga_huecos.validar(imagen);
        
        if (valido_pregunta_larga) {

            int [] arr_tipos_regiones_larga = Regiones.getTiposRegionesRepuestaLarga(imagen);
            CRegionesRespuestas regiones_respuestas_larga = new CRegionesRespuestas(arr_tipos_regiones_larga);
            if (regiones_respuestas_larga.esPreguntaSinResponder()) {
                return true;
            }
        }
        
        return false;
    }
    

    /**
     * Comprueba si la pantalla es la de pregunta de tipo largo respondido.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaPreguntaLargaRespondida(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_pregunta_larga = puntos.pc_pregunta_larga_huecos.validar(imagen);
        
        if (valido_pregunta_larga) {
            int [] arr_tipos_regiones_larga = Regiones.getTiposRegionesRepuestaLarga(imagen);
            CRegionesRespuestas regiones_respuestas_larga = new CRegionesRespuestas(arr_tipos_regiones_larga);
            if (regiones_respuestas_larga.esPreguntaRespondida()) {
                return true;
            }
        }
        
        return false;
    }
    
    
    /**
     * Comprueba si la pantalla es la de revancha con las tres opciones disponibles.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaRevanchaTresOpciones(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_revancha_3_op = puntos.pc_revancha_3_op.validar(imagen);
        return valido_revancha_3_op;
    }
    
    
    /**
     * Comprueba si la pantalla es la de revancha con las tres opciones disponibles.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaRevanchaDosOpciones(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_revancha_2_op = puntos.pc_revancha_2_op.validar(imagen);
        return valido_revancha_2_op;
    }
    
    
    /**
     * Comprueba si la pantalla es la de jugar.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaJugar(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_jugar = puntos.pc_jugar.validar(imagen);
        return valido_jugar;
    }
    
    
    /**
     * Comprueba si la pantalla es la de juega ya.
     * 
     * @param imagen                            Imagen de la pantalla
     * 
     * @return                                  'true' si lo es
     *                                          'false' si no lo es
     */
    private static boolean esPantallaJuegaYa(BufferedImage imagen) {
        VerificacionRegiones puntos = new VerificacionRegiones();
        boolean valido_juega_ya = puntos.pc_juega_ya.validar(imagen);
        return valido_juega_ya;
    }
    
    
    
    
    /**
     * Trata de identificar el tipo de pantalla suministrada en la imagen,
     * 
     * @param imagen                            Imagen con la pantalla
     * 
     * @return                                  Tipo de pantalla (Pantallas.TIPO_PANT_xxx)
     */
    public static int identificarPantalla(BufferedImage imagen) {
        
        boolean es_preg_normal_sr = esPantallaPreguntaNormalSinResponder(imagen);
        if (es_preg_normal_sr) {
            return TIPO_PANT_PREGUNTA_NORMAL_SIN_RESPONDER;
        }
        
        boolean es_preg_normal_r = esPantallaPreguntaNormalRespondida(imagen);
        if (es_preg_normal_r) {
            return TIPO_PANT_PREGUNTA_NORMAL_RESPONDIDA;
        }

        boolean es_preg_larga_sr = esPantallaPreguntaLargaSinResponder(imagen);
        if (es_preg_larga_sr) {
            return TIPO_PANT_PREGUNTA_LARGA_SIN_RESPONDER;
        }

        boolean es_preg_larga_r = esPantallaPreguntaLargaRespondida(imagen);
        if (es_preg_larga_r) {
            return TIPO_PANT_PREGUNTA_LARGA_RESPONDIDA;
        }
        
        boolean es_rev_3_op = esPantallaRevanchaTresOpciones(imagen);
        if (es_rev_3_op) {
            return TIPO_PANT_REVANCHA_TRES_OPCIONES;
        }
        
        boolean es_rev_2_op = esPantallaRevanchaDosOpciones(imagen);
        if (es_rev_2_op) {
            return TIPO_PANT_REVANCHA_DOS_OPCIONES;
        }
        
        boolean es_jugar = esPantallaJugar(imagen);
        if (es_jugar) {
            return TIPO_PANT_JUGAR;
        }
        
        boolean es_juega_ya = esPantallaJuegaYa(imagen);
        if (es_juega_ya) {
            return TIPO_PANT_JUEGA_YA;
        }
        
        return TIPO_PANT_DESCONOCIDA;
    }   
}
