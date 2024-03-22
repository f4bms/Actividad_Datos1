public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        System.out.println("Lista original:");
        lista.imprimir();
        ListaEnlazadaSimple Anexo = new ListaEnlazadaSimple();
        Anexo.agregar(23);
        Anexo.agregar(24);
        Anexo.agregar(25);
        lista.insertarLista(Anexo);
        System.out.println("Lista Añadida:");
        lista.imprimir();
        lista.invertir();
        System.out.println("Lista invertida:");
        lista.imprimir();
        ListaEnlazadaSimple subLista =lista.SubLista(2,4);
        System.out.println("Sub Lista:");
        subLista.imprimir();
        System.out.println("Iterador:");
        IteradorLista iterator = new IteradorLista(lista.cabeza);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}