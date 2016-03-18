/**
 * Puntos.java
 *
 * Creado el 17-mar-2016, 19:31:48
 */

package es.pmp.qubot.imagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Definición de puntos clave para las pantallas.
 * 
 * @author pmpreciado
 */
public class Puntos {

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


    /** Validaciones de colores de puntos de las pantallas */
    CPuntosColor pc_pregunta_larga_huecos;
    CPuntosColor pc_revancha_3_op;
    CPuntosColor pc_revancha_2_op;
    
    
    /**
     * 
     */
    public Puntos() {
        initPuntosColor();
    }
        
        
    public final void initPuntosColor() {
        
        
        pc_pregunta_larga_huecos = new CPuntosColor(Colores.COLOR_NEGRO_FONDO);
        pc_pregunta_larga_huecos.addPuntosVerticales(50, 70, 88);
        
        
        pc_revancha_3_op = new CPuntosColor(Colores.COLOR_VERDE_REVANCHA);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 58);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 65);
        pc_revancha_3_op.addPuntosVerticales(23, 58, 65);
        pc_revancha_3_op.addPuntosVerticales(77, 58, 65);
        
        pc_revancha_3_op.setColor(Colores.COLOR_ROJO_OTRO_ADVERSARIO);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 70.4);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 77.4);
        pc_revancha_3_op.addPuntosVerticales(23, 70.4, 77.4);
        pc_revancha_3_op.addPuntosVerticales(77, 70.4, 77.4);
        
        pc_revancha_3_op.setColor(Colores.COLOR_CIAN_VER_RESULTADOS);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 82.8);
        pc_revancha_3_op.addPuntosHorizontales(23, 77, 95.2);
        pc_revancha_3_op.addPuntosVerticales(23, 82.8, 95.2);
        pc_revancha_3_op.addPuntosVerticales(77, 82.8, 95.2);

        
        pc_revancha_2_op = new CPuntosColor(Colores.COLOR_ROJO_OTRO_ADVERSARIO);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 58);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 65);
        pc_revancha_2_op.addPuntosVerticales(23, 58, 65);
        pc_revancha_2_op.addPuntosVerticales(77, 58, 65);
        
        pc_revancha_2_op.setColor(Colores.COLOR_CIAN_VER_RESULTADOS);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 70.4);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 77.4);
        pc_revancha_2_op.addPuntosVerticales(23, 70.4, 77.4);
        pc_revancha_2_op.addPuntosVerticales(77, 70.4, 77.4);
        
        pc_revancha_2_op.setColor(Colores.COLOR_NEGRO_FONDO);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 82.8);
        pc_revancha_2_op.addPuntosHorizontales(23, 77, 95.2);
        pc_revancha_2_op.addPuntosVerticales(23, 82.8, 95.2);
        pc_revancha_2_op.addPuntosVerticales(77, 82.8, 95.2);
    }
    

    /**
     * Obtiene el color de un punto en una imagen.
     * 
     * @param imagen                            Imagen
     * @param x_abs                             Coordenada X absoluta
     * @param y_abs                             Coordenada Y absoluta
     * 
     * @return                                  Color del punto
     */
    public static Color getColorPunto(BufferedImage imagen, int x_abs, int y_abs) {
        int rgb = imagen.getRGB(x_abs, y_abs);
        Color color = new Color(rgb);
        return color;
    }
    
    
    /**
     * Obtiene el color de un punto en una imagen.
     * 
     * @param imagen                            Imagen
     * @param punto                             Punto a comprobar
     * 
     * @return                                  Color del punto
     */
    public static Color getColorPunto(BufferedImage imagen, CPunto punto) {
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        int x_abs = CPunto.getCoordAbs(punto.x, ancho);
        int y_abs = CPunto.getCoordAbs(punto.y, alto);
        Color color = getColorPunto(imagen, x_abs, y_abs);
        return color;
    }
    
}
