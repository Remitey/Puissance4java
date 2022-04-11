import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid {

    public Grid() {
        JFrame grid = new JFrame();
        grid.setUndecorated(true);
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int rows = 5;
        int col = 5;
        Dimension dFrame = new Dimension(rows * 100, col * 100);
        Dimension dBox = new Dimension(100, 100);
        grid.setLayout(new GridLayout(rows, col));
        grid.setSize(dFrame);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                grid.add(new BoxGridGraphics(dBox));
            }
        }

        grid.setVisible(true);
    }
}
