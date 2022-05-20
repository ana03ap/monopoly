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
 * @author DELL
 */
public class ListaCampo {

    protected Nodo head, tail;

    public ListaCampo() {
        Nodo head = null;
        Nodo tail = null;
    }

    public void addNode(int data, String name, String Color, String D, int val, int rent, int rentM, String Ruta) {
        Nodo P = new Nodo(data, name, Color, D, val, rent, rentM, Ruta);
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

    public void display() {
        Nodo current = head;

        if (current == null) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");

        do {
            System.out.println(current.Ruta + "-->");

            current = current.next;
        } while (current != head);

        /*while (current != null) {
            if (current.next != null) {
                System.out.print(current.numCasilla + "." + current.nombre + " <-> ");
            } else {
                System.out.print(current.numCasilla + "." + current.nombre + " -> ");
            }
            current = current.next;
        }
        if (current == null) {
            System.out.print("null\n");
        }*/
    }

    public void buscarn(Jugadores n) {
        Nodo P = head;
        do {
            if (P.numCasilla == n.posicion) { //Casilla es igual a la posición. 
                System.out.println("se encontró");

                if (!"nada".equals(P.Ruta)) { //Para ver si es propiedad
                    String[] botones = {"comprar", "no comprar"};

                    if (P.valor != 0) {// arreglar lo de valor y renta en los servicios
                        if ("nadie".equals(P.Dueño)) {
                            // mostrarlo con los botones de comprar  
                            Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                            //int ventana =  JOptionPane.showOptionDialog(null, "", "CARTA", carta);
                            int ventana = JOptionPane.showOptionDialog(null, "",
                                    "Carta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, carta, botones, botones[0]);
                            //Lo que pasa si presiona cada botón
                            switch(ventana){
                                case 0: //Comprar, va un método :D
                                    if(n.dinero >= P.valor){ //Validar que el valor de su dinero sea mayor 
                                        n.dinero = n.dinero -P.valor;
                                        P.Dueño = n.nombre; //Implementar si acaba de conseguir un monopoly
                                    }else{ //Cuando no le alcanza
                                        JOptionPane.showMessageDialog(null, "No tienes dinero cachón", "!!!", JOptionPane.PLAIN_MESSAGE);
                                    }
                                    break;
                                case 1:
                                    System.out.println("No se compró");
                                    break;
                            }
                            return;
                        } else{//Cobrar, es decir, renta :)
                           //if(P.Dueño  ){
                               
                           //}
                           if(n.dinero <= P.renta){
                               
                           }
                        }
                    } else {
                        Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                        return;
                    }

                } else {// fortuna o arca comunal 
                    if (P.numCasilla == 2 || P.numCasilla == 17 || P.numCasilla == 33) {// arca comunal 
                        Cofre C = new Cofre();
                        String cartica = "/ImgArcaComunal/" + C.cartaRandom() + ".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                        System.out.println("aa");
                    } else if (P.numCasilla == 7 || P.numCasilla == 22 || P.numCasilla == 36) {// fortuna
                        Suerte S = new Suerte();
                        String cartica = "/ImgSuerte/" + S.cartaRandom() + ".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                    }

                }

            }
            P = P.next;

        } while (P != head);
    }

    // metodos para comprar las propiedades 
}
