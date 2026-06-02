import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DisplayPanel extends JPanel implements KeyListener, ActionListener{
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
    private BufferedImage background;
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
    private boolean[] pressedKeys;
    private Timer timer;


    public DisplayPanel() {
        score = 0;
        steveX = 0;
        steveY = 0;
        timer = new Timer(10, this);
        pressedKeys = new boolean[128];
        try {
            background = ImageIO.read(new File("img.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            steve = ImageIO.read(new File("Steve_Right.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        timer.start();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(steve, steveX, steveY, null);

        g.setFont(new Font("Georgia", Font.BOLD, 24));
        g.setColor(Color.YELLOW);
        g.drawString("Score: " + score, 10, 20);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys[keyCode] = true;
        if (keyCode == KeyEvent.VK_A) {
            try {
                steve = ImageIO.read(new File("Steve_Left.png"));
            } catch (IOException error) { }
        }
        if (keyCode == KeyEvent.VK_D) {  // D key; VK_D equals 65
            try {
                steve = ImageIO.read(new File("Steve_Right.png"));
            } catch (IOException error) { }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressedKeys[keyCode] = false;   
    }

    private void moveSteve() {
        if (pressedKeys[KeyEvent.VK_A]) {
            steveX -= 5;
        }else if (pressedKeys[KeyEvent.VK_D]) {
            steveX += 5;
        }else if (pressedKeys[KeyEvent.VK_W]) {
            steveY -= 5;
        }else if (pressedKeys[KeyEvent.VK_S]) {
            steveY += 5;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        moveSteve();
        repaint();
    }

}
