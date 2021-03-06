package GestionUtilisateur.AccountPlayer1;


import Database.DAOmodel.PlayerDAO;
import Database.Table.Player;
import GestionUtilisateur.UserManagement.BackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Connection implements ActionListener {

    private final Player player;

    public Color colorText = new Color(162, 170, 214);
    public Font fontText = new Font(null, Font.PLAIN, 17);
    JFrame frame = new JFrame();
    JLabel connect = new JLabel(" please enter your username and password");
    JLabel username = new JLabel("Username : ");
    JLabel password = new JLabel("Password : ");
    JLabel error = new JLabel("Username or password incorect please try again");
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    Icon connectionImage = new ImageIcon("..\\Puissance4java\\src\\image\\connexionBoutonAccount.png");
    JButton buttonconnection = new JButton(connectionImage);
    JPanel jPanel= new JPanel();

    public Connection(Player player) {
        this.player = player;

        //phrase
        connect.setBounds(250, -50, 500, 300);
        connect.setForeground(colorText);
        frame.add(connect);

        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background10.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ecriture
        user.setBounds(300, 200, 200, 30);
        frame.add(user);
        pass.setBounds(300, 300, 200, 30);
        frame.add(pass);

        //text
        password.setBounds(150, 260, 100, 100);
        password.setFont(fontText);
        password.setForeground(colorText);
        frame.add(password);
        username.setBounds(150, 115, 200, 200);
        username.setFont(fontText);
        username.setForeground(colorText);
        frame.add(username);
        error.setBounds(150, 115, 200, 200);
        error.setFont(fontText);
        error.setForeground(colorText);


        //button
        buttonconnection.setBounds(300, 400, 200, 40);
        buttonconnection.setContentAreaFilled(false);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);

        //tout
        frame.setSize(800, 500);
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
        System.out.println(user.getText());
        System.out.println(String.valueOf(pass.getPassword()));
        if (e.getSource() == buttonconnection) {


                PlayerDAO playerDAO = new PlayerDAO();
                Player player = playerDAO.findPlayer(userName,password);

                if (player == null) {
                    JOptionPane.showMessageDialog(jPanel, "Wrong Username & Password");
                } else {
                    new ShowMenu(player);
                    frame.dispose();

                    //if (playerDAO==admin)
                    // new MenuAdmin();
                    //      frame.dispose();
                    //else : showmenu

                }



        }

        //if connection possible

        //else
        //frame.add(error);

    }
}

