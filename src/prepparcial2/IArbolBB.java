package prepparcial2;

import java.util.LinkedList;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operaci�n
     */
    public boolean insertar(IElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del arbol.
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);
    
    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Imprime en InOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en InOrden los elementos del arbol, entre parentesis y separados
     * por coma.
     *
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> inorden();

    /**
     * Imprime en PreOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en PreOrden los elementos del arbol, entre parentesis y separados
     * por coma.
     *
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> preorden();

    /**
     * Imprime en PosOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el posorden separado por guiones.
     */
    public String posOrden();

    /**
     * Imprime en PosOrden los elementos del arbol, entre parentesis y separados
     * por coma.
     *
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> posorden();

    /**
     * Retorna la altura del arbol.
     *
     * @return Altura del arbol.
     */
    public int obtenerAltura();

    /**
     * Retorna el tamaño del arbol.
     *
     * @return Tamaño del arbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del arbol a partir de la etiqueta indicada
     *
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol.
     *
     * @return Cantidad de hojas del arbol.
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
    public IElementoAB<T> obtenerAnterior(Comparable unaEtiqueta);

    /**
     * Método encargado de devolver el nodo siguiente a una etiqueta dada.
     *
     * @param unaEtiqueta la etiqueta de la cual se desea obtener el siguiente.
     * @return el elemento siguiente, si existe.
     */
    public IElementoAB<T> obtenerSiguiente(Comparable unaEtiqueta);
    
    /**
     * Método encargado de verificar si el arbol es ABB.
     *
     * @return TRUE si es ABB.
     */
    public boolean verificarABB();
    
    public int cantidadNodosNivel(int nivel);

    /**
     * Recorre el arbol y suma el valor de la etiqueta en una variable entera
     * 
     * @return La suma de los valores de las etiquetas de todo el arbol 
     */
    public int sumaValorEtiquetas();
    
    /**
     * Recorre el arbol y cuenta la cantidad de nodos internos que tiene
     * 
     * @return La cantidad de nodos internos
     */
    public int cantNodosInternos();
    
    public LinkedList<Comparable> buscarPorAtributo(String nombreAtributo, Comparable valorAtributo);
}
