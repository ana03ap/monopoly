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
import javax.swing.JLabel;

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

    public void addNode(int data, String name, String Color, String D, int val, int rent, int rentM, String Ruta, int key) {
        Nodo P = new Nodo(data, name, Color, D, val, rent, rentM, Ruta, key);
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
            System.out.println(current.key + "-->");

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

    public void buscarn(Jugadores n, Jugadores x, Jugadores y, Jugadores z, JLabel ficha) {
        Nodo P = head;
        // n es la persona a la que se le va a quitar la plata
        do {
            if (P.numCasilla == 30 && P.numCasilla == n.posicion) {//Vaya para la carcel
                Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                int dado = 0;
                while (n.posicion + dado != 10) {
                    dado++;
                    if (dado + n.posicion == 40) {
                        moversin(dado, ficha, n);
                        dado = 0;
                    }
                }
                moversin(dado, ficha, n);
                n.estado = 2;
                return;
            }
            // aca esta en economia naranja y pa vivir sabroso 
            if ((P.numCasilla == 4 && P.numCasilla == n.posicion) || (P.numCasilla == 38 && P.numCasilla == n.posicion)) {
                Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                switch (P.numCasilla) {
                    case 4: // economia naranja le suma 200
                        n.dinero = n.dinero + 200;
                        break;
                    case 38: // pa vivir sabroso le suma 100
                        n.dinero = n.dinero + 100;
                        break;
                }
                return;
            }

            if (P.numCasilla == 30 && P.numCasilla == n.posicion) {
                Icon carta = new ImageIcon(getClass().getResource(P.Ruta));
                JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                // IMPLEMENTAR CARCEL
            }
            if (P.numCasilla == n.posicion) { //Casilla es igual a la posición. 

                if (!"nada".equals(P.Ruta)) { //Para ver si es propiedad
                    String[] botones = {" COMPRAR ", " NO COMPRAR "};

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
                                        Nodo Q = head;
                                        int cont = 0;
                                        Nodo A = null, B = null;
                                        do {
                                            if (P.color.equals("Magenta") || P.color.equals("Azul")) { //Estas son las propiedades que tienen solo dos
                                                if (P.Dueño.equals(Q.Dueño) && P != Q) {//Si la otra propiedad es tamb su dueño y obvio no es la misma propiedad
                                                    //Hacer P.monopoly y Q.monopoly 1
                                                    P.key = 1;
                                                    Q.key = 1;
                                                }
                                            } else { //Si son los otros colores que tienen 3 propiedades
                                                if (P.Dueño.equals(Q.Dueño) && P != Q) {
                                                    cont++;
                                                    if (cont == 1) {
                                                        A = Q;
                                                    }
                                                    if (cont == 2) {
                                                        B = Q;
                                                    }
                                                }
                                            }
                                            Q = Q.next;
                                        } while (Q != head);
                                        if (cont == 2) {//Se recorrió la lista y se determinó que los de 3 tienen el mismo dueño
                                            P.key = 1;
                                            A.key = 1;
                                            B.key = 1;
                                        }
                                    } else { //Cuando no le alcanza
                                        JOptionPane.showMessageDialog(null, "No tienes dinero", "WARNING!", JOptionPane.PLAIN_MESSAGE);
                                        n.dinero = 0;
                                        n.estado = 1;
                                    }
                                    sonido = java.applet.Applet.newAudioClip(getClass().getResource("/audios/chicogel.wav"));
                                    //sonido.play();
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
                                if (P.key == 1) {//Es una con monopoly
                                    if (n.dinero <= P.rentaMonopoly) {//La plata no le alcanza
                                        n.estado = 1;
                                        if (P.Dueño.equals(x.nombre)) {
                                            x.dinero = x.dinero + n.dinero;
                                        }
                                        if (P.Dueño.equals(y.nombre)) {
                                            y.dinero = y.dinero + n.dinero;
                                        }
                                        if (P.Dueño.equals(z.nombre)) {
                                            z.dinero = z.dinero + n.dinero;
                                        }
                                        n.dinero = 0;
                                    } else {//La plata le alcanza
                                        n.dinero = n.dinero - P.rentaMonopoly;
                                        if (P.Dueño.equals(x.nombre)) {
                                            x.dinero = x.dinero + P.rentaMonopoly;
                                        }
                                        if (P.Dueño.equals(y.nombre)) {
                                            y.dinero = y.dinero + P.rentaMonopoly;
                                        }
                                        if (P.Dueño.equals(z.nombre)) {
                                            z.dinero = z.dinero + P.rentaMonopoly;
                                        }
                                    }
                                } else {//La propiedad no es parte de un monopoly
                                    if (n.dinero <= P.renta && P.renta != 9999) { //, ya sabemos q no tiene plata, no es servicio
                                        n.estado = 1;
                                        // estamos sumando la renta al dueño de la propiedad
                                        // puede que la renta sea 30 y el jugador tenga 15, se le suma los 15 al dueño
                                        if (P.Dueño.equals(x.nombre)) {
                                            x.dinero = x.dinero + n.dinero;
                                        }
                                        if (P.Dueño.equals(y.nombre)) {
                                            y.dinero = y.dinero + n.dinero;
                                        }
                                        if (P.Dueño.equals(z.nombre)) {
                                            z.dinero = z.dinero + n.dinero;
                                        }
                                        n.dinero = 0;

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
                                                n.estado = 1;
                                                n.dinero = 0;
                                                System.out.println("no tienes plata compa");
                                            } else {
                                                n.dinero = n.dinero - resultado; // se le descuenta la renta de su dinero
                                                System.out.println(n.dinero);
                                                // estamos sumando la renta al dueño de la propiedad 
                                                if (P.Dueño.equals(x.nombre)) {
                                                    x.dinero = x.dinero + P.renta;
                                                }
                                                if (P.Dueño.equals(y.nombre)) {
                                                    y.dinero = y.dinero + P.renta;
                                                }
                                                if (P.Dueño.equals(z.nombre)) {
                                                    z.dinero = z.dinero + P.renta;
                                                }
                                            }
                                        } else {
                                            n.dinero = n.dinero - P.renta; // se le descuenta la renta de su dinero
                                            System.out.println(n.dinero);

                                            // estamos sumando la renta al dueño de la propiedad 
                                            if (P.Dueño.equals(x.nombre)) {
                                                x.dinero = x.dinero + P.renta;
                                            }
                                            if (P.Dueño.equals(y.nombre)) {
                                                y.dinero = y.dinero + P.renta;
                                            }
                                            if (P.Dueño.equals(z.nombre)) {
                                                z.dinero = z.dinero + P.renta;
                                            }
                                        }
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
                        int escogido = C.cartaRandom();
                        String cartica = "/ImgArcaComunal/" + escogido + ".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                        int dado = 0;
                        switch (escogido) {
                            case 1:
                                //Salga de la carcel
                                break;
                            case 2:
                                //Vaya para la carcel
                                while (n.posicion + dado != 10) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        moversin(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                moversin(dado, ficha, n);
                                n.estado = 2;
                                break;
                            case 3:
                                while (n.posicion + dado != 40) {
                                    dado++;
                                }
                                mover(dado, ficha, n);
                                break;
                            case 4:
                                n.dinero = n.dinero + 200;
                                break;
                            case 5:
                                if (n.dinero <= 50) {
                                    n.dinero = 0;
                                    n.estado = 1;
                                } else {
                                    n.dinero = n.dinero - 50;
                                }
                                break;
                            case 6:
                                n.dinero = n.dinero + 100;
                                break;
                            case 7:
                                if (n.dinero <= 100) {
                                    n.dinero = 0;
                                    n.estado = 1;
                                } else {
                                    n.dinero = n.dinero - 100;
                                }
                                break;
                            case 8:
                                if (n.dinero <= 50) {
                                    n.dinero = 0;
                                    n.estado = 1;
                                } else {
                                    n.dinero = n.dinero - 50;
                                }
                                break;
                            case 9:
                                n.dinero = n.dinero + 20;
                                break;
                            case 10:
                                n.dinero = n.dinero + 25;
                                break;
                            case 11:
                                if (n.dinero <= 100) {
                                    n.dinero = 0;
                                    n.estado = 1;
                                } else {
                                    n.dinero = n.dinero - 100;
                                }
                                break;
                            case 12:
                                switch (Variables.njugadores) {
                                    case 2:
                                        if (x.dinero <= 10) {
                                            n.dinero = n.dinero + x.dinero;
                                            x.dinero = 0;
                                            x.estado = 1;
                                        } else {
                                            x.dinero = x.dinero - 10;
                                            n.dinero = n.dinero + 10;
                                        }
                                        break;
                                    case 3:
                                        int one = 10,
                                         two = 10;
                                        if (x.dinero <= 10) {
                                            one = x.dinero;
                                            x.dinero = 0;
                                            x.estado = 1;
                                        }
                                        if (y.dinero <= 10) {
                                            two = y.dinero;
                                            y.dinero = 0;
                                            y.estado = 1;
                                        }
                                        n.dinero = n.dinero + one + two;
                                        break;
                                    case 4:
                                        int one1 = 10,
                                         two1 = 10,
                                         three1 = 10;
                                        if (x.dinero <= 10) {
                                            one1 = x.dinero;
                                            x.dinero = 0;
                                            x.estado = 1;
                                        }
                                        if (y.dinero <= 10) {
                                            two1 = y.dinero;
                                            y.dinero = 0;
                                            y.estado = 1;
                                        }
                                        if (z.dinero <= 10) {
                                            three1 = z.dinero;
                                            z.estado = 1;
                                            z.dinero = 0;
                                        }
                                        n.dinero = n.dinero + one1 + two1 + three1;
                                        break;
                                }
                                break;
                            case 13:
                                n.dinero = n.dinero + 100;
                                break;
                            case 14:
                                n.dinero = n.dinero + 50;
                                break;
                            case 15:
                                n.dinero = n.dinero + 10;
                                break;
                        }
                    } else if (P.numCasilla == 7 || P.numCasilla == 22 || P.numCasilla == 36) {// fortuna
                        Suerte S = new Suerte();
                        int escogido = S.cartaRandom();
                        String cartica = "/ImgSuerte/" + escogido + ".png";
                        Icon carta = new ImageIcon(getClass().getResource(cartica));
                        JOptionPane.showMessageDialog(null, "", "CARTA", JOptionPane.PLAIN_MESSAGE, carta);
                        int dado = 0;
                        switch (escogido) {
                            case 1:
                                System.out.println("hola");
                                while (n.posicion + dado != 39) {
                                    dado++;
                                }
                                mover(dado, ficha, n);
                                break;
                            case 2:

                                while (n.posicion + dado != 40) {
                                    dado++;
                                }
                                mover(dado, ficha, n);
                                break;
                            case 3:
                                while (n.posicion + dado != 24) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                break;
                            case 4:
                                while (n.posicion + dado != 11) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                break;
                            case 5:
                                while (n.posicion + dado != 25) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);

                                break;
                            case 6:
                                while (n.posicion + dado != 5) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                break;
                            case 7:
                                while (n.posicion + dado != 35) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                break;
                            case 8:
                                n.dinero = n.dinero - 150;
                                break;
                            case 9:
                                switch (Variables.njugadores) {
                                    case 2:
                                        if (n.dinero <= 50) {
                                            x.dinero = x.dinero + n.dinero;
                                            n.dinero = 0;
                                            n.estado = 1;
                                        } else {
                                            n.dinero = n.dinero - 50;
                                            x.dinero = x.dinero + 50;
                                        }

                                        break;
                                    case 3:
                                        if (n.dinero <= 100) {
                                            x.dinero = x.dinero + (n.dinero / 2);
                                            y.dinero = y.dinero + (n.dinero / 2);
                                            n.dinero = 0;
                                            n.estado = 1;
                                        } else {
                                            n.dinero = n.dinero - 100;
                                            x.dinero = x.dinero + 50;
                                            y.dinero = y.dinero + 50;
                                        }
                                        break;
                                    case 4:
                                        if (n.dinero <= 150) {
                                            x.dinero = x.dinero + (n.dinero / 3);
                                            y.dinero = y.dinero + (n.dinero / 3);
                                            z.dinero = z.dinero + (n.dinero / 3);
                                            n.dinero = 0;
                                            n.estado = 1;
                                        } else {
                                            n.dinero = n.dinero - 150;
                                            x.dinero = x.dinero + 50;
                                            y.dinero = y.dinero + 50;
                                            z.dinero = z.dinero + 50;
                                        }
                                }
                                break;
                            case 10:
                                n.dinero = n.dinero + 50;
                                break;
                            case 11:
                                //Salir de la carcel gratis
                                break;
                            case 12:
                                //Esto toca arreglarlo pq retroceder tres casillas no está bién implementado, por ahora da la vuelta completa
                                /*while (n.posicion + dado != n.posicion - 3) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                n.dinero = n.dinero - 200;*/
                                break;
                            case 13:
                                if (n.dinero <= 15) {
                                    n.dinero = 0;
                                    n.estado = 1;
                                } else {
                                    n.dinero = n.dinero - 15;
                                }
                                break;
                            case 14:
                                while (n.posicion + dado != 28) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        mover(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                mover(dado, ficha, n);
                                break;
                            case 15:
                                //Vaya pa la carcel implementar esa porqueria
                                while (n.posicion + dado != 10) {
                                    dado++;
                                    if (dado + n.posicion == 40) {
                                        moversin(dado, ficha, n);
                                        dado = 0;
                                    }
                                }
                                moversin(dado, ficha, n);
                                n.estado = 2;
                                break;

                        }

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

    public void mover(int dado, JLabel rojo, Jugadores a) {
        //MOVIMIENTO DE UNA FICHA
        if ((a.posicion + dado >= 11 && a.posicion < 19) && a.posicion <= 10) { //para cuando dé la primera vuelta
            if (a.posicion + dado != 11) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 11);
            }
            //Si casualmente cae en 11 ya se situe acá
            a.x = 35;
            a.y = 540;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 21 && a.posicion < 29) && (a.posicion <= 19 && a.posicion > 10)) { //Para cuando de la primer vuelta
            if (a.posicion + dado != 21) {
                do {
                    a.posicion++;
                    dado--;

                } while (a.posicion != 21);
            }
            //Si casualmente cae en 21 ya se situe acá
            a.x = 90;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 31 && a.posicion < 39) && (a.posicion <= 29 && a.posicion > 20)) {
            if (a.posicion + dado != 31) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 31);
            }
            a.x = 585;
            a.y = 95;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 41) && (a.posicion <= 39 && a.posicion > 30)) {
            if (a.posicion + dado != 41) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 41);

            }
            a.posicion = 1;
            a.x = 585 - 55;
            a.y = 603;
            rojo.setBounds(a.x, a.y, 35, 57);
            JOptionPane.showMessageDialog(null, "Gana 200");
            a.dinero = a.dinero + 200; // se le añade a la plata, los 200 de la salida 
        }

        a.posicion = a.posicion + dado; //Ya suma la pos del jugador con el dado
        if (a.posicion >= 0 && a.posicion <= 9) { //Si cae entre la a la 9
            a.x = a.x - (55 * dado);//mover x 55 pixeles
            rojo.setBounds(a.x, a.y, 35, 57);

        }
        if (a.posicion == 10) { // Si cae en la 10
            a.x = 35;
            rojo.setBounds(a.x, a.y, 35, 57);

        }
        if (a.posicion >= 12 && a.posicion <= 19) { //Si cae en la 12 a 19
            a.y = a.y - (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 20) { //Si cae en la 20
            a.x = 35;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion >= 22 && a.posicion <= 29) { //Si cae de la 22 a la 29
            a.x = a.x + (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 30) {
            a.x = 585;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion >= 32 && a.posicion <= 39) { //Si cae de la 32 a la 39
            a.y = a.y + (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 40) {
            a.posicion = 0;
            a.x = 585;
            a.y = 603;
            rojo.setBounds(a.x, a.y, 35, 57);
            JOptionPane.showMessageDialog(null, "Gana 200");
            a.dinero = a.dinero + 200; // se le añade a la plata, los 200 de la salida 
        }

    }

    public void moversin(int dado, JLabel rojo, Jugadores a) {
        //MOVIMIENTO DE UNA FICHA
        if ((a.posicion + dado >= 11 && a.posicion < 19) && a.posicion <= 10) { //para cuando dé la primera vuelta
            if (a.posicion + dado != 11) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 11);
            }
            //Si casualmente cae en 11 ya se situe acá
            a.x = 35;
            a.y = 540;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 21 && a.posicion < 29) && (a.posicion <= 19 && a.posicion > 10)) { //Para cuando de la primer vuelta
            if (a.posicion + dado != 21) {
                do {
                    a.posicion++;
                    dado--;

                } while (a.posicion != 21);
            }
            //Si casualmente cae en 21 ya se situe acá
            a.x = 90;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 31 && a.posicion < 39) && (a.posicion <= 29 && a.posicion > 20)) {
            if (a.posicion + dado != 31) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 31);
            }
            a.x = 585;
            a.y = 95;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if ((a.posicion + dado >= 41) && (a.posicion <= 39 && a.posicion > 30)) {
            if (a.posicion + dado != 41) {
                do {
                    a.posicion++;
                    dado--;
                } while (a.posicion != 41);

            }
            a.posicion = 1;
            a.x = 585 - 55;
            a.y = 603;
            rojo.setBounds(a.x, a.y, 35, 57);

        }

        a.posicion = a.posicion + dado; //Ya suma la pos del jugador con el dado
        if (a.posicion >= 0 && a.posicion <= 9) { //Si cae entre la a la 9
            a.x = a.x - (55 * dado);//mover x 55 pixeles
            rojo.setBounds(a.x, a.y, 35, 57);

        }
        if (a.posicion == 10) { // Si cae en la 10
            a.x = 35;
            rojo.setBounds(a.x, a.y, 35, 57);

        }
        if (a.posicion >= 12 && a.posicion <= 19) { //Si cae en la 12 a 19
            a.y = a.y - (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 20) { //Si cae en la 20
            a.x = 35;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion >= 22 && a.posicion <= 29) { //Si cae de la 22 a la 29
            a.x = a.x + (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 30) {
            a.x = 585;
            a.y = 40;
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion >= 32 && a.posicion <= 39) { //Si cae de la 32 a la 39
            a.y = a.y + (55 * dado);
            rojo.setBounds(a.x, a.y, 35, 57);
        }
        if (a.posicion == 40) {
            a.posicion = 0;
            a.x = 585;
            a.y = 603;
            rojo.setBounds(a.x, a.y, 35, 57);

        }

    }

    public void mostrarP(Jugadores ficha) {
        Nodo P = head;
        String res = "";
        do{
            if(P.Dueño.equals(ficha.nombre)){
                if(P.renta == 9999){
                    res = res+"Propiedad: "+P.nombre+"/ "
                        + "Renta: "+"Cuatro veces los dados"+"\n"
                        + "\n"
                        + "";
                }else{
                  res = res+"Propiedad: "+P.nombre+"/ "
                        + "Color: "+P.color+"/ "
                        + "Renta Común: "+P.renta+"/ "
                        + "Renta Monopol: "+P.rentaMonopoly+"\n"
                        + "\n"
                        + "";  
                }
                
            }
            P =P.next;
        }while (P != head);
        if(res ==""){
            JOptionPane.showMessageDialog(null, "No tienes ninguna propiedad");
        }else{
            JOptionPane.showMessageDialog(null, res);
        }
        
    }
}
