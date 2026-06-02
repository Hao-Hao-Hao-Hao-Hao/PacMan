import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1480;
        int height = 1025; 

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();

        frame.add(panel);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
