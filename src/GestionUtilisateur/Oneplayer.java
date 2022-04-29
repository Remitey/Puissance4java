package GestionUtilisateur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Oneplayer implements ActionListener {

    public Color colorText = new Color(162,170,214);
    JFrame frame = new JFrame();
    Icon playImage = new ImageIcon("..\\Puissance4java\\src\\image\\playBouton.png");
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBouton.png");
    JButton game = new JButton(playImage);
    JButton back = new JButton(backImage);
    JLabel difficulty = new JLabel("Difficulty : ");
    JLabel sentence = new JLabel("Please choose :");


    JPanel panel = new JPanel();

    Oneplayer() {

        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background7.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] list = {"--Select Difficulty--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox cbg = new JComboBox<>(list);
        difficulty.setFont(new Font(null, Font.PLAIN, 15));

        sentence.setBounds(270, 120, 100, 100);
        sentence.setForeground(colorText);
        difficulty.setBounds(150, 165, 100, 100);
        difficulty.setForeground(colorText);
        game.setBounds(270, 300, 200, 75);
        game.setContentAreaFilled(false);
        back.setBounds(320, 400, 100, 37); //https://www.javatpoint.com/java-jbutton
        back.setContentAreaFilled(false);
        cbg.setBounds(270, 200, 200, 30);

        frame.add(sentence);
        frame.add(back);
        frame.add(game);
        frame.add(difficulty);
        frame.add(cbg);

        game.addActionListener(this);
        back.addActionListener(this);

        game.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == game) {
            frame.dispose();
            //Game game = new Game();
        }

        if (e.getSource() == back) {
            frame.dispose();
            Play play = new Play();
        }
    }
}