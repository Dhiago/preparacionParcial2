package prepparcial2;


import java.util.LinkedList;

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
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
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
            tempStr.append(getHijoIzq().preOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }
    
    /**
     * @return recorrida en PreOrden del subArbol que cuelga del elemento actual
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
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().posOrden());
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }
    
    /**
     * @return recorrida en PreOrden del subArbol que cuelga del elemento actual
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
        int cantHijoIz =0;
        int cantHijoDr = 0;
        if(hijoDer != null){
            cantHijoIz = 1+ hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){
            cantHijoDr= 1+ hijoDer.obtenerAltura();
        }
        return Integer.max(cantHijoIz, cantHijoDr);
    }

    @Override
    public int obtenerTamanio() {
        int cantidad = 0;
        if (this.hijoIzq != null){
            cantidad+= hijoIzq.obtenerTamanio();
        }
        if(hijoDer != null){
            cantidad+= hijoDer.obtenerTamanio();
        }
        return cantidad+1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        int nivel = 0;
        if (this.buscar(unaEtiqueta) == null){
            return -1;
        }else{
            if (this.etiqueta == unaEtiqueta){
                return 0;
            }else{    
                if (this.etiqueta.compareTo(unaEtiqueta) > 0){      //etiqueta > unaEtiqueta
                    nivel += 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                }else{
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

    
}