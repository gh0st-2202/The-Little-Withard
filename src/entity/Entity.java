package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Esta clase establece los requisitos obligatorios para poder crear una entidad
 */
public class Entity {
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, up3, up4, up5, up6, up7, up8,
            down1, down2, down3, down4, down5, down6, down7, down8,
            left1, left2, left3, left4, left5, left6, left7, left8,
            right1, right2, right3, right4, right5, right6, right7, right8,
            upLeft1, upLeft2, upLeft3, upLeft4, upLeft5, upLeft6, upLeft7, upLeft8,
            upRight1, upRight2, upRight3, upRight4, upRight5, upRight6, upRight7, upRight8,
            downLeft1, downLeft2, downLeft3, downLeft4, downLeft5, downLeft6, downLeft7, downLeft8,
            downRight1, downRight2, downRight3, downRight4, downRight5, downRight6, downRight7, downRight8;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;

}
