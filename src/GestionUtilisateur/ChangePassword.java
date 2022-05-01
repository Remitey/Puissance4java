package GestionUtilisateur;


import Database.DAOmodel.PlayerDAO;
import Database.Table.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword implements ActionListener {

    public Color colorText = new Color(162, 170, 214);
    public Font fontText = new Font(null, Font.PLAIN, 17);
    JFrame frame = new JFrame();
    JLabel connect = new JLabel(" please enter your new password : ");


    JTextField user = new JTextField();

    JButton buttonChangePass = new JButton("Change");
    JPanel jPanel= new JPanel();
    private final Player player;

    ChangePassword(Player player) {

        this.player = player;
        //phrase
        connect.setBounds(100, -105, 500, 300);
        connect.setForeground(colorText);
        frame.add(connect);

        //ecriture
        user.setBounds(350, 30, 300, 30);
        frame.add(user);

        //button
        buttonChangePass.setBounds(300, 100, 200, 40);
        buttonChangePass.setContentAreaFilled(false);
        buttonChangePass.setFocusable(false);
        buttonChangePass.addActionListener(this);
        frame.add(buttonChangePass);

        //tout
        frame.setSize(800, 200);
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

        if (e.getSource() == buttonChangePass) {
            PlayerDAO playerDAO =new PlayerDAO();
            playerDAO.findPlayer(player.getUsername(),player.getPassword());
            playerDAO.update(player);

            }
        }
    }
