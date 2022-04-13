package Game;

import javax.swing.*;
import java.awt.*;

public class DataPlayer extends JPanel {

    public DataPlayer(){
        JLabel label = new JLabel("test0");
        label.setVisible(true);
        label.setSize(100,100);
    }
    @Override
    protected void paintComponent(Graphics g) {

        JLabel label = new JLabel("test0");
        label.setVisible(true);
        label.setSize(100,100);
    }
}
