package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlainManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public PlainManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCor][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/prueba.txt");
    }

    public void loadMap(String mapPath) {
        try {
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCor && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCor) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCor) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
        }
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/futbol_grass/1-1.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/futbol_grass/1-2.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/plains/trees/tree1.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-4.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBeforePlayer(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCor && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * 46;
            int worldY = worldRow * 36;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY &&
                    worldY - 90 < gp.player.worldY) {
                if (tileNum == 2) {
                    g2.drawImage(tile[tileNum].image, screenX-19, screenY-100, 104, 133, null);
                }
            }
            worldCol++;

            if (worldCol == gp.maxWorldCor) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public void drawAfterPlayer(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCor && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * 46;
            int worldY = worldRow * 36;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY &&
                    worldY - 90 > gp.player.worldY) {
                if (tileNum == 2) {
                    g2.drawImage(tile[tileNum].image, screenX-19, screenY-100, 104, 133, null);
                }
            }
            worldCol++;

            if (worldCol == gp.maxWorldCor) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}