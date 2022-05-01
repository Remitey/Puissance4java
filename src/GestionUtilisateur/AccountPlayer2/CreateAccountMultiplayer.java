package GestionUtilisateur.AccountPlayer2;
import Database.DAOmodel.PlayerDAO;
import Database.Table.Player;
import GestionUtilisateur.AccountPlayer2.WelcomePlayer2;
import GestionUtilisateur.UserManagement.BackGround;
import GestionUtilisateur.AccountPlayer2.Multiplayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CreateAccountMultiplayer implements ActionListener {
    private final Player player;
    JFrame frame = new JFrame();
    public Color colorText = new Color(162,170,214);
    public Font fontText =new Font(null, Font.PLAIN,15);
    JLabel connect = new JLabel(" Please enter following information");
    JLabel firstname = new JLabel("First Name : ");
    JLabel lastname = new JLabel("Last Name : ");
    JLabel email = new JLabel("email adress : ");
    JLabel gender = new JLabel("gender : ");
    JLabel country = new JLabel("Country : ");
    JLabel username = new JLabel("Username : ");
    JLabel password = new JLabel("Password : ");
    JLabel confirmpassword = new JLabel("Confirm Password : ");

    JTextField emaill = new JTextField();
    JTextField firstt = new JTextField();
    JTextField lastt = new JTextField();
    JTextField usernamee = new JTextField();

    JLabel error = new JLabel("error in creating account please try again");

    JPasswordField pass = new JPasswordField();
    JPasswordField confpass = new JPasswordField();

    Icon connectionImage = new ImageIcon("..\\Puissance4java\\src\\image\\connexionBoutonAccount.png");
    Icon backImage = new ImageIcon("..\\Puissance4java\\src\\image\\backBoutonAccount.png");
    JButton buttonconnection = new JButton(connectionImage);
    JButton buttonconnectionback = new JButton(backImage);

    JPanel jPanel= new JPanel();

    CreateAccountMultiplayer(Player player) {
        this.player = player;


        try {
            BufferedImage background = ImageIO.read(new File("..\\Puissance4java\\src\\image\\background11bis.jpg"));
            frame.setContentPane(new BackGround(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] list = {"--Select gender--","Man", "Woman", "Nothing"};
        JComboBox cbg1 = new JComboBox<>(list);

        String[] list2 = {"--Select Country--","Francia", "USA", "Espagna", "Itali", "Russia", "Ukrania", "regardcommeilfaitbeau"};
        JComboBox cbg2 = new JComboBox<>(list2);

        //phrase
        connect.setBounds(250,-100,500,300);
        connect.setForeground(colorText);
        connect.setFont(new Font(null,Font.BOLD,20));
        frame.add(connect);

        //ecriture
        firstt.setBounds(300,90,200,30);
        frame.add(firstt);
        lastt.setBounds(300,140,200,30);
        frame.add(lastt);
        emaill.setBounds(300,190,200,30);
        frame.add(emaill);
        usernamee.setBounds(300,340,200,30);
        frame.add(usernamee);
        pass.setBounds(300,390,200,30);
        frame.add(pass);
        confpass.setBounds(300,440,200,30);
        frame.add(confpass);

        //text
        firstname.setBounds(150,50,100,100);
        firstname.setFont(fontText);
        firstname.setForeground(colorText);
        frame.add(firstname);
        lastname.setBounds(150,100,100,100);
        lastname.setFont(fontText);
        lastname.setForeground(colorText);
        frame.add(lastname);
        email.setBounds(150,150,100,100);
        email.setFont(fontText);
        email.setForeground(colorText);
        frame.add(email);
        gender.setBounds(150,200,100,100);
        gender.setFont(fontText);
        gender.setForeground(colorText);
        frame.add(gender);
        country.setBounds(150,250,100,100);
        country.setFont(fontText);
        country.setForeground(colorText);
        frame.add(country);
        username.setBounds(150,300,100,100);
        username.setFont(fontText);
        username.setForeground(colorText);
        frame.add(username);
        password.setBounds(150,350,100,100);
        password.setFont(fontText);
        password.setForeground(colorText);
        frame.add(password);
        confirmpassword.setBounds(150,400,100,100);
        confirmpassword.setFont(fontText);
        confirmpassword.setForeground(colorText);
        frame.add(confirmpassword);

        error.setBounds(150,400,100,100);
        error.setFont(fontText);



        //button
        buttonconnection.setBounds(300,500,200,40);
        buttonconnection.setContentAreaFilled(false);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);
        buttonconnectionback.setBounds(500,500,200,40);
        buttonconnectionback.setContentAreaFilled(false);
        buttonconnectionback.setFocusable(false);
        buttonconnectionback.addActionListener(this);
        frame.add(buttonconnectionback);

        cbg1.setBounds(300,240,200,40);
        frame.add(cbg1);
        cbg2.setBounds(300,290,200,40);
        frame.add(cbg2);


        //tout
        frame.setSize(900,600);
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
        String pasword = String.valueOf(pass.getPassword());
        String username = usernamee.getText();
        String recupemail = emaill.getText();

        if(e.getSource()==buttonconnection) {
            if (!Objects.equals(username, "") && !Objects.equals(recupemail, "") && !pasword.equals("")) {
                PlayerDAO playerDAO = new PlayerDAO();
                Player newplayer = new Player();
                newplayer = new Player(1,username,recupemail, pasword, 2);
                playerDAO.create(newplayer);
                new WelcomePlayer2(player,newplayer);
                frame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(jPanel, "Please enter Wrong Username & Password");
            }
        }
        if (e.getSource() == buttonconnectionback) {
            frame.dispose();
            new Multiplayer(player);
        }
    }
}