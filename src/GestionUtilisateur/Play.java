package GestionUtilisateur;

import Game.BoardGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Play implements ActionListener {



    JFrame frame = new JFrame();
    JButton oneplayer = new JButton(" One player ");
    JButton multipayer = new JButton(" Multiplayer");
    JButton back = new JButton(" Back");
    JPanel panel = new JPanel();


    public Play() {

        oneplayer.setBounds(400, 150, 200, 75);
        multipayer.setBounds(150, 150, 200, 75);
        back.setBounds(320, 350, 100, 37); //https://www.javatpoint.com/java-jbutton

        panel.add(back);
        panel.add(multipayer);
        panel.add(oneplayer);


        oneplayer.addActionListener(this);
        multipayer.addActionListener(this);
        back.addActionListener(this);

        oneplayer.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == oneplayer) {
            frame.dispose();
           new Oneplayer();
        }
        if (e.getSource() == multipayer) {
            frame.dispose();
            new Multiplayer();
            // Oneplayer oneplayer = new Oneplayer();
        }
        if (e.getSource() == back) {
            frame.dispose();
            ShowMenu shomenu = new ShowMenu();
        }
    }
}

