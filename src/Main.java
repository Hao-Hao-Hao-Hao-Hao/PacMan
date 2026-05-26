import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 560);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();

        frame.add(panel);

        frame.setVisible(true);
    }
}
