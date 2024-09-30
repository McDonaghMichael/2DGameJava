import game.Player;
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
    private int cameraOffsetX = 0;
    private int cameraOffsetY = 0;

    public Game() {
        player = new Player(100, 100, 50, 50);
        tileMap = new TileMap();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        player.setYPosition(player.getYPosition() + (10 + Player.getSpeed()));
                        cameraOffsetY += (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setXPosition(player.getXPosition() + (10 + Player.getSpeed()));
                        cameraOffsetX += (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setXPosition(player.getXPosition() - (10 + Player.getSpeed()));
                        cameraOffsetX -= (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setYPosition(player.getYPosition() - (10 + Player.getSpeed()));
                        cameraOffsetY += (10 + Player.getSpeed());
                        break;
                    case KeyEvent.VK_SHIFT:
                        Player.setSpeed(10);
                        break;
                }

                System.out.println("X:" + player.getXPosition() + " Y:" + player.getYPosition());
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

        g.setColor(Color.BLUE);
        g.fillRect(player.getXPosition() - cameraOffsetX, getHeight() - player.getYPosition() - 50 - cameraOffsetY, player.getWidth(), player.getHeight());
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