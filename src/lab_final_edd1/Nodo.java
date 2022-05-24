/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_final_edd1;

public class Nodo {

    //todos lo tienen
    int numCasilla;
    String nombre;

    //propiedades
    String color;
    String Dueño;
    String Ruta;
    int valor;//en servicios // cuando una persona la va a comprar y esta en el tablero
    int renta;//tambien en servicios// en la carta 
    int rentaMonopoly;
    int key;

    //Carcel
    //String Habitantes;
    Nodo prev;
    Nodo next;

    public void tarjetaRandom() {
        //por ahora nada
    }

    public Nodo(int d, String a, String color, String D, int val, int rent, int rentM, String Ruta, int key) {
        this.numCasilla = d;
        this.nombre = a;
        this.color = color;
        this.Dueño = D;
        this.valor = val;
        this.renta = rent;
        this.rentaMonopoly = rentM;
        this.Ruta = Ruta;
        this.key = key;
        //this.Habitantes = hab;
        this.next = null;
        this.prev = null;

    }
}
