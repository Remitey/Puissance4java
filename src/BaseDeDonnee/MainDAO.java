package BaseDeDonnee;


public class MainDAO {
    public static void main(String[] args) {

        Player player1 = new Player(3,"Thotho","lad@yahhoo.fr","123456",2);
        DAO<Player> playerDAO = new PlayerDAO();
        playerDAO.create(player1);
        System.out.println(player1);
        System.out.println(playerDAO.find(1));
    }
}
