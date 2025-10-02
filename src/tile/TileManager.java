package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood.png"));

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(tile[3].image, 0, 0, 366, 222, null);
        g2.drawImage(tile[3].image, 366, 0, 366, 222, null);
        g2.drawImage(tile[3].image, 732, 0, 366, 222, null);
        g2.drawImage(tile[3].image, 1098, 0, 366, 222, null);
        g2.drawImage(tile[3].image, 1464, 0, 366, 222, null);
        g2.drawImage(tile[3].image, 1830, 0, 366, 222, null);

        g2.drawImage(tile[3].image, 0, 222, 366, 222, null);
        g2.drawImage(tile[3].image, 366, 222, 366, 222, null);
        g2.drawImage(tile[3].image, 732, 222, 366, 222, null);
        g2.drawImage(tile[3].image, 1098, 222, 366, 222, null);
        g2.drawImage(tile[3].image, 1464, 222, 366, 222, null);
        g2.drawImage(tile[3].image, 1830, 222, 366, 222, null);

        g2.drawImage(tile[3].image, 0, 444, 366, 222, null);
        g2.drawImage(tile[3].image, 366, 444, 366, 222, null);
        g2.drawImage(tile[3].image, 732, 444, 366, 222, null);
        g2.drawImage(tile[3].image, 1098, 444, 366, 222, null);
        g2.drawImage(tile[3].image, 1464, 444, 366, 222, null);
        g2.drawImage(tile[3].image, 1830, 444, 366, 222, null);

        g2.drawImage(tile[3].image, 0, 666, 366, 222, null);
        g2.drawImage(tile[3].image, 366, 666, 366, 222, null);
        g2.drawImage(tile[3].image, 732, 666, 366, 222, null);
        g2.drawImage(tile[3].image, 1098, 666, 366, 222, null);
        g2.drawImage(tile[3].image, 1464, 666, 366, 222, null);
        g2.drawImage(tile[3].image, 1830, 666, 366, 222, null);

        g2.drawImage(tile[3].image, 0, 888, 366, 222, null);
        g2.drawImage(tile[3].image, 366, 888, 366, 222, null);
        g2.drawImage(tile[3].image, 732, 888, 366, 222, null);
        g2.drawImage(tile[3].image, 1098, 888, 366, 222, null);
        g2.drawImage(tile[3].image, 1464, 888, 366, 222, null);
        g2.drawImage(tile[3].image, 1830, 888, 366, 222, null);
    }
}
