package GestionUtilisateur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount implements ActionListener {

    JFrame frame = new JFrame();
    JLabel connect = new JLabel(" please enter following information");
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

    JButton buttonconnection = new JButton("Connection");

    CreateAccount() {

        String[] list = {"--Select gender--","Man", "Woman", "Nothing"};
        JComboBox cbg1 = new JComboBox<>(list);

        String[] list2 = {"--Select Country--","Francia", "USA", "Espagna", "Itali", "Russia", "Ukrania", "regardcommeilfaitbeau"};
        JComboBox cbg2 = new JComboBox<>(list2);

        //phrase
        connect.setBounds(250,-100,500,300);
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
        firstname.setFont(new Font(null, Font.PLAIN,15));
        frame.add(firstname);
        lastname.setBounds(150,100,100,100);
        lastname.setFont(new Font(null, Font.PLAIN,15));
        frame.add(lastname);
        email.setBounds(150,150,100,100);
        email.setFont(new Font(null, Font.PLAIN,15));
        frame.add(email);
        gender.setBounds(150,200,100,100);
        gender.setFont(new Font(null, Font.PLAIN,15));
        frame.add(gender);
        country.setBounds(150,250,100,100);
        country.setFont(new Font(null, Font.PLAIN,15));
        frame.add(country);
        username.setBounds(150,300,100,100);
        username.setFont(new Font(null, Font.PLAIN,15));
        frame.add(username);
        password.setBounds(150,350,100,100);
        password.setFont(new Font(null, Font.PLAIN,15));
        frame.add(password);
        confirmpassword.setBounds(150,400,100,100);
        confirmpassword.setFont(new Font(null, Font.PLAIN,15));
        frame.add(confirmpassword);

        error.setBounds(150,400,100,100);
        error.setFont(new Font(null, Font.PLAIN,15));



        //button
        buttonconnection.setBounds(300,500,200,40);
        buttonconnection.setFocusable(false);
        buttonconnection.addActionListener(this);
        frame.add(buttonconnection);

        cbg1.setBounds(300,240,200,30);
        frame.add(cbg1);
        cbg2.setBounds(300,290,200,30);
        frame.add(cbg2);


        //tout
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonconnection) {
            // if connection existe
            ShowMenu showmenu = new ShowMenu();
            frame.dispose();
            //else :
            //frame.add(error);
        }
    }
}