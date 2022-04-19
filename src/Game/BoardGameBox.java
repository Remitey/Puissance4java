package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class BoardGameBox extends JPanel implements MouseListener {
    private final Dimension dim;
    private Map<Pair, Boolean> tab;

    public BoardGameBox(Dimension dim, Map<Pair, Boolean> tab){
        this.dim = dim;
        this.tab = tab;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        if(getSize().height > getSize().width){
            g.fillOval(5,5, getSize().width - 10, getSize().width - 10);
        }else{
            g.fillOval(5,5, getSize().height - 10, getSize().height - 10);
        }
    }

    public void drawCircle(Graphics g, Color color){

        this.getGraphics().setColor(color);
        if(dim.height > dim.width){
            this.getGraphics().fillOval(4,4, dim.width + 5, dim.width + 5);
        }else{
            this.getGraphics().fillOval(4,4, dim.height - 10, dim.height - 10);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        int x = (int) getLocation().getX() / getWidth();
        int y = (int) getLocation().getY() / getHeight();

        if (!tab.get(new Pair(y+1, x))){
            System.out.println("ca pose pas");
        }else{
            Pair location = new Pair(y, x);

            System.out.println("ca pose");
            tab.replace(location, true);

            drawCircle(getGraphics(), new Color(0,0,255,0));
        }
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
