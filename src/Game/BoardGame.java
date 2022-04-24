package Game;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame{
    public BoardGame(){
        int rows = 5;
        int col = 5;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        GridGame gridGame = new GridGame(rows, col, true);
        DataPlayer dataPlayer = new DataPlayer();
        gridGame.addObserver(dataPlayer);

        add(gridGame.getjPanel(), "Center");
        add(dataPlayer, "East");

        this.setSize(600, 600);
        this.setVisible(true);
    }
}
