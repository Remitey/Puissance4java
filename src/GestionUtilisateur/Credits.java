package GestionUtilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Credits implements ActionListener {

    JFrame frame = new JFrame();
    public Color colorText = new Color(162,170,214);
    JLabel presentation = new JLabel(" Game has been made by thotho, rere , dodo et thithi");
    JLabel equipe = new JLabel(" Notre graphiste international Rere le meilleur, le Gestionnaire de la base de données internationale ThoTHhhhhhhhhhhhho ");
    JLabel dodo = new JLabel("L'homme qui a fait le moins mais qu'on aime quand meme DOdDO");
    JLabel titi = new JLabel("Et le dernier le Thithri celui qui a tout fait");
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBouton.png");
    JButton buttonBack = new JButton(backImage);

    Credits() {


        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background2.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //phrase
        presentation.setBounds(250,-50,500,300);
        presentation.setForeground(colorText);
        frame.add(presentation);

        //text
        dodo.setBounds(150,110,700,400);
        dodo.setForeground(colorText);

        frame.add(dodo);
        equipe.setBounds(150,50,700,400);
        equipe.setForeground(colorText);

        frame.add(equipe);
        titi.setBounds(150,160,700,400);
        titi.setForeground(colorText);
        frame.add(titi);



        //button
        buttonBack.setBounds(300,400,200,40);
        buttonBack.setContentAreaFilled(false);
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