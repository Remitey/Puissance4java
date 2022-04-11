import javax.swing.*;
import java.awt.*;

public class BoxGrid extends JPanel{
    private JFrame frame = new JFrame();
    private Graphics graphics;
    public BoxGrid(){
        frame.setVisible(true);
        frame.setSize(200,200);
        //frame.add(new BoxGridGraphics());
        frame.pack();
        frame.getContentPane().setBackground(Color.red);
    }
}
