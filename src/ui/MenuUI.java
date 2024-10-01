package ui;


import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuUI extends JPanel {

    public MenuUI() {
        setLayout(new GridLayout(1, 5)); // 5 slots for items, for example
        setPreferredSize(new Dimension(50, 50));

        JLabel healthLabel = new JLabel("Health " + Player.getHealth(), SwingConstants.CENTER);
        healthLabel.setBackground(Color.GRAY);
        healthLabel.setOpaque(true);

        JLabel saturationLabel = new JLabel("Saturation " + Player.getHealth(), SwingConstants.CENTER);
        saturationLabel.setBackground(Color.GRAY);
        saturationLabel.setOpaque(true);

        JLabel energyLabel = new JLabel("Energy " + Player.getEnergy(), SwingConstants.CENTER);
        energyLabel.setBackground(Color.GRAY);
        energyLabel.setOpaque(true);


        add(healthLabel);
        add(saturationLabel);
        add(energyLabel);

    }

    public static void main(String[] args){

    }
}
