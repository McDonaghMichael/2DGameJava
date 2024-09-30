import game.Player;
import objects.GameObject;
import objects.PlayerObject;
import objects.WaterObject;
import world.Tile;
import world.TileMap;
import world.WorldConstants;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {
    private Player player;
    private TileMap tileMap;
    private int cameraOffsetX;
    private int cameraOffsetY;

    private final int mapWidth = WorldConstants.WORLD_X_BORDER;
    private final int mapHeight = WorldConstants.WORLD_Y_BORDER;

    Dimension dimension;

    private final int screenWidth;
    private final int screenHeight;

    public Game() {
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = dimension.width;
        screenHeight = dimension.height;

        player = new Player(800, 800, 50, 50);
        cameraOffsetY = Player.getYPosition() - screenHeight / 4;
        cameraOffsetX = Player.getXPosition() - screenWidth / 4;
        tileMap = new TileMap();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        if (player.getYPosition() > 0) {
                            player.setYPosition(player.getYPosition() - (10 + Player.getSpeed()));
                            cameraOffsetY = Math.max(cameraOffsetY - (10 + Player.getSpeed()), 0);
                        }
                        break;

                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        if (player.getXPosition() < mapWidth - player.getWidth()) {
                            player.setXPosition(player.getXPosition() + (10 + Player.getSpeed()));
                            cameraOffsetX = Math.min(cameraOffsetX + (10 + Player.getSpeed()), mapWidth - getWidth());// Stop scrolling past the right edge
                            Player.setImage(Player.rightImage);
                        }
                        break;

                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        if (player.getXPosition() > 0) {
                            player.setXPosition(player.getXPosition() - (10 + Player.getSpeed()));
                            cameraOffsetX = Math.max(cameraOffsetX - (10 + Player.getSpeed()), 0);
                            Player.setImage(Player.leftImage);
                        }
                        break;

                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        // Move player down if within the map bounds
                        if (player.getYPosition() < mapHeight - player.getHeight() * 2) {
                            player.setYPosition(player.getYPosition() + (10 + Player.getSpeed()));
                            cameraOffsetY = Math.min(cameraOffsetY + (10 + Player.getSpeed()), mapHeight - getHeight()); // Stop scrolling past the bottom edge
                        }else{
                            player.setYPosition(mapHeight - player.getHeight() * 2);
                        }
                        break;

                    case KeyEvent.VK_SHIFT:
                        Player.setSpeed(10);
                        break;
                }


                GameObject tileAtPosition = tileMap.getTileAtPosition(Player.getXPosition() / 50, Player.getYPosition() / 50);

                if (tileAtPosition instanceof WaterObject ) {
                    Player.setImage(Player.waterImage);
                }else{
                    Player.setImage(Player.leftImage);
                }

                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_SHIFT:
                        Player.setSpeed(0);
                        break;
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tileMap.draw(g, cameraOffsetX, cameraOffsetY);
        PlayerObject play = new PlayerObject(player.getXPosition(), player.getYPosition(), Player.getImage());
        play.draw(g, cameraOffsetX, cameraOffsetY);
    }

    public void load() {
        JFrame frame = new JFrame("2D Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(dimension.width, dimension.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}