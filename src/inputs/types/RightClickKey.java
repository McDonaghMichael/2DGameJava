package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.DirtObject;
import objects.GameObject;
import objects.WallObject;
import objects.WaterObject;
import world.TileMap;

import java.util.Random;

public class RightClickKey extends PlayerInput {
    @Override
    public void onKeyPressed() {

        GameObject obj = Player.getTileAtPositionBasedOnDirection();

        if(obj == null){
            System.err.println("Error Tile Position Creating New");
            GameObject newTile = Player.getCurrentObject();
            if(newTile == null){
                newTile = new WaterObject(Player.getXPosition(), Player.getYPosition());
            }
            newTile.setX(Player.getPositionBasedOnDirection());
            newTile.setY(Player.getYPosition());
            TileMap.addTile(newTile);
            Player.setCurrentObject(null);
            return;
        }

        GameObject newTile = Player.getCurrentObject();
        newTile.setX(obj.getX());
        newTile.setY(obj.getY());
        TileMap.addTile(newTile);
        Player.setCurrentObject(null);
        System.out.println("New Tile Position X: " + obj.getX() + " Y: " + obj.getY());

    }

    @Override
    public void onKeyReleased() {

    }
}
