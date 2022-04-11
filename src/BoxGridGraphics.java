import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoxGridGraphics extends JPanel implements MouseListener {
    private Dimension dim;

    public BoxGridGraphics(Dimension dim){
        this.dim = dim;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,dim.width,dim.height);

        drawCircle(g, Color.white);
    }

    public void drawCircle(Graphics g, Color color){
        g.setColor(color);

        if(dim.height > dim.width){
            g.fillOval(5,5, dim.width - 5, dim.width - 5);
        }else{
            g.fillOval(5,5, dim.height - 5, dim.height - 5);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        drawCircle(getGraphics(), Color.blue);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
