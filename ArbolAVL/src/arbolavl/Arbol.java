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
public class Arbol {
    public Nodo raiz;
    
    public Arbol(){
        raiz= null;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    ///////////////Buscar//////////////////
    public Nodo buscar(int d, Nodo r){
        if(raiz==null){
            return null;
        }else if(r.dato==d){
            return r;
        }else if(r.dato<d){
            return buscar(d,r.der);
        }else{
            return buscar(d,r.izq);
        }
    }
    
    /////Insertar/////
    public void insertar(int d){
        Nodo nuevo= new Nodo(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarB(nuevo,raiz);
        }
    }
    
    ///////Insertar Balanceado////////
    public Nodo insertarB(Nodo nuevo, Nodo subAr){
        Nodo nuevoP=subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.izq==null){
                subAr.izq=nuevo;
            }else{
                subAr.izq=insertarB(nuevo,subAr.izq);
                if((getFE(subAr.izq)-getFE(subAr.der)==2)){
                    if(nuevo.dato<subAr.izq.dato){
                        nuevoP=rotacionSIzq(subAr);
                    }else{
                        nuevoP=rotacionDobleIzq(subAr);
                    }
                }
            }
        }else if(nuevo.dato>subAr.dato){
            if (subAr.der==null){
                subAr.der=nuevo;
            }else{
                subAr.der=insertarB(nuevo,subAr.der);
                if((getFE(subAr.der)-getFE(subAr.izq)==2)){
                    if(nuevo.dato>subAr.der.dato){
                        nuevoP=rotacionSDer(subAr);
                    }else{
                        nuevoP=rotacionDobleDer(subAr);
                    }
                }
            }
        }else{
            System.out.println("El nodo ya existe");
        }
        //Actualizando altura
        if((subAr.izq==null)&&(subAr.der!=null)){
            subAr.fe=subAr.der.fe+1;
        }else if((subAr.der==null)&& (subAr.izq!=null)){
            subAr.fe=subAr.izq.fe+1;
        }else{
            subAr.fe=Math.max(getFE(subAr.izq), getFE(subAr.der))+1;
        }
        return nuevoP;
    }
    
    ////////Obtener el Factor de Equilibrio////////
    public int getFE(Nodo x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    
    ////////Rotación Simple Izquierda////////
    public Nodo rotacionSIzq(Nodo c){
        Nodo aux=c.izq;
        c.izq=aux.der;
        aux.der=c;
        c.fe=Math.max(getFE(c.izq), getFE(c.der))+1;
        aux.fe=Math.max(getFE(aux.izq), getFE(aux.der))+1;
        return aux;
    }
    
    //////Rotación Simple Derecha/////
    public Nodo rotacionSDer(Nodo c){
        Nodo aux=c.der;
        c.der=aux.izq;
        aux.izq=c;
        c.fe=Math.max(getFE(c.izq), getFE(c.der))+1;
        aux.fe=Math.max(getFE(aux.izq), getFE(aux.der))+1;
        return aux;
    }
    
    /////Rotación Doble Izquierda////
    public Nodo rotacionDobleIzq(Nodo c){
        Nodo temp;
        c.izq=rotacionSDer(c.izq);
        temp=rotacionSIzq(c);
        return temp;
    }
    
    ////Rotación Doble Derecha///
    public Nodo rotacionDobleDer(Nodo c){
        Nodo temp;
        c.der=rotacionSIzq(c.der);
        temp=rotacionSDer(c);
        return temp;
    }
    
    ///Recorridos////
    public void preOrden (Nodo nodo){
        if(nodo == null)
            return;
        else{
            System.out.print (nodo.dato + " ");
            preOrden (nodo.izq);
            preOrden (nodo.der);
        }
    }

    public void inOrden (Nodo nodo){   
        if(nodo == null)
            return;
        else{
            inOrden (nodo.izq);
            System.out.print(nodo.dato + " ");
            inOrden (nodo.der);
        }
    }

    public void postOrden (Nodo nodo){
        if(nodo == null)
            return;
        else{
            postOrden (nodo.izq);
            postOrden (nodo.der);
            System.out.print (nodo.dato + " ");
        }
    }
}