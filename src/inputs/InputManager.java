package inputs;

import game.GameWindow;
import inputs.types.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputManager extends KeyAdapter {

    private Map<Integer, PlayerInput> inputMap;

    private GameWindow window;

    public InputManager(GameWindow window) {
        this.window = window;
        inputMap = new HashMap<>();
        inputMap.put(KeyEvent.VK_W, new UpKey());
        inputMap.put(KeyEvent.VK_UP, new UpKey());
        inputMap.put(KeyEvent.VK_A, new LeftKey());
        inputMap.put(KeyEvent.VK_LEFT, new LeftKey());
        inputMap.put(KeyEvent.VK_D, new RightKey());
        inputMap.put(KeyEvent.VK_RIGHT, new RightKey());
        inputMap.put(KeyEvent.VK_S, new DownKey());
        inputMap.put(KeyEvent.VK_DOWN, new DownKey());
        inputMap.put(KeyEvent.VK_SHIFT, new ShiftKey());
        inputMap.put(KeyEvent.VK_L, new RightClickKey());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        PlayerInput input = inputMap.get(keyCode);
        window.repaint();
        if (input != null) {
            input.onKeyPressed();
            window.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        PlayerInput input = inputMap.get(keyCode);
        window.repaint();
        if (input != null) {
            input.onKeyReleased();
            window.repaint();

        }
    }
}
