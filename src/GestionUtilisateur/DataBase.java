package GestionUtilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DataBase implements ActionListener {

    JFrame frame = new JFrame();
    public Color colorText = new Color(162,170,214);
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBoutonAccount.png");
    JButton buttonBack = new JButton(backImage);

    DataBase() {


        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background2.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }



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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonBack) {
            //if connection possible
            new MenuAdmin();
            frame.dispose();
        }
    }
}