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
public class HSI {
    public void img_toHSI(String path, String name, String extension) throws IOException{
         File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);
        
        BufferedImage H_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage S_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage I_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage HSI_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color c = new Color(img.getRGB(x, y));
                double r = c.getRed()/255f;
                double g = c.getGreen()/255f;
                double b = c.getBlue()/255f;
                
                double ORiscado = Math.acos((0.5*((r-g) + (r-b)))
                                 /Math.sqrt((Math.pow((r-g), 2) + (r - b) * (g-b))));
                
                double H;
                if(b <= g){
                    H = ORiscado;
                }else{
                    H = (2*Math.PI)-ORiscado;
                }
                double S;
                double I = (r+g+b)/3;
                if(r+g+b == 0){
                    S = 1;
                }else{
                    S = (1 - (3/(r+g+b)));
                }
                
                
                if(r <= b && r <= g){
                    S = S*r;
                }else if(b <= r && b <= g){
                    S = S*b;
                }else if(g <= r && g <= b){
                    S = S*g;
                }
                
                H = H * 255f;
                S = S * 255f;
                I = I * 255f;
                
                int newColorH = (int)H;
                int newColorS = (int)S;
                int newColorI = (int)I;
                
                if(newColorS > 255){
                    newColorS = 255;
                }else if(newColorS < 0){
                    newColorS = 0;
                }
                
                if(newColorI > 255){
                    newColorI = 255;
                }else if(newColorI < 0){
                    newColorI = 0;
                }
                
                if(newColorH > 255){
                    newColorH = 255;
                }else if(newColorH < 0){
                    newColorH = 0;
                }
                
                Color novaCorH = new Color(newColorH,newColorH,newColorH);
                H_Image.setRGB(x, y, novaCorH.getRGB());
                
                Color novaCorS = new Color(newColorS,newColorS,newColorS);
                S_Image.setRGB(x, y, novaCorS.getRGB());
                
                Color novaCorI = new Color(newColorI,newColorI,newColorI);
                I_Image.setRGB(x, y, novaCorI.getRGB());

                Color novaCorHSI = new Color(newColorH,newColorS,newColorI);
                HSI_Image.setRGB(x, y, novaCorHSI.getRGB());
            }
        }
        File outputFile = new File(path + "\\" + "New_ImageH.jpg");
        ImageIO.write(H_Image, "JPG", outputFile);
        
        File output2File = new File(path + "\\" + "New_ImageS.jpg");
        ImageIO.write(S_Image, "JPG", output2File);
        
        File output3File = new File(path + "\\" + "New_ImageI.jpg");
        ImageIO.write(I_Image, "JPG", output3File);
            
        File output4File = new File(path + "\\" + "New_ImageHSI.jpg");
        ImageIO.write(HSI_Image, "JPG", output4File);}
    }

