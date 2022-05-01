package Game.View;

import GestionUtilisateur.BackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PlayerView extends JPanel implements Observer {

    Color colorText =new Color(162, 170, 214);
    Font fontText1 =new Font(null, Font.BOLD,17);
    Font fontText2 =new Font(null, Font.PLAIN,15);

    public PlayerView() {

        setBackground(new Color(0,9,55));

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);

        setLayout(boxLayout);
        JLabel labelTextNamePlayer1 = new JLabel("Premier Joueur :");
        labelTextNamePlayer1.setFont(fontText1);
        labelTextNamePlayer1.setForeground(colorText);
        add(labelTextNamePlayer1);
        JLabel labelNamePlayer1 = new JLabel("Nom Joueur 1 " , JLabel.CENTER);
        labelNamePlayer1.setFont(fontText2);
        labelNamePlayer1.setForeground(colorText);
        add(labelNamePlayer1);
        JLabel labelTextNamePlayer2 = new JLabel("Deuxième Joueur :", JLabel.CENTER);
        labelTextNamePlayer2.setFont(fontText1);
        labelTextNamePlayer2.setForeground(colorText);
        add(labelTextNamePlayer2);
        JLabel labelNamePlayer2 = new JLabel("Nom Joueur 2", JLabel.CENTER);
        labelNamePlayer2.setFont(fontText2);
        labelNamePlayer2.setForeground(colorText);
        add(labelNamePlayer2);



        setSize(200, 500);

        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Window window = SwingUtilities.windowForComponent(this);


        //JOptionPane.showMessageDialog(window, "c'est au tour de " + arg.toString());
    }
}
