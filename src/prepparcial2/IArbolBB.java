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
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Elimina un elemento dada una etiqueta.
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
     * Imprime en InOrden los elementos del arbol, entre parentesis y separados por coma.
     * 
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> inorden( );
    
    /**
     * Imprime en PreOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();
    
    /**
     * Imprime en PreOrden los elementos del arbol, entre parentesis y separados por coma.
     * 
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> preorden( );
    
    /**
     * Imprime en PosOrden los elementos del arbol, separados por guiones.
     *
     * @return String conteniendo el posorden separado por guiones.
     */
    public String posOrden();
    
    /**
     * Imprime en PosOrden los elementos del arbol, entre parentesis y separados por coma.
     * 
     * @return una LinkedList con las etiquetas del recorrido.
     */
    public LinkedList<Comparable> posorden( );

   /**
    * Retorna la altura del arbol.
    * @return Altura del arbol.
    */
   public int obtenerAltura();

   /**
    * Retorna el tamaño del arbol.
    * @return Tamaño del arbol.
    */
   public int obtenerTamanio();

   /**
    * Retorna el nivel del arbol a partir de la etiqueta indicada
    * @param unaEtiqueta
    * @return Nivel
    */
   public int obtenerNivel(Comparable unaEtiqueta);

   /**
    * Retorna la cantidad de hojas del arbol.
    * @return Cantidad de hojas del arbol.
    */
   public int obtenerCantidadHojas();

}