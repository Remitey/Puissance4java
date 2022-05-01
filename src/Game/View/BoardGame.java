package Game.View;

import Database.DAOmodel.GameDAO;
import Database.DAOmodel.PlayerDAO;
import Database.Table.Game;
import Database.Table.Player;
import Game.Model.DataGrid;
import Game.Controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class BoardGame extends JFrame{
    public BoardGame(Player player1, Player player2){
        int rows = 6;
        int col = 7;

        new DataGrid(rows, col, player1, player2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PlayerView playerView = new PlayerView(player1,player2);
        GridView gridView = new GridView();

        GameController gameController = new GameController(gridView);
        gameController.addObserver(playerView);

        add(gameController.getGridView(), "Center");
        add(playerView, "East");

        this.setSize(600, 600);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public BoardGame(Player player, String difficulty){
        int rows = 6;
        int col = 7;

        new DataGrid(rows, col, player);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PlayerView playerView = new PlayerView(player);
        GridView gridView = new GridView();

        GameController gameController = new GameController("easy", gridView);
        gameController.addObserver(playerView);

        add(gameController.getGridView(), "Center");
        add(playerView, "East");

        this.setSize(600, 600);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
