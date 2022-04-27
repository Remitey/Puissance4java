package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GridGame extends Observable implements Observer {
    private final int rows;
    private final int col;
    private final Map<Pair<Integer>, DataGameBox> grid;
    private final JPanel jPanel;
    private int player;
    private final AlgoMinMax algoMinMax;
    private final boolean ia;

    public GridGame(int rows, int col, boolean ia) {
        this.rows = rows;
        this.col = col;
        this.ia = ia;
        this.algoMinMax = new AlgoMinMax(rows, col);

        jPanel = new JPanel();

        Dimension dFrame = new Dimension(rows * 100, col * 100);

        grid = new HashMap<>();

        Random random = new Random();
        player = random.nextInt(2);


        jPanel.setLayout(new GridLayout(rows, col));
        jPanel.setSize(dFrame);
        jPanel.setBackground(Color.blue);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                grid.put(new Pair<>(i, j), new DataGameBox(false));
                grid.get(new Pair<>(i, j)).addObserver(this);
                BoardGameBox boardGameBox = new BoardGameBox(grid);
                jPanel.add(boardGameBox);
            }
        }
        for (int j = 0; j < col; j++) {
            grid.put(new Pair<>(rows, j), new DataGameBox(true));
        }
        jPanel.setVisible(true);
    }

    public JPanel getPanel() {
        return jPanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Updating");

        if (arg instanceof Pair<?>) {
            //System.out.println(arg);
            grid.get(arg).setPlayer(player);
        }

        if (winCondition() || isPath()) {
            SwingUtilities.getWindowAncestor(jPanel).dispose();

            new Win();
            JOptionPane.showMessageDialog(jPanel, "joueur X a win");


        }


        if (ia) {
            player = 0;
            setChanged();
            notifyObservers("IA");
            Pair<Integer> pair = algoMinMax.algoMinMAx(5, grid, player);
            System.out.println(pair);
            int number = rows * pair.getFirst() + pair.getSecond();
            System.out.println(number);

            BoardGameBox boardGameBox = (BoardGameBox) jPanel.getComponent(number);

            grid.get(pair).setUsed(true);
            grid.get(pair).setPlayer(player);

            //boardGameBox.verifyAndDraw(pair.getFirst(), pair.getSecond(), true);
            boardGameBox.base = Color.red;
            boardGameBox.paintComponent(boardGameBox.getGraphics());
            System.out.println(boardGameBox.base);

            player = 1;
        } else {
            if (player == 1) {
                player = 0;
            } else {
                player = 1;
            }
        }
        setChanged();
        notifyObservers(player);
    }

    public boolean winCondition() {
        boolean isWin = false;
        for (int i = 0; i < rows; i++) { // line conditions
            for (int j = 0; j < col - 3; j++) {
                if (grid.get(new Pair<>(i, j)).check(player) && grid.get(new Pair<>(i, j + 1)).check(player) && grid.get(new Pair<>(i, j + 2)).check(player) && grid.get(new Pair<>(i, j + 3)).check(player)) {
                   isWin = true;
                }
            }
        }

        for (int i = 0; i < rows - 3; i++) { // col conditions
            for (int j = 0; j < col; j++) {
                if (grid.get(new Pair<>(i, j)).check(player) && grid.get(new Pair<>(i + 1, j)).check(player) && grid.get(new Pair<>(i + 2, j)).check(player) && grid.get(new Pair<>(i + 3, j)).check(player)) {
                    isWin = true;

                }
            }
        }

        for (int i = 0; i < rows - 3; i++) { // diagonale 1 conditions
            for (int j = 0; j < col - 3; j++) {
                if (grid.get(new Pair<>(i, j)).check(player) && grid.get(new Pair<>(i + 1, j + 1)).check(player) && grid.get(new Pair<>(i + 2, j + 2)).check(player) && grid.get(new Pair<>(i + 3, j + 3)).check(player)) {
                    isWin = true;
                }
            }
        }
        for (int i = 3; i < rows; i++) { // diagonale 2 conditions
            for (int j = 0; j < col - 3; j++) {
                if (grid.get(new Pair<>(i, j)).check(player) && grid.get(new Pair<>(i - 1, j + 1)).check(player) && grid.get(new Pair<>(i - 2, j + 2)).check(player) && grid.get(new Pair<>(i - 3, j + 3)).check(player)) {
                    isWin = true;

                }
            }
        }
        return isWin;
    }


    public boolean isPath() {
        DataGameBox dataGameBox = new DataGameBox(false);
        if (!grid.containsValue(dataGameBox)) {
            JOptionPane.showMessageDialog(jPanel, "no one win");
            SwingUtilities.getWindowAncestor(jPanel).dispose();
        }
        return false;
    }
}
