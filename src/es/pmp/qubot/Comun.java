/**
 * Comun.java
 *
 * Creado el 15-mar-2016, 12:04:46
 */

package es.pmp.qubot;

import java.io.File;

/**
 *
 * @author pmpreciado
 */
public class Comun {
    
    public static final String TITULO_VENTANA_VYSOR = "Vysor (Beta)";
    public static final String TITULO_VENTANA_NOTEPAD = "Bloc de notas";
    
    public static final String NL = System.getProperty("line.separator");
    
    public static final int CAPTURA_PANTALLA_MAX_ANCHO = 300;
    public static final int CAPTURA_PANTALLA_MAX_ALTO = 400;

    
    public static final String RUTA_CAPTURAS        = "imagenes/";
    public static final String RUTA_FICHERO_CAPTURAS = RUTA_CAPTURAS + "qubot_image.png";
    
    
    
    
    /**
     * Comprueba si una cadena dada representa un número entero.
     *
     * @param cadena                Cadena
     * @return                      'true' si la cadena representa un entero, 'false' si no
     */
    public static boolean esEntero(String cadena)
    {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (i == 0 && c == '-') continue;
            if (c < '0' || c > '9') return false;
        }

        return true;
    }
    

    /**
     * Obtiene los 'n' primeros caracteres de una cadena.
     *
     * @param cadena                        Cadena sobre la que se quiere extraer los caracteres
     * @param n                             'n' primeros caracteres a extraer
     * @return                              Subcadena extraída
     */
    public static String primeros(String cadena, int n) {
        if (cadena == null) return null;
        if (cadena.length() == 0) return "";
        if (n <= 0) return "";
        if (n > cadena.length()) n = cadena.length();

        String subcadena = cadena.substring(0, n);
        return subcadena;
    }


    /**
     * Obtiene los 'n' últimos caracteres de una cadena.
     *
     * @param cadena                        Cadena sobre la que se quiere extraer los caracteres
     * @param n                             'n' últimos caracteres a extraer
     * @return                              Subcadena extraída
     */
    public static String ultimos(String cadena, int n) {
        if (cadena == null) return null;
        if (cadena.length() == 0) return "";
        if (n <= 0) return "";
        if (n > cadena.length()) n = cadena.length();

        String subcadena = cadena.substring(cadena.length() - n);
        return subcadena;
    }
    

    /**
     * Dado un nombre de un fichero (o directorio + nombre), obtiene la extensión.
     * al nombre del fichero.
     *
     * @param nombre_fichero                Nombre del fichero
     * @return                              Extensión (sin el punto)
     * @see quitarExtension
     */
    public static String getExtension(String nombre_fichero)
    {
        // Quitamos el directorio, si lo hubiera
        int d = nombre_fichero.lastIndexOf("\\");
        if (d >= 0) nombre_fichero = Comun.ultimos(nombre_fichero, nombre_fichero.length() - d - 1);
        
        int p = nombre_fichero.lastIndexOf(".");
        if (p == -1) return "";

        String extension = nombre_fichero.substring(p + 1);
        return extension;
    }

    /**
     * Dado un nombre de fichero (o directorio + nombre), le quita la extensión.
     *
     * @param nombre_fichero                Nombre del fichero
     * @return                              Nombre sin .extensión
     * @see getExtension
     */
    public static String quitarExtension(String nombre_fichero)
    {
        String extension = getExtension(nombre_fichero);

        if (extension.length() > 0) {
            nombre_fichero = primeros(nombre_fichero, nombre_fichero.length() - extension.length() - 1);
        }

        return nombre_fichero;
    }
    
    
    
    /**
     * Obtiene un nombre de fichero inexistente a partir de un nombre de fichero dado.
     * Para ello, comprueba si ya existe un fichero con el nombre dado y, en caso
     * afirmativo, le añade un contador al nombre dado.
     * El contador se irá incrementando hasta dar con un nombre único.
     * Al nombre del fichero original se le añade un guión bajo y el contador (dos cifras)
     *
     * Ejemplos:
     *    ENTRADA               SALIDA
     *    fichero.txt   -->     fichero.txt (si no existe)
     *                  -->   o fichero_01.txt (si existe fichero.txt)
     *                  -->   o fichero_02.txt (si existen fichero.txt y fichero_01.txt)
     *                          ...
     *
     * @param nombre_inicial                Nombre del fichero inicial, incluyendo extensión, o ruta completa.
     * @return                              Nombre de fichero que no existe
     */
    public static String getNombreFicheroInexistente(String nombre_inicial) {
        File f = new File(nombre_inicial);

        String extension = getExtension(nombre_inicial);

        // Al nombre inicial le quitamos el ".extension"
        nombre_inicial = quitarExtension(nombre_inicial);

        String nombre = nombre_inicial;
        String ultimos_2 = Comun.ultimos(nombre_inicial, 2);
        int contador;
        boolean nombre_inicial_con_contador;
        if (nombre_inicial.length() > 3 &&  nombre_inicial.charAt(nombre_inicial.length() - 3) == '_'
            && esEntero(ultimos_2))
        {
            contador = Integer.parseInt(ultimos_2);
            nombre_inicial_con_contador = true;
        } else {
            contador = 0;
            nombre_inicial_con_contador = false;
        }


        while (f.exists()) {
            contador++;
            String s_contador = Integer.toString(contador);
            while (s_contador.length() < 2) s_contador = "0" + s_contador;

            if (nombre_inicial_con_contador)
            {
                nombre = Comun.primeros(nombre_inicial, nombre_inicial.length() - 3) + "_" + s_contador;
            } else {
                nombre = nombre_inicial + "_" + s_contador;
            }
            f = new File(nombre + "." + extension);
        }

        if (extension.length() == 0) return nombre;

        return nombre + "." + extension;
    }
    
    
    
    
    /**
     * Compara dos números por aproximación.
     * 
     * @param n1                                Primer número
     * @param n2                                Segundo número
     * @param max_distancia                     Máxima distancia permitida (en %, de 0 a 100)
     * 
     * @return                                  'true' si se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(double n1, double n2, int max_distancia) {
        double dist = n1 / n2;
        double inv_dist = Math.abs(1 - dist);
        double tpc_dist = inv_dist * 100;
        if (tpc_dist > max_distancia) {
            return false;
        }
        return true;
    }
    
    
    /**
     * Compara dos números por aproximación.
     * 
     * @param n1                                Primer número
     * @param n2                                Segundo número
     * @param max_distancia                     Máxima distancia permitida (en %, de 0 a 100)
     * 
     * @return                                  'true' si se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(int n1, int n2, int max_distancia) {
        boolean similares = similares((double) n1, (double) n2, max_distancia);
        return similares;
    }
    
    
    /**
     * Compara dos arrays de números por aproximación.
     * 
     * @param arr_n1                            Primer array de números
     * @param arr_n2                            Segundo array de números
     * @param max_distancia                     Máxima distancia permitida (en %, de 0 a 100)
     * 
     * @return                                  'true' si todos los elementos se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(double [] arr_n1, double [] arr_n2, int max_distancia) {
        
        for (int i = 0; i < arr_n1.length; i++) {
            double n1 = arr_n1[i];
            double n2 = arr_n2[i];
            boolean similares = similares(n1, n2, max_distancia);
            if (!similares) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * Compara dos arrays de números por aproximación.
     * 
     * @param arr_n1                            Primer array de números
     * @param arr_n2                            Segundo array de números
     * @param max_distancia                     Máxima distancia permitida (en %, de 0 a 100)
     * 
     * @return                                  'true' si todos los elementos se consideran similares
     *                                          'false' en caso contrario
     */
    public static boolean similares(int [] arr_n1, int [] arr_n2, int max_distancia) {
        
        for (int i = 0; i < arr_n1.length; i++) {
            int n1 = arr_n1[i];
            int n2 = arr_n2[i];
            boolean similares = similares(n1, n2, max_distancia);
            if (!similares) {
                return false;
            }
        }
        
        return true;
    }
    
    }
