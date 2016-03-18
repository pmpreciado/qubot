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

    

    
    

    /** Coordenadas de las regiones y los puntos (en %) */
  
        public static final double SEP_PREGUNTA_VERTICAL = 12.5;
    
        /** Enunciado de la pregunta normal */
            public static final CRectangulo RECT_ENUNCIADO_NORMAL = new CRectangulo(
                    7,
                    14,
                    92.7,
                    41
            );
        
        
        /** Enunciado de la pregunta larga */
            public static final CRectangulo RECT_ENUNCIADO_LARGA = new CRectangulo(
                    7,
                    14,
                    92.7,
                    64
            );

            
        
        /** Respuestas en preguntas normales */
            public static final CRectangulo RECT_RESP_NORMAL_1 = new CRectangulo(
                    7, 
                    43.2, 
                    92.7, 
                    52.95
            );

            public static final CRectangulo RECT_RESP_NORMAL_2 = new CRectangulo(
                    RECT_RESP_NORMAL_1.x0, 
                    RECT_RESP_NORMAL_1.y0 + SEP_PREGUNTA_VERTICAL, 
                    RECT_RESP_NORMAL_1.x1, 
                    RECT_RESP_NORMAL_1.y1 + SEP_PREGUNTA_VERTICAL
            );

            public static final CRectangulo RECT_RESP_NORMAL_3 = new CRectangulo(
                    RECT_RESP_NORMAL_2.x0, 
                    RECT_RESP_NORMAL_2.y0 + SEP_PREGUNTA_VERTICAL, 
                    RECT_RESP_NORMAL_2.x1, 
                    RECT_RESP_NORMAL_2.y1 + SEP_PREGUNTA_VERTICAL
            );

            public static final CRectangulo RECT_RESP_NORMAL_4 = new CRectangulo(
                    RECT_RESP_NORMAL_3.x0, 
                    RECT_RESP_NORMAL_3.y0 + SEP_PREGUNTA_VERTICAL, 
                    RECT_RESP_NORMAL_3.x1, 
                    RECT_RESP_NORMAL_3.y1 + SEP_PREGUNTA_VERTICAL
            );

            public static final CRectangulo ARR_RECT_RESP_NORMAL [] = 
            {
                RECT_RESP_NORMAL_1,
                RECT_RESP_NORMAL_2,
                RECT_RESP_NORMAL_3,
                RECT_RESP_NORMAL_4
            };
    
    
        /** Respuestas en preguntas largas */
            public static final CRectangulo RECT_RESP_LARGA_1 = new CRectangulo(
                    RECT_RESP_NORMAL_1.x0, 
                    RECT_RESP_NORMAL_3.y0, 
                    47.6, 
                    RECT_RESP_NORMAL_3.y1
            );

            public static final CRectangulo RECT_RESP_LARGA_2 = new CRectangulo(
                    52.2, 
                    RECT_RESP_LARGA_1.y0, 
                    RECT_RESP_NORMAL_1.x1, 
                    RECT_RESP_LARGA_1.y1
            );

            public static final CRectangulo RECT_RESP_LARGA_3 = new CRectangulo(
                    RECT_RESP_LARGA_1.x0, 
                    RECT_RESP_LARGA_1.y0 + SEP_PREGUNTA_VERTICAL, 
                    RECT_RESP_LARGA_1.x1, 
                    RECT_RESP_LARGA_1.y1 + SEP_PREGUNTA_VERTICAL
            );

            public static final CRectangulo RECT_RESP_LARGA_4 = new CRectangulo(
                    RECT_RESP_LARGA_2.x0, 
                    RECT_RESP_LARGA_2.y0 + SEP_PREGUNTA_VERTICAL, 
                    RECT_RESP_LARGA_2.x1, 
                    RECT_RESP_LARGA_2.y1 + SEP_PREGUNTA_VERTICAL
            );

            public static final CRectangulo ARR_RECT_RESP_LARGA [] = 
            {
                RECT_RESP_LARGA_1,
                RECT_RESP_LARGA_2,
                RECT_RESP_LARGA_3,
                RECT_RESP_LARGA_4
            };
        
        
        /** Pantalla de revancha */
        
            public static final double SEP_BOTONES_REVANCHA = 12.4;
            
            /** Recuadro con el botón Revancha */
                public static final CRectangulo RECT_REVANCHA = new CRectangulo(
                        23, 
                        58, 
                        77, 
                        65
                );
            
            /** Recuadro con el botón Otro adversario */
                public static final CRectangulo RECT_OTRO_ADVERSARIO = new CRectangulo(
                        RECT_REVANCHA.x0, 
                        RECT_REVANCHA.y0 + SEP_BOTONES_REVANCHA, 
                        RECT_REVANCHA.x1, 
                        RECT_REVANCHA.y1 + SEP_BOTONES_REVANCHA
                );

            /** Recuadro con el botón Ver resultados */
                public static final CRectangulo RECT_VER_RESULTADOS = new CRectangulo(
                        RECT_OTRO_ADVERSARIO.x0, 
                        RECT_OTRO_ADVERSARIO.y0 + SEP_BOTONES_REVANCHA, 
                        RECT_OTRO_ADVERSARIO.x1, 
                        RECT_OTRO_ADVERSARIO.y1 + SEP_BOTONES_REVANCHA
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
        Imagenes.dibujarRectangulo(imagen, RECT_ENUNCIADO_NORMAL, Color.YELLOW);
        Imagenes.dibujarRectangulo(imagen, RECT_ENUNCIADO_LARGA, Color.YELLOW);
        
        // Recuadros preguntas normales
        for (int i = 0; i < ARR_RECT_RESP_NORMAL.length; i++) {
            CRectangulo rectangulo = ARR_RECT_RESP_NORMAL[i];
            Imagenes.dibujarRectangulo(imagen, rectangulo, Color.RED);
        }
        
        // Recuadros preguntas largas
        for (int i = 0; i < ARR_RECT_RESP_LARGA.length; i++) {
            CRectangulo rectangulo = ARR_RECT_RESP_LARGA[i];
            Imagenes.dibujarRectangulo(imagen, rectangulo, Color.GREEN);
        }
        
        // Huecos entre preguntas largas
        for (int i = 0; i < Puntos.ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS.length; i++) {
            CPunto punto = Puntos.ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS[i];
            Imagenes.dibujarPuntoGrueso(imagen, punto, Color.RED);
        }
    }
    
    
    
    /**
     * Traza las regiones definidas sobre una imagen dada de la pantalla de revancha.
     * 
     * @param imagen                            Imagen con la pantalla
     */
    public static void trazarRegionesRevancha(BufferedImage imagen) {

        // Enunciados
        Imagenes.dibujarRectangulo(imagen, RECT_REVANCHA, Color.CYAN);
        Imagenes.dibujarRectangulo(imagen, RECT_OTRO_ADVERSARIO, Color.RED);        
        Imagenes.dibujarRectangulo(imagen, RECT_VER_RESULTADOS, Color.YELLOW);        
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
            Color color_punto = Puntos.getColorPunto(imagen, punto);
            
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
        
        CRectangulo rect = ARR_RECT_RESP_NORMAL[indice];
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
        
        CRectangulo rect = ARR_RECT_RESP_LARGA[indice];
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
