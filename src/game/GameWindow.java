package game;

import game.player.Player;
import inputs.InputManager;
import objects.PlayerObject;
import ui.IndicatorsUI;
import ui.InventoryUI;
import world.TileMap;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    private static Dimension dimension;
    private static int screenwidth;
    private static int screenheight;
    private static Player player;
    private static TileMap tileMap;
    private static InputManager inputManager;

    private static IndicatorsUI indicatorsUI;
    private static InventoryUI inventoryUI;

    public GameWindow(Dimension dimension, int screenwidth, int screenheight) {
        this.dimension = dimension;
        this.screenwidth = screenwidth;
        this.screenheight = screenheight;

        tileMap = new TileMap(this);

        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        player = new Player(800, 800, 50, 50);
        Player.setCameraOffsetY(Player.getYPosition() - this.screenheight / 4);
        Player.setCameraOffsetX(Player.getXPosition() - this.screenwidth / 4);

        inputManager = new InputManager(this);
        this.addKeyListener(inputManager);

        setFocusable(true);
        frame.add(this);

        indicatorsUI = new IndicatorsUI();
        frame.add(indicatorsUI, BorderLayout.NORTH);
        frame.pack();
        inventoryUI = new InventoryUI();
        inventoryUI.setVisible(false);
        frame.add(inventoryUI, BorderLayout.SOUTH);


        frame.setSize(dimension.width, dimension.height);
        frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tileMap.draw(g, Player.getCameraOffsetX(), Player.getCameraOffsetY());

        PlayerObject play = new PlayerObject(player.getXPosition(), player.getYPosition(), Player.getImage());
        play.draw(g, Player.getCameraOffsetX(), Player.getCameraOffsetY());


    }

    public static IndicatorsUI getIndicatorsUI() {
        return indicatorsUI;
    }

    public static InventoryUI getInventoryUI() {
        return inventoryUI;
    }

}
