import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

public class SierpinskiTrianglePanel extends JPanel {
    private int order = 0;
    static private int green = 0;
    /** Set a new order */
    public void setOrder(int order) {
        this.order = order;
        repaint();
    }

    public void increaseOrder() {
        this.order++;
        repaint();
    }

    public void decreaseOrder() {

        if(order == 0) {
            return;
        }

        this.order--;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Select three points in proportion to the panel size
        Point p1 = new Point(getWidth() / 2, 10);
        Point p2 = new Point(10, getHeight() - 10);
        Point p3 = new Point(getWidth() - 10, getHeight() - 10);
        displayTriangles(g, order, p1, p2, p3);
    }

    private static void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
        if (order == 0) {
            // Draw a triangle to connect three points
//				g.drawLine(p1.x, p1.y, p2.x, p2.y);
//				g.drawLine(p1.x, p1.y, p3.x, p3.y);
//				g.drawLine(p2.x, p2.y, p3.x, p3.y);
            int x[] = new int [3];
            int y[] = new int [3];
            x[0] = p1.x; x[1] = p2.x; x[2] = p3.x;
            y[0] = p1.y; y[1] = p2.y; y[2] = p3.y;
            int n = 3;

            Polygon p = new Polygon(x, y, n);
            if(green > 250) {
                green = 0;
            }
            green += 5;
            Color c = new Color(0, green, 255);
            g.setColor(c);
            g.fillPolygon(p);
        } else {
            // Get the midpoint on each edge of the triangle
            Point p12 = midpoint(p1, p2);
            Point p23 = midpoint(p2, p3);
            Point p31 = midpoint(p3, p1);
            // Recursively display three triangles
            displayTriangles(g, order - 1, p1, p12, p31);
            displayTriangles(g, order - 1, p12, p2, p23);
            displayTriangles(g, order - 1, p31, p23, p3);
        }
    }

    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}