import java.awt.*;
public class Ball {
    int x = 0;
    int y = 0; // Current ball position
    int dx = 2; // Increment on ball's x-coordinate
    int dy = 2; // Increment on ball's y-coordinate
    int radius = 5; // Ball radius
    Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}
