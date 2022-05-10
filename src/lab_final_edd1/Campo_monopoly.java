/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Darwin
 */
public class Campo_monopoly {

    
    public static void leertxt(String file_name, Cofre c) {
        int numero;
        String info;

        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numero =Integer.parseInt(temp[0]); // primera coma 
                info = temp[1];
                c.addCarta(numero,info);
                //Añadimos las listas al array  
            }
            c.mostrarlista();
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
     public static void leertxtSuerte(String file_name) {
        int numero;
        String info;

        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            Cofre c= new Cofre();
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numero =Integer.parseInt(temp[0]); // primera coma 
                info = temp[1];
                

                
                
                c.addCarta(numero,info);
                //Añadimos las listas al array  
            }
            c.mostrarlista();
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        /*campo List = new campo();
        List.addNode(1,"Avenida mediterraneo");
        List.addNode(2,"Arca Comunal");
        List.addNode(3,"Avenida Baltica");
        List.addNode(4,"Ingresos de lujo");
        List.addNode(5,"Ferrocarril");
        List.addNode(6,"Avenida Oriental");
        List.addNode(7,"Fortuna");
        List.addNode(8,"Avenida Connnecticut");
        List.addNode(9,"Plaza sanCarlos");
        List.addNode(10,"Compañía de luz");
        List.addNode(11,"Avenida Estados");
        List.display();
        Suerte cartas = new Suerte();
        cartas.addCarta(1, "Avance a el muelle"); //el muelle es el que está antes de la salida       
        cartas.addCarta(2, "Viaje en el Ferrocarril READING, si pasa por “SALIDA” cobre $200.");
        cartas.addCarta(3, "Por cumplimiento en pago del préstamo de construcción cobre $150.");
        cartas.addCarta(4, "Avance a AVENIDA ILLINOIS. Si pasa por la salida cobre $200.");
        cartas.addCarta(5, "AVANCE AL SERVICIO MÁS CERCANO. Si está a LA VENTA, puede comprárselo al banco. Si es PROPIEDAD de alguien, tira los dados y pague 10 veces lo pagado.");
        cartas.addCarta(6, "Váyase a la CÁRCEL. No pase por la SALIDA, no cobra $200");
        cartas.addCarta(7, "Avance a la SALIDA, cobre $200.");
        cartas.addCarta(8, "El banco le paga dividendos por $50.");
        cartas.addCarta(9, "Haga reparaciones en sus propiedades; por cada casa pague $25, por cada hotel pague $100.");
        cartas.addCarta(10, "SALGA DE LA CÁRCEL GRATIS.");
        cartas.addCarta(11, "Avance a PLAZA SAN CARLOS. Si pasa por la SALIDA cobre $200.");
        cartas.addCarta(12, "Ha sido elegido presidente del concejo de administración. Pague a cada jugador $50.");
        cartas.addCarta(13, "Retroceda 3 casillas.");
        cartas.addCarta(14, "Pague multa por exceso de velocidad $15.");
        cartas.addCarta(15, "AVANCE AL FERROCARRIL MÁS CERCANO. Si está a LA VENTA, puede comprársela al banco. Si es PROPIEDAD de alguien, pague el doble de la renta marcada.");
        cartas.addCarta(16, "AVANCE AL FERROCARRIL MÁS CERCANO. Si está a LA VENTA, puede comprársela al banco. Si es PROPIEDAD de alguien, pague el doble de la renta marcada.");
        //cartas.mostrarlista();
*/
        // abrir cartas cofre
        Suerte cartas = new Suerte();
        Cofre c = new Cofre();
        campo ca = new campo();
        //Suerte.leertxt("txtCartaSuerte",cartas);
        //Cofre.leertxt("txtCartasCofre", c);
       campo.leertxt("txtPropiedades",ca);
        
        
         
        
        
        /*
        cartasC.addCarta(1, "SALGA DE LA CÁRCEL GRATIS.");
        cartasC.addCarta(2, "Honorarios médicos, pague $50.");
        cartasC.addCarta(3, "Vencimiento de fondo vacacional, reciba $100.");
        cartasC.addCarta(4, "Vencimiento de seguro de vida. Cobre $100. ");
        cartasC.addCarta(5, "Pague colegiaturas por $50.");
        cartasC.addCarta(6, "Devolución de impuestos. Cobre $20.");
        cartasC.addCarta(7, "Pague cuenta de hospital por $100.");
        cartasC.addCarta(8, "Váyase a la CÁRCEL. No pase por la SALIDA, no cobra $200.");
        cartasC.addCarta(9, "Reciba $25 por consultoría.");
        cartasC.addCarta(10, "Es su cumpleaños. Cobre $10 a cada jugador. ");
        cartasC.addCarta(11, "Herede $100.");
        cartasC.addCarta(12, "Por venta de acciones reciba $50.");
        cartasC.addCarta(13, "Ganó el segundo lugar en un concurso de belleza, cobre $10.");
        cartasC.addCarta(14, "Por reparación vial le cobran: $40 por casa, $115 por hotel.");
        cartasC.addCarta(15, "Avance a la SALIDA, cobre $200.");
        cartasC.addCarta(16, "Error bancario a su favor. Cobre $200.");
        cartas.cartaRandom();
        cartasC.cartaRandom();
        campo Campo = new campo();
        /*
        Campo.addNode(1, "Salida",null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
        Campo.addNode(2, "Avenida Mediterraneo","Magenta", null, 60, 2, 50, 50, 10, 30, 90, 160, 250, null);
        Campo.addNode(3, "Arca comunal",null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
        Campo.addNode(4, "Avenida Baltica","Magenta", null, 60, 4, 50, 50, 20, 60, 180, 320, 450, null);
        Campo.addNode(5, "Ingresos de lujo", null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
        Campo.addNode(6, "Ferrocarril Reading", null, null, 200, 25, 0, 0, 0, 0, 0, 0, 0, null);
        Campo.addNode(7, "Avenida Oriental", "Celeste", null, 100, 6, 50, 50, 30, 90, 270, 400, 550, null);
        Campo.addNode(8, "Fortuna",null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
         */
    }

}
