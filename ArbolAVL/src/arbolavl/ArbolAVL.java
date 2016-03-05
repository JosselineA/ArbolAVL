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
public class ArbolAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Arbol arbolAVL = new Arbol();
       arbolAVL.insertar(10);
       arbolAVL.insertar(5);
       arbolAVL.insertar(13);
       arbolAVL.insertar(1);
       arbolAVL.insertar(6);
       arbolAVL.insertar(17);
       arbolAVL.insertar(16);
       arbolAVL.preOrden(arbolAVL.getRaiz());
        System.out.println("");
       arbolAVL.inOrden(arbolAVL.getRaiz());
        System.out.println("");
       arbolAVL.postOrden(arbolAVL.getRaiz());
    }
    
}
