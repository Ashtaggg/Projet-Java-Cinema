package M.JAVA_MODEL.ConversionImageBDD;

import java.io.*;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;



public class ConvertirImageHexa {
    public static String ImageToHex(String path){ // --------------------------- Convertir Image (depuis un path) en Hexa ---------------------------
        String imageHex = "";
    
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            StringBuilder hexString = new StringBuilder();

            while (bis.available() > 0) {
                int value = bis.read();
                hexString.append(String.format("%02X", value));
            }

            bis.close();
            imageHex = hexString.toString();
            return imageHex;
        } catch (IOException error) {
            System.out.println(error);
        }
        return imageHex;
    }




    public static BufferedImage HexToImage(String imageHex){// --------------- Convertir Hexa en Image et l'afficher ------------------
        if (!imageHex.isEmpty()) {
            byte[] bytes = new byte[imageHex.length() / 2];
            for (int i = 0; i < imageHex.length(); i += 2) {
                bytes[i / 2] = (byte) Integer.parseInt(imageHex.substring(i, i + 2), 16);
            }
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);


            BufferedImage image = null;
            try {
                image = ImageIO.read(bis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Pour afficher cette image : 

            /*JLabel label = new JLabel(new ImageIcon(image));

            label.setBounds(x, y, width, height);

            frame.getPanelBase().setVisible(true);
            frame.getPanelBase().add(label);
            frame.RefreshPage();*/

            return image;
        }
        return null;
    }
}
