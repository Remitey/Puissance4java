package Game.View;

import javax.swing.*;
import java.awt.*;

import static Game.Model.DataGrid.*;
public class GridView extends JPanel{
    public GridView() {
        new JPanel();

        setLayout(new GridLayout(rows, col));
        setBackground(Color.blue);

        setVisible(true);
    }
}
