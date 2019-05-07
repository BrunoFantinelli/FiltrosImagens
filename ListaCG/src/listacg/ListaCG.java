/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacg;

import java.io.IOException;

/**
 *
 * @author CC10848869958
 */
public class ListaCG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Raio = Dimensão - ((Dimensão/2)+1)
        
        //Caminho, nome da imagem, extensão
        //Exercício 6
        EscalaDeCinza escala = new EscalaDeCinza();
        escala.img_toCinza("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg");
    
        //Exercício 7
        YCbCr transformacao_YCbCr = new YCbCr();
        transformacao_YCbCr.img_toYCbCr("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg");
    
        HSI transformacao_HSI = new HSI();
        transformacao_HSI.img_toHSI("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg");

        //Exercicio 10
        //Caminho, nome da imagem, extensão, dimensão da matriz
        SuavizacaoMediana suave = new SuavizacaoMediana();
        suave.img_toSuaveMediana("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg", 7);
        
        //Exercicio 11
        //Caminho, nome da imagem, extensão, opcão de máscara
        FiltragemMascara filtragem = new FiltragemMascara();
        filtragem.img_toFiltragemMascara("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg", 1);
        
        
        //Exercicio 8
        Limiarizacao limiar = new Limiarizacao();
        limiar.limiarizacao("C:\\Users\\CC10848869958\\Desktop", "sasuke", ".jpg");
               
        
    }   

}
