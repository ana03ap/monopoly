/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campo_monopoly;

/**
 *
 * @author Darwin hola
 */
public class campo {
    class Nodo{
        //todos lo tienen
        String nombre;
        int numCasilla;
        //propiedades
        String color;
        String Dueño;
        int valor;//tambien en servicios
        int renta;//tambien en servicios
        int valorCasa;
        int valorHotel;
        int rentaCasa1;
        int rentaCasa2;
        int rentaCasa3;
        int rentaCasa4;
        int rentaHotel;
        //Carcel
        String Habitantes;
        Nodo prev;
        Nodo next;
        
          public void tarjetaRandom (){
        //por ahora nada
    }
          // quitar c3,c4
        public Nodo(int d, String a,String color, String D, int val, int rent, int vCasa, int vHotel, int c1, int c2, int c3, int c4, int h, String hab){
            this.numCasilla = d;
            this.nombre = a;
            this.color = color;
            this.Dueño = D;
            this.valor = val;
            this.renta = rent;
            this.valorCasa = vCasa;
            this.valorHotel = vHotel;
            this.rentaCasa1 = c1;
            this.rentaCasa2 = c2;
            this.rentaCasa3 = c3;
            this.rentaCasa4 = c4;
            this.rentaHotel = h;
            this.Habitantes = hab;
            this.next = null;
            this.prev = null;
        }
    }
    Nodo head = null;
    Nodo tail = null;
     public void addNode(int data,String name,String Color, String D, int val, int rent, int vCasa, int vHotel, int c1, int c2, int c3, int c4, int h, String hab) {
        Nodo P = new Nodo(data, name,Color, D, val, rent, vCasa, vHotel, c1, c2, c3, c4, h, hab);
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
                System.out.print(current.numCasilla + "."+current.nombre + " <-> ");
            } else {
                System.out.print(current.numCasilla + "."+current.nombre + " -> ");
            }
            current = current.next;
        }
        if (current == null) {
            System.out.print("null\n");
        }
    }
}
