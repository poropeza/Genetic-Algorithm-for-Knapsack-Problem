/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

EP2 Práctica de Algoritmo Genético
INTEGRANTES:
Flores Gomez Eduardo
Oropeza Martinez Peter Savier
Sánchez Castillo Victor Hugo


*/
package ep2_algoritmo.genetico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HUGO
 */
public class EP2_ALGORITMOGENETICO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        objeto[] objetos;
        objetos = new objeto[15];

        FileReader lectorArchivo = null;
        try {
            lectorArchivo = new FileReader("objetos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EP2_ALGORITMOGENETICO.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader textoArchivo;
        textoArchivo = new BufferedReader(lectorArchivo);
        int casilla = 0;
        while (casilla < objetos.length) {
            String lineaTexto;
            try {
                lineaTexto = textoArchivo.readLine();
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                return;
            }

            String[] valores;
            valores = lineaTexto.split(";");
            int peso;
            peso = Integer.parseInt(valores[1]);
            int beneficio = Integer.parseInt(valores[2]);
            objetos[casilla] = new objeto();
            objetos[casilla].setNombre(valores[0]);
            objetos[casilla].setPeso(peso);
            objetos[casilla].setBeneficio(beneficio);

            casilla++;

        }
        Problema1 obj = new Problema1();
        //obj.PoblacionInicial(objetos);
        Problema2 obj2 = new Problema2();
        //obj2.poblacioninicial(objetos);
        Problema3 obj3 = new Problema3();
        //obj3.poblacioninicial(objetos);
        Problema4 obj4 = new Problema4();
        // obj4.poblacioninicial(objetos);
        Problema5 obj5 = new Problema5();
        obj5.poblacioninicial(objetos);

    }

}
