public class ListaEnlazadaSimple {
    Nodo cabeza;

    public ListaEnlazadaSimple() {
        cabeza = null;
    }

    // Método para agregar un elemento al final de la lista
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para eliminar un elemento de la lista
    public void eliminar(int dato) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
    public void invertir() {
        Nodo previo = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = previo;
            previo = actual;
            actual = siguiente;
        }
        cabeza = previo;
    }

    // Método para insertar una lista en otra
    public void insertarLista(ListaEnlazadaSimple lista) {
        if (lista.cabeza == null) {
            return; // La lista a insertar está vacía
        }

        if (cabeza == null) {
            cabeza = lista.cabeza; // Si la lista original está vacía, simplemente copiamos la cabeza
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = lista.cabeza; // Enlazamos el último nodo de la lista original con la cabeza de la lista a insertar
        }
    }

    // Método para imprimir la lista
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato).append(" ");
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
        return sb.toString().trim();
    }

    // Método SubLista
    public ListaEnlazadaSimple SubLista(int start, int size) {
        ListaEnlazadaSimple subList = new ListaEnlazadaSimple();
        Nodo actual = cabeza;
        int count = 0;

        // Avanzar hasta la posición de inicio
        while (actual != null && count < start) {
            actual = actual.siguiente;
            count++;
        }

        // Agregar elementos a la sublista hasta alcanzar el tamaño indicado
        while (actual != null && count < start + size) {
            subList.agregar(actual.dato);
            actual = actual.siguiente;
            count++;
        }
        // Agregar ceros al final de la sublista si es necesario
        while (count < start + size) {
            subList.agregar(0);
            count++;
        }

        return subList;
    }

}
