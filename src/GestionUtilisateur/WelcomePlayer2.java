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

public class WelcomePlayer2 implements ActionListener{


    Icon playImage = new ImageIcon("..\\Puissance4java\\src\\image\\playBouton.png");
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBouton.png");
    Icon disconnectImage = new ImageIcon("..\\Puissance4java\\src\\image\\disconnectBouton.png");

    JFrame frame = new JFrame();
    public Color colorText = new Color(162,170,214);
    JButton play = new JButton(playImage);
    JButton back = new JButton(backImage);
    JButton disconnect = new JButton(disconnectImage);
    JPanel panel = new JPanel();
    JLabel sizeRaws = new JLabel("Choose size raws : ");
    JLabel sizeCols = new JLabel("Choose size columns : ");
    //JLabel welcome = new JLabel("Welcome");
    //+ username


    private final Player player;

    public WelcomePlayer2(Player player){

        // this.setLayout(new FlowLayout());


        this.player = player;

        String[] list = {"4", "5", "6", "7", "8", "9", "10", "11"};
        JComboBox cbg1 = new JComboBox<>(list);
        String[] listcol = {"4", "5", "6", "7", "8", "9", "10", "11"};
        JComboBox cbg2 = new JComboBox<>(listcol);

        JLabel welcome = new JLabel("Welcome " );   //ici player 2
        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background4.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        welcome.setBounds(325,-50,200,200);
        welcome.setFont(new Font(null, Font.BOLD,20));
        welcome.setForeground(new Color(162,170,214));
        frame.add(welcome);

        play.setBounds(270, 100, 200, 75);
        play.setContentAreaFilled(false);

        sizeCols.setBounds(50, 165, 200, 100);
        sizeCols.setForeground(colorText);
        sizeRaws.setBounds(50, 200, 200, 100);
        sizeRaws.setForeground(colorText);

        cbg1.setBounds(270, 200, 100, 30);
        cbg2.setBounds(270, 240, 100, 30);

        back.setBounds(270,325,200,75);
        back.setContentAreaFilled(false);
        disconnect.setBounds(525,325,200,75);
        disconnect.setContentAreaFilled(false);


        frame.add(disconnect);
        frame.add(back);
        frame.add(play);
        frame.add(cbg1);
        frame.add(cbg2);
        frame.add(sizeCols);
        frame.add(sizeRaws);

        cbg1.addActionListener(this);
        cbg2.addActionListener(this);



        play.addActionListener(this);
        back.addActionListener(this);
        disconnect.addActionListener(this);

        play.setFocusable(false);

        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== play){
            frame.dispose();
            // new Game()
        }
        if (e.getSource()== back) {
            frame.dispose();
            new Multiplayer(player);
        }
        if (e.getSource()== disconnect) {
            frame.dispose();
            new BorderLayout(player);
        }
    }
}
