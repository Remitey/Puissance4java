package GestionUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Play extends Frame implements ActionListener {


    JFrame frame = new JFrame();
    JButton multiplayer = new JButton(" Multiplayer");
    JButton oneplayer = new JButton(" One player");
    JButton back = new JButton(" Back");

    JPanel panel = new JPanel();

    Play() {


        this.setLayout(new FlowLayout());


        multiplayer.setBounds(400, 150, 200, 75);
        oneplayer.setBounds(150, 150, 200, 75);
        back.setBounds(320, 350, 100, 37); //https://www.javatpoint.com/java-jbutton

        panel.add(back);
        panel.add(oneplayer);
        panel.add(multiplayer);

        multiplayer.addActionListener(this);
        oneplayer.addActionListener(this);
        back.addActionListener(this);

        multiplayer.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == multiplayer) {
            frame.dispose();
            Multiplayer multiplayer = new Multiplayer();
        }
        if (e.getSource() == oneplayer) {
            frame.dispose();
            // Oneplayer oneplayer = new Oneplayer();
        }
        if (e.getSource() == back) {
            frame.dispose();
            ShowMenu shomenu = new ShowMenu();
        }
    }
}

