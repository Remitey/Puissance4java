package Game.Model;

import Game.Controller.GameController;

import java.util.Objects;
import java.util.Observable;

public class BoxModel extends Observable {
    private boolean isUsed;
    private String player;
    private GameController gameController;
    public BoxModel(boolean isUsed, GameController gameController){
        this.isUsed = isUsed;
        this.gameController = gameController;
    }
    public BoxModel(boolean isUsed){
        this.isUsed = isUsed;
    }
    public BoxModel(boolean isUsed, String player){
        this.isUsed = isUsed;
        this.player = player;
    }
    public boolean isUsed() {
        return isUsed;
    }
    public void setUsed(boolean used) {
        isUsed = used;
    }
    public String getPlayer() {
        return player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    public void update(int x, int y){
        setChanged();
        notifyObservers(new Pair<>(x, y));
    }
    public boolean checkPosition(int x, int y){
        if (gameController.verifyPosition(x, y)){
            gameController.changeCase(x, y);
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxModel that = (BoxModel) o;
        return isUsed == that.isUsed;
    }
    @Override
    public int hashCode() {
        return Objects.hash(isUsed, player);
    }
}
