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
        TArbolBB unArbol = new TArbolBB();

        unArbol.insertar(new TElementoAB(19, null));
        unArbol.insertar(new TElementoAB(28, null));
        unArbol.insertar(new TElementoAB(15, null));
        unArbol.insertar(new TElementoAB(21, null));
        unArbol.insertar(new TElementoAB(56, null));
        unArbol.insertar(new TElementoAB(11, null));

        System.out.println("InOrden string: " + unArbol.inOrden());
        System.out.println("InOrden linkedList: " + unArbol.inorden());
        System.out.println("PreOrden string: " + unArbol.preOrden());
        System.out.println("PreOrden linkedList: " + unArbol.preorden());
        System.out.println("PosOrden string: " + unArbol.posOrden());
        System.out.println("PosOrden linkedList: " + unArbol.posorden());

        System.out.println(unArbol.obtenerMayor().getEtiqueta());
        System.out.println(unArbol.obtenerMenor().getEtiqueta());

        System.out.println(unArbol.obtenerAnterior(28).getEtiqueta());
        System.out.println(unArbol.obtenerAnterior(56).getEtiqueta());
        System.out.println("Algo");
        System.out.println(unArbol.obtenerSiguiente(19).getEtiqueta());
        System.out.println(unArbol.obtenerSiguiente(15).getEtiqueta());

        //unaArbol.eliminar(19);
        //System.out.println("InOrden luego de borrar: "+unaArbol.inOrden());
    }

}
