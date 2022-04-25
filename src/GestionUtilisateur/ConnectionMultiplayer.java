package GestionUtilisateur;

import Game.BoardGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionMultiplayer implements ActionListener {

    JFrame frame = new JFrame();
    JLabel connect = new JLabel(" please enter your username and password");
    JLabel username = new JLabel("Username : ");
    JLabel password = new JLabel("Password : ");
    JLabel error = new JLabel("Username or password incorect please try again");
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton buttonconnection = new JButton("Connection");

    ConnectionMultiplayer() {

        //phrase
        connect.setBounds(250,-50,500,300);
        frame.add(connect);

        //ecriture
        user.setBounds(300,200,200,30);
        frame.add(user);
        pass.setBounds(300,300,200,30);
        frame.add(pass);

        //text
        password.setBounds(150,260,100,100);
        password.setFont(new Font(null, Font.PLAIN,17));
        frame.add(password);
        username.setBounds(150,115,200,200);
        username.setFont(new Font(null, Font.PLAIN,17));
        frame.add(username);
        error.setBounds(150,115,200,200);
        error.setFont(new Font(null, Font.PLAIN,17));


        //button
        buttonconnection.setBounds(300,400,200,40);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);

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
            frame.dispose();
            new BoardGame();
            //else
            //frame.add(error);

        }
    }
}