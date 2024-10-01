package ui;


import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class IndicatorsUI extends JPanel {

    public IndicatorsUI() {
        setLayout(new GridLayout(1, 5)); // 5 slots for items, for example
        setPreferredSize(new Dimension(50, 50));

        JLabel healthLabel = new JLabel("Health " + Player.getHealth(), SwingConstants.CENTER);
        healthLabel.setBackground(Color.GRAY);
        healthLabel.setForeground(Color.WHITE);
        healthLabel.setFont(new Font("Arial", Font.BOLD, 30));
        healthLabel.setOpaque(true);

        JLabel saturationLabel = new JLabel("Saturation " + Player.getHealth(), SwingConstants.CENTER);
        saturationLabel.setBackground(Color.GRAY);
        saturationLabel.setForeground(Color.WHITE);
        saturationLabel.setFont(new Font("Arial", Font.BOLD, 30));
        saturationLabel.setOpaque(true);

        JLabel energyLabel = new JLabel("Energy " + Player.getEnergy(), SwingConstants.CENTER);
        energyLabel.setBackground(Color.GRAY);
        energyLabel.setForeground(Color.WHITE);
        energyLabel.setFont(new Font("Arial", Font.BOLD, 30));
        energyLabel.setOpaque(true);


        add(healthLabel);
        add(saturationLabel);
        add(energyLabel);

    }

    public static void main(String[] args){

    }
}
