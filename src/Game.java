import game.Player;
import world.Tile;
import world.TileMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {
    private Player player;
    private TileMap tileMap;
    private int cameraOffsetX;
    private int cameraOffsetY;

    public Game() {
        player = new Player(2000, 2000, 50, 50);
        cameraOffsetY = Player.getYPosition() - 500;
        cameraOffsetX = Player.getXPosition() - 500;
        tileMap = new TileMap();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        player.setYPosition(player.getYPosition() - (10 + Player.getSpeed()));
                        cameraOffsetY = cameraOffsetY - (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        player.setXPosition(player.getXPosition() + (10 + Player.getSpeed()));
                        cameraOffsetX += (10 + Player.getSpeed());
                        Player.setImage(Player.rightImage);
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        player.setXPosition(player.getXPosition() - (10 + Player.getSpeed()));
                        cameraOffsetX -= (10 + Player.getSpeed());
                        Player.setImage(Player.leftImage);
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        player.setYPosition(player.getYPosition() + (10 + Player.getSpeed()));
                        cameraOffsetY = cameraOffsetY + (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_SHIFT:
                        Player.setSpeed(10);
                        break;
                }

                System.out.println("X:" + cameraOffsetX + " Y:" + cameraOffsetY);
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
        Tile play = new Tile(player.getXPosition(), player.getYPosition(), Player.getImage());
        play.draw(g, cameraOffsetX, cameraOffsetY);
    }

    public static void load() {
        JFrame frame = new JFrame("2D Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        load();
    }
}