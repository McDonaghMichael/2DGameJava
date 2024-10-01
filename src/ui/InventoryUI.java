package ui;

import game.GameWindow;
import game.player.Player;
import objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryUI extends JPanel {

    public InventoryUI() {
        setLayout(new GridLayout(1,6));

        WallObject wallObject = new WallObject(Player.getXPosition(), Player.getYPosition());
        JButton wallBtn = new JButton(new ImageIcon(wallObject.getImage()));
        wallBtn.setBackground(Color.GRAY);
        wallBtn.setFocusable(false);
        wallBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(wallObject);
            }
        });

        DirtObject dirtObject = new DirtObject(Player.getXPosition(), Player.getYPosition());
        JButton dirtBtn = new JButton(new ImageIcon(dirtObject.getImage()));
        dirtBtn.setBackground(Color.GRAY);
        dirtBtn.setFocusable(false);
        dirtBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(dirtObject);
            }
        });

        GrassObject grassObject = new GrassObject(Player.getXPosition(), Player.getYPosition());
        JButton grassBtn = new JButton(new ImageIcon(grassObject.getImage()));
        grassBtn.setBackground(Color.GRAY);
        grassBtn.setFocusable(false);
        grassBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(grassObject);
            }
        });

        WaterObject waterObject = new WaterObject(Player.getXPosition(), Player.getYPosition());
        JButton waterBtn = new JButton(new ImageIcon(waterObject.getImage()));
        waterBtn.setBackground(Color.GRAY);
        waterBtn.setFocusable(false);
        waterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(waterObject);
            }
        });

        LavaObject lavaObject = new LavaObject(Player.getXPosition(), Player.getYPosition());
        JButton lavaBtn = new JButton(new ImageIcon(lavaObject.getImage()));
        lavaBtn.setBackground(Color.GRAY);
        lavaBtn.setFocusable(false);
        lavaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(lavaObject);
            }
        });

        SandObject sandObject = new SandObject(Player.getXPosition(), Player.getYPosition());
        JButton sandBtn = new JButton(new ImageIcon(sandObject.getImage()));
        sandBtn.setBackground(Color.GRAY);
        sandBtn.setFocusable(false);
        sandBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player.setCurrentObject(sandObject);
            }
        });

        add(wallBtn);
        add(dirtBtn);
        add(grassBtn);
        add(waterBtn);
        add(lavaBtn);
        add(sandBtn);
    }
}
