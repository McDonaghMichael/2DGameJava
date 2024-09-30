package toolbar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ToolbarUI extends JPanel {

    public ToolbarUI() {
        setLayout(new GridLayout(1, 5)); // 5 slots for items, for example
        setPreferredSize(new Dimension(500, 100));

        JLabel slotOne = new JLabel("Slot " + 1, SwingConstants.CENTER);
        slotOne.setBackground(Color.GRAY);
        slotOne.setOpaque(true);
        add(slotOne);

        JLabel slotTwo = new JLabel("Slot " + 2, SwingConstants.CENTER);
        slotTwo.setBackground(Color.GRAY);
        slotTwo.setOpaque(true);
        add(slotTwo);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        slotOne.setBackground(Color.RED);
                        slotOne.repaint();
                        break;
                }
            }
        });



    }

    public static void main(String[] args){

    }
}
