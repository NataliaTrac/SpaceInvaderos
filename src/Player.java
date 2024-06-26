import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Object {

    private int width;
    private ImageIcon playerImg;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        String selectedImagePath = UI.getSelectedImagePath();
        setPlayerImageFromRadioButton(selectedImagePath);



        width = playerImg.getImage().getWidth(null);


        int START_X = 270;
        setX(START_X);
        int START_Y = 280;
        setY(START_Y);

    }

    public void act() {
        x += dx;

        if (x <= 2) {
            x = 2;
        }

        if (x >= VALUES.BOARD_WIDTH - 2 * width) {
            x = VALUES.BOARD_WIDTH - 2 * width;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public void setPlayerImageFromRadioButton(String imagePath) {
        playerImg = new ImageIcon(imagePath);
        Image scaledImage = playerImg.getImage().getScaledInstance(15, 10, Image.SCALE_SMOOTH);
        playerImg = new ImageIcon(scaledImage);
        setImage(playerImg.getImage());
    }
}