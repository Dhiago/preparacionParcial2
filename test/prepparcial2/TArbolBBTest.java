/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepparcial2;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Before;
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
        cargaArbolInicial();
    }

    /**
     * Test of insertar method, of class TArbolBB.
     */
    @Test
    public void testInsertar() {
        //Casos correctos
        assertTrue(unArbol.insertar(new TElementoAB(29, null)));
        assertTrue(unArbol.insertar(new TElementoAB(38, null)));
        assertTrue(unArbol.insertar(new TElementoAB(25, null)));
        assertTrue(unArbol.insertar(new TElementoAB(31, null)));
        assertTrue(unArbol.insertar(new TElementoAB(66, null)));
        assertTrue(unArbol.insertar(new TElementoAB(41, null)));
        //Casos incorrectos
        assertFalse(unArbol.insertar(new TElementoAB(19, null)));
        assertFalse(unArbol.insertar(new TElementoAB(28, null)));
        assertFalse(unArbol.insertar(new TElementoAB(15, null)));
        assertFalse(unArbol.insertar(new TElementoAB(21, null)));
        assertFalse(unArbol.insertar(new TElementoAB(56, null)));
        assertFalse(unArbol.insertar(new TElementoAB(null, null)));
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
        TElementoAB elem1 = new TElementoAB(20, null);
        TElementoAB elem2 = new TElementoAB(15, null);
        TElementoAB elem3 = new TElementoAB(26, null);

        TArbolBB<Integer> otroArbol = new TArbolBB();//unArbol NO es ABB
        elem1.setHijoDer(elem2);
        elem1.setHijoIzq(elem3);
        otroArbol.insertar(elem1);

        assertEquals(true, unArbol.verificarABB());
        assertEquals(false, otroArbol.verificarABB());
    }

    public void cargaArbolInicial() {
        assertTrue(unArbol.insertar(new TElementoAB(19, null)));
        assertTrue(unArbol.insertar(new TElementoAB(28, null)));
        assertTrue(unArbol.insertar(new TElementoAB(15, null)));
        assertTrue(unArbol.insertar(new TElementoAB(21, null)));
        assertTrue(unArbol.insertar(new TElementoAB(56, null)));
        assertTrue(unArbol.insertar(new TElementoAB(11, null)));
    }
}
