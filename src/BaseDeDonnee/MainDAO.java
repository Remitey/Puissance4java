package BaseDeDonnee;


public class MainDAO {
    public static void main(String[] args) {

        Player player1 = new Player(3,"Thotho","lad@yahhoo.fr","123456",2);
        Player player2 = new Player(4,"Thotho","lad@yahhoo.fr","123456",2);
        DAO<Player> playerDAO = new PlayerDAO();
        playerDAO.find(3);

        System.out.println(playerDAO.find(3));

       /* Cpu cpu1 = new Cpu(6,"ok",8);
        DAO<Cpu> cpuDAO = new CpuDAO();
        cpuDAO.find(4);
        cpuDAO.create(cpu1);
        System.out.println(cpuDAO.find(4));*/

        DAO<Game> gameDAO = new GameDAO();
        gameDAO.find(1);
        System.out.println(gameDAO.find(1));

       /* DAO<Turn> turnDAO = new TurnDAO();

        TurnDAO turnDAO1 = (TurnDAO) turnDAO;
        turnDAO1.find2

        */
    }
}
