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
import java.applet.AudioClip;
/**
 *
 * @author DELL
 */
public class ListaCampo {

    protected Nodo head, tail;
    AudioClip sonido;
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
                    String[] botones = {"COMPRAR", "NO COMPRAR"};

                    if (P.valor != 0) {// CUANDO NO HAY DUEÑO
                        if ("nadie".equals(P.Dueño)) {
                            // mostrarlo con los botones de comprar  
                            Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                            //int ventana =  JOptionPane.showOptionDialog(null, "", "CARTA", carta);
                            int ventana = JOptionPane.showOptionDialog(null, "",
                                    "Carta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, carta, botones, botones[0]);
                            //Lo que pasa si presiona cada botón
                            switch (ventana) {
                                case 0: //comprar una propiedad, va un método :D
                                    if (n.dinero >= P.valor) { //Validar que el valor de su dinero sea mayor 
                                        n.dinero = n.dinero - P.valor;
                                        P.Dueño = n.nombre; //Implementar si acaba de conseguir un monopoly
                                    } else { //Cuando no le alcanza
                                        JOptionPane.showMessageDialog(null, "No tienes dinero", "WARNING!", JOptionPane.PLAIN_MESSAGE);
                                    }
                                    sonido = java.applet.Applet.newAudioClip(getClass().getResource("/audios/chicogel.wav"));
                                    sonido.play();
                                    break;
                                case 1: //no compro la propiedad
                                    System.out.println("No se compró");
                                    break;
                            }
                            return;
                        } else {//Cobrar, es decir, RENTA :)ya hay un dueño
                            Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                            JOptionPane.showMessageDialog(null, "", "¡Debes pagar la renta!", JOptionPane.PLAIN_MESSAGE, carta);
                            if (P.Dueño.equals(n.nombre)) { //lapersona q esta ahi parada es el dueño

                            } else { //cobrarle, no eres el dueño de esa propiedad
                                if (n.dinero <= P.renta && P.renta != 9999) { //, ya sabemos q no tiene plata, no es servicio
                                    n.estado = 1;
                                    System.out.println("estas en 0");
                                } else { //ya sabemos q tiene plata
                                    if (P.renta == 9999) { // ES UN SERVICIO !!!! RENTA CON SERVICIO!!
                                        int dado1 = (int) ((Math.random()) * 60 / 10) + 1;//dado 1
                                        int dado2 = (int) ((Math.random()) * 60 / 10) + 1;//dado2
                                        int dado = dado1 + dado2;
                                        dados(dado1, dado2);
                                        int resultado = dado * 4;
                                        if (resultado >= n.dinero) {
                                            // estas en bancarrota
                                            n.estado=1;
                                            System.out.println("no tienes plata compa");
                                        } else {
                                            n.dinero = n.dinero - resultado; // se le descuenta la renta de su dinero
                                            System.out.println(n.dinero);
                                        }
                                    } else {
                                        n.dinero = n.dinero - P.renta; // se le descuenta la renta de su dinero
                                        System.out.println(n.dinero);
                                    }
                                }
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
    public void dados(int dado1, int dado2) {
        ImageIcon icono = null;

        switch (dado1) { // ver las combinaciones 
            case 1:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/1,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/1,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/1,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/1,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/1,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/1,6.png"));
                        break;
                }
                break;
            case 2:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/2,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/2,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/2,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/2,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/2,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/2,6.png"));
                        break;
                }
                break;
            case 3:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/3,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/3,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/3,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/3,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/3,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/3,6.png"));
                        break;
                }
                break;
            case 4:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/4,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/4,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/4,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/4,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/4,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/4,6.png"));
                        break;
                }
                break;
            case 5:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/5,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/5,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/5,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/5,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/5,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/5,6.png"));
                        break;
                }
                break;
            case 6:
                switch (dado2) {
                    case 1:
                        icono = new ImageIcon(getClass().getResource("/dados/6,1.png"));
                        break;
                    case 2:
                        icono = new ImageIcon(getClass().getResource("/dados/6,2.png"));
                        break;
                    case 3:
                        icono = new ImageIcon(getClass().getResource("/dados/6,3.png"));
                        break;
                    case 4:
                        icono = new ImageIcon(getClass().getResource("/dados/6,4.png"));
                        break;
                    case 5:
                        icono = new ImageIcon(getClass().getResource("/dados/6,5.png"));
                        break;
                    case 6:
                        icono = new ImageIcon(getClass().getResource("/dados/6,6.png"));
                        break;
                }
                break;
        }
        JOptionPane.showMessageDialog(null, "", "DADOS", JOptionPane.PLAIN_MESSAGE, icono);
    }
}
