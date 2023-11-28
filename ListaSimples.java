
public class ListaSimples {
    Node top;

    // Método para insertar un nuevo nodo como el primer nodo de la lista
    public boolean insertaPrimerNodo(String dato) {
        if (top == null) { // La lista está vacía
            top = new Node();
            top.name = dato;
            top.next = null;
            return true;
        } else {
            return false; // No se puede insertar, la lista ya tiene un nodo
        }
    }

    // Método para insertar un nuevo nodo antes del primer nodo existente
    public void insertaAntesPrimerNodo(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
    }

    // Método para insertar un nuevo nodo al final de la lista
    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;
        Node temp2 = this.top;

        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        temp2.next = temp;
    }

    // Método para insertar un nuevo nodo con un valor específico entre dos nodos existentes
    public boolean insertaEntreNodos(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        while ((temp2 != null) && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        if (temp2 != null) { // Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            return true;
        } else {
            return false; // Nodo buscado no encontrado
        }
    }

    // Método para imprimir los valores de los nodos en la lista
    public void imprimir() {
        for (Node temp = this.top; temp != null; temp = temp.next) {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Método para devolver una representación en cadena de la lista
    public String toString() {
        StringBuilder cadAux = new StringBuilder();
        for (Node temp = this.top; temp != null; temp = temp.next) {
            cadAux.append("[ ").append(temp.name).append(" ] -> ");
        }

        cadAux.append("[X]\n");

        return cadAux.toString();
    }

    // Métodos de borrado

    // Método para borrar el primer nodo de la lista
    public void borrarPrimerNodo() {
        if (top != null) {
            this.top = this.top.next;
        }
    }

    // Método para borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado) {
        Node temp = this.top;
        Node prev = null;

        while ((temp != null) && !temp.name.equals(buscado)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) { // Nodo buscado se encontró
            if (prev != null) {
                prev.next = temp.next;
            } else {
                this.top = temp.next;
            }
            return true;
        } else {
            return false; // Nodo buscado no encontrado
        }
    }

    // Método para buscar un nodo por el valor de su campo clave y devolver una referencia
    public Node buscarPorValor(String valorBuscado) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }

        return temp; // Devuelve null si no se encuentra el nodo
    }

    // Método para insertar un nuevo nodo después de un nodo con un valor específico
    public void insertarDespuesDe(String valorBuscado, String nuevoValor) {
        Node temp = buscarPorValor(valorBuscado);
        if (temp != null) { // Si se encuentra el nodo
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;
        }
    }

    // Método para cambiar el identificador de un nodo por uno nuevo
    public boolean intercambiarNodo(String valorBuscado, String nuevoValor) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }

        if (temp != null) { // Si se encuentra el nodo
            temp.name = nuevoValor;
            return true;
        } else {
            return false; // No se encontró el nodo
        }
    }

    // Método para cambiar el identificador de un nodo con otro nodo ya creado
    public void intercambiarNodos(String valorNodo1, String valorNodo2) {
        // Buscar los nodos que se van a intercambiar
        Node nodo1 = null;
        Node nodo2 = null;
        Node temp = this.top;

        while (temp != null) {
            if (temp.name.equals(valorNodo1)) {
                nodo1 = temp;
            } else if (temp.name.equals(valorNodo2)) {
                nodo2 = temp;
            }

            temp = temp.next;
        }

        // Verificar que ambos nodos fueron encontrados
        if (nodo1 != null && nodo2 != null) {
            // Intercambiar los nodos
            String tempValue = nodo1.name;
            nodo1.name = nodo2.name;
            nodo2.name = tempValue;
        }
    }

    // Método para insertar un nuevo nodo antes de un nodo con un valor específico
    public void insertarAntesDe(String valorNodoExistente, String nuevoValor) {
        Node nuevoNodo = new Node();
        nuevoNodo.name = nuevoValor;
        // Manejar el caso especial cuando el nodo a insertar es el primero
        if (top != null && top.name.equals(valorNodoExistente)) {
            nuevoNodo.next = top;
            top = nuevoNodo;
        } else {
            Node temp = top;
            Node prev = null;
            // Buscar el nodo antes del cual se debe insertar el nuevo nodo
            while (temp != null && !temp.name.equals(valorNodoExistente)) {
                prev = temp;
                temp = temp.next;
            }

            // Insertar el nuevo nodo antes del nodo existente
            if (temp != null) {
                nuevoNodo.next = temp;
                if (prev != null) {
                    prev.next = nuevoNodo;
                } else {
                    top = nuevoNodo;
                }
            }
        }
    }
}
