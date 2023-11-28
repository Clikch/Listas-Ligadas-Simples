
/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsaLista {

    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();

        // Insertar nodos en la lista
        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("A", "Y");
        lista.insertarDespuesDe("H", "L");

        // Imprimir la referencia del nodo buscado y la lista actual
        System.out.println("Referencia del nodo buscado: " + lista.buscarPorValor("A"));
        System.out.println("Lista actual:");
        lista.imprimir();
        System.out.println();

        // Intercambiar un nodo específico
        System.out.println("Intercambio de nodos:");
        lista.intercambiarNodo("L", "R");
        lista.imprimir();
        System.out.println();

        // Intercambiar dos nodos específicos
        System.out.println("Intercambio de nodos:");
        lista.intercambiarNodos("A", "R");
        lista.imprimir();
        System.out.println();

        // Insertar un nuevo nodo antes de otro nodo específico
        lista.insertarAntesDe("A", "P");
        System.out.println("Referencia del nodo buscado: " + lista.buscarPorValor("A"));
        System.out.println("Lista actual:");
        System.out.print(lista);
    }
}
