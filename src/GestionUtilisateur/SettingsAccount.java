package GestionUtilisateur;

import Database.Table.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SettingsAccount implements ActionListener {

    public Color colorText =new Color(162,170,214);
    JFrame frame = new JFrame();

    JButton changePass = new JButton("Change Password");
    JButton back = new JButton("Back");
    //regles?

    JLabel hello = new JLabel("Welcome in Settings");
    JPanel panel = new JPanel();

    private final Player player;

    SettingsAccount(Player player) {


        this.player = player;
        // final JTextField text = new JTextField();




        hello.setBounds(270, -50, 600, 300);
        hello.setFont(new Font("Arial",Font.BOLD,20));
        hello.setForeground(colorText);
        frame.add(hello);
        changePass.setContentAreaFilled(false);
        back.setContentAreaFilled(false);

        changePass.setBounds(270, 150, 200, 75);
        back.setBounds(270, 250, 200, 75);//https://www.javatpoint.com/java-jbutton


        frame.add(changePass);
        frame.add(back);

        changePass.addActionListener(this);
        back.addActionListener(this);



        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePass) {
            new ChangePassword(player);
        }
        if (e.getSource() == back) {
            frame.dispose();
            new ShowMenu(player);
        }
    }
}
