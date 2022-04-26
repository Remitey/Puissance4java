package GestionUtilisateur;

import Game.BoardGame;
import GestionUtilisateur.ShowMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Multiplayer implements ActionListener {

    JFrame frame = new JFrame();
    public Color colorText =new Color(162,170,214);
    public Font fontText= new Font(null, Font.PLAIN,17);
    JLabel connect = new JLabel(" PLayer 2/guest please enter your username and password");
    JLabel username = new JLabel("Username : ");
    JLabel password = new JLabel("Password : ");
    JLabel error = new JLabel("Username or password incorect please try again");
    JLabel guest = new JLabel("Guest doesn't have an account?");
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    Icon connectionImage = new ImageIcon("..\\Puissance4java\\src\\image\\connexionBoutonbis.png");
    Icon createImage = new ImageIcon("..\\Puissance4java\\src\\image\\createBoutonbis.png");
    JButton buttonconnection = new JButton(connectionImage);
    JButton createaccountguest = new JButton(createImage);

    Multiplayer() {


        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background6.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //phrase
        connect.setBounds(250,-50,500,300);
        connect.setForeground(colorText);
        password.setFont(new Font(null, Font.BOLD,20));
        frame.add(connect);

        //ecriture
        user.setBounds(300,200,200,30);
        frame.add(user);
        pass.setBounds(300,300,200,30);
        frame.add(pass);

        //text
        password.setBounds(150,260,100,100);
        password.setFont(fontText);
        password.setForeground(colorText);
        frame.add(password);
        username.setBounds(150,115,200,200);
        username.setFont(fontText);
        username.setForeground(colorText);
        frame.add(username);
        error.setBounds(150,115,200,200);
        error.setFont(fontText);
        error.setForeground(colorText);
        guest.setBounds(150,375,250,100);
        guest.setFont(new Font(null, Font.PLAIN,13));
        guest.setForeground(colorText);
        frame.add(guest);


        //button
        buttonconnection.setBounds(300,340,200,40);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);
        createaccountguest.setBounds(360,395,140,40);
        createaccountguest.setFocusable(false);
        createaccountguest.addActionListener(this);
        frame.add(createaccountguest);

        //tout
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonconnection) {
            //if connection possible
            new BoardGame();
            frame.dispose();
            //else
            //frame.add(error);

        }
        if (e.getSource()==createaccountguest) {
            new CreateAccountMultiplayer();
            frame.dispose();
        }
    }
}
