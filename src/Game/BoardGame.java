package Game;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame{
    public BoardGame(){
        int rows = 5;
        int col = 5;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new GridGame(rows, col), "Center");
        add(new DataPlayer(), "East");

        this.setSize(600, 600);
        this.setVisible(true);
    }
}
