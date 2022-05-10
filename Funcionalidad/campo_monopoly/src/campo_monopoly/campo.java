/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campo_monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Darwin hola
 */
public class campo {

    class Nodo {

        //todos lo tienen
        int numCasilla;
        String nombre;
        
        //propiedades
        String color;
        String Dueño;
        int valor;//en servicios // cuando una persona la va a comprar y esta en el tablero
        int renta;//tambien en servicios// en la carta 
        int rentaMonopoly;
        int valorCasa;
        int valorHotel;
        int rentaCasa1;
        int rentaCasa2;
        int rentaHotel;
        //Carcel
        //String Habitantes;
        Nodo prev;
        Nodo next;

        public void tarjetaRandom() {
            //por ahora nada
        }

        public Nodo(int d, String a, String color, String D, int val, int rent, int rentM, int vCasa, int vHotel, int c1, int c2, int h) {
            this.numCasilla = d;
            this.nombre = a;
            this.color = color;
            this.Dueño = D;
            this.valor = val;
            this.renta = rent;
            this.rentaMonopoly = rentM;
            this.valorCasa = vCasa;
            this.valorHotel = vHotel;
            this.rentaCasa1 = c1;
            this.rentaCasa2 = c2;

            this.rentaHotel = h;
            //this.Habitantes = hab;
            this.next = null;
            this.prev = null;
        }
    }
    Nodo head = null;
    Nodo tail = null;

    public void addNode(int data, String name, String Color, String D, int val, int rent, int rentM, int vCasa, int vHotel, int c1, int c2, int h) {
        Nodo P = new Nodo(data, name, Color, D, val, rent, rentM, vCasa, vHotel, c1, c2, h);
        if (head == null) {
            head = P;
            tail = P;
        } else {
            tail.next = P;
            P.prev = tail;
            P.next = head;
            head.prev = P;
            tail = P;
        }
    }
    ///ARREGALR EL DISPLAYYYYYY ESTÁ PARA LISTA SIMPLE, NO CORRER PORQUE EXPLOTA EL PC XD BSOS

    public void display() {
        Nodo current = head;

        if (current == null) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");
        System.out.print("null <- ");
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.numCasilla + "." + current.nombre + " <-> ");
            } else {
                System.out.print(current.numCasilla + "." + current.nombre + " -> ");
            }
            current = current.next;
        }
        if (current == null) {
            System.out.print("null\n");
        }
    }

    public static void leertxt(String file_name, campo ca) {
        String nombre;
        int numCasilla;
        //propiedades
        String color;
        String Dueño;
        int valor;//en servicios // cuando una persona la va a comprar y esta en el tablero
        int renta;//tambien en servicios// en la carta 
        int rentaMonopoly;
        int valorCasa;
        int valorHotel;
        int rentaCasa1;
        int rentaCasa2;
        int rentaHotel;
        // meter los registros en una lista y las listas en un arraylist 
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name + ".txt"));
            String line = ""; //asi se leen los archivos         
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(","); // se hace split con cada coma
                numCasilla= Integer.parseInt(temp[0]);
                nombre=temp[1];
                //propiedades
                color =temp[2];
                Dueño =temp[3];
                valor= Integer.parseInt(temp[4]);
                renta= Integer.parseInt(temp[5]);
                rentaMonopoly = Integer.parseInt(temp[6]);
                valorCasa = Integer.parseInt(temp[7]);
                valorHotel = Integer.parseInt(temp[8]);
                rentaCasa1 = Integer.parseInt(temp[9]);
                rentaCasa2 = Integer.parseInt(temp[10]);
                rentaHotel = Integer.parseInt(temp[11]);
                
                ca.addNode(numCasilla,nombre,color,Dueño,valor,renta,rentaMonopoly,valorCasa,valorHotel,rentaCasa1,rentaCasa2,rentaHotel);
                //Añadimos las listas al array  
            }
            ca.display();
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
