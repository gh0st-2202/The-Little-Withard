package main;

import javax.swing.*;

public class Main {
    /**
     * Metodo principal del juego
     * Se establecen el nombre de ventana y se crea la ventana
     * @param args
     */
    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setTitle("El pequeño mago");

        GamePanel gamePanel = new GamePanel();
        ventana.add(gamePanel);

        ventana.pack();

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        gamePanel.setupGame();

        gamePanel.startGameThread();
    }
}
