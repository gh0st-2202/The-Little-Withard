package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Esta funcion detecta si existe una colision entre un objeto del mapa y una entidad
     * Además detecta el lado de la colisión (arriba, abajo, izquierda, derecha)
     * @param entity La entidad que se comprueba
     */

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / 46;
        int entityRightCol = entityRightWorldX /46;
        int entityTopRow = entityTopWorldY / 36;
        int entityBottomRow = entityBottomWorldY / 36;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / 36;
                tileNum1 = gp.pM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.pM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.pM.tile[tileNum1].collision || gp.pM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / 36;
                tileNum1 = gp.pM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.pM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.pM.tile[tileNum1].collision || gp.pM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / 46;
                tileNum1 = gp.pM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.pM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.pM.tile[tileNum1].collision || gp.pM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / 46;
                tileNum1 = gp.pM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.pM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.pM.tile[tileNum1].collision || gp.pM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }

    }
}
