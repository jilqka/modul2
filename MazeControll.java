import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MazeControl extends JPanel {
    private MazePanel mazePanel = new MazePanel();
    private JButton findPathButton = new JButton("Find Path");
    private JButton cleanPathButton = new JButton("Reset");
    public MazeControl(){
        setLayout(new BorderLayout());
        add(mazePanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(findPathButton);
        buttonPanel.add(cleanPathButton);
        add(buttonPanel, BorderLayout.SOUTH);
        findPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mazePanel.findPath();
            }
        });
        cleanPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mazePanel.cleanPath();
            }
        });
    }
}