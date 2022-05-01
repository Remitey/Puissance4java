package GestionUtilisateur.UserManagement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGround extends JComponent {

    private Image background;


    public BackGround(Image background) { //https://stackoverflow.com/questions/1064977/setting-background-images-in-jframe
        this.background = background;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
    }

}
