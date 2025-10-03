package main;

import entity.Player;
import tile.PlainManager;
import tile.Tile;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    /* AJUSTES DE LA PANTALLA */
    final int originalTileSize = 160; /* 32x32 tile */
    final int scale = 1;

    public final int tileSize = originalTileSize * scale; /* 160x160 pixels */
    public final int maxScreenCol = 12;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize * maxScreenCol; /* 1920 pixels */
    public final int screenHeight = tileSize * maxScreenRow; /* 960 pixels */

    // AJUSTES DEL MUNDO
    public final int maxWorldCor = 6;
    public final int maxWorldRow = 5;
    public final int worldWidth = maxWorldCor * 46;
    public final int worldHeight = maxWorldRow * 36;

    // FPS
    double FPS = 60;

    TileManager tileM = new TileManager(this);
    PlainManager pM = new PlainManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        pM.drawBeforePlayer(g2);
        player.draw(g2);
        pM.drawAfterPlayer(g2);
        g2.dispose();
    }
}
