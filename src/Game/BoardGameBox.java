package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BoardGameBox extends JPanel implements MouseListener {

    private final Map<Pair<Integer>, DataGameBox> tab;
    public Color base = null;

    public BoardGameBox(Map<Pair<Integer>, DataGameBox> tab){
        this.tab = tab;
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        if (base == null){
            base = Color.white;
            g.setColor(base);
            if(getSize().height > getSize().width){
                g.fillOval(5,5, getSize().width - 10, getSize().width - 10);
            }else{
                g.fillOval(5,5, getSize().height - 10, getSize().height - 10);
            }
        }else{
            g.setColor(base);
            if(getSize().height > getSize().width){
                g.fillOval(4,4, getSize().width - 5, getSize().width - 5);
            }else{
                g.fillOval(4,4, getSize().height - 5, getSize().height - 5);
            }
        }

    }

    public void verifyAndDraw(int x, int y, boolean isIA){
        if (!tab.get(new Pair<>(y+1, x)).isUsed() || tab.get(new Pair<>(y, x)).isUsed()){
            System.out.println("ca pose pas");
        }else{
            Pair<Integer> location = new Pair<>(y, x);

            System.out.println("ca pose");

            tab.get(location).setUsed(true);

            if(!isIA){
                tab.get(location).update(location);
            }

            if(tab.get(location).getPlayer() == 0){
                base = Color.red;
            }else {
                base = Color.yellow;
            }

            paintComponent(getGraphics());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        int x = (int) getLocation().getX() / getWidth();
        int y = (int) getLocation().getY() / getHeight();

        verifyAndDraw(x, y, false);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
