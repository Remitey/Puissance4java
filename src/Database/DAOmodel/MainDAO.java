package Database.DAOmodel;


import Database.Table.Cpu;
import Database.Table.Game;
import Database.Table.Player;
import Database.Table.Turn;

import java.util.Date;

public class MainDAO {
    public static void main(String[] args) {

        Player player1 = new Player(1, "thotho", "lad@yahhoo.fr", "123456", 2);
        Player player2 = new Player( 1,"dhodho", "lad@yahhoo.fr", "123456", 2);

        Cpu cpu1 = new Cpu(1,"easy",5);
        Cpu cpu2 = new Cpu(2,"hard",5);

        CpuDAO cpuDAO = new CpuDAO();

       // cpuDAO.create(cpu1);
        //.create(cpu2);
      //  Date date = new Date();
        //System.out.println(date.getTime());

        //PlayerDAO playerDAO = new PlayerDAO();
        //playerDAO.create(player1);
        //playerDAO.create(player2);
        /*GameDAO gameDAO = new GameDAO();
        TurnDAO turnDAO = new TurnDAO();

        Game game = new Game(0, playerDAO.findPlayer(player1.getUsername()), playerDAO.findPlayer(player2.getUsername()), 6, 7, 5, date.getTime(),0);
        gameDAO.create(game);
        game.setResult(5);
        game = gameDAO.find(1);
        gameDAO.update(game);*/
        //Turn turn = new Turn(5, 0, playerDAO.findPlayer(player1.getUsername()), 0, 0);
        //turnDAO.create(turn);
        //gameDAO.create(game);

        //playerDAO.create(player1);
        //Player player3 = new Player(playerDAO.findPlayer(player1.getUsername()).getId(), "thotho", "lad@yahhoo.fr", "123456", 2);
        //playerDAO.update(player3);
       // playerDAO.update(player1);
        //playerDAO.updatePassword("nice_ca");



      // System.out.println(playerDAO.findPlayer("unedingz","thrugzg"));

       // System.out.println( playerDAO.findPlayer("ok","nik zebi"));
        //System.out.println( playerDAO.findPlayer("nice","tu cocos"));



        //playerDAO.find(3);
        //playerDAO.create(player8);



        // System.out.println(playerDAO.find(3));

       // Cpu cpu1 = new Cpu(6,"ok",8);
        //DAO<Cpu> cpuDAO = new CpuDAO();
        //cpuDAO.find(4);
        //cpuDAO.create(cpu1);
       // System.out.println(cpuDAO.find(4));
      //  Date date = new Date(40);


        //Game game2 = new Game(5,player3,player2,6,7,null,date,null);
       // Game game3 = new Game(6,player3,cpu1,7,6,null,date,null);

      //  DAO<Game> gameDAO = new GameDAO();
        //gameDAO.find(1);
        // gameDAO.create(game2);
      //  gameDAO.create(game3);
        //System.out.println(gameDAO.find(1));


        //Turn turn1 = new Turn(6,1,player3,7,3);
       // Turn turn2 = new Turn(6,7,player3,4,8);

       // Turn turn3 = new Turn(5,1,player3,4,5);
      //  Turn turn4 = new Turn(5,2,player2,7,8);
        //Turn turn = new Turn(7,8,player1,4,6);
      //  TurnDAO turnDAO = new TurnDAO();

       //turnDAO.create(turn1);
       //turnDAO.create(turn2);
       //turnDAO.create(turn3);
      // turnDAO.create(turn4);
       // turnDAO.find2(7,8);
        //System.out.println(turnDAO.find2(7,8));

        ///utilise l'objet turn dao


    }
}
