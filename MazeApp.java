import javax.swing.*;

public class MazeApp {
    public static void main(String[] args) {
        JFrame frame =new JFrame();
        frame.setSize(400,400);
        frame.add(new MazeControl());
        frame.setTitle("Maze");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
