import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class SortingPanel extends JPanel {

    private ArrayList<Integer> numbers = new ArrayList(Arrays.asList(5, 4, 3, 2, 1));

    private static int noSortingStage = -1;
    private static int incrementIStage = 0; // not visible on animation
    private static int incrementJStage = 1;
    private static int compareStage = 2; // show j and j+1
    private static int switchStage = 3;
    private static int isSortedStage = 4;

    private int stage = noSortingStage;

    int currentI = -1;
    int currentJ = -1;

    boolean swapAtI = false;

    public SortingPanel() {

    }

    public void nextStepInSorting() {
        if (stage == isSortedStage) {
            return;
        }

        if (stage == noSortingStage) {
            stage = incrementIStage; // Initializing stage, continue directly to next stage
        }

        if (stage == incrementIStage) {
            currentI++;
            swapAtI = false;
            stage = incrementJStage; // Initializing stage, continue directly to next stage
        }

        if (stage == incrementJStage) {
            currentJ++;
        } else if (stage == switchStage) {
            Integer numberJ = numbers.get(currentJ);
            Integer numberJPlus1 = numbers.get(currentJ + 1);
            if (numberJ > numberJPlus1) {
                swapAtI = true;
                numbers.set(currentJ + 1, numberJ);
                numbers.set(currentJ, numberJPlus1);
            }
        }

        repaint();

    }

    private void nextStage() {
        if (stage == incrementJStage) {
            stage = compareStage;
        } else if (stage == compareStage) {
            stage = switchStage;
        } else if (stage == switchStage) {
            // allows j++ only when j will not get greater than  numbers.size() - 2- currentI (the last valid option)
            if (currentJ < numbers.size() - 2 - currentI) {
                stage = incrementJStage;
            } else {
                currentJ = -1; // finished comparing all pair for this iteration of i
                System.out.println(currentI);
                // allows i++ only when i will not get greater than  numbers.size() - 2 (the last valid option)
                if (currentI < numbers.size() - 2 && swapAtI) {
                    stage = incrementIStage; // next i

                } else {
                    currentI = -1;
                    stage = isSortedStage; // finished sorting
                    repaint();
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int towerWidth = ((getWidth() - 20) / numbers.size()) - 2;
        int towerHeghtIndex = (getHeight() - 20) / maxElement(numbers);
        int downY = getHeight() - 5;
        for (int j = 0; j < numbers.size(); j++) {

            // establish color
            if (stage == noSortingStage || stage == isSortedStage) {
                g.setColor(Color.BLACK);
            } else if (j == currentJ + 1 && (stage == compareStage || stage == switchStage)) {
                g.setColor(Color.RED);
            } else if (j == currentJ) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }

            int leftX = j * towerWidth + 5 * (j + 1);
            int rightX = leftX + towerWidth;
            int upperY = downY - numbers.get(j) * towerHeghtIndex;
            g.drawLine(leftX, downY, leftX, upperY); // left side line
            g.drawLine(leftX, upperY, rightX, upperY); // top line
            g.drawLine(rightX, downY, rightX, upperY); // right line

            g.drawString(numbers.get(j).toString(), leftX + towerWidth / 2, downY - 5);
        }

        if (stage != noSortingStage) {
            nextStage();
        }
    }

    public static Integer maxElement(ArrayList<Integer> numbers) {
        Integer max = numbers.get(0);
        for (Integer a : numbers) {
            if (a > max) {
                max = a;
            }
        }

        return max;
    }

}
