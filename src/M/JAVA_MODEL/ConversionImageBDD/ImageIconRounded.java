package M.JAVA_MODEL.ConversionImageBDD;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class ImageIconRounded extends ImageIcon {
    public ImageIconRounded(Image image) {
        super(image);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        int diameter = Math.min(getIconWidth(), getIconHeight());
        int radius = diameter / 2;
        int centerX = x + getIconWidth() / 2;
        int centerY = y + getIconHeight() / 2;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setClip(new Ellipse2D.Double(centerX - radius, centerY - radius, diameter, diameter));
        super.paintIcon(c, g2, x, y);
        g2.dispose();
    }
}