/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campo_monopoly;

import java.util.Random;

/**
 *
 * @author Darwin
 */
public class Suerte {
    class Carta{
        int num;
        String info;
        Carta next;
        public Carta (int num, String info){
        this.num = num;
        this.info = info;
        this.next = null;
    }
    }
    Carta head = null;
    Carta tail = null;
    public void addCarta(int data,String name) {
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
            System.out.println( recorrer.num +"."+recorrer.info+"---->");
            recorrer = recorrer.next;
                    
        }
    }
    public void cartaRandom (){
        Random random = new Random();
        int rnum = random.nextInt((15+1))+1;
        System.out.println("El random de la suerte es: "+rnum);
       
        if (rnum == 1) {
            System.out.println(head.num+"."+head.info);
        } else {
            int cont = 1;
            Carta recorrer = head;
            do {
                recorrer = recorrer.next;
                cont++;
            } while (cont < rnum);
            System.out.println(recorrer.num+"."+recorrer.info);
        }
        //Acá va la ejecución del metodo jijiji
    }
}
