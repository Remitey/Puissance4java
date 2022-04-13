package Game;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame{
    public BoardGame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new GridGame(), "Center");
        add(new DataPlayer(), "East");

        this.setSize(600, 600);
        this.setVisible(true);
    }
}
