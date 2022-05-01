package Game.View;

//import BaseDeDonnee.Player;
import Database.Table.Player;
import Game.Model.DataGrid;
import Game.Controller.GameController;
import GestionUtilisateur.Play;

import javax.swing.*;
import java.awt.*;

public class BoardGame extends JFrame{
    public BoardGame(Player player1, Player player2){
        int rows = 6;
        int col = 7;
        //new DataGrid(rows, col, player1, player2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PlayerView playerView = new PlayerView();

        GridView gridView = new GridView();

        GameController gameController = new GameController(false, gridView);


        gameController.addObserver(playerView);

        add(gameController.getGridView(), "Center");
        add(playerView, "East");

        this.setSize(600, 600);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
