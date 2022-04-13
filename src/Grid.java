import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{

    public Grid(){
        int rows = 5;
        int col = 5;
        Dimension dFrame = new Dimension(rows * 100, col * 100);
        Dimension dBox = new Dimension(100, 100);
        setLayout(new GridLayout(rows, col));
        setSize(dFrame);
        setBackground(Color.blue);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                add(new BoxGridGraphics(dBox));
            }
        }

        setVisible(true);
    }
}
