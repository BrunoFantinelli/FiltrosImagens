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
 * @author cc10848869958
 */
public class ErosaoDilatacao {

    public void img_toErosaoDilatacao(String path, String name, String extension, int dimension, int op, String fazer) throws IOException {
        File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);

        BufferedImage ErosaoDilatacao_NewImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        int mf[][] = new int[3][3];
        if (op == 1) {
            mf[0][0] = 0;
            mf[0][1] = 1;
            mf[0][2] = 0;

            mf[1][0] = 1;
            mf[1][1] = 1;
            mf[1][2] = 1;

            mf[2][0] = 0;
            mf[2][1] = 1;
            mf[2][2] = 0;

        } else if (op == 2) {
            mf[0][0] = 1;
            mf[0][1] = 1;
            mf[0][2] = 1;

            mf[1][0] = 1;
            mf[1][1] = 1;
            mf[1][2] = 1;

            mf[2][0] = 1;
            mf[2][1] = 1;
            mf[2][2] = 1;

        } else if (op == 3) {
            mf[0][0] = 0;
            mf[0][1] = 0;
            mf[0][2] = 0;

            mf[1][0] = 1;
            mf[1][1] = 1;
            mf[1][2] = 1;

            mf[2][0] = 0;
            mf[2][1] = 0;
            mf[2][2] = 0;

        } else if (op == 4) {
            mf[0][0] = 0;
            mf[0][1] = 1;
            mf[0][2] = 0;

            mf[1][0] = 0;
            mf[1][1] = 1;
            mf[1][2] = 0;

            mf[2][0] = 0;
            mf[2][1] = 1;
            mf[2][2] = 0;

        }

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                double r = c.getRed() / 255f;
                double g = c.getGreen() / 255f;
                double b = c.getBlue() / 255f;
                int maior = -1, menor = 256;
                int raio = (dimension - ((dimension / 2) + 1));
                int matriz_x = 0, matriz_y = 0;

                for (int j = x - raio; j <= x + raio; j++) {
                    for (int k = y - raio; k <= y + raio; k++) {
                        if (k >= 0 && j >= 0 && j < img.getWidth() && k < img.getHeight()) {
                            if (mf[matriz_x][matriz_y] == 1) {
                                Color cor = new Color(img.getRGB(j, k));
                                if (fazer == "Erosao") {
                                    if (cor.getRed() < menor) {
                                        menor = cor.getRed();
                                    }
                                } else if (fazer == "Dilatacao") {
                                    
                                    if (cor.getRed() > maior) {
                                        maior = cor.getRed();
                                    }
                                }

                            }

                        }

                        matriz_y++;
                    }
                    matriz_y = 0;
                    matriz_x++;
                }
                
                if (fazer == "Erosao") {
                    Color novaCorH = new Color(menor, menor, menor);
                    ErosaoDilatacao_NewImage.setRGB(x, y, novaCorH.getRGB());
                } else if (fazer == "Dilatacao") {
                    Color novaCorH = new Color(maior, maior, maior);
                    ErosaoDilatacao_NewImage.setRGB(x, y, novaCorH.getRGB());
                }

            }
        }

        if (fazer == "Erosao") {
            File outputFile = new File(path + "\\" + "New_ImageErosao.jpg");
            ImageIO.write(ErosaoDilatacao_NewImage, "JPG", outputFile);
        } else if (fazer == "Dilatacao") {
            File outputFile = new File(path + "\\" + "New_ImageDilatacao.jpg");
            ImageIO.write(ErosaoDilatacao_NewImage, "JPG", outputFile);
        }
        

    }
}
