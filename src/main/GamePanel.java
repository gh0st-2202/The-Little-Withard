package main;

import entity.Player;
import object.SuperObject;
import tile.PlainManager;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    /* AJUSTES DE LA PANTALLA */
    final int originalTileSize = 160; /* 160x160 tile */
    final int scale = 1;

    public final int tileSize = originalTileSize * scale; /* 160x160 pixels */
    public final int maxScreenCol = 12;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize * maxScreenCol; /* 1920 pixels */
    public final int screenHeight = tileSize * maxScreenRow; /* 960 pixels */

    /* AJUSTES DEL MUNDO */
    public final int maxWorldCor = 6;
    public final int maxWorldRow = 5;

    /* FPS */
    double FPS = 60;

    TileManager tileM = new TileManager(this);
    PlainManager pM = new PlainManager(this);
    Sound sound = new Sound();
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];

    /**
     * Este metodo establece las propiedades básicas de la ventana
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    /**
     * Este metodo permite hacer cosas en el juego ANTES de que se inicie
     * Es llamado en el main
     */
    public void setupGame(){
        aSetter.setObject();
        playMusic(0);

    }

    /**
     * Este metodo inicia el proceso del juego (para tener tiempo)
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Este metodo establece el límite de FPS con el que trabajaremos
     * ajustando las físicas a esta frecuencia de actualizado
     * Tocar estos parámetros hará que el juego no funcione
     * de la manera adecuada
     */
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

    /**
     * Este metodo actualiza toda la información cuando es llamado
     * (es llamado una vez en cada frame)
     */
    public void update(){
        player.update();
    }

    /**
     * Este metodo muestra por pantalla la información actualizada
     * (es llamado una vez en cada frame)
     * @param g Llama a la clase Graphics (encargada de dibujar los pixeles)
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // SUELO
        tileM.draw(g2);

        // ESTRUCTURAS DETRÁS DEL JUGADOR
        pM.drawBeforePlayer(g2);

        // OBJETOS
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        // JUGADOR
        player.draw(g2);

        // ESTRUCTURAS DELANTE DEL JUGADOR
        pM.drawAfterPlayer(g2);
        g2.dispose();
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
