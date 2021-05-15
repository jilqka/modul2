import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class SortControll extends JPanel {
        private SortingPanel sortingPanel = new SortingPanel();

        private JButton nextStepBtn = new JButton("NextStep");

        public SortControll() {

            setLayout(new BorderLayout());
            add(sortingPanel, BorderLayout.CENTER);
            add(nextStepBtn, BorderLayout.SOUTH);

            nextStepBtn.addActionListener(new ActionListener() {


                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    sortingPanel.nextStepInSorting();
                }
            });

        }
    }

