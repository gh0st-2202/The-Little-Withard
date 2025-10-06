package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    /**
     * Este metodo es el encargado de centrar al jugador y crear su hitbox
     * @param gp Llama a GamePanel
     * @param keyH La tecla que se pulsa
     */
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - 80;
        screenY = gp.screenHeight / 2 - 80;

        solidArea = new Rectangle(57, 80, 36, 36);

        setDefaultValues();
        getPlayerImage();
    }

    /**
     * Este metodo establece los valores predeterminados del jugador
     */
    public void setDefaultValues() {
        worldX = 10;
        worldY = 10;
        speed = 3;
        direction = "down";
    }

    /**
     * Este metodo es el encargado de cargar todas las texturas del jugador
     */
    public void getPlayerImage(){

        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/down/down_8.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/left/left_8.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/right/right_8.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/player/movimiento/up/up_8.png"));


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Este metodo es el encargado de actualizar los datos del jugador
     * Es llamado en main.GamePanel.update() para ser actualizado al ritmo del reloj del juego
     */
    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            if(!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed + 1;
                        break;
                    case "down":
                        worldY += speed + 1;
                        break;
                    case "left":
                        worldX -= speed + 1;
                        break;
                    case "right":
                        worldX += speed + 1;
                        break;
                }
            }

            spriteCounter++;

            if (spriteCounter > 4) {
                if (spriteNum == 1) {
                    spriteNum ++;
                } else if (spriteNum == 2) {
                    spriteNum ++;
                } else if (spriteNum == 3) {
                    spriteNum ++;
                } else if (spriteNum == 4) {
                    spriteNum ++;
                } else if (spriteNum == 5) {
                    spriteNum ++;
                } else if (spriteNum == 6) {
                    spriteNum ++;
                } else if (spriteNum == 7) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    /**
     * Este metodo es el encargado de dibujar la información actualizada sobre el personaje
     * Es llamado en main.GamePanel.update() para ser actualizado al ritmo del reloj del juego
     * @param g2
     */
    public void draw(Graphics g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                if(spriteNum == 3){image = up3;}
                if(spriteNum == 4){image = up4;}
                if(spriteNum == 5){image = up5;}
                if(spriteNum == 6){image = up6;}
                if(spriteNum == 7){image = up7;}
                if(spriteNum == 8){image = up8;}
                break;
            case "down":
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                if(spriteNum == 3){image = down3;}
                if(spriteNum == 4){image = down4;}
                if(spriteNum == 5){image = down5;}
                if(spriteNum == 6){image = down6;}
                if(spriteNum == 7){image = down7;}
                if(spriteNum == 8){image = down8;}
                break;
            case "left":
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                if(spriteNum == 3){image = left3;}
                if(spriteNum == 4){image = left4;}
                if(spriteNum == 5){image = left5;}
                if(spriteNum == 6){image = left6;}
                if(spriteNum == 7){image = left7;}
                if(spriteNum == 8){image = left8;}
                break;
            case "right":
                if(spriteNum == 1){image = right1;}
                if(spriteNum == 2){image = right2;}
                if(spriteNum == 3){image = right3;}
                if(spriteNum == 4){image = right4;}
                if(spriteNum == 5){image = right5;}
                if(spriteNum == 6){image = right6;}
                if(spriteNum == 7){image = right7;}
                if(spriteNum == 8){image = right8;}
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
