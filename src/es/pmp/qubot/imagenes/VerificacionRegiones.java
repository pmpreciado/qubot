/**
 * Puntos.java
 *
 * Creado el 17-mar-2016, 19:31:48
 */

package es.pmp.qubot.imagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Definición de puntos clave para las pantallas.
 * 
 * @author pmpreciado
 */
public class VerificacionRegiones {


    /** Validaciones de colores de puntos de las pantallas */
    CPuntosColor pc_pregunta_larga_huecos;
    CPuntosColor pc_revancha_3_op;
    CPuntosColor pc_revancha_2_op;
    CPuntosColor pc_jugar;
    CPuntosColor pc_juega_ya;
    
    
    /**
     * 
     */
    public VerificacionRegiones() {
        initVerificaciones();
    }
        
        
    /**
     * Define los colores en que se deben encontrar las zonas.
     */
    public final void initVerificaciones() {
        
        pc_pregunta_larga_huecos = new CPuntosColor();
        pc_pregunta_larga_huecos.addPuntosVerticales(Regiones.PPREG_LVERT_CENTRAL, Colores.COLOR_NEGRO_FONDO_PREGUNTAS);
        
        pc_revancha_3_op = new CPuntosColor();
        pc_revancha_3_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_1, Colores.COLOR_VERDE_REVANCHA);
        pc_revancha_3_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_2, Colores.COLOR_ROJO_OTRO_ADVERSARIO);
        pc_revancha_3_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_3, Colores.COLOR_CIAN_VER_RESULTADOS);
        
        pc_revancha_2_op = new CPuntosColor();
        pc_revancha_2_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_1, Colores.COLOR_ROJO_OTRO_ADVERSARIO);
        pc_revancha_2_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_2, Colores.COLOR_CIAN_VER_RESULTADOS);
        pc_revancha_2_op.addPuntosRectangulares(Regiones.PREV_RECT_REVANCHA_BOTON_3, Colores.COLOR_NEGRO_FONDO_PREGUNTAS);
        
        pc_jugar = new CPuntosColor(Colores.COLOR_BLANCO_FONDO_PREGUNTA);
        pc_jugar.addPuntosRectangulares(Regiones.PJUG_RECT_JUGAR_BOTON_1);
        pc_jugar.addPuntosRectangulares(Regiones.PJUG_RECT_JUGAR_BOTON_2);
        pc_jugar.addPuntosRectangulares(Regiones.PJUG_RECT_JUGAR_BOTON_3);
        pc_jugar.addPuntosRectangulares(Regiones.PJUG_RECT_JUGAR_BOTON_4);
        pc_jugar.addPuntosVerticales(Regiones.PJUG_LVERT_IZQUIERDA, Colores.COLOR_NEGRO_FONDO_JUGAR);
        pc_jugar.addPuntosVerticales(Regiones.PJUG_LVERT_DERECHA, Colores.COLOR_NEGRO_FONDO_JUGAR);
        
        pc_juega_ya = new CPuntosColor();
        pc_juega_ya.addPuntosRectangulares(Regiones.PJYA_RECT_BOTON_JUEGA_YA, Colores.COLOR_BLANCO_FONDO_PREGUNTA);
        pc_juega_ya.addPunto(Regiones.PJYA_PUNTO_ROJO_BOTON_0, Colores.COLOR_SALMON_TEXTO_BOTON_JUGAR);
        pc_juega_ya.addPunto(Regiones.PJYA_PUNTO_ROJO_BOTON_1, Colores.COLOR_SALMON_TEXTO_BOTON_JUGAR);
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
