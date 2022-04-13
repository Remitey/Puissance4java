import javax.swing.*;
import java.awt.*;

public class Border extends JFrame{
    public Border(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new Grid(), "Center");
        add(new Data(), "East");

        this.setSize(600, 600);
        this.setVisible(true);
    }
}
