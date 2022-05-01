package Game.Controller;

import Game.Model.BoxModel;
import Game.Model.DataGrid;
import Game.Model.Pair;
import Game.View.BoxView;
import Game.View.GridView;
import Game.Win;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameController extends Observable implements Observer {
    private int player;
    private boolean ia;
    private Map<Pair<Integer>, BoxModel> grid;
    private final AlgoMinMax algoMinMax;
    private final GridView gridView;
    public GameController(boolean ia, GridView gridView){
        this.ia = ia;
        this.gridView = gridView;

        algoMinMax = new AlgoMinMax(0);
        Random random = new Random();
        player = random.nextInt(2);
        createGrid();
    }
    private void createGrid(){
        grid = new HashMap<>();
        for (int i = 0; i < DataGrid.rows; i++) {
            for (int j = 0; j < DataGrid.col; j++) {
                BoxView box = new BoxView(new BoxModel(false, this));
                grid.put(new Pair<>(i, j), box.getBoxModel());
                grid.get(new Pair<>(i, j)).addObserver(this);
                gridView.add(box);
            }
        }
        for (int j = 0; j < DataGrid.col; j++) {
            grid.put(new Pair<>(DataGrid.rows, j), new BoxModel(true));
        }
    }
    public boolean isIa(){
        return ia;
    }
    public void changeCase(int x, int y){
        grid.get(new Pair<>(x, y)).setUsed(true);
        grid.get(new Pair<>(x, y)).setPlayer(player);
    }
    public GridView getGridView(){
        return gridView;
    }
    public boolean check(int i, int j, int player){
        return grid.get(new Pair<>(i, j)).isUsed() && grid.get(new Pair<>(i, j)).getPlayer() == player;
    }
    public Map<Pair<Integer>, BoxModel> getGrid(){
        return grid;
    }
    public boolean isUsed(int i, int j){
        return grid.get(new Pair<>(i, j)).isUsed();
    }
    public boolean verifyPosition(int x, int y, boolean isIA){
        if (!isUsed(x + 1, y) || isUsed(x, y)){
            System.out.println("ca pose pas");
            return false;
        }else{
            //Pair<Integer> location = new Pair<>(x, y);

            System.out.println("ca pose");

            /*grid.get(location).setUsed(true);

            if(!isIA){
                grid.get(location).update(location);
            }*/
            return true;
        }
    }
    public boolean winCondition(int player) {
        boolean isWin = false;
        for (int i = 0; i < DataGrid.rows; i++) { // line conditions
            for (int j = 0; j < DataGrid.col - 3; j++) {
                if (check(i ,j, player) && check(i, j + 1, player) && check(i, j + 2, player) && check(i, j + 3, player)) {
                    isWin = true;
                }
            }
        }

        for (int i = 0; i < DataGrid.rows - 3; i++) { // col conditions
            for (int j = 0; j < DataGrid.col; j++) {
                if (check(i ,j, player) && check(i + 1,j, player) && check(i + 2,j, player) && check(i + 3,j, player)) {
                    isWin = true;

                }
            }
        }

        for (int i = 0; i < DataGrid.rows - 3; i++) { // diagonale 1 conditions
            for (int j = 0; j < DataGrid.col - 3; j++) {
                if (check(i ,j, player) && check(i + 1,j + 1, player) && check(i + 2,j + 2, player) && check(i + 3,j + 3, player)) {
                    isWin = true;
                }
            }
        }
        for (int i = 3; i < DataGrid.rows; i++) { // diagonale 2 conditions
            for (int j = 0; j < DataGrid.col - 3; j++) {
                if (check(i ,j, player) && check(i - 1,j + 1, player) && check(i - 2,j + 2, player) && check(i - 3,j + 3, player)) {
                    isWin = true;
                }
            }
        }
        return isWin;
    }
    public boolean isFull() {
        BoxModel boxModel = new BoxModel(false);
        return !grid.containsValue(boxModel);
    }
    public void isEnd(){
        if (winCondition(player)) {
            SwingUtilities.getWindowAncestor(gridView).dispose();
            new Win();

            JOptionPane.showMessageDialog(gridView, "joueur " + player + " a win");
        }
        else if (isFull()){
            SwingUtilities.getWindowAncestor(gridView).dispose();
            new Win();

            JOptionPane.showMessageDialog(gridView, "full grid, no one win");
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Updating");

        isEnd();
        if (ia) {
            player = 0;
            setChanged();
            notifyObservers("IA");
            Pair<Integer> pair = algoMinMax.algoMinMAx(3, grid);
            System.out.println(pair);
            int number = DataGrid.col * pair.getFirst() + pair.getSecond();
            System.out.println(number);

            BoxView boxView = (BoxView) gridView.getComponent(number);

            grid.get(pair).setUsed(true);
            grid.get(pair).setPlayer(player);

            boxView.base = Color.red;
            boxView.paintComponent(boxView.getGraphics());
            System.out.println(boxView.base);

            player = 1;
        } else {
            if (player == 1) {
                player = 0;
            } else {
                player = 1;
            }
        }
        setChanged();
        notifyObservers(player);
    }
}
