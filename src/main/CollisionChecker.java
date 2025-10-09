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

    public int ckeckObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {
                // Obtener posición del área sólida del jugador
                entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;

                // Obtener posición del área sólida del objeto
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidAreaDefaultY;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "up-left":
                        entity.solidArea.y -= (int) Math.sqrt(entity.speed);
                        entity.solidArea.x -= (int) Math.sqrt(entity.speed);
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "up-right":
                        entity.solidArea.y -= (int) Math.sqrt(entity.speed);
                        entity.solidArea.x += (int) Math.sqrt(entity.speed);
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "down-left":
                        entity.solidArea.y += (int) Math.sqrt(entity.speed);
                        entity.solidArea.x -= (int) Math.sqrt(entity.speed);
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "down-right":
                        entity.solidArea.y += (int) Math.sqrt(entity.speed);
                        entity.solidArea.x += (int) Math.sqrt(entity.speed);
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
