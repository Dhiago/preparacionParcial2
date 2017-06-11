package prepparcial2;

import java.util.LinkedList;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @param elemento
     */
    public void setHijoIzq(IElementoAB elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @param elemento
     */
    public void setHijoDer(IElementoAB elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB elemento);

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     * @return
     */
    public IElementoAB<T> eliminar(Comparable unaEtiqueta);

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * pone las etiquetas del recorrido en inorden en una linkedlist.
     *
     * @param unaLista
     */
    public void inOrden(LinkedList<Comparable> unaLista);

    /**
     * Imprime en PreOrden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * pone las etiquetas del recorrido en PreOrden en una linkedlist.
     *
     * @param listaPreorden
     */
    public void preOrden(LinkedList<Comparable> listaPreorden);

    /**
     * Imprime en PreOrden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String posOrden();

    /**
     * pone las etiquetas del recorrido en PreOrden en una linkedlist.
     *
     * @param listaPosorden
     */
    public void posOrden(LinkedList<Comparable> listaPosorden);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();

    /**
     * Retorna la altura del arbol cuya raiz es la del nodo actual.
     *
     * @return Altura del subarbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tama�o del arbol cuya raiz es la del nodo actual.
     *
     * @return Tama�o del subarbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
     *
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
     *
     * @return Cantidad de hojas del subarbol.
     */
    public int obtenerCantidadHojas();

    /**
     * Método encargad de obtener el nodo con mayor etiqueta.
     *
     * @return el nodo con la etiqueta más grande del árbol.
     */
    public IElementoAB<T> obtenerMayor();

    /**
     * Método encargado de obtener el nodo con menor etiqueta.
     *
     * @return el nodo con la etiqueta más chica del árbol.
     */
    public IElementoAB<T> obtenerMenor();

    /**
     * Método encargado de devolver el nodo anterior a una etiqueta dada.
     *
     * @param unaEtiqueta la etiqueta de la cual se desea obtener el anterior.
     * @return el elemento anterior, si existe.
     */
    public IElementoAB<T> obtenerAnterior(Comparable unaEtiqueta, IElementoAB padre);

    /**
     * Método encargado de devolver el nodo siguiente a una etiqueta dada.
     *
     * @param unaEtiqueta la etiqueta de la cual se desea obtener el siguiente.
     * @return el elemento siguiente, si existe.
     */
    public IElementoAB<T> obtenerSiguiente(Comparable unaEtiqueta, IElementoAB padre);

}
