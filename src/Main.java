import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1496; //19 col * 32 pixels
        int height = 1066; //21 row * 32 pixels
        
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        
        DisplayPanel panel = new DisplayPanel();
        
        frame.add(panel);
        
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
