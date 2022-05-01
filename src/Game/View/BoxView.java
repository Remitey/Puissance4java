package Game.View;

import Game.Model.BoxModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoxView extends JPanel implements MouseListener {
    public Color base = null;
    private final BoxModel boxModel;
    public BoxView(BoxModel boxModel){
        this.boxModel = boxModel;
        addMouseListener(this);
    }
    public BoxModel getBoxModel(){
        return boxModel;
    }
    @Override
    public void paintComponent(Graphics g){
        if (base == null){
            base = new Color(162,170,214);
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
        int y = (int) getLocation().getX() / getWidth();
        int x = (int) getLocation().getY() / getHeight();

        if(boxModel.checkPosition(x, y)){
            if(boxModel.getPlayer() == 0){
                base = new Color(236,55,131);
            }else {
                base = new Color(116,242,147);
            }
            paintComponent(getGraphics());
        }
        boxModel.update(x, y);
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
