package orderStatisc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class QuickSelectTest {
    public QuickSelect<Integer> quick;

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
    private Integer[] vetorUnitario;

    @Before
    public void setUp(){
        this.quick = new QuickSelect<Integer>();

        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        this.vetorTamImpar = new Integer[]{10, 24, 46, -54, 32, 11, 34, 12, 13, 22, 33};
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        this.vetorValoresRepetidos = new Integer[]{4, 4, 4, 4, 4, 4, 4, 4};
        this.vetorUnitario = new Integer[]{1};
    }

    /**TESTES PARA O VETOR DE TAMANHO PAR */

    @Test
    public void firstOrdersStatiscsVetorTamPar(){
        assertEquals((Integer) (-1),quick.quickSelect(vetorTamPar, 1));
    }

    @Test
    public void lastOrderStatiscsVetorTamPar(){
        assertEquals((Integer) 28, quick.quickSelect(vetorTamPar, 10));
    }

    @Test
    public void middleOrderStatiscsVetorTamPar(){
        assertEquals((Integer) 4, quick.quickSelect(vetorTamPar, 5));
    }

    //Estatistica de ordem acima da faixa.

    @Test
    public void aboveRangeVetorTamPar(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 11));
    }

    //Estatistica de ordem abaixo da faixa.

    @Test
    public void bellowRangeVetorTamPar(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 0));
    }

    /*TESTES PARA O VETOR DO TAMANHO IMPAR*/
    
    @Test
    public void firstOrdersStatiscsVetorTamImpar(){
        assertEquals((Integer) (-54),quick.quickSelect(vetorTamImpar, 1));
    }

    @Test
    public void lastOrderStatiscsVetorTamImpar(){
        assertEquals((Integer) 46, quick.quickSelect(vetorTamImpar, 11));
    }

    @Test
    public void middleOrderStatiscsVetorTamImpar(){
        assertEquals((Integer) 13, quick.quickSelect(vetorTamImpar, 5));
    }

    //Estatistica de ordem acima da faixa.

    @Test
    public void aboveRangeVetorTamImpar(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamImpar, 12));
    }

    //Estatistica de ordem abaixo da faixa.

    @Test
    public void bellowRangeVetorTamImpar(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamImpar, 0));
    }

    
    //TESTES PARA VETORES COM ELEMENTOS IGUAIS// 

    @Test
    public void firstOrdersStatiscsVetorValoresIguais(){
        assertEquals((Integer) (-1),quick.quickSelect(vetorValoresIguais, 1));
    }

    @Test
    public void lastOrderStatiscsVetorValoresIguais(){
        assertEquals((Integer) 68, quick.quickSelect(vetorValoresIguais, 9));
    }

    @Test
    public void middleOrderStatiscsVetorValoresIguais(){
        assertEquals((Integer) 1, quick.quickSelect(vetorValoresIguais, 4));
    }

    //Estatistica de ordem acima da faixa.

    @Test
    public void aboveRangeVetorValoresIguais(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 11));
    }

    //Estatistica de ordem abaixo da faixa.

    @Test
    public void bellowRangeVetorValoresIguais(){
        assertEquals((Integer) null, quick.quickSelect(vetorTamPar, 0));
    }

    /**TESTES PARA O VETOR COM ELEMENTOS TODOS OS ELEMENTOS IGUAIS */

    @Test
    public void firstOrdersStatiscsVetorValoresRepetidos(){
        assertEquals((Integer)4,quick.quickSelect(vetorValoresRepetidos, 1));
    }

    @Test
    public void lastOrderStatiscsVetorValoresRepetidos(){
        assertEquals((Integer)4,quick.quickSelect(vetorValoresRepetidos, 8));
    }

    @Test
    public void middleOrderStatiscsVetorValoresRepetidos(){
        assertEquals((Integer) 4, quick.quickSelect(vetorValoresRepetidos, 4));
    }

    /*TESTES PARA UM VETOR UNITÁRIO */

    @Test
    public void firstOrderStatiscsVetorUnitario(){
        assertEquals((Integer)1, quick.quickSelect(vetorUnitario, 1));
    }

    @Test
    public void aboveRangeOrderStatiscsVetorUnitario(){
        assertEquals((Integer)null, quick.quickSelect(vetorUnitario, 2));
    }

    @Test
    public void bellowRangeOrderStatiscsVetorUnitario(){
        assertEquals((Integer)null, quick.quickSelect(vetorUnitario, 0));
    }

    /**TESTES PARA UM VETOR VAZIO*/

    @Test
    public void vetorVazio(){
        assertEquals((Integer) null, quick.quickSelect(vetorVazio, 1));
    }
}
