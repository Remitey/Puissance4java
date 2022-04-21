package Game;

import Util.Pair;

import java.util.HashMap;
import java.util.Map;

public class AlgoMinMax {
    private final int rows;
    private final int col;
    private final Map<Pair, DataGameBox> tab;
    private final int player;
    private int playColumn = 0;
    private int playValue;
    private int playCurrentValue;

    public AlgoMinMax(int rows, int col, Map<Pair, DataGameBox> tab, int player) {
        this.rows = rows;
        this.col = col;
        this.tab = copie(tab);
        this.player = player;
    }

    public int algoMinMAx(Map<Pair, DataGameBox> tab, int depth, int player) {
        if (depth <= 0) {
            return playColumn;
        }
        for (int i = 0; i < col; i++) {
            if (!tab.get(new Pair(0, i)).isUsed()) {

                Map<Pair, DataGameBox> copieTab = copie(play(tab, i));
                if (player == 0) {
                    playValue = Integer.MAX_VALUE;
                } else {
                    playValue = Integer.MIN_VALUE;
                }

                playCurrentValue = Math.min(playValue, algoMinMAx(copieTab, depth - 1, otherPlayer(player)));

                if(playCurrentValue >= playValue){
                    playValue = playCurrentValue;
                    playColumn = i;
                }
            }
        }
        return 0;
    }



    public int otherPlayer(int player) {
        if (player == 0) {
            return 1;
        }
        return 0;
    }

    public Map<Pair, DataGameBox> play(Map<Pair, DataGameBox> tab, int i) {
        Map<Pair, DataGameBox> copieTab = copie(tab);

        int j = rows - 1;
        while (copieTab.get(new Pair(i, j)).isUsed()) { //verify is the column is not full
            j--;
        }
        if (j - 1 > 0) { //place the first Token
            copieTab.replace(new Pair(i, j - 1), new DataGameBox(true, player));
        }
        return copieTab;
    }

    public Map<Pair, DataGameBox> copie(Map<Pair, DataGameBox> tab) {
        Map<Pair, DataGameBox> copie = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                Pair pair = new Pair(i, j);
                DataGameBox dataGameBox = new DataGameBox(tab.get(pair).isUsed());
                dataGameBox.setPlayer(tab.get(pair).getPlayer());
                copie.put(pair, dataGameBox);
            }
        }
        return copie;
    }
}
