package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardGameBox extends JPanel implements MouseListener {
    private Dimension dim;

    public BoardGameBox(Dimension dim){
        this.dim = dim;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawCircle(g, Color.white);

    }

    public void drawCircle(Graphics g, Color color){
        g.setColor(color);

        if(getSize().height > getSize().width){
            g.fillOval(5,5, getSize().width - 10, getSize().width - 10);
        }else{
            g.fillOval(5,5, getSize().height - 10, getSize().height - 10);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(dim.height > dim.width){
            getGraphics().fillOval(4,4, dim.width - 5, dim.width - 5);
        }else{
            getGraphics().fillOval(4,4, dim.height - 5, dim.height - 5);
        }    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
