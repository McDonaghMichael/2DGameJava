package inputs.types;

import game.player.Player;
import inputs.PlayerInput;
import objects.DirtObject;
import objects.GameObject;
import objects.WallObject;
import world.TileMap;

import java.util.Random;

public class RightClickKey extends PlayerInput {
    @Override
    public void onKeyPressed() {
        int direction = Player.getDirection();
        GameObject obj;
        if(direction == 0){
            obj = Player.getTileAtPositionWest();
        }else{
            obj = Player.getTileAtPositionEast();
        }

        if(obj == null) return;

        TileMap.addTile(new WallObject(obj.getX(), obj.getY(),  TileMap.wallImages.get(new Random().nextInt(TileMap.wallImages.size()))));
        System.out.println("New Tile Position X: " + obj.getX() + " Y: " + obj.getY());

    }

    @Override
    public void onKeyReleased() {

    }
}
