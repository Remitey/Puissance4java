package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class GridGame extends Observable implements Observer {
    private final int rows;
    private final int col;
    private final Map<Pair, DataGameBox> tab;
    private JPanel jPanel;
    private int player;

    public GridGame(int rows, int col) {
        this.rows = rows;
        this.col = col;

        jPanel = new JPanel();
        player = 0;
        Dimension dFrame = new Dimension(rows * 100, col * 100);
        Dimension dBox = new Dimension(100, 100);

        tab = new HashMap<>();

        jPanel.setLayout(new GridLayout(rows, col));
        jPanel.setSize(dFrame);
        jPanel.setBackground(Color.blue);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                tab.put(new Pair(i, j), new DataGameBox(false));
                tab.get(new Pair(i, j)).addObserver(this);
                BoardGameBox boardGameBox = new BoardGameBox(dBox, tab);
                jPanel.add(boardGameBox);
            }
        }
        for (int j = 0; j < col; j++) {
            tab.put(new Pair(rows, j), new DataGameBox(true));
        }
        jPanel.setVisible(true);
    }

    public JPanel getjPanel(){
        return jPanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Updating");

        if (arg instanceof Pair<?>){
            System.out.println(arg);
            tab.get(arg).setPlayer(player);
        }

        for (int i = 0; i < rows; i++) { // line conditions
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)).check(player) && tab.get(new Pair(i, j + 1)).check(player) && tab.get(new Pair(i, j + 2)).check(player) && tab.get(new Pair(i, j + 3)).check(player)) {
                    JOptionPane.showMessageDialog(jPanel, "win line");
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) { // col conditions
            for (int j = 0; j < col; j++) {
                if (tab.get(new Pair(i, j)).check(player) && tab.get(new Pair(i + 1, j)).check(player) && tab.get(new Pair(i + 2, j)).check(player) && tab.get(new Pair(i + 3, j)).check(player)) {
                    JOptionPane.showMessageDialog(jPanel, "win col");
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) { // diagonale 1 conditions
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)).check(player) && tab.get(new Pair(i + 1, j + 1)).check(player) && tab.get(new Pair(i + 2, j + 2)).check(player) && tab.get(new Pair(i + 3, j + 3)).check(player)) {
                    JOptionPane.showMessageDialog(jPanel, "win diagonal 1");
                }
            }
        }

        for (int i = 3; i < rows; i++) { // diagonale 2 conditions
            for (int j = 0; j < col - 3; j++) {
                if (tab.get(new Pair(i, j)).check(player) && tab.get(new Pair(i - 1, j + 1)).check(player) && tab.get(new Pair(i - 2, j + 2)).check(player) && tab.get(new Pair(i - 3, j + 3)).check(player)) {
                    JOptionPane.showMessageDialog(jPanel, "win diagonal 2");
                }
            }
        }

        if (player == 1){
            player = 0;
        }
        else {
            player = 1;
        }
        setChanged();
        notifyObservers(player);
    }
}
