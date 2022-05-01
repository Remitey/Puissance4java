package GestionUtilisateur.AccountPlayer2;

import Database.DAOmodel.PlayerDAO;
import Database.Table.Player;
import GestionUtilisateur.AccountPlayer2.WelcomePlayer2;
import GestionUtilisateur.UserManagement.BackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Multiplayer implements ActionListener {
    private final Player player;
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
    Icon connectionImage = new ImageIcon("..\\Puissance4java\\src\\image\\connexionBoutonAccount.png");
    Icon createImage = new ImageIcon("..\\Puissance4java\\src\\image\\createBoutonMultiplayer.png");
    JButton buttonconnection = new JButton(connectionImage);
    JButton createaccountguest = new JButton(createImage);
    JPanel jPanel= new JPanel();

    public Multiplayer(Player player) {

        this.player = player;
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
        buttonconnection.setContentAreaFilled(false);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);
        createaccountguest.setBounds(360,395,140,40);
        createaccountguest.setContentAreaFilled(false);
        createaccountguest.setFocusable(false);
        createaccountguest.addActionListener(this);
        frame.add(createaccountguest);

        //tout
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JPanel getPanel() {
        return jPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = user.getText();
        String password = String.valueOf(pass.getPassword());

        if(e.getSource()==buttonconnection) {

            PlayerDAO playerDAO = new PlayerDAO();
            Player newplayer = playerDAO.findPlayer(userName,password);

            if (newplayer == null) {
                JOptionPane.showMessageDialog(jPanel, "Wrong Username & Password");
            }
            if (Objects.equals(newplayer.getUsername(), player.getUsername())){
                JOptionPane.showMessageDialog(jPanel, "Player is already connected");
            }
            else {
                new WelcomePlayer2(player,newplayer);
                frame.dispose();


            }
            //if connection possible

            //else
            //frame.add(error);

        }
        if (e.getSource()==createaccountguest) {
            new CreateAccountMultiplayer(player);
            frame.dispose();
        }
    }
}
