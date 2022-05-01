package Game.Model;


import Database.Table.Player;

public class DataGrid {
    public static int rows;
    public static int col;
    public static String Nameplayer1;
    public static String Nameplayer2;
    public DataGrid(int rows, int col, Player player1, Player player2){
        DataGrid.rows = rows;
        DataGrid.col = col;
        DataGrid.Nameplayer1 = player1.getUsername();
        DataGrid.Nameplayer2 = player2.getUsername();
    }
}
