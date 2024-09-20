package adt.heap;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatisticsHeapImpl;

public class OrderStatisticTest {
    private Comparator<Integer> comparator;
    private OrderStatisticsHeapImpl<Integer> heap;
    private Integer[] array;


    @Before
    public void setUp(){
        this.comparator = new ComparatorMaxHeap<>();
        this.heap = new OrderStatisticsHeapImpl<>();
        this.array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
    }

    @Test
    public void orderStatisticTest01(){
        Integer expected = 1;
        assertEquals(expected, heap.getOrderStatistics(array, 1));
    }

    @Test
    public void orderStatisticTest02(){
        Integer expected = 99;
        assertEquals(expected, heap.getOrderStatistics(array, 8));
    }

    @Test
    public void orderStatisticTest03(){
        assertNull(heap.getOrderStatistics(array, 9));
        assertNull(heap.getOrderStatistics(array, 19));
    }

    @Test
    public void orderStatisticTest04(){
        assertNull(heap.getOrderStatistics(array, 0));
        assertNull(heap.getOrderStatistics(array, -10));
    }

    @Test
    public void orderStatisticTest05(){
        Integer expected = 6;
        assertEquals(expected, heap.getOrderStatistics(array, 2));
    }

    @Test
    public void orderStatisticTest06(){
        Integer expected = 82;
        assertEquals(expected, heap.getOrderStatistics(array, 7));
    }
     
}
