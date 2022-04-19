package Game;

import javax.swing.*;
import java.awt.*;

public class DataPlayer extends JPanel {

    public DataPlayer(){
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        JLabel labelTextNamePlayer1 = new JLabel("Premier Joueur :");
        add(labelTextNamePlayer1);
        JLabel labelNamePlayer1 = new JLabel("Nom Joueur 1", JLabel.CENTER);
        add(labelNamePlayer1);
        JLabel labelTextNamePlayer2 = new JLabel("Deuxième Joueur :", JLabel.CENTER);
        add(labelTextNamePlayer2);
        JLabel labelNamePlayer2 = new JLabel("Nom Joueur 2", JLabel.CENTER);
        add(labelNamePlayer2);

        setSize(100, 500);
        setVisible(true);
    }
}
