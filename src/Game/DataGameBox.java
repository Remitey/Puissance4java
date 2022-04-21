package Game;

import java.util.Objects;
import java.util.Observable;

public class DataGameBox extends Observable {
    private boolean isUsed;
    private int player;

    DataGameBox(boolean bool){
        isUsed = bool;
        player = 0;
    }

    DataGameBox(boolean bool, int player){
        isUsed = bool;
        this.player = player;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataGameBox that = (DataGameBox) o;
        return isUsed == that.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isUsed, player);
    }
}
