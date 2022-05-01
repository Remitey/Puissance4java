package GestionUtilisateur;

import Database.Table.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Play implements ActionListener {


    private final Player player;
    JFrame frame = new JFrame();
    Icon oneplayerImage = new ImageIcon("..\\Puissance4java\\src\\image\\oneplayerBouton.png");
    Icon multiplayerImage = new ImageIcon("..\\Puissance4java\\src\\image\\multiplayerBouton.png");
    JButton oneplayer = new JButton(oneplayerImage);
    JButton multipayer = new JButton(multiplayerImage);
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBouton.png");
    JButton back = new JButton(backImage);
    JPanel panel = new JPanel();


    public Play(Player player) {

        this.player = player;
        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background5.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        oneplayer.setBounds(400, 150, 200, 75);
        oneplayer.setContentAreaFilled(false);
        multipayer.setBounds(150, 150, 200, 75);
        multipayer.setContentAreaFilled(false);
        back.setBounds(320, 350, 100, 37); //https://www.javatpoint.com/java-jbutton
        back.setContentAreaFilled(false);

        frame.add(back);
        frame.add(multipayer);
        frame.add(oneplayer);


        oneplayer.addActionListener(this);
        multipayer.addActionListener(this);
        back.addActionListener(this);

        oneplayer.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == oneplayer) {
            frame.dispose();
            new Oneplayer(player);
        }
        if (e.getSource() == multipayer) {
            frame.dispose();
            new Multiplayer(player);
            // Oneplayer oneplayer = new Oneplayer();
        }
        if (e.getSource() == back) {
            frame.dispose();
            ShowMenu shomenu = new ShowMenu(player);
        }
    }
}

