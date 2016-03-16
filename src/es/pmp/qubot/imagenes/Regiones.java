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



    /** Colores */
    public static final String COLOR_RGB_NEGRO_FONDO                = "010001";
    public static final String COLOR_RGB_BLANCO_FONDO_PREGUNTA      = "ffffff";
    public static final String COLOR_RGB_VERDE_ACIERTO              = "037c46";
    public static final String COLOR_RGB_ROJO_FALLO                 = "9a3234";
    
    public static final String COLOR_RGB_VERDE_REVANCHA             = COLOR_RGB_VERDE_ACIERTO;
    public static final String COLOR_RGB_ROJO_OTRO_ADVERSARIO       = "ff5557";
    public static final String COLOR_RGB_CIAN_VER_RESULTADOS        = "02b5db";
    
    
    public static final String COLOR_RGB_AZUL_MARCO_VYSOR           = "468FCC";

  
    
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
                
                
                
        /** Puntos destacados */
            
            /** Puntos pertenecientes a huecos entre las respuestas a izquierda y derecha en preguntas largas */
            public static final CPunto PT_HUECO_ENTRE_PREGUNTAS_LARGAS_1 = new CPunto(50, 70);
            public static final CPunto PT_HUECO_ENTRE_PREGUNTAS_LARGAS_2 = new CPunto(50, 76);
            public static final CPunto PT_HUECO_ENTRE_PREGUNTAS_LARGAS_3 = new CPunto(50, 82);
            public static final CPunto PT_HUECO_ENTRE_PREGUNTAS_LARGAS_4 = new CPunto(50, 88);

            public static final CPunto ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS [] = {
                PT_HUECO_ENTRE_PREGUNTAS_LARGAS_1,
                PT_HUECO_ENTRE_PREGUNTAS_LARGAS_2,
                PT_HUECO_ENTRE_PREGUNTAS_LARGAS_3,
                PT_HUECO_ENTRE_PREGUNTAS_LARGAS_4
            };
                
        
            
            
            
            
    /**
     * Obtiene la coordenada absoluta a partir de la coordenada relativa (en %) y la dimensión de la imagen (ancho o alto).
     * 
     * @param coordenada_relativa               Coordenada relativa X o Y (en %)
     * @param dimension_imagen                  Ancho o alto de la imagen
     * 
     * @return                                  Coordenada absoluta
     */
    public static int getCoordAbs(double coordenada_relativa, int dimension_imagen) {
        double f_coordenada_absoluta = coordenada_relativa * (double) dimension_imagen / (double) 100;
        int coordenada_absoluta = (int) f_coordenada_absoluta;
        return coordenada_absoluta;
    }
    
   
    
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
        
        int abs_x = getCoordAbs(rel_x, ancho);
        int abs_y = getCoordAbs(rel_y, alto);

        int rgb = imagen.getRGB(abs_x, abs_y);
        Color color = new Color(rgb);
        String hex_color = Imagen.color2Hex(color);

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
        double fila_abs = getCoordAbs(fila, ancho);
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
        double col_abs = getCoordAbs(col, alto);
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
        Imagen.dibujarRectangulo(imagen, RECT_ENUNCIADO_NORMAL, Color.YELLOW);
        Imagen.dibujarRectangulo(imagen, RECT_ENUNCIADO_LARGA, Color.YELLOW);
        
        // Recuadros preguntas normales
        for (int i = 0; i < ARR_RECT_RESP_NORMAL.length; i++) {
            CRectangulo rectangulo = ARR_RECT_RESP_NORMAL[i];
            Imagen.dibujarRectangulo(imagen, rectangulo, Color.RED);
        }
        
        // Recuadros preguntas largas
        for (int i = 0; i < ARR_RECT_RESP_LARGA.length; i++) {
            CRectangulo rectangulo = ARR_RECT_RESP_LARGA[i];
            Imagen.dibujarRectangulo(imagen, rectangulo, Color.GREEN);
        }
        
        // Huecos entre preguntas largas
        for (int i = 0; i < ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS.length; i++) {
            CPunto punto = ARR_PT_HUECOS_ENTRE_PREGUNTAS_LARGAS[i];
            Imagen.dibujarPuntoGrueso(imagen, punto, Color.RED);
        }
    }
    
    
    
    /**
     * Traza las regiones definidas sobre una imagen dada de la pantalla de revancha.
     * 
     * @param imagen                            Imagen con la pantalla
     */
    public static void trazarRegionesRevancha(BufferedImage imagen) {

        // Enunciados
        Imagen.dibujarRectangulo(imagen, RECT_REVANCHA, Color.CYAN);
        Imagen.dibujarRectangulo(imagen, RECT_OTRO_ADVERSARIO, Color.RED);        
        Imagen.dibujarRectangulo(imagen, RECT_VER_RESULTADOS, Color.YELLOW);        
    }
    
    
}
