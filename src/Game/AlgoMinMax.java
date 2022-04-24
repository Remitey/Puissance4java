package Game;

import Util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

public class AlgoMinMax {
    private final int rows;
    private final int col;
    //private int playValue;
    //private int playCurrentValue;

    public AlgoMinMax(int rows, int col) {
        this.rows = rows;
        this.col = col;
    }

    public Pair<Integer> algoMinMAx(int depth, Map<Pair<Integer>, DataGameBox> grid, int player){
        Map<Pair<Integer>, DataGameBox> copieGrid = copie(grid);
        Random rand = new Random();
        int column = rand.nextInt(col);
        int currentChanceToWin = 0;
        int chanceToWin = 0;
        for (int i = 0; i < col; i++) {
            currentChanceToWin = algo(depth, chanceToWin, copieGrid, player);
            if (currentChanceToWin < chanceToWin){
                currentChanceToWin = chanceToWin;
                column = i;
            }
        }
        return new Pair<>(getLine(grid, column), column);
    }

    public int getLine(Map<Pair<Integer>, DataGameBox> grid, int col){
        int j = rows;
        while (grid.get(new Pair<>(j, col)).isUsed()) { //check the line to play
            j--;
        }
        return j;
    }

    public int algo(int depth, int value, Map<Pair<Integer>, DataGameBox> grid, int player){
        if(depth <= 0 || !grid.containsValue(new DataGameBox(false))){
            return heuristic(grid, player);
        }
        for (int i = 0; i < col; i++) {
            if (!grid.get(new Pair<>(0, i)).isUsed()){ // check if the column is not full

                Map<Pair<Integer>, DataGameBox> copieGrid = copie(grid);
                copieGrid = play(copieGrid, i, player);
                int buffer = algo(depth--, value, copieGrid, otherPlayer(player));

                if (buffer > value){
                    value = buffer;
                }
            }
        }
        return value;
    }

    public int heuristic(Map<Pair<Integer>, DataGameBox> grid, int player){
        return countAlignToken(grid, player);
    }

    public int countAlignToken(Map<Pair<Integer>, DataGameBox> grid, int player){
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                value += findCountAlignToken(grid, new Pair<>(i, j), 1, 0, player);
                value += findCountAlignToken(grid, new Pair<>(i, j), 0, 1, player);
                value += findCountAlignToken(grid, new Pair<>(i, j), 1, 1, player);
                value += findCountAlignToken(grid, new Pair<>(i, j), -1, -1, player);
            }
        }
        return 0;
    }

    public int findCountAlignToken(Map<Pair<Integer>, DataGameBox> grid, Pair<Integer> pair, int lineAlignment, int colAlignment, int player){
        int count = 1;
        int i = pair.getFirst();
        int j = pair.getSecond();
        while (grid.containsKey(new Pair<>(i + lineAlignment, j + colAlignment)) && grid.get(new Pair<>(i + lineAlignment, j + colAlignment)).getPlayer() == player){
            i += lineAlignment;
            j += colAlignment;
            count ++;
        }
        if (count == 2){
            return count;
        }
        if (count == 3){
            return 3 * count;
        }
        if (count == 4){
            return 9 * count;
        }
        return count;
    }

    /*public int algoMinMAx(Map<Pair<Integer>, DataGameBox> tab, int depth, int player) {
        if (depth <= 0) {
            return playColumn;
        }
        for (int i = 0; i < col; i++) {
            if (!tab.get(new Pair<>(0, i)).isUsed()) {

                //Map<Pair, DataGameBox> copieTab = copie(play(tab, i));
                if (player == 0) {
                    playValue = Integer.MAX_VALUE;
                } else {
                    playValue = Integer.MIN_VALUE;
                }

               // playCurrentValue = Math.min(playValue, algoMinMAx(copieTab, depth - 1, otherPlayer(player)));

                if(playCurrentValue >= playValue){
                    playValue = playCurrentValue;
                    playColumn = i;
                }
            }
        }
        return 0;
    }
*/


    public int otherPlayer(int player) {
        if (player == 0) {
            return 1;
        }
        return 0;
    }

    public Map<Pair<Integer>, DataGameBox> play(Map<Pair<Integer>, DataGameBox> tab, int i, int player) {
        Map<Pair<Integer>, DataGameBox> copieTab = copie(tab);

        int j = rows - 1;
        while (copieTab.get(new Pair<>(j, i)).isUsed()) { //check the line to play
            j--;
        }

        copieTab.replace(new Pair<>(j, i), new DataGameBox(true, player));
        return copieTab;
    }

    public Map<Pair<Integer>, DataGameBox> copie(Map<Pair<Integer>, DataGameBox> tab) {
        Map<Pair<Integer>, DataGameBox> copie = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                Pair<Integer> pair = new Pair<>(i, j);
                DataGameBox dataGameBox = new DataGameBox(tab.get(pair).isUsed());
                dataGameBox.setPlayer(tab.get(pair).getPlayer());
                copie.put(pair, dataGameBox);
            }
        }
        return copie;
    }
}
