import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaTest {
    private ListaEnlazadaSimple lista;
    private ListaEnlazadaSimple listaA;
    private ListaEnlazadaSimple listaB;
    private ListaEnlazadaSimple listaC;

    @Before
    public void setUp() {
        lista = new ListaEnlazadaSimple();
    }
//Agregar e imprimir
    @Test
    public void testAgregarElemento() {
        lista.agregar(1);
        assertEquals("1", lista.imprimir());
    }

    @Test
    public void testAgregarElementoIgual() {
        lista.agregar(1);
        lista.agregar(1);
        assertEquals("1 1", lista.imprimir());
    }

    @Test
    public void testAgregarElementoDobleDigito() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        assertEquals("11 12 13", lista.imprimir());
    }
//Anexar e imprimir
    @Test
    public void testAnexarListasSecuencial() {
        lista.agregar(1);
        lista.agregar(2);
        ListaEnlazadaSimple listaNueva = new ListaEnlazadaSimple();
        listaNueva.agregar(3);
        listaNueva.agregar(4);
        lista.insertarLista(listaNueva);
        assertEquals("1 2 3 4",lista.imprimir());
    }
    @Test
    public void testAnexarListasAleatoria() {
        lista.agregar(1);
        lista.agregar(2);
        ListaEnlazadaSimple listaNueva = new ListaEnlazadaSimple();
        listaNueva.agregar(33);
        listaNueva.agregar(411);
        lista.insertarLista(listaNueva);
        assertEquals("1 2 33 411", lista.imprimir());
    }

    @Test
    public void testAnexarListasRandom() {
        lista.agregar(66);
        lista.agregar(99);
        ListaEnlazadaSimple listaNueva = new ListaEnlazadaSimple();
        listaNueva.agregar(0);
        listaNueva.agregar(2);
        lista.insertarLista(listaNueva);
        assertEquals("66 99 0 2", lista.imprimir());
    }

    //Invertir e imprimir
    @Test
    public void testAnexarListasRandomeEInvertir() {
        lista.agregar(66);
        lista.agregar(99);
        ListaEnlazadaSimple listaNueva = new ListaEnlazadaSimple();
        listaNueva.agregar(0);
        listaNueva.agregar(2);
        lista.insertarLista(listaNueva);
        lista.invertir();
        assertEquals("2 0 99 66", lista.imprimir());
    }

    @Test
    public void testAnexarListasRandomInvertir() {
        lista.agregar(66);
        lista.agregar(99);
        ListaEnlazadaSimple listaNueva = new ListaEnlazadaSimple();
        listaNueva.agregar(0);
        listaNueva.agregar(2);
        lista.insertarLista(listaNueva);
        lista.invertir();
        assertEquals("2 0 99 66", lista.imprimir());
    }
    @Test
    public void testAgregarElementoDobleDigitoInvertir() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.invertir();
        assertEquals("13 12 11", lista.imprimir());
    }
    @Test
    public void testEliminarPrimero() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.eliminar(11);
        assertEquals("12 13", lista.imprimir());
    }
    @Test
    public void testEliminarUltimo() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.eliminar(13);
        assertEquals("11 12", lista.imprimir());
    }
    @Test
    public void testEliminarRandom() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.agregar(15);
        lista.agregar(99);
        lista.agregar(130);
        lista.agregar(1312);
        lista.eliminar(15);
        assertEquals("11 12 13 99 130 1312", lista.imprimir());
    }
    @Test
    public void Sublista1() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.agregar(15);
        lista.agregar(99);
        lista.agregar(130);
        lista.agregar(1312);
        ListaEnlazadaSimple subLista =lista.SubLista(2,5);
        assertEquals("13 15 99 130 1312", subLista.imprimir());
    }

    @Test
    public void Sublista2() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.agregar(15);
        lista.agregar(99);
        lista.agregar(130);
        lista.agregar(1312);
        ListaEnlazadaSimple subLista =lista.SubLista(1,2);
        assertEquals("12 13", subLista.imprimir());
    }
    @Test
    public void Sublista3() {
        lista.agregar(11);
        lista.agregar(12);
        lista.agregar(13);
        lista.agregar(15);
        lista.agregar(99);
        lista.agregar(130);
        lista.agregar(1312);
        ListaEnlazadaSimple subLista =lista.SubLista(6,3);
        assertEquals("1312 0 0", subLista.imprimir());
    }
   @Before
    public void Sepup1(){
        listaA = new ListaEnlazadaSimple();
        listaA.agregar(1);
        listaA .agregar(11);
        listaA .agregar(111);
        listaA .agregar(11111);
    }
    @Test
    public void testIterator1() {

        IteradorLista iterator = new IteradorLista(listaA.cabeza);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(11, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(111, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(11111, iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Before
    public void Sepup2(){
        listaB = new ListaEnlazadaSimple();
        listaB .agregar(1);
        listaB .agregar(2);
        listaB .agregar(3);
        listaB .agregar(4);
    }
    @Test
    public void testIterator2() {
        IteradorLista iterator = new IteradorLista(listaB.cabeza);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertFalse(iterator.hasNext());
    }
    @Before
    public void Sepup3(){
        listaC = new ListaEnlazadaSimple();
        listaC.agregar(5);
        listaC.agregar(4);
        listaC.agregar(3);
        listaC.agregar(2);
    }
    @Test
    public void testIterator3() {
        IteradorLista iterator = new IteradorLista(listaC.cabeza);
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());

    }

}
