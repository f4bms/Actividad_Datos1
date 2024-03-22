import java.util.NoSuchElementException;

public class IteradorLista {
    private Nodo actual;

    public IteradorLista(Nodo cabeza) {
        this.actual = cabeza;
    }
    public boolean hasNext() {
        return actual != null;
    }
    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        int dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}
