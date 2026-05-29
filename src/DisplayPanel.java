import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class DisplayPanel extends JPanel implements MouseListener, KeyListener, ActionListener{
    private int score;
    private int lives;
    private int health;
    private int steveX;
    private int steveY;
    private int zombieX;
    private int zombieY;
    private int skeletonX;
    private int skeletonY;
    private int creeperX;
    private int creeperY;
    private int bigSlimeX;
    private int bigSlimeY;
    private int smallSlime1X;
    private int smallSlime1Y;
    private int smallSlime2X;
    private int smallSlime2Y;
    private BufferedImage steve; //image from google search
    private BufferedImage zombie; //image from google search
    private BufferedImage skeleton; //image from google search
    private BufferedImage creeper; //image from google search
    private BufferedImage bigSlime; //image from google search
    private BufferedImage smallSlime1; //image from google search
    private BufferedImage smallSlime2; //image from google search
    private BufferedImage sword; //image from google search
    private BufferedImage bow; //image from google search
    private BufferedImage shield; //image from google search
    private BufferedImage arrow; //image from google search
    private BufferedImage tnt; //image from google search
    private BufferedImage totem; //image from google search
    private BufferedImage heal; //image from google search
    private BufferedImage speed; //image from google search
    private BufferedImage live; //image from google search
    private BufferedImage fullHeart; //image from google search
    private BufferedImage halfHeart; //image from google search
    private BufferedImage iron; //image from google search
    private BufferedImage gold; //image from google search
    private BufferedImage emerald; //image from google search
    private BufferedImage diamond; //image from google search
    private BufferedImage ancientDebris; //image from google search
    private boolean gameStart;
    private boolean gameOver;
    private int keyCode;


    public DisplayPanel() {
        setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveSteve();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A) {
            try {
                steve = ImageIO.read(new File("imgs/Steve_Left.png"));
            } catch (IOException error) { }
        }
        if (keyCode == KeyEvent.VK_D) {  // D key; VK_D equals 65
            try {
                steve = ImageIO.read(new File("imgs/Steve_Right.png"));
            } catch (IOException error) { }
        }

    }
    private void moveSteve() {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}