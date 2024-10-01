package ui;

import game.GameWindow;

import javax.swing.*;
import java.awt.*;

public class InventoryUI extends JPanel {

    public InventoryUI() {
        setLayout(new GridLayout(3,3));

        JButton wallBtn = new JButton("Wall");
        wallBtn.setBackground(Color.GRAY);
        wallBtn.setFocusable(false);

        JButton dirtBtn = new JButton("Dirt");
        dirtBtn.setBackground(Color.GRAY);
        dirtBtn.setFocusable(false);

        JButton grassBtn = new JButton("Grass");
        grassBtn.setBackground(Color.GRAY);
        grassBtn.setFocusable(false);

        JButton waterBtn = new JButton("Water");
        waterBtn.setBackground(Color.GRAY);
        waterBtn.setFocusable(false);

        add(wallBtn);
        add(dirtBtn);
        add(grassBtn);
        add(waterBtn);
    }
}
