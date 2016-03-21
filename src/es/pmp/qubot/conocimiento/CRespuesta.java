/**
 * CRespuesta.java
 *
 * Creado el 21-mar-2016, 11:39:02
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.Comun;
import es.pmp.qubot.imagenes.Colores;
import es.pmp.qubot.imagenes.Imagenes;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author pmpreciado
 */
public class CRespuesta {

    public static final int ESTADO_DESCONOCIDO      = 0;
    public static final int ESTADO_SIN_RESPONDER    = 1;
    public static final int ESTADO_ACIERTO          = 2;
    public static final int ESTADO_FALLO            = 3;
    
    
    private static final String SEP = "|";
    
    /** Máxima diferencia permitida para que identificadores de preguntas se consideren similares (%) */
    public static final int MAX_DISTANCIA_ID_SIMILARES = 5;

    /** Umbral para considerar un píxel negro */
    public static final double UMBRAL_NEGRO = 80;

    public static final int UMBRAL_CONVERTIR_A_BLANCO = 40;
    
    
    BufferedImage imagen;
    
    int estado;
    
    
    /**
     * Identificador único para la respuesta. Es una cadena con este formato:
     *      PB|PN
     * 
     *      PB: Suma de píxeles blancos
     *      PN: Suma de píxeles negros
     */
    String id_unico;
    
    
    /**
     * Crea una instancia de la clase.
     * 
     * @param imagen 
     */
    public CRespuesta(BufferedImage imagen) {
        
        BufferedImage imagen_blanco = Imagenes.duplicarImagen(imagen);
        Imagenes.reemplazarColor(imagen_blanco, Colores.COLOR_VERDE_ACIERTO, Colores.COLOR_BLANCO_FONDO_PREGUNTA, UMBRAL_CONVERTIR_A_BLANCO);
        Imagenes.reemplazarColor(imagen_blanco, Colores.COLOR_ROJO_FALLO, Colores.COLOR_BLANCO_FONDO_PREGUNTA, UMBRAL_CONVERTIR_A_BLANCO);
        
        id_unico = generarIdUnico(imagen_blanco, UMBRAL_NEGRO);
        this.imagen = imagen;
        this.estado = detectarEstadoRespuesta(imagen);
    }

    
    /**
     * Genera un identificador único para la pregunta.
     * 
     * @param imagen                            Imagen de la pregunta
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     * 
     * @return                                  Identificador único
     */
    public static String generarIdUnico(BufferedImage imagen, double umbral_negro) {        
        //int [] bn = Imagenes.getSumaBnDobleVertical(imagen, UMBRAL_NEGRO);
        int [] bn = Imagenes.getSumaBn(imagen, UMBRAL_NEGRO);
        
        String id = bn[0] + SEP + bn[1];
        return id;
    }
    

    /**
     * Obtiene el identificador único para la pregunta.
     * 
     * @return                                  Identificador único para la pregunta
     */
    public String getIdUnico() {
        return id_unico;
    }

    
    /**
     * Retorna la imagen asociada.
     * 
     * @return                                  Imagen asociada
     */
    public BufferedImage getImagen() {
        return imagen;
    }

    
    
    /**
     * Detecta el estado de la respuesta, a partir de su color.
     * 
     * @param imagen
     * 
     * @return                                  Estado
     */
    public static int detectarEstadoRespuesta(BufferedImage imagen) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int rgb_si = imagen.getRGB(0, 0);
        int rgb_sd = imagen.getRGB(ancho - 1, 0);
        int rgb_ii = imagen.getRGB(0, alto - 1);
        int rgb_id = imagen.getRGB(ancho - 1, alto - 1);
        
        Color color_si = new Color(rgb_si);
        Color color_sd = new Color(rgb_sd);
        Color color_ii = new Color(rgb_ii);
        Color color_id = new Color(rgb_id);
        
        if (Colores.similares(color_si, Colores.COLOR_BLANCO_FONDO_PREGUNTA) &&
            Colores.similares(color_sd, Colores.COLOR_BLANCO_FONDO_PREGUNTA) &&
            Colores.similares(color_ii, Colores.COLOR_BLANCO_FONDO_PREGUNTA) &&
            Colores.similares(color_id, Colores.COLOR_BLANCO_FONDO_PREGUNTA)) 
        {
            return ESTADO_SIN_RESPONDER;
        }
        
        if (Colores.similares(color_si, Colores.COLOR_VERDE_ACIERTO) &&
            Colores.similares(color_sd, Colores.COLOR_VERDE_ACIERTO) &&
            Colores.similares(color_ii, Colores.COLOR_VERDE_ACIERTO) &&
            Colores.similares(color_id, Colores.COLOR_VERDE_ACIERTO)) 
        {
            return ESTADO_ACIERTO;
        }
        
        if (Colores.similares(color_si, Colores.COLOR_ROJO_FALLO) &&
            Colores.similares(color_sd, Colores.COLOR_ROJO_FALLO) &&
            Colores.similares(color_ii, Colores.COLOR_ROJO_FALLO) &&
            Colores.similares(color_id, Colores.COLOR_ROJO_FALLO)) 
        {
            return ESTADO_FALLO;
        }
        
        return ESTADO_DESCONOCIDO;
    }
    
    
    public int getEstado() {
        return estado;
    }
    
    public String getDescripcionEstado() {
        switch (estado) {
            case ESTADO_SIN_RESPONDER: return "Sin responder";
            case ESTADO_ACIERTO: return "Acierto";
            case ESTADO_FALLO: return "Fallo";
        }
        
        return "Desconocido";
    }

    
    /**
     * Obtiene la suma de píxeles blancos y negros a partir del identificador único.
     * 
     * @param id_unico
     * 
     * @return 
     */
    public static int [] getBn(String id_unico) {
        String [] sp = id_unico.split(SEP);
        int b0 = Integer.parseInt(sp[0]);
        int n0 = Integer.parseInt(sp[1]);
        //int b1 = Integer.parseInt(sp[2]);
        //int n1 = Integer.parseInt(sp[3]);
        
        //int [] result = {b0, n0, b1, n1};
        int [] result = {b0, n0};
        return result;
    }
    
    
    
    /**
     * Compara dos identificadores únicos de preguntas.
     * 
     * @param id_unico_1
     * @param id_unico_2
     * @param max_distancia                     Máxima distancia permitida en cada uno de los tres componentes (en %, de 0 a 100)
     * 
     * @return                                  'true' si los identificadores se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean idSimilares(String id_unico_1, String id_unico_2, int max_distancia) {
        
        int [] bn_1 = getBn(id_unico_1);
        int [] bn_2 = getBn(id_unico_2);
        boolean bn_similares = Comun.similares(bn_1, bn_2, max_distancia);
        if (!bn_similares) {
            return false;
        } 

        return true;
    }

    
    /**
     * Genera información de la respuesta.
     * 
     * @return 
     */
    public String getInfo() {
        StringBuilder s = new StringBuilder();
        s.append("Id: " + getIdUnico() + ", Estado: " + getDescripcionEstado());
        return s.toString();
    }
    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = "id_unico: " + id_unico + ", " + Comun.NL;
        s += "estado: " + this.estado + " - " + getDescripcionEstado() + Comun.NL;
        return s;
    }
}
