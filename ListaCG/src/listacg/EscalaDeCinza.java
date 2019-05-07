/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacg;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author CC10848869958
 */
public class EscalaDeCinza {

    public void img_toCinza(String path, String name, String extension) throws IOException {

        File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);

        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int media = (r + g + b)/3;

                Color novaCorR = new Color(media, media, media);
                newImage.setRGB(x, y, novaCorR.getRGB());
                }
        }
        File outputFile = new File(path + "\\novaImagemEscalaCinza.jpg");
        ImageIO.write(newImage, "JPG", outputFile);

    }
}
