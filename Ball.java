import java.awt.*;
public class Ball implements Comparable<Ball> {
    int x = 0;
    int y = 0; // Current ball position
    int dx = 2; // Increment on ball's x-coordinate
    int dy = 2; // Increment on ball's y-coordinate
    int radius = (int)(Math.random()*19)+2;
    Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

    @Override
    public int compareTo(Ball o) {
        if (radius-o.radius>0){
            return 1;
        }
        else if (radius-o.radius<0){
            return -1;
        }
        else {
            return 0;
        }
    }
}
