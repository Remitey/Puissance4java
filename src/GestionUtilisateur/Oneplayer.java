package GestionUtilisateur;

import Database.Table.Player;

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

    JLabel sizeRaws = new JLabel("Choose size raws : ");
    JLabel sizeCols = new JLabel("Choose size columns : ");
    private final Player player;

    JPanel panel = new JPanel();

    Oneplayer(Player player) {
        this.player = player;
        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background7.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // String[] list = {"--Select Difficulty--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] list = {"--Select Difficulty--", "Easy", "Hard"};
        JComboBox cbg = new JComboBox<>(list);
        String[] listraw = {"4", "5", "6", "7", "8", "9", "10", "11"};
        JComboBox cbgraw = new JComboBox<>(listraw);
        String[] listcol = {"4", "5", "6", "7", "8", "9", "10", "11"};
        JComboBox cbg2 = new JComboBox<>(listcol);

        difficulty.setFont(new Font(null, Font.PLAIN, 15));


        sentence.setBounds(270, 60, 100, 100);
        sentence.setForeground(colorText);
        difficulty.setBounds(150, 70, 100, 100);
        difficulty.setForeground(colorText);
        game.setBounds(270, 300, 200, 75);
        game.setContentAreaFilled(false);
        back.setBounds(320, 400, 100, 37); //https://www.javatpoint.com/java-jbutton
        back.setContentAreaFilled(false);

        sizeCols.setBounds(90, 208, 200, 100);
        sizeCols.setForeground(colorText);
        sizeRaws.setBounds(110, 153, 200, 100);
        sizeRaws.setForeground(colorText);

        cbg.setBounds(270, 105, 200, 30);
        cbgraw.setBounds(270, 185, 200, 30);
        cbg2.setBounds(270, 240, 200, 30);


        frame.add(sentence);
        frame.add(back);
        frame.add(game);
        frame.add(difficulty);
        frame.add(cbg);
        frame.add(sizeRaws);
        frame.add(sizeCols);
        frame.add(cbgraw);
        frame.add(cbg2);

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
            Play play = new Play(player);
        }
    }
}