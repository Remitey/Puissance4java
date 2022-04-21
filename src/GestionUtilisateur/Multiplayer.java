package GestionUtilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Multiplayer extends Frame implements ActionListener {


    JFrame frame = new JFrame();
    JButton game = new JButton(" Play");
    JButton back = new JButton(" Back");
    JLabel difficulty = new JLabel("Difficulty : ");
    JLabel sentence = new JLabel("Please choose :");


    JPanel panel = new JPanel();

    Multiplayer() {


        this.setLayout(new FlowLayout());

        String[] list = {"--Select Difficulty--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox cbg = new JComboBox<>(list);
        difficulty.setFont(new Font(null, Font.PLAIN, 15));

        sentence.setBounds(270, 120, 100, 100);
        difficulty.setBounds(150, 165, 100, 100);
        game.setBounds(270, 300, 200, 75);
        back.setBounds(320, 400, 100, 37); //https://www.javatpoint.com/java-jbutton
        cbg.setBounds(270, 200, 200, 30);

        panel.add(sentence);
        panel.add(back);
        panel.add(game);
        frame.add(difficulty);
        frame.add(cbg);

        game.addActionListener(this);
        back.addActionListener(this);

        game.setFocusable(false);

        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

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