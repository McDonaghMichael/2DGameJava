package ui;

import game.GameWindow;
import game.player.Player;
import objects.DirtObject;
import objects.GrassObject;
import objects.WallObject;
import objects.WaterObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryUI extends JPanel {

    public InventoryUI() {
        setLayout(new GridLayout(3,3));

        JButton wallBtn = new JButton("Wall");
        wallBtn.setBackground(Color.GRAY);
        wallBtn.setFocusable(false);
        wallBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(new WallObject(Player.getXPosition(), Player.getYPosition()));
            }
        });

        JButton dirtBtn = new JButton("Dirt");
        dirtBtn.setBackground(Color.GRAY);
        dirtBtn.setFocusable(false);
        dirtBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(new DirtObject(Player.getXPosition(), Player.getYPosition()));
            }
        });

        JButton grassBtn = new JButton("Grass");
        grassBtn.setBackground(Color.GRAY);
        grassBtn.setFocusable(false);
        grassBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(new GrassObject(Player.getXPosition(), Player.getYPosition()));
            }
        });

        JButton waterBtn = new JButton("Water");
        waterBtn.setBackground(Color.GRAY);
        waterBtn.setFocusable(false);
        waterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(new WaterObject(Player.getXPosition(), Player.getYPosition()));
            }
        });

        add(wallBtn);
        add(dirtBtn);
        add(grassBtn);
        add(waterBtn);
    }
}
