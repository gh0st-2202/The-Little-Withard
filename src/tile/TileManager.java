package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    /**
     * Este metodo establece los valores para detectar y dibujar el suelo del mapa
     * @param gp Llama a GamePanel para enviarle la información del mapa
     */
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[101];
        mapTileNum = new int[gp.maxWorldCor][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map01.txt");
    }

    /**
     * Este metodo se encarga de leer el mapa completo
     * @param mapPath La ruta hasta el archivo del mapa
     */
    public void loadMap(String mapPath){
        try{
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCor && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCor){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col] [row] = num;
                    col++;
                }
                if(col == gp.maxWorldCor){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){}
    }

    /**
     * Este metodo es un diccionario, encargado de traducir el mapa a imagenes
     */
    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/futbol_grass/1-1.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/futbol_grass/1-2.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/futbol_grass/1-3.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-1.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-2.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-3.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-4.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-5.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-6.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-7.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ceramic/1-8.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-1.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-2.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-3.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-4.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-5.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-6.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-7.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood/1-8.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dark_grass/1-1.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dark_grass/1-2.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dark_grass/1-3.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice/1-1.png"));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice/1-2.png"));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice/1-3.png"));

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo es el encargado de dibujar el suelo del mapa
     * @param g2 Llama a la clase Graphics2D de Java
     */
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCor && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol] [worldRow];
            int worldX = worldCol * 46;
            int worldY = worldRow * 36;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, 46, 36, null);}
            worldCol ++;

            if (worldCol == gp.maxWorldCor) {
                worldCol = 0;
                worldRow ++;
            }
        }
    }
}
