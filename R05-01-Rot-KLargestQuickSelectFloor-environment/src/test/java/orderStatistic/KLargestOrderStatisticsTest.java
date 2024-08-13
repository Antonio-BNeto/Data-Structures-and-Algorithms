package orderStatistic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsTest {
    public KLargestOrderStatisticsImpl<Integer> kLargest;
    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
    private Integer[] vetorDoisValores;
    private Integer[] vetorValoresNull;
 
    @Before
    public void setUp(){
        this.kLargest = new KLargestOrderStatisticsImpl<Integer>();
        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        this.vetorTamImpar = new Integer[]{10, 24, 46, -54, 32, 11, 34, 12, 13, 22, 33};
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        this.vetorValoresRepetidos = new Integer[]{4, 4, 4, 4, 4, 4, 4, 4};
        this.vetorDoisValores = new Integer[]{0, 1};
        this.vetorValoresNull = new Integer[]{null, null, null};
    }

    @Test
    public void test01(){
        Integer[] result = new Integer[]{28, 20, 13};
       // assertArrayEquals(result, KLargest.getKLargest(vetorTamPar, 3));
    }

}
