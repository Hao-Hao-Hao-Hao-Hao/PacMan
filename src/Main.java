import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        DisplayPanel board = new DisplayPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1496, 1120);
        frame.add(board);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
