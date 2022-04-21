package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class DataPlayer extends JPanel implements Observer {

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

    @Override
    public void update(Observable o, Object arg) {
        Window window = SwingUtilities.windowForComponent(this);
        JOptionPane.showMessageDialog(window, "c'est au tour de " + arg.toString());
    }
}
