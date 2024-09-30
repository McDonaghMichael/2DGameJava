import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {
    private Character character;

    public Game() {
        character = new Character(100, 100);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch(key){
                    case KeyEvent.VK_UP:
                        character.setY(character.getY() + 10);
                        break;
                    case KeyEvent.VK_RIGHT:
                        character.setX(character.getX() + 10);
                        break;
                    case KeyEvent.VK_LEFT:
                        character.setX(character.getX() - 10);
                        break;
                        case KeyEvent.VK_DOWN:
                            character.setY(character.getY() - 10);
                            break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the ground
        g.setColor(Color.GREEN);
        g.fillRect(0, getHeight() - 50, getWidth(), 50);

        // Draw the character
        g.setColor(Color.BLUE);
        // Adjust Y to be above the ground
        g.fillRect(character.getX(), getHeight() - character.getY() - 50, 50, 50);
    }

    public static void load() {
        JFrame frame = new JFrame("2D Game");
        Game game = new Game(); // Create the game instance
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
