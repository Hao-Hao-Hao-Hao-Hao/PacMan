import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DisplayPanel extends JPanel implements KeyListener, ActionListener, MouseListener {
   private final int[][] maze = {
           {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
           {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
           {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
           {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
           {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
           {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
           {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
           {1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
           {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
   }; //Reference image is from Google
   //finished instance variables
   private int score;
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
   private BufferedImage steve; //image from google search
   private BufferedImage zombie; //image from google search
   private BufferedImage skeleton; //image from google search
   private BufferedImage creeper; //image from google search
   private BufferedImage bigSlime; //image from google search
   private BufferedImage sword; //image from google search
   private BufferedImage shield; //image from google search
   private BufferedImage pearl; //image from google search
   private BufferedImage tnt; //image from google search
   private BufferedImage heal; //image from google search//image from google search
   private BufferedImage speed; //image from google search
   private BufferedImage heart;
   private BufferedImage copper; //image from google search
   private BufferedImage iron; //image from google search
   private BufferedImage gold; //image from google search
   private BufferedImage emerald; //image from google search
   private BufferedImage diamond; //image from google search
   private BufferedImage ancientDebris; //image from google search
   private boolean gameStart;
   private boolean gameOver;
   private Timer timer;
   private final int tileSize = 32;
   private final int rows = maze.length;
   private final int columns = maze[0].length;
   private ArrayList<Point> ores;
   private List<Integer> randomOres;
   private ArrayList<Point> lives;
   private int itemNum;
   private direction nextDirection = direction.none;
   private long lastCollisionTime = 0;
   private long cooldown = 1000;
   private int oreCollected = 0;
   private int steveMoveAmount;
   private int currentItem;
   private boolean ableToTakeDamage;
   private int zombieDirection;
   private int zombieAmount;
   private int skeletonDirection;
   private int skeletonAmount;
   private int creeperDirection;
   private int creeperAmount;
   private int bigSlimeDirection;
   private int bigSlimeAmount;
   private boolean usedSpeedPot;
   private boolean usedTnt;
   private Point tntPoint;
   private boolean zombieKilled;
   private boolean skeletonKilled;
   private boolean creeperKilled;
   private boolean bigSlimeKilled;
   private int totalNumItems;
   //not finished instance variables
   private Timer shieldTimer;
   private Timer speedPotTimer;
   private Timer swordTimer;
   private Timer tntTimer;
   private Timer zombieRespawn;
   private Timer skeletonRespawn;
   private Timer creeperRespawn;
   private Timer bigSlimeRespawn;
   private Timer steveTimer; //animation
   private ArrayList<BufferedImage> steveRight; //animation
   private ArrayList<BufferedImage> steveLeft; //animation
   private int steveRightIdx;
   private int steveLeftIdx;
   private BufferedImage inventorySlot;
   private BufferedImage bigSword;
   private BufferedImage bigShield;
   private BufferedImage bigTnt;
   private BufferedImage bigPearl;
   private BufferedImage bigSpeedPot;
   private BufferedImage bigHealPot;
   private HashMap<Point, Integer> itemMap = new HashMap<>();


   public DisplayPanel() {
       health = 5;
       score = 0;
       steveX = 56;
       steveY = 128;
       zombieX = 544;
       zombieY = 485;
       skeletonX = 480;
       skeletonY = 485;
       creeperX = 608;
       creeperY = 485;
       bigSlimeX = 674;
       bigSlimeY = 482;
       zombieDirection = 1;
       zombieAmount = 0;
       skeletonDirection = 1;
       skeletonAmount = 0;
       creeperDirection = 1;
       creeperAmount = 0;
       bigSlimeDirection = 1;
       bigSlimeAmount = 0;
       currentItem = 0;
       steveMoveAmount = 4;
       usedSpeedPot = false;
       usedTnt = false;
       ableToTakeDamage = true;
       itemNum = 0;
       totalNumItems = 4;
       zombieKilled = false;
       skeletonKilled = false;
       creeperKilled = false;
       bigSlimeKilled = false;
       lives = new ArrayList<>();
       ores = new ArrayList<>();
       populateOres();
       randomOres = new ArrayList<>();
       populateRandomOres();
       populateRandomItems();
       populateHearts();
       shieldTimer = new Timer(20000, e -> {
           ableToTakeDamage = true;
           currentItem = 0;
       });
       shieldTimer.setRepeats(false);
       speedPotTimer = new Timer(20000, e -> {
           steveMoveAmount-= 2;
       });
       speedPotTimer.setRepeats(false);
       swordTimer = new Timer(10000, e -> {
           currentItem = 0;
           ableToTakeDamage = true;
       });
       swordTimer.setRepeats(false);
       tntTimer = new Timer(4000, e -> {
           double zombieDistance = distance(tntPoint.x, tntPoint.y, zombieX, zombieY);
           double skeletonDistance = distance(tntPoint.x, tntPoint.y, skeletonX, skeletonY);
           double creeperDistance = distance(tntPoint.x, tntPoint.y, creeperX, creeperY);
           double bigSlimeDistance = distance(tntPoint.x, tntPoint.y, bigSlimeX, bigSlimeY);
           if (zombieDistance <= 256) {
               zombieKilled();
           }
           if (skeletonDistance <= 256) {
               skeletonKilled();
           }
           if (creeperDistance <= 256) {
               creeperKilled();
           }
           if (bigSlimeDistance <= 256) {
               bigSlimeKilled();
           }
           usedTnt = false;
       });
       tntTimer.setRepeats(false);
       zombieRespawn = new Timer(5000, e -> {
           zombieKilled = false;
       });
       zombieRespawn.setRepeats(false);
       skeletonRespawn = new Timer(5000, e -> {
           skeletonKilled = false;
       });
       skeletonRespawn.setRepeats(false);
       creeperRespawn = new Timer(5000, e -> {
           creeperKilled = false;
       });
       creeperRespawn.setRepeats(false);
       bigSlimeRespawn = new Timer(5000, e -> {
           bigSlimeKilled = false;
       });
       bigSlimeRespawn.setRepeats(false);


       int width = columns * tileSize;
       int height = rows * tileSize;
       timer = new Timer(10, this);
       steveTimer = new Timer(0, this);
       gameStart = false;
       gameOver = false;
       loadSteveImages();
       steve = steveRight.get(steveRightIdx);
       try {
           zombie = ImageIO.read(new File("imgs/Zombie_Right.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           skeleton = ImageIO.read(new File("imgs/Skeleton_Right.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           creeper = ImageIO.read(new File("imgs/Creeper_Right.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           bigSlime = ImageIO.read(new File("imgs/Big_Slime_Right.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           sword = ImageIO.read(new File("imgs/Netherite_Sword.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigSword = ImageIO.read(new File("imgs/Big_Sword.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           shield = ImageIO.read(new File("imgs/Shield.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigShield = ImageIO.read(new File("imgs/Big_Shield.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           pearl = ImageIO.read(new File("imgs/Ender_Pearl.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigPearl = ImageIO.read(new File("imgs/Big_Ender_Pearl.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           tnt = ImageIO.read(new File("imgs/tnt.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigTnt = ImageIO.read(new File("imgs/Big_tnt.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           heal = ImageIO.read(new File("imgs/Healing_Pot.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigHealPot = ImageIO.read(new File("imgs/Big_Heal_Pot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           speed = ImageIO.read(new File("imgs/Speed_Pot.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            bigSpeedPot = ImageIO.read(new File("imgs/Big_Speed_Pot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       try {
           heart = ImageIO.read(new File("imgs/Totem_Of_Undying.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           copper = ImageIO.read(new File("imgs/Copper_Ore.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           iron = ImageIO.read(new File("imgs/Iron_Ore.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           gold = ImageIO.read(new File("imgs/Gold_Ore.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           emerald = ImageIO.read(new File("imgs/Emerald_Ore.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           diamond = ImageIO.read(new File("imgs/Diamond_Ore.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
           ancientDebris = ImageIO.read(new File("imgs/Ancient_Debris.png"));
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
       try {
            inventorySlot = ImageIO.read(new File("imgs/Inventory_Slot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       this.setPreferredSize(new Dimension(width, height));
       this.setBackground(Color.BLACK);
       addMouseListener(this);
       addKeyListener(this);
       setFocusable(true);
       requestFocusInWindow();
   }

    private void loadSteveImages() {
        steveRight = new ArrayList<>();
        steveLeft = new ArrayList<>();

        // load right
        for (int i = 0; i < 16; i++) {
            try {
                BufferedImage img;
                if (i < 10) {
                    img = ImageIO.read(new File("imgs/Steve_Right00" + i + ".png"));
                }else {
                    img = ImageIO.read(new File("imgs/Steve_Right0" + i + ".png"));
                }
                steveRight.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        // load left
        for (int i = 0; i < 16; i++) {
            try {
                BufferedImage img;
                if (i < 10) {
                    img = ImageIO.read(new File("imgs/Steve_Left00" + i + ".png"));
                }else {
                    img = ImageIO.read(new File("imgs/Steve_Left0" + i + ".png"));
                }
                steveLeft.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       drawMap(g);

       itemNum = 0;
       for (int i = 0; i < ores.size(); i++) {
           Point p = ores.get(i);
           if (itemMap.containsKey(p)) {
            Integer itemType = itemMap.get(p);
            if (itemType == 1) {
                   g.drawImage(sword, p.x, p.y, null);
               } else if (itemType == 2) {
                   g.drawImage(shield, p.x, p.y, null);
               } else if (itemType == 3) {
                   g.drawImage(tnt, p.x, p.y, null);
               } else if (itemType == 4) {
                   g.drawImage(pearl, p.x, p.y, null);
               } else if (itemType == 5) {
                   g.drawImage(speed, p.x, p.y, null);
               } else if (itemType == 6) {
                   g.drawImage(heal, p.x, p.y, null);
               }
               itemNum++;
               if (itemNum == totalNumItems) {
                   itemNum = 0;
               }
           } else if (randomOres.get(i) < 7) {
               g.drawImage(ancientDebris, p.x, p.y, null);
           } else if (randomOres.get(i) < 11) {
               g.drawImage(diamond, p.x, p.y, null);
           } else if (randomOres.get(i) < 19) {
               g.drawImage(emerald, p.x, p.y, null);
           } else if (randomOres.get(i) < 35) {
               g.drawImage(gold, p.x, p.y, null);
           } else if (randomOres.get(i) < 67) {
               g.drawImage(iron, p.x, p.y, null);
           } else {
               g.drawImage(copper, p.x, p.y, null);
           }
       }
       if (usedTnt) {
           g.drawImage(tnt, tntPoint.x, tntPoint.y, null);
       }
       g.drawImage(steve, steveX, steveY, null);
       if (!zombieKilled) {
           g.drawImage(zombie, zombieX, zombieY, null);
       }
       if (!skeletonKilled) {
           g.drawImage(skeleton, skeletonX, skeletonY, null);
       }
       if (!creeperKilled) {
           g.drawImage(creeper, creeperX, creeperY, null);
       }
       if (!bigSlimeKilled) {
           g.drawImage(bigSlime, bigSlimeX, bigSlimeY, null);
       }
       g.drawImage(inventorySlot, 1256, 64, null);
        if (currentItem == 1) {
            g.drawImage(bigSword, 1288, 96, null);
        }else if (currentItem == 2) {
            g.drawImage(bigShield, 1320, 96, null);
        } else if (currentItem == 3) {
            g.drawImage(bigTnt, 1288, 96, null);
        } else if (currentItem == 4) {
            g.drawImage(bigPearl, 1288, 96, null);
        } else if (currentItem == 5) {
            g.drawImage(bigSpeedPot, 1288, 96, null);
        } else if (currentItem == 6) {
            g.drawImage(bigHealPot, 1288, 96, null);
        }

       g.setFont(new Font("Georgia", Font.BOLD, 24));
       g.setColor(Color.YELLOW);
       g.drawString("Score: " + score, 10, 20);
       for (int i = 0; i < lives.size(); i++) {
           Point p = lives.get(i);
           g.drawImage(heart, p.x, p.y, null);
       }
       if (!gameStart) {
           g.setColor(new Color(79, 58, 43));
           g.setFont(new Font("Pixelify Sans", Font.BOLD, 200));
           g.drawString("Pac-Craft", 180, 540);
           g.setColor(Color.green);
           g.setFont(new Font("Pixelify Sans", Font.BOLD, 90));
           g.drawString("Click To Start", 300, 640);
       }
       if (health <= 0) {
           g.setColor(Color.green);
           g.setFont(new Font("Pixelify Sans", Font.BOLD, 200));
           g.drawString("You Lose", 180, 540);
           g.setColor(new Color(79, 58, 43));
           g.setFont(new Font("Pixelify Sans", Font.BOLD, 90));
           g.drawString("Died by Killing", 300, 640);
       }
       if (gameOver) {
        g.setColor(Color.green);
           g.setFont(new Font("Pixelify Sans", Font.BOLD, 180));
           g.drawString("You Survived!!!", 70, 540);
           g.setColor(new Color(79, 58, 43));
       }

       g.setFont(new Font("Georgia", Font.BOLD, 24));
       g.setColor(Color.YELLOW);
       g.drawString("Score: " + score, 10, 20);
       g.drawString("Lives: ", 950, 20);
   }
   private void sword() {
       if (currentItem == 1) {
           if (steveZombieCollision()) {
               zombieKilled();
           }
           if (steveSkeletonCollision()) {
               skeletonKilled();
           }
           if (steveCreeperCollision()) {
               creeperKilled();
           }
           if (steveBigSlimeCollision()) {
               bigSlimeKilled();
           }
       }
   }
   public static double distance(double x1, double y1, double x2, double y2) {
       return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
       if (e.getSource() == timer) {
        moveSteve();
        moveZombie();
        moveSkeleton();
        moveCreeper();
        moveBigSlime();
        itemCollision();
        sword();
        checkHaveItem(currentItem);
        oreCollision();
        if (steveZombieCollision() || steveSkeletonCollision() || steveCreeperCollision() || steveBigSlimeCollision()) {
            collisionCooldown();
        }
        if (health <= 0 || oreCollected == 117) {
            timer.stop();
            steveTimer.stop();
            gameOver = true;
        }
        repaint();
       }  
       if (e.getSource() == steveTimer) {
            animateSteveWalking();
            repaint();
        }
   }
   private void animateSteveWalking() {
       if (nextDirection == direction.left || nextDirection == direction.up) {
           steveLeftIdx++;
           if (steveLeftIdx >= steveLeft.size()) {
               steveLeftIdx = 0;
           }
           steve = steveLeft.get(steveLeftIdx);
       }
       if (nextDirection == direction.right || nextDirection == direction.down) {
           steveRightIdx++;
           if (steveRightIdx >= steveRight.size()) {
               steveRightIdx = 0;
           }
           steve = steveRight.get(steveRightIdx);
       }
   }


   public void checkHaveItem(int currentItem) {
       if (currentItem == 1 && !swordTimer.isRunning()) {
           ableToTakeDamage = false;
           swordTimer.start();
       } else if (currentItem == 3 && !shieldTimer.isRunning()) {
           ableToTakeDamage = false;
           shieldTimer.start();
       } else if (usedSpeedPot && !speedPotTimer.isRunning()) {
           usedSpeedPot = false;
           steveMoveAmount+= 2;
           speedPotTimer.start();
       }
       if (currentItem != 1 && currentItem != 2) {
            ableToTakeDamage = true;
        }
   }
   private void itemCollision() {
    Rectangle steveRect = steveRectangle();
    for (int i = 0; i < ores.size(); i++) {
        Point p = ores.get(i);
        if (itemMap.containsKey(p) && (steveRect.intersects(itemRectangle(p)) || steveRect.intersects(shieldRectangle(p)))) {
            Integer itemType = itemMap.get(p);
            if (itemType == null) { 
                randomOres.remove(i);
                ores.remove(i);
                i--;
                continue;
            }
            currentItem = itemMap.get(p);
            itemMap.remove(p);
            randomOres.remove(i);
            ores.remove(i);
            i--;
        }
    }
}
   //finished code
   @Override
   public void keyPressed(KeyEvent e) {
       int keyCode = e.getKeyCode();
       if (keyCode == KeyEvent.VK_A) {
           nextDirection = direction.left;
       }
       if (keyCode == KeyEvent.VK_D) {
           nextDirection = direction.right;  // D key; VK_D equals 65
       }
       if (keyCode == KeyEvent.VK_W) {
           nextDirection = direction.up;
       }
       if (keyCode == KeyEvent.VK_S) {
           nextDirection = direction.down;
       }
   }
   private void moveSteve() {
       int boundaries = columns * tileSize;

       if (steveX + steve.getWidth() < 0) {
            steveX = boundaries - 1;      
       } else if (steveX > boundaries) {
            steveX = -steve.getWidth();  
       }

       if (nextDirection == direction.left) {
           if (canMoveLeftSteve(steveX - steveMoveAmount, steveY)) {
               steveX -= steveMoveAmount;
           }
       } else if (nextDirection == direction.right) {
           if (canMoveRightSteve(steveX + steveMoveAmount, steveY)) {
               steveX += steveMoveAmount;
           }
       }
       if (nextDirection == direction.up) {
           if (canMoveUpSteve(steveX, steveY - steveMoveAmount)) {
               steveY -= steveMoveAmount;
           }
       } else if (nextDirection == direction.down) {
           if (canMoveDownSteve(steveX, steveY + steveMoveAmount)) {
               steveY += steveMoveAmount;
           }
       }
   }
   private void moveZombie() {
       if (zombieAmount % 8 == 0) {
           zombieDirection = (int) (Math.random() * 4);
           zombieAmount = 0;
       }
       if (zombieDirection == 0 && canMoveUp(zombieX, zombieY - 4)) {
           if (zombieAmount % 8 != 0 || zombieAmount == 0) {
               zombieY -= 4;
               zombieAmount++;
           }
       } else if (zombieDirection == 1 && canMoveRight(zombieX + 4, zombieY)) {
           try {
               zombie = ImageIO.read(new File("imgs/Zombie_Right.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (zombieAmount % 8 != 0 || zombieAmount == 0) {
               zombieX += 4;
               zombieAmount++;
           }
       } else if (zombieDirection == 2 && canMoveDown(zombieX, zombieY + 4)) {
           if (zombieAmount % 8 != 0 || zombieAmount == 0) {
               zombieY += 4;
               zombieAmount++;
           }
       } else if (zombieDirection == 3 && canMoveLeft(zombieX - 4, zombieY)) {
           try {
               zombie = ImageIO.read(new File("imgs/Zombie_Left.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (zombieAmount % 8 != 0 || zombieAmount == 0) {
               zombieX -= 4;
               zombieAmount++;
           }
       } else {
           zombieAmount = 0;
       }
   }
   private void moveSkeleton() {
       if (skeletonAmount % 8 == 0) {
           skeletonDirection = (int) (Math.random() * 4);
           skeletonAmount = 0;
       }
       if (skeletonDirection == 0 && canMoveUp(skeletonX, skeletonY - 4)) {
           if (skeletonAmount % 8 != 0 || skeletonAmount == 0) {
               skeletonY -= 4;
               skeletonAmount++;
           }
       } else if (skeletonDirection == 1 && canMoveRight(skeletonX + 4, skeletonY)) {
           try {
               skeleton = ImageIO.read(new File("imgs/Skeleton_Right.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (skeletonAmount % 8 != 0 || skeletonAmount == 0) {
               skeletonX += 4;
               skeletonAmount++;
           }
       } else if (skeletonDirection == 2 && canMoveDown(skeletonX, skeletonY + 4)) {
           if (skeletonAmount % 8 != 0 || skeletonAmount == 0) {
               skeletonY += 4;
               skeletonAmount++;
           }
       } else if (skeletonDirection == 3 && canMoveLeft(skeletonX - 4, skeletonY)) {
           try {
               skeleton = ImageIO.read(new File("imgs/Skeleton_Left.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (skeletonAmount % 8 != 0 || skeletonAmount == 0) {
               skeletonX -= 4;
               skeletonAmount++;
           }
       } else {
           skeletonAmount = 0;
       }
   }
   private void moveCreeper() {
       if (creeperAmount % 8 == 0) {
           creeperDirection = (int) (Math.random() * 4);
           creeperAmount = 0;
       }
       if (creeperDirection == 0 && canMoveUp(creeperX, creeperY - 4)) {
           if (creeperAmount % 8 != 0 || creeperAmount == 0) {
               creeperY -= 4;
               creeperAmount++;
           }
       } else if (creeperDirection == 1 && canMoveRight(creeperX + 4, creeperY)) {
           try {
               creeper = ImageIO.read(new File("imgs/Creeper_Right.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (creeperAmount % 8 != 0 || creeperAmount == 0) {
               creeperX += 4;
               creeperAmount++;
           }
       } else if (creeperDirection == 2 && canMoveDown(creeperX, creeperY + 4)) {
           if (creeperAmount % 8 != 0 || creeperAmount == 0) {
               creeperY += 4;
               creeperAmount++;
           }
       } else if (creeperDirection == 3 && canMoveLeft(creeperX - 4, creeperY)) {
           try {
               creeper = ImageIO.read(new File("imgs/Creeper_Left.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (creeperAmount % 8 != 0 || creeperAmount == 0) {
               creeperX -= 4;
               creeperAmount++;
           }
       } else {
           creeperAmount = 0;
       }
   }
   private void moveBigSlime() {
       if (bigSlimeAmount % 32 == 0) {
           bigSlimeDirection = (int) (Math.random() * 4);
           bigSlimeAmount = 0;
       }
       if (bigSlimeDirection == 0 && canMoveUp(bigSlimeX + 2, bigSlimeY - 2)) {
           if (bigSlimeAmount % 32 != 0 || bigSlimeAmount == 0) {
               bigSlimeY -= 2;
               bigSlimeAmount++;
           }
       } else if (bigSlimeDirection == 1 && canMoveRight(bigSlimeX + 34, bigSlimeY)) {
           try {
               bigSlime = ImageIO.read(new File("imgs/Big_Slime_Right.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (bigSlimeAmount % 32 != 0 || bigSlimeAmount == 0) {
               bigSlimeX += 2;
               bigSlimeAmount++;
           }
       } else if (bigSlimeDirection == 2 && canMoveDown(bigSlimeX + 2, bigSlimeY + 2)) {
           if (bigSlimeAmount % 32 != 0 || bigSlimeAmount == 0) {
               bigSlimeY += 2;
               bigSlimeAmount++;
           }
       } else if (bigSlimeDirection == 3 && canMoveLeft(bigSlimeX - 2, bigSlimeY)) {
           try {
               bigSlime = ImageIO.read(new File("imgs/Big_Slime_Left.png"));
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
           if (bigSlimeAmount % 32 != 0 || bigSlimeAmount == 0) {
               bigSlimeX -= 2;
               bigSlimeAmount++;
           }
       } else {
           bigSlimeAmount = 0;
       }
   }

   private void oreCollision() {
       Rectangle steveRect = steveRectangle();
       for (int i = 0; i < ores.size(); i++) {
           Rectangle oreRectangleRect = oreRectangle(ores.get(i));
           if (steveRect.intersects(oreRectangleRect)) {
               if (randomOres.get(i) > 66) {
                   score += 10;
               } else if (randomOres.get(i) > 34) {
                   score += 20;
               } else if (randomOres.get(i) > 18) {
                   score += 30;
               } else if (randomOres.get(i) > 10) {
                   score += 50;
               } else if (randomOres.get(i) > 6) {
                   score += 100;
               } else if (randomOres.get(i) > 4) {
                   score += 200;
               }
               oreCollected++;
               itemMap.remove(ores.get(i));
               ores.remove(i);
               randomOres.remove(i);
               i--;
           }
       }
   }

   private boolean steveZombieCollision() {
       Rectangle steveRect = steveRectangle();
       Rectangle zombieRect = zombieRectangle();
       return steveRect.intersects(zombieRect);
   }
   private boolean steveSkeletonCollision() {
       Rectangle steveRect = steveRectangle();
       Rectangle skeletonRect = skeletonRectangle();
       return steveRect.intersects(skeletonRect);
   }
   private boolean steveCreeperCollision() {
       Rectangle steveRect = steveRectangle();
       Rectangle creeperRect = creeperRectangle();
       return steveRect.intersects(creeperRect);
   }
   private boolean steveBigSlimeCollision() {
       Rectangle steveRect = steveRectangle();
       Rectangle bigSlimeRect = bigSlimeRectangle();
       return steveRect.intersects(bigSlimeRect);
   }
   private void collisionCooldown() {
       long currentTime = System.currentTimeMillis();
       if (currentTime - lastCollisionTime >= cooldown && ableToTakeDamage) {
           health--;
           lives.removeLast();
           lastCollisionTime = currentTime;
       }
   }

   private boolean canMoveLeftSteve(int nextX, int nextY) {
       int left = (nextX + 16) / tileSize;
       int up = (nextY + 16) / tileSize;
       int down = (nextY + 63 - 1) / tileSize;
       if (left < 0 || left >= columns){
           return true;
       }
       return maze[up][left] != 1 && maze[down][left] != 1;
   }
   private boolean canMoveRightSteve(int nextX, int nextY) {
       int right = (nextX + 31 - 1) / tileSize;
       int up = (nextY + 16) / tileSize;
       int down = (nextY + 63 - 1) / tileSize;
       if (right >= columns) {
           return true;
       }
       return maze[up][right] != 1 && maze[down][right] != 1;
   }
   private boolean canMoveUpSteve(int nextX, int nextY) {
       int left = (nextX + 16) / tileSize;
       int up = (nextY + 16) / tileSize;
       int right = (nextX + 32 - 1) / tileSize;
       return maze[up][left] != 1 && maze[up][right] != 1;
   }
   private boolean canMoveDownSteve(int nextX, int nextY) {
       int left = (nextX + 16) / tileSize;
       int right = (nextX + 32 - 1) / tileSize;
       int down = (nextY + 63 - 1) / tileSize;
       return maze[down][left] != 1 && maze[down][right] != 1;
   }
   private boolean canMoveLeft(int nextX, int nextY) {
       int left = nextX / tileSize;
       int up = nextY / tileSize;
       int down = (nextY + 63 - 1)/ tileSize;

       if (left < 0 || left >= columns){
           return true;
       }

       return maze[up][left] != 1 && maze[down][left] != 1;
   }
   private boolean canMoveRight(int nextX, int nextY) {
       int right = (nextX + 32 - 1) / tileSize;
       int up = nextY / tileSize;
       int down = (nextY + 63 - 1)/ tileSize;

       if (right >= columns) {
           return true;
       }

       return maze[up][right] != 1 && maze[down][right] != 1;
   }
   private boolean canMoveUp(int nextX, int nextY) {
       int left = nextX / tileSize;
       int up = nextY / tileSize;
       int right = (nextX + 32 - 1)/ tileSize;
       return maze[up][left] != 1 && maze[up][right] != 1;
   }
   private boolean canMoveDown(int nextX, int nextY) {
       int left = nextX / tileSize;
       int right = (nextX + 32 - 1) / tileSize;
       int down = (nextY + 63 - 1)/ tileSize;
       return maze[down][left] != 1 && maze[down][right] != 1;
   }
   private void populateOres() {
       ores.add(new Point(56, 56));
       ores.add(new Point(120, 56));
       ores.add(new Point(184, 56));
       ores.add(new Point(248, 56));
       ores.add(new Point(312, 56));
       ores.add(new Point(376, 56));
       ores.add(new Point(440, 56));
       ores.add(new Point(504, 56));
       ores.add(new Point(664, 56));
       ores.add(new Point(728, 56));
       ores.add(new Point(792, 56));
       ores.add(new Point(856, 56));
       ores.add(new Point(920, 56));
       ores.add(new Point(984, 56));
       ores.add(new Point(1048, 56));
       ores.add(new Point(1112, 56));
       ores.add(new Point(56, 128));
       ores.add(new Point(248, 128));
       ores.add(new Point(504, 128));
       ores.add(new Point(664, 128));
       ores.add(new Point(920, 128));
       ores.add(new Point(1112, 128));
       ores.add(new Point(56, 200));
       ores.add(new Point(120, 200));
       ores.add(new Point(184, 200));
       ores.add(new Point(248, 200));
       ores.add(new Point(320, 200));
       ores.add(new Point(392, 200));
       ores.add(new Point(448, 200));
       ores.add(new Point(504, 200));
       ores.add(new Point(584, 200));
       ores.add(new Point(664, 200));
       ores.add(new Point(720, 200));
       ores.add(new Point(776, 200));
       ores.add(new Point(848, 200));
       ores.add(new Point(920, 200));
       ores.add(new Point(984, 200));
       ores.add(new Point(1048, 200));
       ores.add(new Point(1112, 200));
       ores.add(new Point(56, 296));
       ores.add(new Point(120, 296));
       ores.add(new Point(184, 296));
       ores.add(new Point(248, 296));
       ores.add(new Point(392, 296));
       ores.add(new Point(448, 296));
       ores.add(new Point(504, 296));
       ores.add(new Point(664, 296));
       ores.add(new Point(720, 296));
       ores.add(new Point(776, 296));
       ores.add(new Point(920, 296));
       ores.add(new Point(984, 296));
       ores.add(new Point(1048, 296));
       ores.add(new Point(1112, 296));
       ores.add(new Point(248, 392));
       ores.add(new Point(920, 392));
       ores.add(new Point(248, 488));
       ores.add(new Point(920, 488));
       ores.add(new Point(248, 584));
       ores.add(new Point(920, 584));
       ores.add(new Point(56, 680));
       ores.add(new Point(120, 680));
       ores.add(new Point(184, 680));
       ores.add(new Point(248, 680));
       ores.add(new Point(320, 680));
       ores.add(new Point(392, 680));
       ores.add(new Point(448, 680));
       ores.add(new Point(504, 680));
       ores.add(new Point(664, 680));
       ores.add(new Point(720, 680));
       ores.add(new Point(776, 680));
       ores.add(new Point(848, 680));
       ores.add(new Point(920, 680));
       ores.add(new Point(984, 680));
       ores.add(new Point(1048, 680));
       ores.add(new Point(1112, 680));
       ores.add(new Point(56, 778));
       ores.add(new Point(120, 778));
       ores.add(new Point(248, 778));
       ores.add(new Point(320, 778));
       ores.add(new Point(392, 778));
       ores.add(new Point(448, 778));
       ores.add(new Point(504, 778));
       ores.add(new Point(584, 778));
       ores.add(new Point(664, 778));
       ores.add(new Point(720, 778));
       ores.add(new Point(776, 778));
       ores.add(new Point(848, 778));
       ores.add(new Point(920, 778));
       ores.add(new Point(1048, 778));
       ores.add(new Point(1112, 778));
       ores.add(new Point(56, 873));
       ores.add(new Point(120, 873));
       ores.add(new Point(184, 873));
       ores.add(new Point(248, 873));
       ores.add(new Point(376, 873));
       ores.add(new Point(440, 873));
       ores.add(new Point(504, 873));
       ores.add(new Point(664, 873));
       ores.add(new Point(728, 873));
       ores.add(new Point(792, 873));
       ores.add(new Point(920, 873));
       ores.add(new Point(984, 873));
       ores.add(new Point(1048, 873));
       ores.add(new Point(1112, 873));
       ores.add(new Point(56, 978));
       ores.add(new Point(120, 978));
       ores.add(new Point(184, 978));
       ores.add(new Point(248, 978));
       ores.add(new Point(312, 978));
       ores.add(new Point(376, 978));
       ores.add(new Point(440, 978));
       ores.add(new Point(504, 978));
       ores.add(new Point(584, 978));
       ores.add(new Point(664, 978));
       ores.add(new Point(728, 978));
       ores.add(new Point(792, 978));
       ores.add(new Point(856, 978));
       ores.add(new Point(920, 978));
       ores.add(new Point(984, 978));
       ores.add(new Point(1048, 978));
       ores.add(new Point(1112, 978));
   }
   private void populateRandomOres() {
       for (int i = 1; i <= 121; i++) {
           randomOres.add(i);
       }
       Collections.shuffle(randomOres);
   }
   private void populateRandomItems() {
    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i < ores.size(); i++) {
        temp.add(i);
    }
    Collections.shuffle(temp);

    List<Integer> itemTypes = new ArrayList<>();
    for (int i = 1; i <= 6; i++) {
        itemTypes.add(i);
    }
    Collections.shuffle(itemTypes);


    for (int i = 0; i < 4; i++) {
        Point p = ores.get(temp.get(i));
        itemMap.put(p, itemTypes.get(i));
    }
}
   private void populateHearts() {
       lives.add(new Point(1030, 0));
       lives.add(new Point(1060, 0));
       lives.add(new Point(1090, 0));
       lives.add(new Point(1120, 0));
       lives.add(new Point(1150, 0));
   }
   private void zombieKilled() {
       zombieKilled = true;
       score+= 200;
       zombieX = 544;
       zombieY = 485;
       zombieRespawn.start();
   }
   private void skeletonKilled() {
       skeletonKilled = true;
       score+= 200;
       skeletonX = 480;
       skeletonY = 485;
       skeletonRespawn.start();
   }
   private void creeperKilled() {
       creeperKilled = true;
       score+= 200;
       creeperX = 608;
       creeperY = 485;
       creeperRespawn.start();
   }
   private void bigSlimeKilled() {
       bigSlimeKilled = true;
       score+= 200;
       bigSlimeX = 674;
       bigSlimeY = 482;
       bigSlimeRespawn.start();
   }
   private Rectangle steveRectangle() {
       int imageHeight = steve.getHeight();
       int imageWidth = steve.getWidth();
       Rectangle rect = new Rectangle(steveX, steveY, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle zombieRectangle() {
       int imageHeight = zombie.getHeight();
       int imageWidth = zombie.getWidth();
       Rectangle rect = new Rectangle(zombieX, zombieY, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle skeletonRectangle() {
       int imageHeight = skeleton.getHeight();
       int imageWidth = skeleton.getWidth();
       Rectangle rect = new Rectangle(skeletonX, skeletonY, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle creeperRectangle() {
       int imageHeight = creeper.getHeight();
       int imageWidth = creeper.getWidth();
       Rectangle rect = new Rectangle(creeperX, creeperY, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle bigSlimeRectangle() {
       int imageHeight = bigSlime.getHeight();
       int imageWidth = bigSlime.getWidth();
       Rectangle rect = new Rectangle(bigSlimeX, bigSlimeY, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle oreRectangle(Point point) {
       int imageHeight = copper.getHeight();
       int imageWidth = copper.getWidth();
       Rectangle rect = new Rectangle(point.x, point.y, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle itemRectangle(Point point) {
       int imageHeight = sword.getHeight();
       int imageWidth = sword.getWidth();
       Rectangle rect = new Rectangle(point.x, point.y, imageWidth, imageHeight);
       return rect;
   }
   private Rectangle shieldRectangle(Point point) {
       int imageHeight = shield.getHeight();
       int imageWidth = shield.getWidth();
       Rectangle rect = new Rectangle(point.x, point.y, imageWidth, imageHeight);
       return rect;
   }
   @Override
   public void mouseClicked(MouseEvent e) {
   }
   @Override
   public void mousePressed(MouseEvent e) {
       if (e.getButton() == MouseEvent.BUTTON1) {
           gameStart = true;
           timer.start();
           steveTimer.start();
           repaint();
       }
       if (e.getButton() == MouseEvent.BUTTON1 && currentItem == 3) {
           usedTnt = true;
           tntPoint = e.getPoint();
           tntTimer.start();
           currentItem = 0;
       }
       if (e.getButton() == MouseEvent.BUTTON1 && currentItem == 4) {
           Point clickLocation = e.getPoint();
           steveX = clickLocation.x;
           steveY = clickLocation.y;
           currentItem = 0;
       }
       if (e.getButton() == MouseEvent.BUTTON1 && currentItem == 5) {
           usedSpeedPot = true;
           currentItem = 0;
       }
       if (e.getButton() == MouseEvent.BUTTON1 && currentItem == 6) {
           int count = 2;
           while (count != 0 && health != 5) {
               int heart = 1030 + 30 * health;
               lives.add(new Point(heart,10));
               health++;
               count--;
           }
           currentItem = 0;
       }
   }
   private void drawMap(Graphics g) {
       for (int r = 0; r < rows; r++) {
           for (int c = 0; c < columns; c++) {
               int tile = maze[r][c];
               int x = c * tileSize;
               int y = r * tileSize;
               if (tile == 1) {
                   g.setColor(Color.BLUE);
                   g.fillRect(x, y, tileSize, tileSize);
                   g.setColor(Color.DARK_GRAY);
                   g.drawRect(x, y, tileSize, tileSize);
               }
           }
       }
   }
   public enum direction {
       none, left, right, down, up
   }
   @Override
   public void keyReleased(KeyEvent e) {
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
   @Override
   public void keyTyped(KeyEvent e) {
   }
}


