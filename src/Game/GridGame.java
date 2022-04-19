package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GridGame extends JPanel{

    public GridGame(int rows, int col){

        Dimension dFrame = new Dimension(rows * 100, col * 100);
        Dimension dBox = new Dimension(100, 100);

        Map<Pair, Boolean> tab = new HashMap<>();

        setLayout(new GridLayout(rows, col));
        setSize(dFrame);
        setBackground(Color.blue);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                tab.put(new Pair(i, j), false);
                add(new BoardGameBox(dBox, tab));
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
}
