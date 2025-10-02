package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){

        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_3.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_4.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_5.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_6.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_7.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_3.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_4.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_5.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_6.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_7.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_3.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_4.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_5.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_6.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_7.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_3.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_4.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_5.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_6.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_7.png"));



        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            if (keyH.downPressed) {
                direction = "down";
                y += speed;
            }
            if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;

            if (spriteCounter > 3) {
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
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
