package prepparcial2;

import java.util.LinkedList;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en InOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en InOrden del arbol
     */
    @Override
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
    }

    /**
     * @return recorrida en PreOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    /**
     * @return recorrida en PreOrden del arbol
     */
    @Override
    public LinkedList<Comparable> preorden() {
        LinkedList<Comparable> listaPreorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.preOrden(listaPreorden);
        }
        return listaPreorden;
    }

    /**
     * @return recorrida en PosOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String posOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.posOrden();
        }
    }

    /**
     * @return recorrida en PosOrden del arbol
     */
    @Override
    public LinkedList<Comparable> posorden() {
        LinkedList<Comparable> listaPosorden = new LinkedList<>();
        if (!esVacio()) {
            raiz.posOrden(listaPosorden);
        }
        return listaPosorden;
    }

    /**
     * @return True si el arbol esta vacio
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public int obtenerAltura() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerAltura();
        }
    }

    @Override
    public int obtenerTamanio() {
        if (esVacio()) {
            return 1;
        } else {
            return raiz.obtenerTamanio();
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.esVacio()) {
            return -1;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        if (this.esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }

    @Override
    public IElementoAB<T> obtenerMayor() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.obtenerMayor();
        }
    }

    @Override
    public IElementoAB<T> obtenerMenor() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.obtenerMenor();
        }
    }

    @Override
    public IElementoAB<T> obtenerAnterior(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.obtenerAnterior(unaEtiqueta, null);
        }
    }

    @Override
    public IElementoAB<T> obtenerSiguiente(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.obtenerSiguiente(unaEtiqueta, null);
        }
    }

    @Override
    public boolean verificarABB() {
        if (esVacio()) {
            return true;
        } else {
            return raiz.verificarABB();
        }
    }

    @Override
    public int cantidadNodosNivel(int nivel) {
        if (raiz != null){
            return raiz.cantidadNodosNivel(nivel, raiz);
        }
        else{
            return 0;
        }
    }

    @Override
    public int sumaValorEtiquetas() {
        if (raiz != null){
            return raiz.sumaValorEtiquetas();
        }
        else{
            return 0;
        }
    }

    @Override
    public int cantNodosInternos() {
        if (raiz != null){
            return raiz.cantNodosInternos();
        }
        else{
            return 0;
        }
    }

    @Override
    public LinkedList<Comparable> buscarPorAtributoCasteo(String nombreAtributo, Comparable valorAtributo) {
        LinkedList<Comparable> lista = new LinkedList<>();
        if (!esVacio()) {
            raiz.buscarPorAtributoCasteo(nombreAtributo, valorAtributo, lista);
        } 
        return lista;
   
    }

    @Override
    public LinkedList<Comparable> buscarPorAtributoReflection(String nombreAtributo, Comparable valorAtributo) {
        LinkedList<Comparable> lista = new LinkedList<>();
        if (!esVacio()) {
            raiz.buscarPorAtributoReflection(nombreAtributo, valorAtributo, lista);
        } 
        return lista;
   
    }
}
