/**
 * Robot.java
 *
 * Creado el 14-mar-2016, 19:48:26
 */

package es.pmp.qubot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pmpreciado
 */
public class Controlador {

    Robot robot;
    
    public Controlador() {
    }
    
    
    
    public void testControl() {
        try {
             
            robot = new Robot();
            // Creates the delay of 5 sec so that you can open notepad before
            // Robot start writting
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_B);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_Y);
             
        } catch (AWTException awtex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, awtex);
        }
    }
}
