package Game;

import GestionUtilisateur.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Win implements ActionListener {
    JFrame frame = new JFrame();
    public Color colorText = new Color(162,170,214);
    Icon dataImage = new ImageIcon("..\\Puissance4java\\src\\image\\dataBouton.png");
    Icon menuImage = new ImageIcon("..\\Puissance4java\\src\\image\\menuBouton.png");

    JButton data = new JButton(dataImage);
    JButton menu = new JButton(menuImage);
    JPanel panel = new JPanel();
    JLabel welcome = new JLabel("Player X has won the game"); //+ username


    public Win() {

        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background7.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        welcome.setBounds(300, -50, 200, 200);
        welcome.setFont(new Font(null, Font.PLAIN, 15));
        welcome.setForeground(colorText);
        frame.add(welcome);

        data.setBounds(270, 100, 200, 75);
        menu.setBounds(270, 200, 200, 75);
        data.setContentAreaFilled(false);
        menu.setContentAreaFilled(false);

        frame.add(menu);
        frame.add(data);

        menu.addActionListener(this);
        data.addActionListener(this);
        data.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == data) {
            frame.dispose();
            //new Play();
        }
        if (e.getSource() == menu) {
            frame.dispose();
            //new ShowMenu();
            // Data data = new Data();
        }
    }
}

