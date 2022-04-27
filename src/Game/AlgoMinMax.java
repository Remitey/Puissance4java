package Game;

import Util.Pair;

import java.util.*;

public class AlgoMinMax {
    private final int rows;
    private final int col;
    private int player;

    public AlgoMinMax(int rows, int col) {
        this.rows = rows;
        this.col = col;
    }

    public Pair<Integer> algoMinMAx(int depth, Map<Pair<Integer>, DataGameBox> grid, int player){
        this.player = player;
        //Random rand = new Random();
        int column = 0;// = rand.nextInt(col);
        int currentChanceToWin;
        int chanceToWin = 0;

        for (int i = 0; i < col; i++) {
            if (!grid.get(new Pair<>(0, i)).isUsed()){
                Map<Pair<Integer>, DataGameBox> copieGrid = copie(grid);
                copieGrid = play(copieGrid, i, player);
                currentChanceToWin = algo(depth, copieGrid, player);
                if (currentChanceToWin > chanceToWin){
                    chanceToWin = currentChanceToWin;
                    column = i;
                }
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

    /*public int algo(int depth, int value, Map<Pair<Integer>, DataGameBox> grid, int player){
        if(depth <= 0 || !grid.containsValue(new DataGameBox(false))){
            return heuristic(grid, player);
        }
        for (int i = 0; i < col; i++) {
            if (!grid.get(new Pair<>(0, i)).isUsed()){ // check if the column is not full

                Map<Pair<Integer>, DataGameBox> copieGrid = copie(grid);
                copieGrid = play(copieGrid, i, player);
                int buffer;

                if(player == this.player){
                    buffer = 1000;
                    value = Math.max(buffer, algo(depth--, value, copieGrid, otherPlayer(player)));
                }
                else{
                    buffer = -1000;
                    value = Math.min(value, algo(depth--, value, copieGrid, otherPlayer(player)));
                }

                if (buffer > value){
                    value = buffer;
                }
            }
        }
        return value;
    }*/
    public int algo(int depth, Map<Pair<Integer>, DataGameBox> grid, int player){
        if(depth <= 0 || !grid.containsValue(new DataGameBox(false))){
            return heuristic(grid, player);
        }
        List<Integer> list = new ArrayList<>(col);
        for (int i = 0; i < col; i++) {
            if (!grid.get(new Pair<>(0, i)).isUsed()){ // check if the column is not full
                Map<Pair<Integer>, DataGameBox> copieGrid = copie(grid);
                copieGrid = play(copieGrid, i, player);

                list.add(algo(depth--, copieGrid, otherPlayer(player)));
            }
        }

        if(player == this.player){
            return Collections.max(list);
        }
        else{
            return Collections.min(list);
        }
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
        return value;
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
            return 0;
        }
        if (count == 3){
            return 25 * count;
        }
        if (count >= 4){
            return 250 * count;
        }
        return count;
    }

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
