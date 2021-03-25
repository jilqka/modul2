import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

public class Lists_7_3 {

    public static class doc7_ex3 {

        private JFrame frame;
        private JTextField textField;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        doc7_ex3 window = new doc7_ex3();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the application.
         */
        public doc7_ex3() {
            initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 666, 386);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JLabel lblNewLabel = new JLabel("Enter a number:");
            lblNewLabel.setFont(new Font("Tacoma", Font.PLAIN, 14));
            lblNewLabel.setBounds(134, 22, 111, 14);
            frame.getContentPane().add(lblNewLabel);

            LinkedList<Integer> allNumbers = new LinkedList<>();

            textField = new JTextField();
            textField.setFont(new Font("Tacoma", Font.PLAIN, 14));
            textField.setBounds(243, 21, 119, 22);
            frame.getContentPane().add(textField);
            textField.setColumns(10);


            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
            textArea.setBounds(24, 76, 599, 182);
            frame.getContentPane().add(textArea);

            JButton addBtn = new JButton("Add number");
            addBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int number = Integer.parseInt(textField.getText());
                    if (!allNumbers.contains(number)) {
                        allNumbers.add(number);
                        displayList(allNumbers, textArea);
                    }
                    textField.setText("");
                }
            });
            addBtn.setFont(new Font("Tacoma", Font.PLAIN, 14));
            addBtn.setBounds(372, 20, 111, 23);
            frame.getContentPane().add(addBtn);

            JButton sortBtn = new JButton("Sort");
            sortBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Collections.sort(allNumbers);
                    displayList(allNumbers, textArea);
                }
            });
            sortBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
            sortBtn.setBounds(125, 298, 89, 23);
            frame.getContentPane().add(sortBtn);

            JButton shuffleBtn = new JButton("Shuffle");
            shuffleBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Collections.shuffle(allNumbers);
                    displayList(allNumbers, textArea);
                }
            });
            shuffleBtn.setFont(new Font("Tacoma", Font.PLAIN, 14));
            shuffleBtn.setBounds(258, 298, 89, 23);
            frame.getContentPane().add(shuffleBtn);

            JButton reverseBtn = new JButton("Reverse");
            reverseBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Collections.reverse(allNumbers);
                    displayList(allNumbers, textArea);
                }
            });
            reverseBtn.setFont(new Font("Tacoma", Font.PLAIN, 14));
            reverseBtn.setBounds(394, 298, 89, 23);
            frame.getContentPane().add(reverseBtn);


        }

        public static void displayList(LinkedList<Integer> list, JTextArea textArea) {
            String displayText = "";
            for (int n : list) {
                displayText += n + " ";
            }
            textArea.setText(displayText);
        }
    }
}
