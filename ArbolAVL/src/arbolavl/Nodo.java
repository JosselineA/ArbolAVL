/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author W8
 */
public class Nodo {
    int dato, fe;
    Nodo izq;
    Nodo der;
    
    public Nodo (int d){
        this.dato=d;
        this.fe=0;
        this.izq=null;
        this.der=null;
    }
}
