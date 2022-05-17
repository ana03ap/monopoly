package lab_final_edd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Darwin
 */
public class Cofre {

    class Carta {

        int num;
        String info;
        Carta next;

        public Carta(int num, String info) {
            this.num = num;
            this.info = info;
            this.next = null;
        }
    }
    Carta head = null;
    Carta tail = null;

    public void addCarta(int data, String name) {
        Carta P = new Carta(data, name);
        if (head == null) {
            head = P;
            tail = P;
        } else {
            tail.next = P;
            tail = P;
        }
    }

    public void mostrarlista() {
        Carta recorrer = head;
        while (recorrer != null) {
            System.out.println(recorrer.num + "." + recorrer.info + "---->");
            recorrer = recorrer.next;

        }
    }

    public int cartaRandom() {
        Random random = new Random();
        int rnum = random.nextInt((14 + 1)) + 1;
        return rnum;
        // System.out.println("El random del cofre es: " + rnum);
        /**
         * if (rnum == 1) { System.out.println(head.num + "." + head.info); }
         * else { int cont = 1; Carta recorrer = head; do { recorrer =
         * recorrer.next; cont++; } while (cont < rnum);
         * System.out.println(recorrer.num + "." + recorrer.info);
        }
         */
        //Acá va la ejecución del metodo jijiji

    }
    // hay que instanciar cofre pa pasarlo de parametro

    public static void leertxt(String file_name, Cofre c) {
        int numero;
        String info;

        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numero = Integer.parseInt(temp[0]); // primera coma 
                info = temp[1];
                c.addCarta(numero, info);
                //Añadimos las listas al array  
            }
            c.mostrarlista();
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void crearLista(String file_name, Cofre c) {
        int numero;
        String info;

        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numero = Integer.parseInt(temp[0]); // primera coma 
                info = temp[1];
                c.addCarta(numero, info);
                //Añadimos las listas al array  
            }
            c.mostrarlista();
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
