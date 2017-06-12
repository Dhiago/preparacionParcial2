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
        TArbolBB otroArbol = new TArbolBB();

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
        System.out.println("Algo");
        System.out.println(unArbol.cantidadNodosNivel(0));
        System.out.println(unArbol.cantidadNodosNivel(1));
        System.out.println(unArbol.cantidadNodosNivel(2));
        //unaArbol.eliminar(19);
        //System.out.println("InOrden luego de borrar: "+unaArbol.inOrden());
        
        //leer claves desde un archivo y completar otroArbol con dichas claves y datos null
//        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/prepparcial2/claves3.txt");
//        for (String linea : lineas) {
//            //String[] datos = linea.split(",");
//            otroArbol.insertar(new TElementoAB(Integer.parseInt(linea), null));
//        }
//        
//        System.out.println("otroArbol - inOrden: " + otroArbol.inOrden());
//        System.out.println("otroArbol - tamaño: " + otroArbol.obtenerTamanio());
//        System.out.println("otroArbol - menor: " + otroArbol.obtenerMenor().getEtiqueta());
//        System.out.println("otroArbol - mayor: " + otroArbol.obtenerMayor().getEtiqueta());
//        System.out.println("otroArbol - ant del 87: " + otroArbol.obtenerAnterior(10).getEtiqueta());
//        System.out.println("otroArbol - post del 87: " + otroArbol.obtenerSiguiente(621).getEtiqueta());
//        
        
        //armar un arol con productos
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/prepparcial2/altasPrueba.txt");
        for (String linea : lineas2) {
            String[] datos = linea.split(",");
            
            Producto prod = new Producto(datos[0], datos[1]);
            prod.setPrecio(Integer.parseInt(datos[2]));
            prod.setStock(Integer.parseInt(datos[3]));
            
            otroArbol.insertar(new TElementoAB(datos[0], prod));
        }
        
        System.out.println("arbol de productos - inOrden: " + otroArbol.inOrden());
        System.out.println("arbol de productos - buscar por atributo: " + otroArbol.buscarPorAtributo("stock", 73));
    }

}
