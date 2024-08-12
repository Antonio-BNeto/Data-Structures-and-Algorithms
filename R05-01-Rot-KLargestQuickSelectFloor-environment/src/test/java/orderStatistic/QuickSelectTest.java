package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSelectTest {
    public QuickSelect<Integer> quick;

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
    private Integer[] vetorDoisValores;
    private Integer[] vetorValoresNull;

    @Before
    public void setUp(){
        this.quick = new QuickSelect<Integer>();

        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        this.vetorTamImpar = new Integer[]{10, 24, 46, -54, 32, 11, 34, 12, 13, 22, 33};
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        this.vetorValoresRepetidos = new Integer[]{4, 4, 4, 4, 4, 4, 4, 4};
        this.vetorDoisValores = new Integer[]{0, 1};
        this.vetorValoresNull = new Integer[]{null, null, null};
    }

    @Test
    public void test01(){
        assertEquals((Integer) (-1),quick.quickSelect(vetorTamPar, 1));
    }

    @Test
    public void test02(){
        assertEquals((Integer) 0, quick.quickSelect(vetorTamPar, 2));
    }

    @Test
    public void test03(){
        assertEquals((Integer) 28, quick.quickSelect(vetorTamPar, 10));
    }

    @Test
    public void test04(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 11));
    }
    @Test
    public void test05(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 0));
    }

}
