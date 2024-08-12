package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import problems.FloorBinarySearchImpl;

public class FloorBinarySearchTest {
    private FloorBinarySearchImpl floorBinarySearch;

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
    private Integer[] vetorDoisValores;
    private Integer[] vetorValoresNull;
 
    @Before
    public void setUp(){
        this.floorBinarySearch = new FloorBinarySearchImpl();
        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        this.vetorTamImpar = new Integer[]{10, 24, 46, -54, 32, 11, 34, 12, 13, 22, 33};
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        this.vetorValoresRepetidos = new Integer[]{4, 4, 4, 4, 4, 4, 4, 4};
        this.vetorDoisValores = new Integer[]{0, 1};
        this.vetorValoresNull = new Integer[]{null, null, null};
    }

    @Test
    public void test01(){
        assertEquals((Integer)(-1), floorBinarySearch.floor(vetorTamPar, -1));
    }

    @Test
    public void test02(){
        assertEquals((Integer) 0 , floorBinarySearch.floor(vetorTamPar, 0));
    }

    @Test
    public void test03(){
        assertEquals((Integer) 28, floorBinarySearch.floor(vetorTamPar, 30));
    }

    @Test
    public void test04(){
        assertEquals((Integer) 4,floorBinarySearch.floor(vetorTamPar, 5));
    }

    @Test
    public void test05(){
        assertEquals((Integer) (-54), floorBinarySearch.floor(vetorTamImpar, -53));
    }

    @Test
    public void test06(){
        assertEquals((Integer) 1, floorBinarySearch.floor(vetorTamPar, 2));
    }

    @Test
    public void test07(){
        assertEquals((Integer)(-54),floorBinarySearch.floor(vetorTamImpar, -54));
    }

    @Test
    public void test08(){
        assertEquals((Integer)(-54),floorBinarySearch.floor(vetorTamImpar, -53));
    }

    @Test
    public void test09(){
        assertEquals((Integer) 46, floorBinarySearch.floor(vetorTamImpar, 46));
    }    

    @Test
    public void test10(){
        assertEquals((Integer) 46, floorBinarySearch.floor(vetorTamImpar, 50));
    }

    @Test
    public void test11(){
        assertEquals((Integer) 22, floorBinarySearch.floor(vetorTamImpar, 22));
    }

    @Test
    public void test12(){
        assertEquals((Integer) 22, floorBinarySearch.floor(vetorTamImpar, 23));
    }

    @Test
    public void test13(){
        assertEquals((Integer) 0 , floorBinarySearch.floor(vetorDoisValores, 0));
    }

    @Test
    public void test14(){
        assertEquals((Integer) 1, floorBinarySearch.floor(vetorDoisValores, 2));
    }

    @Test
    public void test15(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorDoisValores, -1));
    }

}