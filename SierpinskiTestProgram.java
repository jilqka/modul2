import javax.swing.JFrame;

public class SierpinskiTestProgram {
    public static void main(String[] args) {
        SierpinskiTriangleFrame frame = new SierpinskiTriangleFrame();
        frame.setSize(400, 400);
        frame.setTitle("TestFigurePanel");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}