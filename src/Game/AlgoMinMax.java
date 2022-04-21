package Game;

import Util.Pair;

import java.util.HashMap;
import java.util.Map;

public class AlgoMinMax {
    private final int rows;
    private final int col;
    private final Map<Pair, DataGameBox> tab;
    private boolean player;

    public AlgoMinMax(int rows, int col, Map<Pair, DataGameBox> tab, boolean player) {
        this.rows = rows;
        this.col = col;
        this.tab = tab;
        this.player = player;
    }

    public int AlgoMinMAx(){
        for (int i = 0; i < col; i++) {
            if(!tab.get(new Pair(0,i)).isUsed()){
                Map<Pair, DataGameBox> Copietab = copie(tab);

            }
        }
        return 0;
    }

    public Map<Pair, DataGameBox> copie(Map<Pair, DataGameBox> tab){
        Map<Pair, DataGameBox> copie = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                Pair pair = new Pair(i,j);
                DataGameBox dataGameBox = new DataGameBox(tab.get(pair).isUsed());
                dataGameBox.setPlayer(tab.get(pair).getPlayer());
                copie.put(pair, dataGameBox);
            }
        }
        return copie;
    }
}
