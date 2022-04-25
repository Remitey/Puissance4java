package GestionUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowMenu implements ActionListener{


        JFrame frame = new JFrame();
        JButton play = new JButton(" Play");
        JButton data = new JButton(" Data");
        JButton credits = new JButton(" Credits");
        JPanel panel = new JPanel();
        JLabel welcome = new JLabel("Welcome" ); //+ username


        public ShowMenu(){

           // this.setLayout(new FlowLayout());


            welcome.setBounds(300,-50,200,200);
            welcome.setFont(new Font(null, Font.PLAIN,15));
            frame.add(welcome);

            play.setBounds(270, 100, 200, 75);
            data.setBounds(270,200,200,75);
            credits.setBounds(270,300,200,75);

            panel.add(credits);
            panel.add(data);
            panel.add(play);

            play.addActionListener(this);
            data.addActionListener(this);
            credits.addActionListener(this);

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
            if (e.getSource()== data) {
                frame.dispose();
               // Data data = new Data();

            }
            if (e.getSource()== credits) {
                frame.dispose();
                Credits credits = new Credits();
            }
        }
    }

