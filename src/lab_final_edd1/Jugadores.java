/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_final_edd1;

/**
 *
 * @author Emily Roldán
 */
public class Jugadores {
    int turno; //1, 2, 3, 4
    int x;
    int y;
    int posicion;
    int estado; // 0 jugando, 1 bancarrota, 2 encarcelado
    String propiedades; // esto es una lista de propiedades 
    String monopolios; // esto es una lista dependiendo de propiedades BONOOOOO
    int dinero;//empieza en 1500
    public Jugadores(int posicion, int estado, int dinero, int x, int y) {
        this.posicion = posicion;
        this.estado = estado;
        this.dinero = dinero;
        this.x = x;
        this.y = y;
    }
}
