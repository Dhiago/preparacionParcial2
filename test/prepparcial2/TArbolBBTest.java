/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepparcial2;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dhiago
 */
public class TArbolBBTest {

    private TArbolBB<Integer> unArbol;

    public TArbolBBTest() {
    }

    @Before
    public void setUp() {
        unArbol = new TArbolBB<>();
    }

    /**
     * Test of insertar method, of class TArbolBB.
     */
    @Test
    public void testInsertar() {
    }

    /**
     * Test of buscar method, of class TArbolBB.
     */
    @Test
    public void testBuscar() {
    }

    /**
     * Test of eliminar method, of class TArbolBB.
     */
    @Test
    public void testEliminar() {
        unArbol.insertar(new TElementoAB(19, null));
        unArbol.insertar(new TElementoAB(28, null));
        unArbol.insertar(new TElementoAB(15, null));
        unArbol.insertar(new TElementoAB(21, null));
        unArbol.insertar(new TElementoAB(56, null));
        unArbol.insertar(new TElementoAB(11, null));

        //elimino una HOJA
        unArbol.eliminar(11);

        LinkedList<Integer> lista1 = new LinkedList<>(Arrays.asList(15, 19, 21, 28, 56));
        assertEquals(lista1, unArbol.inorden());
        LinkedList<Integer> lista2 = new LinkedList<>(Arrays.asList(19, 15, 28, 21, 56));
        assertEquals(lista2, unArbol.preorden());
        LinkedList<Integer> lista3 = new LinkedList<>(Arrays.asList(15, 21, 56, 28, 19));
        assertEquals(lista3, unArbol.posorden());

        //elimino un NODO INCOMPLETO
        unArbol.insertar(new TElementoAB(11, null));
        unArbol.eliminar(15);

        LinkedList<Integer> lista4 = new LinkedList<>(Arrays.asList(11, 19, 21, 28, 56));
        assertEquals(lista4, unArbol.inorden());
        LinkedList<Integer> lista5 = new LinkedList<>(Arrays.asList(19, 11, 28, 21, 56));
        assertEquals(lista5, unArbol.preorden());
        LinkedList<Integer> lista6 = new LinkedList<>(Arrays.asList(11, 21, 56, 28, 19));
        assertEquals(lista6, unArbol.posorden());

        //elimino un NODO COMPLETO
        unArbol.insertar(new TElementoAB(15, null));
        unArbol.eliminar(19);

        LinkedList<Integer> lista7 = new LinkedList<>(Arrays.asList(11, 15, 21, 28, 56));
        assertEquals(lista7, unArbol.inorden());
        LinkedList<Integer> lista8 = new LinkedList<>(Arrays.asList(15, 11, 28, 21, 56));
        assertEquals(lista8, unArbol.preorden());
        LinkedList<Integer> lista9 = new LinkedList<>(Arrays.asList(11, 21, 56, 28, 15));
        assertEquals(lista9, unArbol.posorden());
    }

    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Test
    public void testVerificarABB() {
        TElementoAB elem1 = new TElementoAB(19, null);
        TElementoAB elem2 = new TElementoAB(15, null);
        TElementoAB elem3 = new TElementoAB(26, null);

        TArbolBB<Integer> otroArbol = new TArbolBB();       //otroArbol es ABB    
        otroArbol.insertar(new TElementoAB(1, null));
        otroArbol.insertar(new TElementoAB(31, null));
        otroArbol.insertar(new TElementoAB(18, null));

        elem1.setHijoIzq(elem3);
        elem1.setHijoDer(elem2);
        unArbol.insertar(elem1);                            //unArbol NO es ABB

        assertEquals(false, unArbol.verificarABB());
        assertEquals(true, otroArbol.verificarABB());
    }
}
