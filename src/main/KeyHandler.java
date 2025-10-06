package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed,  downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    /**
     * Este metodo detecta cuando es pulsada una tecla y se lo dice al juego
     * @param e El codigo de la tecla que es pulsada
     */

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    /**
     * Este metodo detecta cuando una tecla deja de ser pulsada y se lo dice al juego
     * @param e La tecla que deja de ser pulsada
     */
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
