package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import adt.heap.extended.FloorCeilHeapImpl;

public class FloorCeilTest {
    private Comparator<Integer> comparator;
    private HeapImpl<Integer> heap;
    private FloorCeilHeapImpl floorceil;
    private Integer[] array;

    @Before
    public void setUp(){
        this.comparator = new ComparatorMaxHeap<Integer>();
        this.heap = new HeapImpl<Integer>(comparator);
        this.floorceil = new FloorCeilHeapImpl(comparator);
        this.array =  new Integer[] {82, 6, 99, 12, 34, 64, 58, 1};
    }

    //Testes do metodo floor

    @Test
    public void floorTest01(){
        assertNull(floorceil.floor(array, 0));
    }

    @Test
    public void floorTest02(){
        Integer expected = 99;
        assertEquals(expected, floorceil.floor(array, 100));
    }

    @Test
    public void floorTest03(){
        Integer expected = 1;
        assertEquals(expected, floorceil.floor(array, 2));
    }

    @Test
    public void floorTest04(){
        Integer expected = 6;
        assertEquals(expected, floorceil.floor(array, 7));
    }

    @Test
    public void floorTest05(){
        Integer expected = 64;
        assertEquals(expected, floorceil.floor(array, 65));
    }

    //Testes para o metodo ceil

    @Test
    public void ceilTest01(){
        Integer expected = 1;
        assertEquals(expected, floorceil.ceil(array, 0));
    }

    @Test
    public void ceilTest02(){
        assertNull(floorceil.ceil(array, 100));
    }

    @Test
    public void ceilTest03(){
        Integer expected = 6;
        assertEquals(expected, floorceil.ceil(array, 5));
    }

    @Test
    public void ceilTest04(){
        Integer expected = 6;
        assertEquals(expected, floorceil.ceil(array, 6));
    }

}
