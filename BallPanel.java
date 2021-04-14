import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class BallPanel extends JPanel {
    private int delay = 10;
    private PriorityQueue<Ball> queue= new PriorityQueue<Ball>(Collections.reverseOrder());
    // Create a timer with the initial delay
    protected Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        @Override /** Handle the action event */
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public BallPanel() {
        timer.start();
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                int x = e.getX();
                int y = e.getY();
                for (Ball ball : queue) {
                    double distance=BallPanel.distance(x,y,ball.x,ball.y);
                    if (ball.radius>=distance){
                        queue.remove(ball);
                        break;
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public void add() {
        queue.offer(new Ball());
        for (Ball ball : queue) {
            System.out.println(ball.radius);
        }

    }

    public void subtract() {
        if (queue.size()>0){
            queue.poll();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : queue) {
            g.setColor(ball.color);
            if (ball.x<0||ball.x>getWidth()){
                ball.dx=-ball.dx;
            }
            if (ball.y<0||ball.y>getHeight()){
                ball.dy=-ball.dy;
            }
            ball.x+=ball.dx;
            ball.y+=ball.dy;
            g.fillOval(ball.x-ball.radius,ball.y-ball.radius,ball.radius*2,ball.radius*2);
        }


        ArrayList<Ball> ballsToRemove = new ArrayList<>();
        for (Ball ball : queue) {
            if (!ballsToRemove.contains(ball)){
                for (Ball ball1 : queue) {
                    if (ball1!=ball){
                        int radiusSum=ball.radius+ball1.radius;
                        double distance=BallPanel.distance(ball.x,ball.y,ball1.x,ball1.y);
                        if (radiusSum>=distance){
                            ballsToRemove.add(ball1);
                            ball.radius+=ball1.radius;
                        }
                    }
                }

            }
        }

    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2));
    }

    public void suspend() {
        timer.stop();
    }

    public void resume() {
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
        timer.setDelay(delay);
    }
}