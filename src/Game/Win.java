package Game;

import GestionUtilisateur.Credits;
import GestionUtilisateur.Play;
import GestionUtilisateur.ShowMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win implements ActionListener {
    JFrame frame = new JFrame();
    JButton play = new JButton(" Play again");
    JButton menu = new JButton(" Menu");
    JPanel panel = new JPanel();
    JLabel welcome = new JLabel("Player X has won the game" ); //+ username


   public Win(){

        welcome.setBounds(300,-50,200,200);
        welcome.setFont(new Font(null, Font.PLAIN,15));
        frame.add(welcome);

        play.setBounds(270, 100, 200, 75);
        menu.setBounds(270,200,200,75);

        panel.add(menu);
        panel.add(play);


        play.setFocusable(false);

        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== play){
            frame.dispose();
            Play play = new Play();
        }
        if (e.getSource()== menu) {
            ShowMenu showMenu = new ShowMenu();
            frame.dispose();
            // Data data = new Data();
        }
    }
}

