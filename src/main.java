//import BaseDeDonnee.Player;
//import BaseDeDonnee.PlayerDAO;
import Database.DAOmodel.PlayerDAO;
import Database.Table.Player;
import Game.View.BoardGame;

public class main {
    public static void main(String[] args) {
        PlayerDAO playerDAO = new PlayerDAO();
        new BoardGame(playerDAO.findPlayer("Thotho", "123456"), "easy");
    }
}