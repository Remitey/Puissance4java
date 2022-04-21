package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BoardGameBox extends JPanel implements MouseListener{

    private final Dimension dim;
    private final Map<Pair, DataGameBox> tab;
    public Color base = null;

    public BoardGameBox(Dimension dim, Map<Pair, DataGameBox> tab){
        this.dim = dim;
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

    @Override
    public void mouseClicked(MouseEvent e){
        int x = (int) getLocation().getX() / getWidth();
        int y = (int) getLocation().getY() / getHeight();

        if (!tab.get(new Pair(y+1, x)).isUsed() || tab.get(new Pair(y, x)).isUsed()){
            System.out.println("ca pose pas");
        }else{
            Pair location = new Pair(y, x);

            System.out.println("ca pose");
            tab.get(location).setUsed(true);

            tab.get(location).update(location);

            if(tab.get(location).getPlayer() == 0){
                base = Color.red;
            }else {
                base = Color.yellow;
            }

            paintComponent(getGraphics());

            //drawCircle(Color.blue, tab.get(location).getPlayer());
        }
    }

    public void drawCircle(Color color, int player){
        getGraphics().setColor(color);
        if(dim.height > dim.width){
            getGraphics().fillOval(4,4, dim.width + 5, dim.width + 5);
        }else{

            getGraphics().fillOval(4,4, dim.height - 10, dim.height - 10);
        }
        String str = String.valueOf(player);
        getGraphics().drawString(str, 10, 10);
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
