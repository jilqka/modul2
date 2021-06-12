
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MazePanel extends JPanel {
    boolean displayPath = false;
    Maze m;
    public MazePanel(){
        try {
            m = new Maze("dsk_2/src/maze.txt");
            for(int i = 0; i <m.maze.length; i++){
                for(int j = 0; j <m.maze[i].length; j++){
                    System.out.print(m.maze[i][j]);
                }
                System.out.println();
            }
            if (MazeSolver.solveMaze(m)) {
                System.out.println("You won!");
            } else {
                System.out.println("No path");
            }
            for(int i = 0; i <m.maze.length; i++){
                for(int j = 0; j <m.maze[i].length; j++){
                    System.out.print(m.maze[i][j]);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void findPath(){
        displayPath = true;
        repaint();
    }

    public void cleanPath(){
        displayPath = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth()/m.maze[0].length - 2;
        int height = getHeight()/m.maze.length - 2;
        if(displayPath) {
            g.setColor(Color.BLACK);
            for (Position p : m.path) {
                g.fillRect(2 + p.x * (width + 2), 2 + p.y * (height + 2), width, height);
            }
            g.setColor(Color.WHITE);
            for(int i = 0; i < m.maze.length; i++){
                for(int j = 0; j < m.maze[i].length; j++){
                    if(m.maze[i][j] == 1 || m.maze[i][j] == 3) {
                        g.fillRect(2 + j * (width + 2), 2 + i * (height + 2), width, height);
                        //System.out.print(m.maze[i][j]);
                    }else if(m.maze[i][j] == 2) {
                        g.setColor(Color.RED);
                        g.fillRect(2 + j * (width + 2), 2 + i * (height + 2), width, height);
                        g.setColor(Color.WHITE);
                        //System.out.print(m.maze[i][j]);
                    }else if(m.maze[i][j] == 0) {
                        g.setColor(Color.GRAY);
                        g.fillRect(2 + j * (width + 2), 2 + i * (height + 2), width, height);
                        g.setColor(Color.WHITE);
                        //System.out.print(m.maze[i][j]);
                    }
                }
                //System.out.println();
            }
        }
    }
}