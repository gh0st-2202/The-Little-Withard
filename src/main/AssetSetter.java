package main;

import object.OBJ_Coin;

/**
 * Esta clase pone todos los objetos del mapa en su lugar
 */
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Coin();
        gp.obj[0].worldX = 0;
        gp.obj[0].worldY = 0;

        gp.obj[1] = new OBJ_Coin();
        gp.obj[1].worldX = 2*46;
        gp.obj[1].worldY = 2*36;
    }
}
