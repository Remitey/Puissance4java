package GestionUtilisateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BorderLayout implements ActionListener {

    public Color colorText =new Color(162,170,214);
    JFrame frame = new JFrame();
    Icon connectionImage = new ImageIcon("..\\Puissance4java\\src\\image\\connexionBouton.png");
    Icon createImage = new ImageIcon("..\\Puissance4java\\src\\image\\createBouton.png");
    JButton connexion = new JButton(connectionImage);
    JButton createaccount = new JButton(createImage);
    //regles?

    JLabel hello = new JLabel("Welcome to the game");
    JPanel panel = new JPanel();


    BorderLayout() {

        // final JTextField text = new JTextField();

        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background10.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        hello.setBounds(270, -50, 600, 300);
        hello.setFont(new Font("Arial",Font.BOLD,20));
        hello.setForeground(colorText);
        frame.add(hello);
        connexion.setContentAreaFilled(false);
        createaccount.setContentAreaFilled(false);

        connexion.setBounds(270, 150, 200, 75);
        createaccount.setBounds(270, 250, 200, 75);//https://www.javatpoint.com/java-jbutton


        frame.add(createaccount);
        frame.add(connexion);

        connexion.addActionListener(this);
        createaccount.addActionListener(this);


        connexion.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connexion) {
            frame.dispose();
            Connection connection = new Connection();
        }
        if (e.getSource() == createaccount) {
            frame.dispose();
            CreateAccount createAccount = new CreateAccount();
        }
    }
}
