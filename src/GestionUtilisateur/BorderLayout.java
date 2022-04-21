package GestionUtilisateur;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BorderLayout extends Frame implements ActionListener {

    JFrame frame = new JFrame();
    JButton button2 = new JButton(" Connection");
    JButton button3 = new JButton(" Create an account");
    JButton button4 = new JButton(" Credits");
    //regles?

    JLabel hello = new JLabel("Welcome to the game");
    JPanel panel = new JPanel();


    BorderLayout() {

        // final JTextField text = new JTextField();

        this.setLayout(new FlowLayout());

        hello.setBounds(270, -50, 500, 300);
        panel.add(hello);

        button2.setBounds(270, 150, 200, 75);
        button3.setBounds(270, 250, 200, 75);
        button4.setBounds(270, 350, 200, 75); //https://www.javatpoint.com/java-jbutton

        panel.add(button4);
        panel.add(button3);
        frame.add(button2);

        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        button2.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            frame.dispose();
            Connection connection = new Connection();
        }
        if (e.getSource() == button3) {
            frame.dispose();
            CreateAccount createAccount = new CreateAccount();
        }
    }
}
