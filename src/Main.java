import game.entites.EntityManager;
import game.Game;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        EntityManager entityManager = new EntityManager(game);
        game.load();



    }
}