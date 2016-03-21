/**
 * Imagen.java
 *
 * Creado el 15-mar-2016, 14:08:39
 */

package es.pmp.qubot.imagenes;

import es.pmp.qubot.Comun;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pmpreciado
 */
public class Imagenes {


    /**
     * Comprueba si la imagen dada contiene píxeles transparentes.
     * 
     * @param image                         Imagen a comprobar
     * 
     * @return                              'true' si la imagen contiene píxeles transparentes
     *                                      'false' en caso contrario
     */
    public static boolean hasAlpha(Image image) {
        
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage)image;
            return bimage.getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }

        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        if (cm == null) {
            return false;
        }
        
        return cm.hasAlpha();
    }

    
    
    /**
     * Redimensiona una imagen al ancho y al alto dados.
     * 
     * @param imagen_original
     * @param nuevo_ancho
     * @param nuevo_alto
     * 
     * @return 
     */
    public static BufferedImage escalarImagen(BufferedImage imagen_original, int nuevo_ancho, int nuevo_alto) {
        
        int ancho = imagen_original.getWidth();
        int alto = imagen_original.getHeight();
        
        BufferedImage imagen_escala = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagen_escala.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imagen_original, 0, 0, nuevo_ancho, nuevo_alto, null);
        g2.dispose();
        
        
        BufferedImage imagen_escala_recortada = imagen_escala.getSubimage(0, 0, nuevo_ancho, nuevo_alto);
        imagen_escala_recortada.flush();
        return imagen_escala_recortada;
    }
    
    
    /**
     * Escala una imagen para que ocupe como máximo el ancho y el alto dados.
     * 
     * @param imagen_original
     * @param max_ancho
     * @param max_alto
     * 
     * @return 
     */
    public static BufferedImage escalarImagenMax(BufferedImage imagen_original, int max_ancho, int max_alto) {
        
        int ancho = imagen_original.getWidth();
        int alto = imagen_original.getHeight();

        float escala_horizontal = 1;
        float escala_vertical = 1;
        
        if (ancho > max_ancho) {
            escala_horizontal = (float) max_ancho / (float) ancho;
        }
        if (alto > max_alto) {
            escala_vertical = (float) max_alto / (float) alto;
        }
        
        float escala = Math.min(escala_horizontal, escala_vertical);
        
        float f_nuevo_ancho = (float) ancho * escala;
        float f_nuevo_alto = (float) alto * escala;
        
        int nuevo_ancho = (int) f_nuevo_ancho;
        int nuevo_alto = (int) f_nuevo_alto;
        
        BufferedImage imagen_escala = escalarImagen(imagen_original, nuevo_ancho, nuevo_alto);
        
        return imagen_escala;
    }
    
    
    
    /**
     * Redimensiona una imagen a las dimensiones estándar de la aplicación.
     * 
     * @param imagen_original
     * 
     * @return 
     */
    public static BufferedImage escalarImagenStd(BufferedImage imagen_original) {
        
        BufferedImage img_escala = Imagenes.escalarImagenMax(imagen_original, Comun.CAPTURA_PANTALLA_MAX_ANCHO, Comun.CAPTURA_PANTALLA_MAX_ALTO);
        return img_escala;
    }
    
    
    /**
     * Guarda en disco una imagen en formato PNG.
     * 
     * @param imagen                            Imagen a guardar
     * @param ruta_fichero                      Ruta para guardar la imagen
     * 
     * @return                                  Ruta del fichero generado
     * 
     * @throws java.io.IOException              Error al guardar el fichero
     */
    public static String guardarImagenPng(BufferedImage imagen, String ruta_fichero) throws IOException {

        File fichero_salida = new File(ruta_fichero);
        ImageIO.write(imagen, "png", fichero_salida);
        
        String ruta = fichero_salida.getAbsolutePath();
        return ruta;
    }

    
    /**
     * Carga una imagen en formato PNG.
     * 
     * @param ruta_fichero                      Ruta del fichero que contiene la imagen
     * 
     * @return                                  Imagen cargada
     * 
     * @throws Exception                        Error al cargar el fichero
     */
    public static BufferedImage cargarImagenPng(String ruta_fichero) throws Exception {
        BufferedImage image;
        File fichero_entrada = new File(ruta_fichero);
        try {
            image = ImageIO.read(fichero_entrada);
            
        } catch (IOException ioex) {
            String mensaje = "No se puede cargar el fichero " + fichero_entrada.getAbsolutePath();
            throw new Exception(mensaje, ioex);
        }
        
        return image;
    }
    
    
    
    /**
     * Dibuja un punto grueso sobre una imagen.
     * El punto ocupa un área de 3x3.
     * 
     * @param imagen
     * @param x
     * @param y
     * @param color
     */
    public static void dibujarPuntoGrueso(BufferedImage imagen, int x, int y, Color color) {
        int rgb = color.getRGB();
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int x2 = x;
        int y2 = y;
        
        x2 = x - 1;
        y2 = y - 1;
        if (x2 >= 0 && y2 >= 0) {
            imagen.setRGB(x2, y2, rgb);
        }
        
        x2 = x;
        y2 = y - 1;
        if (y2 >= 0) {
            imagen.setRGB(x2, y2, rgb);
        }
        
        x2 = x + 1;
        y2 = y - 1;
        if (x2 < ancho && y2 >= 0) {
            imagen.setRGB(x2, y2, rgb);
        }

        x2 = x - 1;
        y2 = y;
        if (x2 >= 0) {
            imagen.setRGB(x2, y2, rgb);
        }

        x2 = x;
        y2 = y;
        imagen.setRGB(x2, y2, rgb);
        
        x2 = x + 1;
        y2 = y;
        if (x2 < ancho) {
            imagen.setRGB(x2, y2, rgb);
        }
        
        
        x2 = x - 1;
        y2 = y + 1;
        if (x2 >= 0 && y2 < alto) {
            imagen.setRGB(x2, y2, rgb);
        }
        
        x2 = x;
        y2 = y + 1;
        if (y2 < alto) {
            imagen.setRGB(x2, y2, rgb);
        }
        
        x2 = x + 1;
        y2 = y + 1;
        if (x2 < ancho && y2 < alto) {
            imagen.setRGB(x2, y2, rgb);
        }
    }
    
    
    /**
     * Dibuja un punto grueso sobre una imagen.
     * El punto ocupa un área de 3x3.
     * Se suministra con coordenadas relativas.
     * 
     * @param imagen
     * @param punto
     * @param color
     */
    public static void dibujarPuntoGrueso(BufferedImage imagen, CPunto punto, Color color) {
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        int x_abs = CPunto.getCoordAbs(punto.x, ancho);
        int y_abs = CPunto.getCoordAbs(punto.y, alto);
        
        dibujarPuntoGrueso(imagen, x_abs, y_abs, color);
    }
    
    
    /**
     * Dibuja una línea vertical sobre la imagen dada.
     * La línea se suministra con coordenadas relativas.
     * 
     * @param imagen                            Imagen
     * @param linea_vertical                    Línea vertical
     * @param color                             Color
     */
    public static void dibujarLinea(BufferedImage imagen, CLineaVertical linea_vertical, Color color) {

        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        int x = CPunto.getCoordAbs(linea_vertical.x, ancho);
        int y0 = CPunto.getCoordAbs(linea_vertical.y0, alto);
        int y1 = CPunto.getCoordAbs(linea_vertical.y1, alto);
        
        Line2D linea_2d = new Line2D.Double(x, y0, x, y1);
        
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(color);
        BasicStroke bs = new BasicStroke(3);
        g2d.setStroke(bs);
        
        g2d.draw(linea_2d);
    }
    
    
    /**
     * Dibuja una línea horizontal sobre la imagen dada.
     * La línea se suministra con coordenadas relativas.
     * 
     * @param imagen                            Imagen
     * @param linea_horizontal                    Línea vertical
     * @param color                             Color
     */
    public static void dibujarLinea(BufferedImage imagen, CLineaHorizontal linea_horizontal, Color color) {

        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        int x0 = CPunto.getCoordAbs(linea_horizontal.x0, ancho);
        int x1 = CPunto.getCoordAbs(linea_horizontal.x1, ancho);
        int y = CPunto.getCoordAbs(linea_horizontal.y, alto);
        
        Line2D linea_2d = new Line2D.Double(x0, y, x1, y);
        
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(color);
        BasicStroke bs = new BasicStroke(3);
        g2d.setStroke(bs);
        
        g2d.draw(linea_2d);
    }
    
    
    /**
     * Dibuja un rectángulo sobre la imagen dada.
     * El rectángulo se suministra con coordenadas relativas.
     * 
     * @param imagen                            Imagen
     * @param rectangulo                        Rectángulo
     * @param color                             Color
     */
    public static void dibujarRectangulo(BufferedImage imagen, CRectangulo rectangulo, Color color) {

        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        int x0 = CPunto.getCoordAbs(rectangulo.x0, ancho);
        int y0 = CPunto.getCoordAbs(rectangulo.y0, alto);
        int x1 = CPunto.getCoordAbs(rectangulo.x1, ancho);
        int y1 = CPunto.getCoordAbs(rectangulo.y1, alto);
        double ancho_rect = x1 - x0 + 1;
        double alto_rect = y1 - y0 + 1;
        
        Rectangle2D rectangulo_2d = new Rectangle2D.Double(x0, y0, ancho_rect, alto_rect);
        
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(color);
        BasicStroke bs = new BasicStroke(3);
        g2d.setStroke(bs);
        
        g2d.draw(rectangulo_2d);
    }


    /**
     * Duplica una imagen dada.
     * 
     * @param imagen_original                   Imagen a duplicar
     * 
     * @return                                  Imagen duplicada
     */
    public static BufferedImage duplicarImagen(BufferedImage imagen_original) {
        ColorModel cm = imagen_original.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = imagen_original.copyData(null);
        BufferedImage imagen_duplicada = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        return imagen_duplicada;
    }
    
    
    /**
     * Extrae un recorte de una imagen dada.
     * 
     * @param imagen_original                   Imagen a duplicar
     * @param rectangulo                        Rectángulo a extraer, con las coordenadas relativas
     * 
     * @return                                  Imagen extraída
     */
    public static BufferedImage extraerSubimagen(BufferedImage imagen_original, CRectangulo rectangulo) {
        BufferedImage recorte = duplicarImagen(imagen_original);
        
        int ancho = imagen_original.getWidth();
        int alto = imagen_original.getHeight();
        
        int x0_abs = CPunto.getCoordAbs(rectangulo.x0, ancho);
        int y0_abs = CPunto.getCoordAbs(rectangulo.y0, alto);
        int x1_abs = CPunto.getCoordAbs(rectangulo.x1, ancho);
        int y1_abs = CPunto.getCoordAbs(rectangulo.y1, alto);
        
        int ancho_abs = x1_abs - x0_abs;
        int alto_abs = y1_abs - y0_abs;
        
        recorte = recorte.getSubimage(x0_abs, y0_abs, ancho_abs, alto_abs);
        return recorte;
    }
    


    /**
     * Reemplaza un color por otro en una imagen dada.
     * 
     * @param imagen                            Imagen
     * @param color_origen
     * @param color_destino
     * @param max_distancia                     Máxima distancia permitida en cada uno de los tres componentes (en valor absoluto, 0-255)
     */
    public static void reemplazarColor(BufferedImage imagen, Color color_origen, Color color_destino, int max_distancia) {
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int color_destino_rgb = color_destino.getRGB();

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                Color color_pixel = new Color(rgb);
                boolean similares = Colores.similares(color_pixel, color_origen, max_distancia);
                if (similares) {
                    imagen.setRGB(x, y, color_destino_rgb);
                }
            }
        }
    }
    
    
    
    /**
     * Obtiene la suma de los componentes de colores de una imagen.
     * 
     * @param imagen                            Imagen
     * 
     * @return                                  Array de tres posiciones
     *                                              0: Suma de componentes rojos
     *                                              1: Suma de componentes verdes
     *                                              2: Suma de componentes azules
     */
    public static int [] getSumaComponentes(BufferedImage imagen) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int suma_red = 0;
        int suma_green = 0;
        int suma_blue = 0;
        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                int red   = (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue  =  rgb & 0x000000ff;
                
                suma_red    += red;
                suma_green  += green;
                suma_blue   += blue;
            }
        }
        
        int [] result = {
            suma_red,
            suma_green,
            suma_blue
        };
                
        return result;
    }
    
    
    /**
     * Dado un color, comprueba si se puede considerar negro.
     * 
     * @param rgb                               Color
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     *                                          A mayor sea, se aceptan como negros colores más claros
     *                                          Si es 0, sólo se considerará negro el negro puro
     * 
     * @return                                  'true' si el color se puede considerar negro
     *                                          'false' en caso contrario
     */
    public static boolean esNegro(int rgb, double umbral_negro) {
        int red   = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue  =  rgb & 0x000000ff;
        
        double bw = 0.2126 * red  + 0.7152 * green + 0.0722 * blue;
        double umbral_255 = umbral_negro * 255 / 100;
        
        if (bw < umbral_255) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Obtiene la suma de píxeles blancos y negros de una imagen.
     * Los píxeles de la imagen son reducidos a blanco o negro.
     * 
     * @param imagen                            Imagen
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     * 
     * @return                                  array de dos posiciones
     *                                              0: Suma de píxeles blancos
     *                                              1: Suma de píxeles negros
     */
    public static int [] getSumaBn(BufferedImage imagen, double umbral_negro) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int suma_b = 0;
        int suma_n = 0;
        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                boolean es_negro = esNegro(rgb, umbral_negro);

                if (es_negro) {
                    suma_n++;
                } else {
                    suma_b++;
                }
            }
        }
        
        int [] result = {
            suma_b,
            suma_n
        };
                
        return result;
    }

    
    /**
     * Obtiene la suma de píxeles blancos y negros de una imagen.
     * Los píxeles de la imagen son reducidos a blanco o negro.
     * Hace dos sumas:
     *     Por un lado, la mitad superior de la imagen
     *     Por otro, la mitad inferior
     * 
     * @param imagen                            Imagen
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     * 
     * @return                                  array de dos posiciones
     *                                              0: Suma de píxeles blancos mitad superior
     *                                              1: Suma de píxeles negros mitad superior
     *                                              2: Suma de píxeles blancos mitad inferior
     *                                              2: Suma de píxeles negros mitad inferior
     */
    public static int [] getSumaBnDobleVertical(BufferedImage imagen, double umbral_negro) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        int mitad_alto = alto / 2;
        
        int suma_b_0 = 0;
        int suma_n_0 = 0;
        int suma_b_1 = 0;
        int suma_n_1 = 0;

        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                boolean es_negro = esNegro(rgb, umbral_negro);

                if (y < mitad_alto) {
                    if (es_negro) {
                        suma_n_0++;
                    } else {
                        suma_b_0++;
                    }
                } else {
                    if (es_negro) {
                        suma_n_1++;
                    } else {
                        suma_b_1++;
                    }
                }
            }
        }
        
        int [] result = {
            suma_b_0,
            suma_n_0,
            suma_b_1,
            suma_n_1            
        };
                
        return result;
    }

    
    
    /**
     * Obtiene la suma de píxeles blancos y negros de una imagen.
     * Los píxeles de la imagen son reducidos a blanco o negro.
     * Hace dos sumas:
     *     Por un lado, la mitad izquierda de la imagen
     *     Por otro, la mitad derecha
     * 
     * @param imagen                            Imagen
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     * 
     * @return                                  array de dos posiciones
     *                                              0: Suma de píxeles blancos mitad izquierda
     *                                              1: Suma de píxeles negros mitad izquierda
     *                                              2: Suma de píxeles blancos mitad derecha
     *                                              2: Suma de píxeles negros mitad derecha
     */
    public static int [] getSumaBnDobleHorizontal(BufferedImage imagen, double umbral_negro) {
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        int mitad_ancho = ancho / 2;
        
        int suma_b_0 = 0;
        int suma_n_0 = 0;
        int suma_b_1 = 0;
        int suma_n_1 = 0;

        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                boolean es_negro = esNegro(rgb, umbral_negro);

                if (y < mitad_ancho) {
                    if (es_negro) {
                        suma_n_0++;
                    } else {
                        suma_b_0++;
                    }
                } else {
                    if (es_negro) {
                        suma_n_1++;
                    } else {
                        suma_b_1++;
                    }
                }
            }
        }
        
        int [] result = {
            suma_b_0,
            suma_n_0,
            suma_b_1,
            suma_n_1            
        };
                
        return result;
    }
    
    /**
     * Convierte uma imagen dada a blanco y negro.
     * 
     * @param imagen
     * @param umbral_negro                      Umbral de negro, expresado en % (0 a 100)
     *                                          A mayor sea, se aceptan como negros colores más claros
     *                                          Si es 0, sólo se considerará negro el negro puro
     */
    public static void convertirBlancoYNegro(BufferedImage imagen, double umbral_negro) {
        
        Color color_negro = Color.BLACK;
        Color color_blanco = Color.WHITE;
        
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        
        int suma_b = 0;
        int suma_n = 0;
        
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int rgb = imagen.getRGB(x, y);
                boolean es_negro = esNegro(rgb, umbral_negro);
                
                if (es_negro) {
                    imagen.setRGB(x, y, color_negro.getRGB());
                } else {
                    imagen.setRGB(x, y, color_blanco.getRGB());
                }
            }
        }
    }
    
}
