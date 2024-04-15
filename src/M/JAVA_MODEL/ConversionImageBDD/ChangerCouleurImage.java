package M.JAVA_MODEL.ConversionImageBDD;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import V.FrameBase;

public class ChangerCouleurImage {
    public static ImageIcon changer(FrameBase frame, ImageIcon icon){
        BufferedImage image = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        Color nouvelleCouleur = frame.getSecondeCouleur();
        Color ancienneCouleur = new Color(0, 0, 0);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color couleurPixel = new Color(rgb);
                if (couleurPixel.equals(ancienneCouleur)) {
                    image.setRGB(x, y, nouvelleCouleur.getRGB());
                }
            }
        }

        nouvelleCouleur = frame.getMainCouleur();
        ancienneCouleur = new Color(255, 255, 255);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color couleurPixel = new Color(rgb);
                if (couleurPixel.equals(ancienneCouleur)) {
                    image.setRGB(x, y, nouvelleCouleur.getRGB());
                }
            }
        }


        ImageIcon newIcon = new ImageIcon(image);

        return newIcon;
    }
}
