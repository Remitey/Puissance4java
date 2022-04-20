package Game;

import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BoardGameBox extends Observable implements MouseListener{
    private final Dimension dim;
    private Map<Pair, Boolean> tab;
    private JPanel jPanel = new JPanel(true){
        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            if(jPanel.getSize().height > jPanel.getSize().width){
                g.fillOval(5,5, jPanel.getSize().width - 10, jPanel.getSize().width - 10);
            }else{
                g.fillOval(5,5, jPanel.getSize().height - 10, jPanel.getSize().height - 10);
            }
        }
    };

    public BoardGameBox(Dimension dim, Map<Pair, Boolean> tab){
        this.dim = dim;
        this.tab = tab;

        jPanel.addMouseListener(this);
    }

    public void drawCircle(Graphics g, Color color){

        jPanel.getGraphics().setColor(color);
        if(dim.height > dim.width){
            jPanel.getGraphics().fillOval(4,4, dim.width + 5, dim.width + 5);
        }else{
            jPanel.getGraphics().fillOval(4,4, dim.height - 10, dim.height - 10);
        }
    }

    public JPanel getjPanel(){
        return jPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        int x = (int) jPanel.getLocation().getX() / jPanel.getWidth();
        int y = (int) jPanel.getLocation().getY() / jPanel.getHeight();

        if (!tab.get(new Pair(y+1, x))){
            System.out.println("ca pose pas");
        }else{
            Pair location = new Pair(y, x);

            System.out.println("ca pose");
            tab.replace(location, true);

            drawCircle(jPanel.getGraphics(), new Color(0,0,255,0));

            setChanged();
            notifyObservers();
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
