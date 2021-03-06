/**
 * CPregunta.java
 *
 * Creado el 21-mar-2016, 11:38:49
 */

package es.pmp.qubot.conocimiento;

import es.pmp.qubot.Comun;
import es.pmp.qubot.imagenes.Imagenes;
import java.awt.image.BufferedImage;

/**
 *
 * @author pmpreciado
 */
public class CPregunta {

    
    private static final String SEP_ID = "_";
    
    /** Máxima diferencia permitida para que identificadores de preguntas se consideren similares (%) */
    public static final int MAX_DISTANCIA_ID_SIMILARES = 5;

    /** Umbral para considerar un píxel negro */
    public static final double UMBRAL_NEGRO = 50;

    /** Imagen de la pregunta */
    BufferedImage imagen;

    
    /** Atributos usados para identificar la pregunta */
    
        /** Componentes RGB */
        public int suma_r;
        public int suma_g;
        public int suma_b;

        /** Píxeles blancos y negros */
        public int suma_blancos_sup;
        public int suma_negros_sup;
        public int suma_blancos_inf;
        public int suma_negros_inf;

    
    
    /**
     * Identificador único para la pregunta. Es una cadena con este formato:
     *      R|G|B|PB0|PN0|PB1|PN1
     * 
     *      R:   Suma de componentes rojos
     *      G:   Suma de componentes verdes
     *      B:   Suma de componentes azules
     *      PB0: Suma de píxeles blancos mitad superior
     *      PN0: Suma de píxeles negros mitad superior
     *      PB1: Suma de píxeles blancos mitad inferior
     *      PN1: Suma de píxeles negros mitad inferior
     */
    String id_unico;
    
    
    
    /**
     * Crea una instancia de la clase.
     * 
     * @param imagen 
     */
    public CPregunta(BufferedImage imagen) {
        this.id_unico = generarIdUnico(imagen);
        setAtributosIdentificadores(this.id_unico);
        this.imagen = imagen;
    }


    /**
     * Genera y establece los identificadores para la pregunta a partir de su imagen.
     * 
     * @param id_unico
     */
    private void setAtributosIdentificadores(String id_unico) {
        String [] arr_sp = id_unico.split(SEP_ID);
        
        int c = 0;
        suma_r = Integer.parseInt(arr_sp[c++]);
        suma_g = Integer.parseInt(arr_sp[c++]);
        suma_b = Integer.parseInt(arr_sp[c++]);

        suma_blancos_sup = Integer.parseInt(arr_sp[c++]);
        suma_negros_sup = Integer.parseInt(arr_sp[c++]);
        suma_blancos_inf = Integer.parseInt(arr_sp[c++]);
        suma_negros_inf = Integer.parseInt(arr_sp[c++]);
    }

    
    
    /**
     * Genera un identificador único para la pregunta.
     * 
     * @param imagen                            Imagen de la pregunta
     * 
     * @return                                  Identificador único
     */
    public static String generarIdUnico(BufferedImage imagen) {        
        int [] rgb = Imagenes.getSumaComponentes(imagen);
        int [] bn = Imagenes.getSumaBnDobleVertical(imagen, UMBRAL_NEGRO);
        String id = rgb[0] + SEP_ID + rgb[1] + SEP_ID + rgb[2] + SEP_ID + bn[0] + SEP_ID + bn[1] + SEP_ID + bn[2] + SEP_ID + bn[3];
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
     * Obtiene los componentes RGB a partir del identificador único.
     * 
     * @param id_unico
     * 
     * @return 
     */
    public static int [] getRgb(String id_unico) {
        String [] sp = id_unico.split(SEP_ID);
        int r = Integer.parseInt(sp[0]);
        int g = Integer.parseInt(sp[1]);
        int b = Integer.parseInt(sp[2]);
        
        int [] result = {r, g, b};
        return result;
    }
    
    
    /**
     * Obtiene la suma de píxeles blancos y negros a partir del identificador único.
     * 
     * @param id_unico
     * 
     * @return 
     */
    public static int [] getBn(String id_unico) {
        String [] sp = id_unico.split(SEP_ID);
        int b0 = Integer.parseInt(sp[3]);
        int n0 = Integer.parseInt(sp[4]);
        int b1 = Integer.parseInt(sp[5]);
        int n1 = Integer.parseInt(sp[6]);
        
        int [] result = {b0, n0, b1, n1};
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
        int [] rgb_1 = getRgb(id_unico_1);
        int [] rgb_2 = getRgb(id_unico_2);
        
        boolean rgb_similares = Comun.similares(rgb_1, rgb_2, max_distancia);
        if (!rgb_similares) {
            return false;
        }
        
        int [] bn_1 = getBn(id_unico_1);
        int [] bn_2 = getBn(id_unico_2);
        boolean bn_similares = Comun.similares(bn_1, bn_2, max_distancia);
        if (!bn_similares) {
            return false;
        } 

        return true;
    }

    
    
    /**
     * Genera una cadena con la información de la instancia.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String s = "id_unico: " + id_unico;
        return s;
    }
}
