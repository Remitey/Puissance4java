package Game.View;

import javax.swing.*;
import java.awt.*;

import static Game.Model.DataGrid.*;
public class GridView extends JPanel{
    public GridView() {
        new JPanel();

        setLayout(new GridLayout(rows, col));
        setBackground(new Color(0,9,55));

        setVisible(true);
    }
}
