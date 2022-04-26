package GestionUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits implements ActionListener {

    JFrame frame = new JFrame();
    JLabel presentation = new JLabel(" Game has been made by thotho, rere , dodo et thithi");
    JLabel equipe = new JLabel(" Notre graphiste international Rere le meilleur, le Gestionnaire de la base de données internationale ThoTHo ");
    JLabel dodo = new JLabel("L'homme qui a fait le moins mais qu'on aime quand meme DOdDO");
    JLabel titi = new JLabel("Et le dernier le Thithi celui qui a tout fait");

    JButton buttonBack = new JButton("Back");

    Credits() {

        //phrase
        presentation.setBounds(250,-50,500,300);
        frame.add(presentation);

        //text
        dodo.setBounds(150,110,700,400);

        frame.add(dodo);
        equipe.setBounds(150,50,700,400);

        frame.add(equipe);
        titi.setBounds(150,160,700,400);
        frame.add(titi);



        //button
        buttonBack.setBounds(300,400,200,40);
        buttonBack.setFocusable(false);
        buttonBack.addActionListener(this);
        frame.add(buttonBack);

        //tout
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonBack) {
            //if connection possible
            ShowMenu shomenu = new ShowMenu();
            frame.dispose();
        }
    }
}