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
    private BufferedImage steve;
    private BufferedImage zombie;
    private BufferedImage skeleton;
    private BufferedImage creeper;
    private BufferedImage bigSlime;
    private BufferedImage smallSlime1;
    private BufferedImage smallSlime2;
    private BufferedImage sword;
    private BufferedImage bow;
    private BufferedImage shield;
    private BufferedImage arrow;
    private BufferedImage tnt;
    private BufferedImage totem;
    private BufferedImage heal;
    private BufferedImage speed;
    private BufferedImage live;
    private BufferedImage fullHeart;
    private BufferedImage halfHeart;
    private BufferedImage iron;
    private BufferedImage gold;
    private BufferedImage emerald;
    private BufferedImage diamond;
    private BufferedImage ancientDebris;
    private boolean gameStart;
    private boolean gameOver;
    private boolean pressedKeys;


    public DisplayPanel() {
        setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

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