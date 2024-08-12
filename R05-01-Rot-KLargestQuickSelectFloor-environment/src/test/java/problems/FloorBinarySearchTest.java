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

    @Before
    public void setUp(){
        this.floorBinarySearch = new FloorBinarySearchImpl();
        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        this.vetorTamImpar = new Integer[]{10, 23, 46, -54, 32, 10, 34, 12, 13, 22, 33};
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        this.vetorValoresRepetidos = new Integer[]{4, 4, 4, 4, 4, 4, 4, 4};
        this.vetorVazio = new Integer[]{};
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

    
}