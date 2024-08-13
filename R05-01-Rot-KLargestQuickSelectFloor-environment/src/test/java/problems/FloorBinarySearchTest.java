package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FloorBinarySearchTest {
    private FloorBinarySearchImpl floorBinarySearch;

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresIguais;
    private Integer[] vetorDoisValores;
    private Integer[] vetorUnitario;
 
    @Before
    public void setUp(){
        this.floorBinarySearch = new FloorBinarySearchImpl();
        this.vetorTamPar = new Integer[]{0, 1, 3, 4, 10, -1, 28, 13, 8, 20};
        //[-1, 0, 1, 3, 4, 8, 10, 13, 20, 28]
        this.vetorTamImpar = new Integer[]{10, 24, 46, -54, 32, 11, 34, 12, 13, 22, 33};
        //[-54, 10, 11, 12, 13, 22, 24, 32, 33, 34, 46]
        this.vetorValoresIguais = new Integer[]{1, 2, 4, 5, 1, 68, -1, 2, 1};
        //[-1, 1, 1, 1, 2, 2, 4, 5, 68]
        this.vetorDoisValores = new Integer[]{0, 20};
        //[0, 1]
        this.vetorUnitario = new Integer[]{18};
        //[18]
    }

    /** TESTES PARA UM VETOR DE TAMANHO PAR */

    //Primeiro floor do array de tamanho par
    @Test
    public void firstFloorVetorTamPar(){
        assertEquals((Integer)(-1), floorBinarySearch.floor(vetorTamPar, -1));
    }

    //Ultimo floor do array do tamanho par.
    @Test
    public void lastFloorVetorTamPar(){
        assertEquals((Integer) 28, floorBinarySearch.floor(vetorTamPar, 28));
    }

    //floor do elemento que se encontra no meio do array.
    @Test
    public void middleFloorVetorTamPar(){
        assertEquals((Integer) 4, floorBinarySearch.floor(vetorTamPar, 4));
    }

    //Acima do ultimo floor do array de tamanho par.
    @Test
    public void aboveTheLastFloorVetorTamPar(){
        assertEquals((Integer) 28,floorBinarySearch.floor(vetorTamPar, 30));
    }

    //Abaixo do primeiro floor do array de tamanho par.
    @Test
    public void belowTheFirstFloorVetorTamPar(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorTamPar, -2));
    }

    //Floor do x = null.

    @Test
    public void xNullVetorPar(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorTamPar, null));
    }

    //Penultimo elemento.
    @Test
    public void penultimateFloorVetorTamPar(){
        assertEquals((Integer) 20, floorBinarySearch.floor(vetorTamPar, 20));
    }

    //Segundo elemento.
    @Test
    public void secondFloorVetorTamPar(){
        assertEquals((Integer)0,floorBinarySearch.floor(vetorTamPar, 0));
    }

    //floor de um elemento que não existe no array mas está na faixa.

    @Test
    public void elementNotExistButIsRangeVetorTamPar(){
        assertEquals((Integer) 4, floorBinarySearch.floor(vetorTamPar, 5));
    }

    /** TESTES PARA UM VETOR DE TAMANHO ÍMPAR */

    // Primeiro floor do array de tamanho ímpar.
    @Test
    public void firstFloorVetorTamImpar(){
        assertEquals((Integer)(-54),floorBinarySearch.floor(vetorTamImpar, -54));
    }

    // Ultimo floor do array de tamanho ímpar.

    @Test
    public void lastFloorVetorTamImpar(){
        assertEquals((Integer) 46,floorBinarySearch.floor(vetorTamImpar, 46));
    }

    // Floor do elemeto que está no meio do array de tamanho ímpar.
    @Test
    public void middleFloorVetorTamImpar(){
        assertEquals((Integer) 13, floorBinarySearch.floor(vetorTamImpar, 13));
    }    

    //Floor de um elemento que está acima do maior elemento do array.
    @Test
    public void aboveTheLastFloorVetorTamImpar(){
        assertEquals((Integer) 46, floorBinarySearch.floor(vetorTamImpar, 50));
    }

    //Floor de um elemento abaixo do menor elemento do array.
    @Test
    public void bellowTheFirstFloorVetorTamImpar(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorTamImpar, -55));
    }

    //Floor x = null.

    @Test
    public void xNullVetorImpar(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorTamImpar, null));
    }

    // Floor do penultimo elemento do array.
    @Test
    public void penultimateFloorVetorTamImpar(){
        assertEquals((Integer) 34, floorBinarySearch.floor(vetorTamImpar, 34));
    }

    // Floor do segundo elemento do array.
    @Test
    public void secondFloorVetorTamImpar(){
        assertEquals((Integer) 10 , floorBinarySearch.floor(vetorTamImpar, 10));
    }

    // Floor de um elmento que não existe no array mas se encontra no intervalo.
    @Test
    public void elementNotExistButIsRangeVetorTamImpar(){
        assertEquals((Integer) 34, floorBinarySearch.floor(vetorTamImpar, 35));
    }
    
    /**TESTES PARA UM VETOR COM VALORES IGUAIS */

    // Primeiro floor do array de valores iguais.
    @Test
    public void firstFloorVetorValoresIguais(){
        assertEquals((Integer)(-1),floorBinarySearch.floor(vetorValoresIguais, -1));
    }

    // Ultimo floor do vetor de valores iguais.

    @Test
    public void lastFloorVetorValoresIguais(){
        assertEquals((Integer) 68,floorBinarySearch.floor(vetorValoresIguais, 68));
    }

    // Floor do elemeto que está no meio do vetor de valores iguais.
    @Test
    public void middleFloorVetorValoresIguais(){
        assertEquals((Integer) 1, floorBinarySearch.floor(vetorValoresIguais, 1));
    }    

    //Floor de um elemento que está acima do maior elemento do array.
    @Test
    public void aboveTheLastFloorVetorValoresIguais(){
        assertEquals((Integer) 68, floorBinarySearch.floor(vetorValoresIguais, 69));
    }

    //Floor de um elemento abaixo do menor elemento do array.
    @Test
    public void bellowTheFirstFloorVetorValoresIguais(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorValoresIguais, -2));
    }

    //Floor x = null.
    @Test
    public void xNullVetorIguais(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorValoresIguais, null));
    }

    // Floor do penultimo elemento do array.
    @Test
    public void penultimateFloorVetorValoresIguais(){
        assertEquals((Integer) 5, floorBinarySearch.floor(vetorValoresIguais, 5));
    }

    // Floor de um elmento que não existe no array mas se encontra no intervalo.
    @Test
    public void elementNotExistButIsRangeVetorValoresIguais(){
        assertEquals((Integer) 2, floorBinarySearch.floor(vetorValoresIguais, 3));
    }

    /**TESTES PARA VETOR COM APENAS DOIS ELENTOS*/

    //Floor do primeiro elemento do array.

    @Test
    public void firstFloorVetorDoisValores(){
        assertEquals((Integer) 0, floorBinarySearch.floor(vetorDoisValores, 0));
    }

    //Floor do ultimo elemento do array.

    @Test
    public void lastFloorVetorDoisValores(){
        assertEquals((Integer) 20, floorBinarySearch.floor(vetorDoisValores, 20));
    }


    //Floor de um elemento acima do maior elemento.

    @Test
    public void aboveTheLastFloorVetorDoisValores(){
        assertEquals((Integer) 20, floorBinarySearch.floor(vetorDoisValores, 21) );
    }

    //Floor de um elemento abaixo do menor elemento do array.

    @Test
    public void bellowTheFirstFloorVetorDoisValores(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorDoisValores, -1));
    }

    //Floor x = null.

    @Test
    public void xNullVetorDoisValores(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorDoisValores, null));
    }


    //Floor de um elemento que se encontra na faixa do array.

    @Test
    public void elementNotExistButIsRangeVetorDoisValores(){
        assertEquals((Integer) 0, floorBinarySearch.floor(vetorDoisValores, 10));
    }

    /**TESTES PARA UM ARRAY UNITÁRIO */

    //Floor do elemento que está no array.

    @Test
    public void floorSingleElementUnitario(){
        assertEquals((Integer) 18,floorBinarySearch.floor(vetorUnitario, 18));
    }

    //Floor de um elemento acima do elemento do array.

    @Test
    public void aboveSingleFloorVetorUnitario(){
        assertEquals((Integer)18, floorBinarySearch.floor(vetorUnitario, 19));
    }

    //Floor x = null.

    @Test
    public void xNullVetorUnitario(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorUnitario, null));
    }

    //Floor de um elemento que está abaixo do elemento.

    @Test
    public void bellowSingleFloorVetorUnitario(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorUnitario, -1));
    }

    /**TESTES DE ARRAY VAZIO */

    @Test
    public void lookingfloorInEmptyArray(){
        assertEquals((Integer) null, floorBinarySearch.floor(vetorVazio, 10));
    }

}