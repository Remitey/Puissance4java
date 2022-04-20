package Game;

import java.util.Observable;

public class DataGameBox extends Observable {
    private boolean isUsed;
    private int player;

    DataGameBox(boolean bool){
        isUsed = bool;
        player = 0;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void update(Object arg){
        setChanged();
        notifyObservers(arg);
    }

    public boolean check(int player){
        return isUsed && this.player == player;
    }
}
