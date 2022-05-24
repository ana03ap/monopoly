/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_final_edd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Lab_Final_EDD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        //Variables.jugador1.posicion = 37;
        //tablero.buscarn(Variables.jugador1);

      

        Pp g = new Pp();
        g.setVisible(true);
        
        
        

    }
    public static void leertxt(String file_name, ListaCampo ca) {
        String nombre;
        int numCasilla;
        //propiedades
        String color;
        String Dueño;
        String Ruta;
        int valor;//en servicios // cuando una persona la va a comprar y esta en el tablero
        int renta;//tambien en servicios// en la carta 
        int rentaMonopoly;
        int key;

        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numCasilla = Integer.parseInt(temp[0]);
                nombre = temp[1];
                //propiedades
                color = temp[2];
                Dueño = temp[3];
                valor = Integer.parseInt(temp[4]);
                renta = Integer.parseInt(temp[5]);
                rentaMonopoly = Integer.parseInt(temp[6]);
                Ruta = temp[7];
                key= Integer.parseInt(temp[8]);

                ca.addNode(numCasilla, nombre, color, Dueño, valor, renta, rentaMonopoly, Ruta,key);
                //Añadimos las listas al array  
            }

            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
