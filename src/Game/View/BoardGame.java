package Game.View;

import Game.Model.DataGrid;
import Game.Controller.GameController;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame{
    public BoardGame(){
        int rows = 6;
        int col = 7;
        new DataGrid(rows, col);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PlayerView playerView = new PlayerView();

        GridView gridView = new GridView();

        GameController gameController = new GameController(false, gridView);


        gameController.addObserver(playerView);

        add(gameController.getGridView(), "Center");
        add(playerView, "East");

        this.setSize(600, 600);
        this.setVisible(true);
    }
}
