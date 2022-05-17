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
            if (P.numCasilla == n.posicion) {
                System.out.println("se encontró");
                if (!"nada".equals(P.Ruta)) {
                    Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                    JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                    return;
                } else {// fortuna o arca comunal 
                    if (P.numCasilla == 2 || P.numCasilla == 17 || P.numCasilla == 23) {// arca comunal 
                        Cofre C = new Cofre();
                        String  cartica = "/ImgArcaComunal/"+C.cartaRandom()+".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null,"", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                        System.out.println("aa");
                    } else if (P.numCasilla == 7 || P.numCasilla == 22 || P.numCasilla == 36) {// fortuna
                        Suerte S = new Suerte();
                        String  cartica = "/ImgArcaComunal/"+S.cartaRandom()+".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                    }

                }

            }
            P = P.next;

        } while (P != head);
    }

}
