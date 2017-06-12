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

        LinkedList<Integer> lista1 = new LinkedList<>(Arrays.asList(15, 17, 19, 21, 28, 56));
        assertEquals(lista1, unArbol.inorden());
        LinkedList<Integer> lista2 = new LinkedList<>(Arrays.asList(19, 15, 17, 28, 21, 56));
        assertEquals(lista2, unArbol.preorden());
        LinkedList<Integer> lista3 = new LinkedList<>(Arrays.asList(17, 15, 21, 56, 28, 19));
        assertEquals(lista3, unArbol.posorden());

        //elimino un NODO INCOMPLETO
        unArbol.insertar(new TElementoAB(11, null));
        unArbol.eliminar(15);

        LinkedList<Integer> lista4 = new LinkedList<>(Arrays.asList(11, 17, 19, 21, 28, 56));
        assertEquals(lista4, unArbol.inorden());
        LinkedList<Integer> lista5 = new LinkedList<>(Arrays.asList(19, 11, 17, 28, 21, 56));
        assertEquals(lista5, unArbol.preorden());
        LinkedList<Integer> lista6 = new LinkedList<>(Arrays.asList(17, 11, 21, 56, 28, 19));
        assertEquals(lista6, unArbol.posorden());

        //elimino un NODO COMPLETO
        unArbol.insertar(new TElementoAB(15, null));
        unArbol.eliminar(19);

        LinkedList<Integer> lista7 = new LinkedList<>(Arrays.asList(11, 15, 17, 21, 28, 56));
        assertEquals(lista7, unArbol.inorden());
        LinkedList<Integer> lista8 = new LinkedList<>(Arrays.asList(17, 11, 15, 28, 21, 56));
        assertEquals(lista8, unArbol.preorden());
        LinkedList<Integer> lista9 = new LinkedList<>(Arrays.asList(15, 11, 21, 56, 28, 17));
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
        assertTrue(unArbol.insertar(new TElementoAB(17, null)));
    }

    /**
     * Test of inOrden method, of class TArbolBB.
     */
    @Test
    public void testInOrden() {
        LinkedList<Integer> lista1 = new LinkedList<>(Arrays.asList(11, 15, 17, 19, 21, 28, 56));
        assertEquals(lista1, unArbol.inorden());
    }

    /**
     * Test of preOrden method, of class TArbolBB.
     */
    @Test
    public void testPreOrden() {
        LinkedList<Integer> lista2 = new LinkedList<>(Arrays.asList(19, 15, 11, 17, 28, 21, 56));
        assertEquals(lista2, unArbol.preorden());
    }

    /**
     * Test of posorden method, of class TArbolBB.
     */
    @Test
    public void testPosorden() {
        LinkedList<Integer> lista3 = new LinkedList<>(Arrays.asList(11, 17, 15, 21, 56, 28, 19));
        assertEquals(lista3, unArbol.posorden());
    }

    /**
     * Test of esVacio method, of class TArbolBB.
     */
    @Test
    public void testEsVacio() {
        //Verificamos que el árbol no esté vacío.
        assertFalse(unArbol.esVacio());
        //Lo vaciamos.
        assertTrue(unArbol.vaciar());
        //Y por último verificamos que esté vacío.
        assertTrue(unArbol.esVacio());

    }

    /**
     * Test of vaciar method, of class TArbolBB.
     */
    @Test
    public void testVaciar() {
        //Verificamos que vacía correctamente el árbol.
        assertTrue(unArbol.vaciar());
        //Verificamos que no se puede vaciar dos veces seguidas.
        assertFalse(unArbol.vaciar());
    }

    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void testObtenerAltura() {
        assertEquals(2, unArbol.obtenerAltura());
    }

    /**
     * Test of obtenerTamanio method, of class TArbolBB.
     */
    @Test
    public void testObtenerTamanio() {
        assertEquals(7, unArbol.obtenerTamanio());
    }

    /**
     * Test of obtenerNivel method, of class TArbolBB.
     */
    @Test
    public void testObtenerNivel() {
        assertEquals(0, unArbol.obtenerNivel(19));
    }

    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        assertEquals(4, unArbol.obtenerCantidadHojas());
    }

    /**
     * Test of obtenerMayor method, of class TArbolBB.
     */
    @Test
    public void testObtenerMayor() {
        assertEquals(56, unArbol.obtenerMayor().getEtiqueta());
    }

    /**
     * Test of obtenerMenor method, of class TArbolBB.
     */
    @Test
    public void testObtenerMenor() {
        assertEquals(11, unArbol.obtenerMenor().getEtiqueta());
    }

    /**
     * Test of obtenerAnterior method, of class TArbolBB.
     */
    @Test
    public void testObtenerAnterior() {
        assertNull(unArbol.obtenerAnterior(11));
        assertEquals(11, unArbol.obtenerAnterior(15).getEtiqueta());
        assertEquals(15, unArbol.obtenerAnterior(17).getEtiqueta());
        assertEquals(17, unArbol.obtenerAnterior(19).getEtiqueta());
        assertEquals(19, unArbol.obtenerAnterior(21).getEtiqueta());
        assertEquals(21, unArbol.obtenerAnterior(28).getEtiqueta());
        assertEquals(28, unArbol.obtenerAnterior(56).getEtiqueta());
    }

    /**
     * Test of obtenerSiguiente method, of class TArbolBB.
     */
    @Test
    public void testObtenerSiguiente() {
        assertEquals(15, unArbol.obtenerSiguiente(11).getEtiqueta());
        assertEquals(17, unArbol.obtenerSiguiente(15).getEtiqueta());
        assertEquals(19, unArbol.obtenerSiguiente(17).getEtiqueta());
        assertEquals(21, unArbol.obtenerSiguiente(19).getEtiqueta());
        assertEquals(28, unArbol.obtenerSiguiente(21).getEtiqueta());
        assertEquals(56, unArbol.obtenerSiguiente(28).getEtiqueta());
        assertNull(unArbol.obtenerSiguiente(56));
    }

    /**
     * Test of cantidadNodosNivel method, of class TArbolBB.
     */
    @Test
    public void testCantidadNodosNivel() {
        TArbolBB unArbol = new TArbolBB();
        // Test de la cantidad de nodos la raiz es vacia.
        assertEquals(0, unArbol.cantidadNodosNivel(0));
        // Test de la cantidad de nodos en el nivel 0.
        unArbol.insertar(new TElementoAB(19, null));
        unArbol.insertar(new TElementoAB(28, null));
        unArbol.insertar(new TElementoAB(15, null));
        unArbol.insertar(new TElementoAB(21, null));
        unArbol.insertar(new TElementoAB(56, null));
        unArbol.insertar(new TElementoAB(11, null));
        assertEquals(1, unArbol.cantidadNodosNivel(0));
        // Test de la cantidad de nodos en el nivel 1.
        assertEquals(2, unArbol.cantidadNodosNivel(1));
        // Test de la cantidad de nodos en el nivel 2.
        assertEquals(3, unArbol.cantidadNodosNivel(2));
        // Test de la cantidad de nodos en un nivel mayor al del arbol
        assertEquals(0, unArbol.cantidadNodosNivel(3));
    }
    
    /**
     * Test of cantidadNodosNivel method, of class TArbolBB.
     */
    @Test
    public void testSumaValorEtiquetas() {
        //arbol con elementos
        assertEquals(167, unArbol.sumaValorEtiquetas());
        
        //arbol vacio
        TArbolBB<Integer> arbolVacio = new TArbolBB<>();
        assertEquals(0, arbolVacio.sumaValorEtiquetas());
    }
    
    /**
     * Test of cantidadNodosNivel method, of class TArbolBB.
     */
    @Test
    public void testCantNodosInternos() {
        //arbol con elementos
        assertEquals(3, unArbol.cantNodosInternos());
        
        //arbol vacio
        TArbolBB<Integer> arbolVacio = new TArbolBB<>();
        assertEquals(0, arbolVacio.cantNodosInternos());
    }
}