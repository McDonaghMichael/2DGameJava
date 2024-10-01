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

        GameObject obj = Player.getTileAtPositionBasedOnDirection();

        if(obj == null){
            System.err.println("Error Tile Position Creating New");
            //TileMap.addTile(new WallObject(Player.getPositionBasedOnDirection(), Player.getYPosition(),  TileMap.wallImages.get(new Random().nextInt(TileMap.wallImages.size()))));
            return;
        }

       // TileMap.addTile(new WallObject(obj.getX(), obj.getY(),  TileMap.wallImages.get(new Random().nextInt(TileMap.wallImages.size()))));
        System.out.println("New Tile Position X: " + obj.getX() + " Y: " + obj.getY());

    }

    @Override
    public void onKeyReleased() {

    }
}
