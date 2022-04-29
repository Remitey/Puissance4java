package GestionUtilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShowMenu implements ActionListener{


        JFrame frame = new JFrame();
    Icon playImage = new ImageIcon("..\\Puissance4java\\src\\image\\playBouton.png");
    Icon dataImage = new ImageIcon("..\\Puissance4java\\src\\image\\dataBouton.png");
    Icon creditsImage = new ImageIcon("..\\Puissance4java\\src\\image\\creditsBouton.png");

    JButton play = new JButton(playImage);
        JButton data = new JButton(dataImage);
        JButton credits = new JButton(creditsImage);
        JPanel panel = new JPanel();
        JLabel welcome = new JLabel("Welcome" ); //+ username


        public ShowMenu(){

           // this.setLayout(new FlowLayout());

            try {
                BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background4.jpg"));
                frame.setContentPane(new BackGround(background));
            } catch (IOException e) {
                e.printStackTrace();
            }
            welcome.setBounds(325,-50,200,200);
            welcome.setFont(new Font(null, Font.BOLD,20));
            welcome.setForeground(new Color(162,170,214));
            frame.add(welcome);

            play.setBounds(270, 100, 200, 75);
            play.setContentAreaFilled(false);
            data.setBounds(270,200,200,75);
            data.setContentAreaFilled(false);
            credits.setBounds(270,300,200,75);
            credits.setContentAreaFilled(false);

            frame.add(credits);
            frame.add(data);
            frame.add(play);

            play.addActionListener(this);
            data.addActionListener(this);
            credits.addActionListener(this);

            play.setFocusable(false);

            frame.setSize(800,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
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

