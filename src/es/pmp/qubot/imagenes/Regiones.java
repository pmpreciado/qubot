/**
 * Pantallas.java
 *
 * Creado el 15-mar-2016, 18:32:00
 */

package es.pmp.qubot.imagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Definición de regiones clave para las pantallas.
 * 
 * @author pmpreciado
 */
public class Regiones {


    /** Las coordenadas se deben especificar en % (0 a 100) */
    
    
    /** Pantalla de preguntas y respuestas */
  
        public static final double PPREG_SEP_VERT_RESPUESTAS = 12.5;
    
        /** Enunciado de la pregunta normal */
            public static final CRectangulo PPREG_RECT_ENUNCIADO_NORMAL = new CRectangulo(
                    7,
                    14,
                    92.7,
                    41
            );
        
        
        /** Enunciado de la pregunta larga */
            public static final CRectangulo PPREG_RECT_ENUNCIADO_LARGA = new CRectangulo(
                    7,
                    14,
                    92.7,
                    64
            );

            
        
        /** Respuestas en preguntas normales */
            public static final CRectangulo PPREG_RECT_RESP_NORMAL_1 = new CRectangulo(
                    7, 
                    43.2, 
                    92.7, 
                    52.95
            );

            public static final CRectangulo PPREG_RECT_RESP_NORMAL_2 = new CRectangulo(
                    PPREG_RECT_RESP_NORMAL_1.x0, 
                    PPREG_RECT_RESP_NORMAL_1.y0 + PPREG_SEP_VERT_RESPUESTAS, 
                    PPREG_RECT_RESP_NORMAL_1.x1, 
                    PPREG_RECT_RESP_NORMAL_1.y1 + PPREG_SEP_VERT_RESPUESTAS
            );

            public static final CRectangulo PPREG_RECT_RESP_NORMAL_3 = new CRectangulo(
                    PPREG_RECT_RESP_NORMAL_2.x0, 
                    PPREG_RECT_RESP_NORMAL_2.y0 + PPREG_SEP_VERT_RESPUESTAS, 
                    PPREG_RECT_RESP_NORMAL_2.x1, 
                    PPREG_RECT_RESP_NORMAL_2.y1 + PPREG_SEP_VERT_RESPUESTAS
            );

            public static final CRectangulo PPREG_RECT_RESP_NORMAL_4 = new CRectangulo(
                    PPREG_RECT_RESP_NORMAL_3.x0, 
                    PPREG_RECT_RESP_NORMAL_3.y0 + PPREG_SEP_VERT_RESPUESTAS, 
                    PPREG_RECT_RESP_NORMAL_3.x1, 
                    PPREG_RECT_RESP_NORMAL_3.y1 + PPREG_SEP_VERT_RESPUESTAS
            );

            public static final CRectangulo[] ARR_PPREG_RECT_RESP_NORMAL = 
            {
                PPREG_RECT_RESP_NORMAL_1,
                PPREG_RECT_RESP_NORMAL_2,
                PPREG_RECT_RESP_NORMAL_3,
                PPREG_RECT_RESP_NORMAL_4
            };
    
    
        /** Respuestas en preguntas largas */
            public static final CRectangulo PPREG_RECT_RESP_LARGA_1 = new CRectangulo(
                    PPREG_RECT_RESP_NORMAL_1.x0, 
                    PPREG_RECT_RESP_NORMAL_3.y0, 
                    47.6, 
                    PPREG_RECT_RESP_NORMAL_3.y1
            );

            public static final CRectangulo PPREG_RECT_RESP_LARGA_2 = new CRectangulo(
                    52.2, 
                    PPREG_RECT_RESP_LARGA_1.y0, 
                    PPREG_RECT_RESP_NORMAL_1.x1, 
                    PPREG_RECT_RESP_LARGA_1.y1
            );

            public static final CRectangulo PPREG_RECT_RESP_LARGA_3 = new CRectangulo(
                    PPREG_RECT_RESP_LARGA_1.x0, 
                    PPREG_RECT_RESP_LARGA_1.y0 + PPREG_SEP_VERT_RESPUESTAS, 
                    PPREG_RECT_RESP_LARGA_1.x1, 
                    PPREG_RECT_RESP_LARGA_1.y1 + PPREG_SEP_VERT_RESPUESTAS
            );

            public static final CRectangulo PPREG_RECT_RESP_LARGA_4 = new CRectangulo(
                    PPREG_RECT_RESP_LARGA_2.x0, 
                    PPREG_RECT_RESP_LARGA_2.y0 + PPREG_SEP_VERT_RESPUESTAS, 
                    PPREG_RECT_RESP_LARGA_2.x1, 
                    PPREG_RECT_RESP_LARGA_2.y1 + PPREG_SEP_VERT_RESPUESTAS
            );

            public static final CRectangulo[] ARR_PPREG_RECT_RESP_LARGA = 
            {
                PPREG_RECT_RESP_LARGA_1,
                PPREG_RECT_RESP_LARGA_2,
                PPREG_RECT_RESP_LARGA_3,
                PPREG_RECT_RESP_LARGA_4
            };
        
            /** Línea vertical en negro */
                public static final CLineaVertical PPREG_LVERT_CENTRAL = new CLineaVertical(
                        50,
                        70,
                        88
                );
                
            
            
        /** Pantalla de revancha */
        
            public static final double PREV_SEP_VERT_BOTONES = 12.4;
            
            /** Primer botón disponible en la pantalla de revancha */
                public static final CRectangulo PREV_RECT_REVANCHA_BOTON_1 = new CRectangulo(
                        23, 
                        58, 
                        77, 
                        65
                );
            
            /** Segundo botón disponible en la pantalla de revancha */
                public static final CRectangulo PREV_RECT_REVANCHA_BOTON_2 = new CRectangulo(
                        PREV_RECT_REVANCHA_BOTON_1.x0, 
                        PREV_RECT_REVANCHA_BOTON_1.y0 + PREV_SEP_VERT_BOTONES, 
                        PREV_RECT_REVANCHA_BOTON_1.x1, 
                        PREV_RECT_REVANCHA_BOTON_1.y1 + PREV_SEP_VERT_BOTONES
                );

            /** Tercer botón disponible en la pantalla de revancha */
                public static final CRectangulo PREV_RECT_REVANCHA_BOTON_3 = new CRectangulo(
                        PREV_RECT_REVANCHA_BOTON_2.x0, 
                        PREV_RECT_REVANCHA_BOTON_2.y0 + PREV_SEP_VERT_BOTONES, 
                        PREV_RECT_REVANCHA_BOTON_2.x1, 
                        PREV_RECT_REVANCHA_BOTON_2.y1 + PREV_SEP_VERT_BOTONES
                );
                
        /** Pantalla jugar */
                
             public static final double PJUG_SEP_VERT_BOTONES = 7.6;
                
            /** Primer botón disponible en la pantalla de jugar */
                public static final CRectangulo PJUG_RECT_JUGAR_BOTON_1 = new CRectangulo(
                        53.3,
                        28,
                        85,
                        32.6
                );
                
            /** Segundo botón disponible en la pantalla de jugar */
                public static final CRectangulo PJUG_RECT_JUGAR_BOTON_2 = new CRectangulo(
                        PJUG_RECT_JUGAR_BOTON_1.x0,
                        PJUG_RECT_JUGAR_BOTON_1.y0 + PJUG_SEP_VERT_BOTONES,
                        PJUG_RECT_JUGAR_BOTON_1.x1,
                        PJUG_RECT_JUGAR_BOTON_1.y1 + PJUG_SEP_VERT_BOTONES
                );                
    
            /** Tercer botón disponible en la pantalla de jugar */
                public static final CRectangulo PJUG_RECT_JUGAR_BOTON_3 = new CRectangulo(
                        PJUG_RECT_JUGAR_BOTON_2.x0,
                        PJUG_RECT_JUGAR_BOTON_2.y0 + PJUG_SEP_VERT_BOTONES,
                        PJUG_RECT_JUGAR_BOTON_2.x1,
                        PJUG_RECT_JUGAR_BOTON_2.y1 + PJUG_SEP_VERT_BOTONES
                );                    
                
            /** Cuarto botón disponible en la pantalla de jugar */
                public static final CRectangulo PJUG_RECT_JUGAR_BOTON_4 = new CRectangulo(
                        PJUG_RECT_JUGAR_BOTON_3.x0,
                        PJUG_RECT_JUGAR_BOTON_3.y0 + PJUG_SEP_VERT_BOTONES,
                        PJUG_RECT_JUGAR_BOTON_3.x1,
                        PJUG_RECT_JUGAR_BOTON_3.y1 + PJUG_SEP_VERT_BOTONES
                );                
                
            /** Línea vertical en negro */
                public static final CLineaVertical PJUG_LVERT_IZQUIERDA = new CLineaVertical(
                        8,
                        20,
                        60
                );
                
                public static final CLineaVertical PJUG_LVERT_DERECHA = new CLineaVertical(
                        92,
                        20,
                        60
                );
            
                
    /**
     * Muestra en la salida estándar el color de un pixel dado por sus coordenadas relativas (%).
     * 
     * @param imagen
     * @param rel_x
     * @param rel_y 
     */
    public static void mostrarColorPixel(BufferedImage imagen, double rel_x, double rel_y) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int abs_x = CPunto.getCoordAbs(rel_x, ancho);
        int abs_y = CPunto.getCoordAbs(rel_y, alto);

        int rgb = imagen.getRGB(abs_x, abs_y);
        Color color = new Color(rgb);
        String hex_color = Colores.color2Hex(color);

        String s = "abs_x: " + abs_x + ", abs_y: " + abs_y + ", rel_x: " + rel_x + ", rel_y: " + rel_y +", rgb: " + hex_color;
        System.out.println(s);

    }
    
    
    /**
     * Muestra en la salida estándar el color de los pixeles de una fila dada por sus coordenadas relativas (%).
     * 
     * @param imagen
     * @param fila
     */
    public static void mostrarColorPixelesFila(BufferedImage imagen, double fila) {
        int ancho = imagen.getWidth();
        double fila_abs = CPunto.getCoordAbs(fila, ancho);
        System.out.println("Fila rel: " + fila + ", Fila abs: " + fila_abs);
        
        for (int rel_x = 0; rel_x < 100; rel_x++) {
            mostrarColorPixel(imagen, rel_x, fila);
        }
    }

    
    /**
     * Muestra en la salida estándar el color de los pixeles de una columna dada por sus coordenadas relativas (%).
     * 
     * @param imagen
     * @param col
     */
    public static void mostrarColorPixelesColumna(BufferedImage imagen, double col) {
        int alto = imagen.getHeight();
        double col_abs = CPunto.getCoordAbs(col, alto);
        System.out.println("Col rel: " + col + ", Col abs: " + col_abs);
        
        for (int rel_y = 0; rel_y < 100; rel_y++) {
            mostrarColorPixel(imagen, col, rel_y);
        }
    }

    
    
    
    /**
     * Traza las regiones definidas sobre una imagen dada de la pantalla de preguntas.
     * 
     * @param imagen                            Imagen con la pantalla
     */
    public static void trazarRegionesPregunta(BufferedImage imagen) {

        // Enunciados
        Imagenes.dibujarRectangulo(imagen, PPREG_RECT_ENUNCIADO_NORMAL, Color.YELLOW);
        Imagenes.dibujarRectangulo(imagen, PPREG_RECT_ENUNCIADO_LARGA, Color.YELLOW);
        
        // Recuadros preguntas normales
        for (int i = 0; i < ARR_PPREG_RECT_RESP_NORMAL.length; i++) {
            CRectangulo rectangulo = ARR_PPREG_RECT_RESP_NORMAL[i];
            Imagenes.dibujarRectangulo(imagen, rectangulo, Color.RED);
        }
        
        // Recuadros preguntas largas
        for (int i = 0; i < ARR_PPREG_RECT_RESP_LARGA.length; i++) {
            CRectangulo rectangulo = ARR_PPREG_RECT_RESP_LARGA[i];
            Imagenes.dibujarRectangulo(imagen, rectangulo, Color.GREEN);
        }
        
        // Huecos entre preguntas largas
        for (int i = 0; i < VerificacionRegiones.ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS.length; i++) {
            CPunto punto = VerificacionRegiones.ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS[i];
            Imagenes.dibujarPuntoGrueso(imagen, punto, Color.RED);
        }
    }
    
    
    
    /**
     * Traza las regiones definidas sobre una imagen dada de la pantalla de revancha.
     * 
     * @param imagen                            Imagen con la pantalla
     */
    public static void trazarRegionesRevancha(BufferedImage imagen) {

        Imagenes.dibujarRectangulo(imagen, PREV_RECT_REVANCHA_BOTON_1, Color.CYAN);
        Imagenes.dibujarRectangulo(imagen, PREV_RECT_REVANCHA_BOTON_2, Color.RED);        
        Imagenes.dibujarRectangulo(imagen, PREV_RECT_REVANCHA_BOTON_3, Color.YELLOW);        
    }
    

    /**
     * Traza las regiones definidas sobre una imagen dada de la pantalla de jugar.
     * 
     * @param imagen                            Imagen con la pantalla
     */
    public static void trazarRegionesJugar(BufferedImage imagen) {

        Imagenes.dibujarRectangulo(imagen, PJUG_RECT_JUGAR_BOTON_1, Color.RED);
        Imagenes.dibujarRectangulo(imagen, PJUG_RECT_JUGAR_BOTON_2, Color.RED);
        Imagenes.dibujarRectangulo(imagen, PJUG_RECT_JUGAR_BOTON_3, Color.RED);
        Imagenes.dibujarRectangulo(imagen, PJUG_RECT_JUGAR_BOTON_4, Color.RED);

        Imagenes.dibujarLinea(imagen, Regiones.PJUG_LVERT_IZQUIERDA, Color.yellow);
        Imagenes.dibujarLinea(imagen, Regiones.PJUG_LVERT_DERECHA, Color.yellow);
    }
    
    
    

    /**
     * Busca en la imagen la región de la respuesta dada, y retorna el tipo de respuesta que hay.
     * Espera respuestas para preguntas normales (no largas).
     * 
     * @param imagen                            Imagen con la pantalla
     * @param arr_puntos                        Puntos de las cuatro esquinas de la respuesta
     * 
     * @return                                  Tipo de la región de respuesta encontrada (TREG_RESP_xxx)
     */
    private static int getTipoRegionRespuesta(BufferedImage imagen, CPunto [] arr_puntos) {
        
        Color color_general = null;
        
        for (CPunto punto : arr_puntos) {
            Color color_punto = VerificacionRegiones.getColorPunto(imagen, punto);
            
            if (color_general == null) {
                color_general = color_punto;
            }
            
            if (!Colores.similares(color_punto, color_general)) {
                return CRegionesRespuestas.TREG_RESP_NINGUNA;
            }
        }

        if (Colores.similares(color_general, Colores.COLOR_BLANCO_FONDO_PREGUNTA)) {
            return CRegionesRespuestas.TREG_RESP_BLANCO;
        }

        if (Colores.similares(color_general, Colores.COLOR_VERDE_ACIERTO)) {
            return CRegionesRespuestas.TREG_RESP_ACIERTO;
        }
        
        if (Colores.similares(color_general, Colores.COLOR_ROJO_FALLO)) {
            return CRegionesRespuestas.TREG_RESP_FALLO;
        }

        return CRegionesRespuestas.TREG_RESP_NINGUNA;
    }
    
    
    
    /**
     * Busca en la imagen la región de la respuesta dada, y retorna el tipo de respuesta que hay.
     * Espera respuestas para preguntas normales (no largas).
     * 
     * @param imagen                            Imagen con la pantalla
     * @param indice                            Índice de la respuesta (0 a 3)
     * 
     * @return                                  Tipo de la región de respuesta encontrada (TREG_RESP_xxx)
     */
    public static int getTipoRegionRespuestaNormal(BufferedImage imagen, int indice) {
        
        CRectangulo rect = ARR_PPREG_RECT_RESP_NORMAL[indice];
        CPunto [] arr_puntos = rect.getEsquinas();
        int tipo_respuesta = getTipoRegionRespuesta(imagen, arr_puntos);
        return tipo_respuesta;
    }
    
    
    /**
     * Busca en la imagen la región de la respuesta dada, y retorna el tipo de respuesta que hay.
     * Espera respuestas para preguntas largas.
     * 
     * @param imagen                            Imagen con la pantalla
     * @param indice                            Índice de la respuesta (0 a 3)
     * 
     * @return                                  Tipo de la región de respuesta encontrada (TREG_RESP_xxx)
     */
    public static int getTipoRegionRespuestaLarga(BufferedImage imagen, int indice) {
        
        CRectangulo rect = ARR_PPREG_RECT_RESP_LARGA[indice];
        CPunto [] arr_puntos = rect.getEsquinas();
        int tipo_respuesta = getTipoRegionRespuesta(imagen, arr_puntos);
        return tipo_respuesta;
    }

    
    /**
     * Dada una imagen, retorna los cuatro tipos de regiones de respuestas detectadas.
     * Espera respuestas para preguntas normales.
     * 
     * @param imagen                            Imagen con la pantalla
     * 
     * @return                                  Tipos de respuestas encontradas (TREG_RESP_xxx)
     */
    public static int [] getTiposRegionesRepuestaNormal(BufferedImage imagen) {

        int [] arr_tipo_region = new int[4];
        for (int i = 0; i < 4; i++) {
            arr_tipo_region[i] = Regiones.getTipoRegionRespuestaNormal(imagen, i);
        }
        
        return arr_tipo_region;
    }
    
    
    /**
     * Dada una imagen, retorna los cuatro tipos de regiones de respuestas detectadas.
     * Espera respuestas para preguntas alrgas.
     * 
     * @param imagen                            Imagen con la pantalla
     * 
     * @return                                  Tipos de respuestas encontradas (TREG_RESP_xxx)
     */
    public static int [] getTiposRegionesRepuestaLarga(BufferedImage imagen) {

        int [] arr_tipo_region = new int[4];
        for (int i = 0; i < 4; i++) {
            arr_tipo_region[i] = Regiones.getTipoRegionRespuestaLarga(imagen, i);
        }
        
        return arr_tipo_region;
    }
    
    
    
}
