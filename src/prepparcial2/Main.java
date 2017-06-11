/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepparcial2;

/**
 *
 * @author Dhiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolBB unaArbol = new TArbolBB();
        
        unaArbol.insertar(new TElementoAB(19, null));
        unaArbol.insertar(new TElementoAB(28, null));
        unaArbol.insertar(new TElementoAB(15, null));
        unaArbol.insertar(new TElementoAB(21, null));
        unaArbol.insertar(new TElementoAB(56, null));
        unaArbol.insertar(new TElementoAB(11, null));
        
        System.out.println("InOrden string: "+unaArbol.inOrden());
        System.out.println("InOrden linkedList: "+unaArbol.inorden());
        System.out.println("PreOrden string: "+unaArbol.preOrden());
        System.out.println("PreOrden linkedList: "+unaArbol.preorden());
        System.out.println("PosOrden string: "+unaArbol.posOrden());
        System.out.println("PosOrden linkedList: "+unaArbol.posorden());
        
        //unaArbol.eliminar(19);
        //System.out.println("InOrden luego de borrar: "+unaArbol.inOrden());
        
    }
    
}