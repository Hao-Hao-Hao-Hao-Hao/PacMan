import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayPanel extends JPanel{
    private int score;
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


    public DisplayPanel() {
        setBackground(Color.BLACK);
    }
}