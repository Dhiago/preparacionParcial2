package prepparcial2;

import static java.lang.Integer.max;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.ListAdapter;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean insertar(IElementoAB unElemento) {
        if (unElemento.getEtiqueta() != null) {
            if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    return getHijoIzq().insertar(unElemento);
                } else {
                    hijoIzq = unElemento;
                    return true;
                }
            } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                    return getHijoDer().insertar(unElemento);
                } else {
                    hijoDer = unElemento;
                    return true;
                }
            } else {
                // ya existe un elemento con la misma etiqueta.-
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private IElementoAB quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }

        //tiene los dos hijos, buscamos el lexicograficamente anterior
        IElementoAB elHijo = hijoIzq;
        IElementoAB elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }

    /**
     * @recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    /**
     * @return recorrida en PreOrden del subArbol que cuelga del elemento actual
     */
    @Override
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @param unaLista
     * @recorrida en PreOrden del subArbol que cuelga del elemento actual
     */
    @Override
    public void preOrden(LinkedList<Comparable> unaLista) {
        unaLista.add(this.getEtiqueta());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }

    /**
     * @return recorrida en PreOrden del subArbol que cuelga del elemento actual
     */
    @Override
    public String posOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().posOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().posOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    /**
     * @param unaLista
     * @recorrida en PreOrden del subArbol que cuelga del elemento actual
     */
    @Override
    public void posOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.posOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.posOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerAltura() {
        int A = -1;
        int B = -1;
        if (hijoIzq != null) {
            A = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            B = hijoDer.obtenerAltura();
        }
        return 1 + max(A, B);
    }

    @Override
    public int obtenerTamanio() {
        int cantidad = 0;
        if (this.hijoIzq != null) {
            cantidad += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            cantidad += hijoDer.obtenerTamanio();
        }
        return cantidad + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = 0;
        if (this.buscar(unaEtiqueta) == null) {
            return -1;
        } else {
            if (this.etiqueta == unaEtiqueta) {
                return 0;
            } else {
                if (this.etiqueta.compareTo(unaEtiqueta) > 0) {      //etiqueta > unaEtiqueta
                    nivel += 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                } else {
                    nivel += 1 + hijoDer.obtenerNivel(unaEtiqueta);
                }
            }
            return nivel;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        int cantidadDeHojas = 0;
        if (hijoIzq != null && hijoDer != null) {
            cantidadDeHojas += hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        } else {
            if (hijoIzq != null) {
                cantidadDeHojas += hijoIzq.obtenerCantidadHojas();
            } else {
                if (hijoDer != null) {
                    cantidadDeHojas += hijoDer.obtenerCantidadHojas();
                } else {
                    cantidadDeHojas += 1;
                }
            }
        }
        return cantidadDeHojas;
    }

    @Override
    public IElementoAB<T> obtenerMayor() {
        if (this.hijoDer == null) {
            return this;
        } else {
            return hijoDer.obtenerMayor();
        }
    }

    @Override
    public IElementoAB<T> obtenerMenor() {
        if (this.hijoIzq == null) {
            return this;
        } else {
            return hijoIzq.obtenerMenor();
        }
    }

    @Override
    public IElementoAB<T> obtenerAnterior(Comparable unaEtiqueta, IElementoAB unPadre) {
        if (sonIguales(this.getEtiqueta(), unaEtiqueta)) {
            if (hijoIzq != null) {
                return hijoIzq.obtenerMayor();
            } else {
                if (unPadre != null) {
                    return unPadre;
                } else {
                    return null;
                }
            }
        } else {
            if (esMenor(unaEtiqueta, this.getEtiqueta())) {
                if (hijoIzq != null) {
                    return hijoIzq.obtenerAnterior(unaEtiqueta, unPadre);
                } else {
                    return null;
                }
            } else {
                if (hijoDer != null) {
                    return hijoDer.obtenerAnterior(unaEtiqueta, this);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public IElementoAB<T> obtenerSiguiente(Comparable unaEtiqueta, IElementoAB unPadre) {
        if (sonIguales(this.getEtiqueta(), unaEtiqueta)) {
            if (hijoDer != null) {
                return hijoDer.obtenerMenor();
            } else {
                if (unPadre != null) {
                    return unPadre;
                } else {
                    return null;
                }
            }
        } else {
            if (esMenor(unaEtiqueta, this.getEtiqueta())) {
                if (hijoIzq != null) {
                    return hijoIzq.obtenerSiguiente(unaEtiqueta, this);
                } else {
                    return null;
                }
            } else {
                if (hijoDer != null) {
                    return hijoDer.obtenerSiguiente(unaEtiqueta, unPadre);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public boolean verificarABB() {
        if (this.hijoIzq != null) {
            if (this.esMayor(this.getEtiqueta(), hijoIzq.getEtiqueta())) {
                hijoIzq.verificarABB();
            } else {
                return false;
            }
        }
        if (this.hijoDer != null) {
            if (this.esMenor(this.getEtiqueta(), hijoDer.getEtiqueta())) {
                hijoDer.verificarABB();
            } else {
                return false;
            }
        }
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos auxiliares">
    /**
     * Método encargado de comparar dos etiquetas y determinar si unaEtiqueta es
     * mayor a otraEtiqueta.
     *
     * @param unaEtiqueta la etiqueta que se quiere comparar.
     * @param otraEtiqueta la etiqueta contra la que se quiere comprar.
     * @return true si unaEtiqueta es mayor a otraEtiqueta.
     */
    private boolean esMayor(Comparable unaEtiqueta, Comparable otraEtiqueta) {
        return (unaEtiqueta.compareTo(otraEtiqueta) > 0);
    }

    /**
     * Método encargado de comparar dos etiquetas y determinar si unaEtiqueta es
     * menor a otraEtiqueta.
     *
     * @param unaEtiqueta la etiqueta que se quiere comparar.
     * @param otraEtiqueta la etiqueta contra la que se quiere comprar.
     * @return true si unaEtiqueta es menor a otraEtiqueta.
     */
    private boolean esMenor(Comparable unaEtiqueta, Comparable otraEtiqueta) {
        return (unaEtiqueta.compareTo(otraEtiqueta) < 0);
    }

    /**
     * Método encargado de comparar dos etiquetas y determinar si unaEtiqueta es
     * igual a otraEtiqueta.
     *
     * @param unaEtiqueta la etiqueta que se quiere comparar.
     * @param otraEtiqueta la etiqueta contra la que se quiere comprar.
     * @return true si unaEtiqueta es igual a otraEtiqueta.
     */
    private boolean sonIguales(Comparable unaEtiqueta, Comparable otraEtiqueta) {
        return (unaEtiqueta.compareTo(otraEtiqueta) == 0);
    }

    /**
     * Compara 2 enteros y devuelve el mas grande
     *
     * @param a un entero
     * @param b otro entero
     * @return b si b es mayor que a, a si a es igual o mayor que b.
     */
    private int maximo(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
    //</editor-fold>

    @Override
    public int cantidadNodosNivel(int nivel, IElementoAB raiz) {
        int A = 0;
        if (nivel == raiz.obtenerNivel(etiqueta)) {
            return 1;
        }
        if (hijoIzq != null) {
            A = A + hijoIzq.cantidadNodosNivel(nivel, raiz);
        }
        if (hijoDer != null) {
            A = A + hijoDer.cantidadNodosNivel(nivel, raiz);
        }
        return A;
    }

    @Override
    public int sumaValorEtiquetas() {
        int x = 0;
        int y = 0;
        if (hijoIzq != null) {
            x = hijoIzq.sumaValorEtiquetas();
        }
        if (hijoDer != null) {
            y = hijoDer.sumaValorEtiquetas();
        }
        return x + y + ((int) this.getEtiqueta());
    }

    @Override
    public int cantNodosInternos() {
        int x = 0;
        int y = 0;
        if (hijoIzq == null && hijoDer == null) {
            return 0;
        }
        if (hijoIzq != null) {
            x = hijoIzq.cantNodosInternos();
        }
        if (hijoDer != null) {
            y = hijoDer.cantNodosInternos();
        }
        return x + y + 1;
    }

    @Override
    public void buscarPorAtributoReflection(String nombreAtributo, Comparable valorAtributo, LinkedList<Comparable> lista) {
        if (hijoIzq != null) {
            getHijoIzq().buscarPorAtributoReflection(nombreAtributo, valorAtributo, lista);
        }

        Class<?> c = this.getDatos().getClass();
        Field f = null;
        try {
            f = c.getDeclaredField(nombreAtributo);
            f.setAccessible(true);
            String valor = f.get(this.getDatos()).toString();
            if (valor.equals(valorAtributo)) {
                lista.add((Comparable) this.getDatos());
            }
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(TElementoAB.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (hijoDer != null) {
            getHijoDer().buscarPorAtributoReflection(nombreAtributo, valorAtributo, lista);
        }
    }

    @Override
    public void buscarPorAtributoCasteo(String nombreAtributo, Comparable valorAtributo, LinkedList<Comparable> lista) {
        if (hijoIzq != null) {
            getHijoIzq().buscarPorAtributoCasteo(nombreAtributo, valorAtributo, lista);
        }

        if (sonIguales(valorAtributo, (Comparable) devolverValorCampo(nombreAtributo, (IProducto) this.getDatos()))) {
            lista.add(this.etiqueta);
        }

        if (hijoDer != null) {
            getHijoDer().buscarPorAtributoCasteo(nombreAtributo, valorAtributo, lista);
        }
    }

    private Object devolverValorCampo(String nombreAtributo, IProducto unProducto) {

        switch (normalizarNombreAtributo(nombreAtributo)) {
            case "stock":
                return unProducto.getStock();
            case "nombre":
                return unProducto.getNombre();
            case "precio":
                return unProducto.getPrecio();
            case "etiqueta":
                return unProducto.getEtiqueta();
            default:
                return unProducto.getEtiqueta();
        }
    }

    private String normalizarNombreAtributo(String nombreAtributo) {
        if (nombreAtributo != null) {
            return nombreAtributo.toLowerCase();
        } else {
            return "Debe seleccionar un nombre de atributo válido.";
        }
    }
}
