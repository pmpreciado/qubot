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
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pmpreciado
 */
public class Imagen {

    
//    public static BufferedImage escalarImagen(BufferedImage imagen_original, float escala_horizontal, float escala_vertical) {
//        
//        int ancho = imagen_original.getWidth();
//        int alto = imagen_original.getHeight();
//        
//        BufferedImage imagen_escala = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
//
//        AffineTransform at = new AffineTransform();
//        at.scale(escala_horizontal, escala_vertical);
//        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//        imagen_escala = scaleOp.filter(imagen_original, imagen_escala);
//        return imagen_escala;
//    }
    
    
    

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
        
        BufferedImage img_escala = Imagen.escalarImagenMax(imagen_original, Comun.CAPTURA_PANTALLA_MAX_ANCHO, Comun.CAPTURA_PANTALLA_MAX_ALTO);
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
     * @throws java.io.IOException              Error al guardar el fichero
     */
    public static BufferedImage cargarImagenPng(String ruta_fichero) throws IOException {

        File fichero_entrada = new File(ruta_fichero);
        BufferedImage image = ImageIO.read(fichero_entrada);
        return image;
    }
    
    
    /**
     * Obtiene una cadena con la representación hexadecimal del color dado por sus componentes.
     *
     * @param r                             Componente rojo (0-255)
     * @param g                             Componente verde (0-255)
     * @param b                             Componente azul (0-255)
     *
     * @return                              Cadena generada (por ejemplo, "0F0A16"
     */
    public static String rgb2Hex(int r, int g, int b) {
        String s = "";

        String sr = Integer.toHexString(r);
        String sg = Integer.toHexString(g);
        String sb = Integer.toHexString(b);

        while (sr.length() < 2) sr = "0" + sr;
        while (sg.length() < 2) sg = "0" + sg;
        while (sb.length() < 2) sb = "0" + sb;

        s = sr + sg + sb;
        return s;
    }
    
    /**
     * Obtiene la representación hexadecimal RGB de un color dado.
     *
     * @param color                         Objeto de tipo Color
     *
     * @return                              Representación hexadecimal RGB del color, por ejemplo "0F0A16"
     */
    public static String color2Hex(Color color) {

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        String hex = rgb2Hex(r, g, b);
        return hex;
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

        int x_abs = Regiones.getCoordAbs(punto.x, ancho);
        int y_abs = Regiones.getCoordAbs(punto.y, alto);
        
        dibujarPuntoGrueso(imagen, x_abs, y_abs, color);
    }
    
    
    
    /**
     * Dibuja el rectángulo sobre la imagen dada.
     * El rectángulo se suministra con coordenadas relativas.
     * 
     * @param imagen                            Imagen
     * @param rectangulo                        Rectángulo
     * @param color                             Color
     */
    public static void dibujarRectangulo(BufferedImage imagen, CRectangulo rectangulo, Color color) {

        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        int x0 = Regiones.getCoordAbs(rectangulo.x0, ancho);
        int y0 = Regiones.getCoordAbs(rectangulo.y0, alto);
        int x1 = Regiones.getCoordAbs(rectangulo.x1, ancho);
        int y1 = Regiones.getCoordAbs(rectangulo.y1, alto);
        double ancho_rect = x1 - x0;
        double alto_rect = y1 - y0;
        
        Rectangle2D r2d = new Rectangle2D.Double(x0, y0, ancho_rect, alto_rect);
        
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(color);
        BasicStroke bs = new BasicStroke(3);
        g2d.setStroke(bs);
        
        g2d.draw(r2d);
    }
    
    
}
