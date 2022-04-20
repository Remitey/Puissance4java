package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class GridGame extends JPanel implements Observer {
    private int rows;
    private int col;
    private Map<Pair, Boolean> tab;

    public GridGame(int rows, int col) {
        this.rows = rows;
        this.col = col;

        Dimension dFrame = new Dimension(rows * 100, col * 100);
        Dimension dBox = new Dimension(100, 100);

        tab = new HashMap<>();

        setLayout(new GridLayout(rows, col));
        setSize(dFrame);
        setBackground(Color.blue);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                tab.put(new Pair(i, j), false);
                BoardGameBox boardGameBox = new BoardGameBox(dBox, tab);
                add(boardGameBox.getjPanel());
                boardGameBox.addObserver(this);
            }
        }
        for (int j = 0; j < col; j++) {
            tab.put(new Pair(rows, j), true);
        }
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print((new Pair<>(i, j)).toString() + tab.get(new Pair<>(i, j)) + " ");
            }
            System.out.println();
        }
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Updating");
        int buffer;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)) && tab.get(new Pair(i, j + 1)) && tab.get(new Pair(i, j + 2)) && tab.get(new Pair(i, j + 3))) {
                    System.out.println("win line");
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < col; j++) {
                if (tab.get(new Pair(i, j)) && tab.get(new Pair(i + 1, j)) && tab.get(new Pair(i + 2, j)) && tab.get(new Pair(i + 3, j))) {
                    System.out.println("win col");
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)) && tab.get(new Pair(i + 1, j + 1)) && tab.get(new Pair(i + 2, j + 2)) && tab.get(new Pair(i + 3, j + 3))) {
                    System.out.println("win diagonal 1");
                }
            }
        }

        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)) && tab.get(new Pair(i - 1, j + 1)) && tab.get(new Pair(i - 2, j + 2)) && tab.get(new Pair(i - 3, j + 3))) {
                    System.out.println("win diagonal 2");
                }
            }
        }
    }
}
