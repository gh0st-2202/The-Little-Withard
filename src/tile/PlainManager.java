package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PlainManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    /**
     * Este metodo establece los valores para detectar y dibujar los obstaculos del mapa
     * @param gp Llama a GamePanel para enviarle la información del mapa
     */
    public PlainManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCor][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map03.txt");
    }

    /**
     * Este metodo se encarga de leer el mapa completo
     * @param mapPath La ruta hasta el archivo del mapa
     */
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

    /**
     * Este metodo es un diccionario, encargado de traducir el mapa a imagenes
     */
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/plains/trees/tree1.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/plains/trees/tree2.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/plains/trees/tree3.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/plains/rocks/rock1.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/plains/rocks/rock2.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/plains/rocks/rock3.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/plains/rocks/rock4.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/plains/flowers/flor1.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo es el encargado de dibujar los objetos por debajo del jugador
     * La finalidad de este metodo es conseguir un efecto de 3D
     * @param g2 Llama a la clase Graphics2D de Java
     */
    public void drawBeforePlayer(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCor && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * 46;
            int worldY = worldRow * 36;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            int[] resolucionX = {0, 73, 104, 110, 16, 24, 22, 22, 37};
            int[] resolucionY = {0, 107, 133, 134, 16, 24, 22, 34, 37};

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - 2*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - 2*gp.tileSize < gp.player.worldY + gp.player.screenY &&
                    worldY - 90 < gp.player.worldY && tileNum != 0) {
                g2.drawImage(tile[tileNum].image, screenX-((resolucionX[tileNum]-46)/2), screenY-((resolucionY[tileNum]-36)), resolucionX[tileNum], resolucionY[tileNum], null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCor) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    /**
     * Este metodo es el encargado de dibujar los objeto por encima del jugador
     * La finalidad de este metodo es conseguir un efecto de 3D
     * @param g2 Llama a la clase Graphics2D de Java
     */
    public void drawAfterPlayer(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCor && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * 46;
            int worldY = worldRow * 36;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            int[] resolucionX = {0, 73, 104, 110, 16, 24, 22, 22, 37};
            int[] resolucionY = {0, 107, 133, 134, 16, 24, 22, 34, 37};

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - 2*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - 2*gp.tileSize < gp.player.worldY + gp.player.screenY &&
                    worldY - 90 >= gp.player.worldY && tileNum != 0) {
                g2.drawImage(tile[tileNum].image, screenX-((resolucionX[tileNum]-46)/2), screenY-((resolucionY[tileNum]-36)), resolucionX[tileNum], resolucionY[tileNum], null);

            }
            worldCol++;

            if (worldCol == gp.maxWorldCor) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}