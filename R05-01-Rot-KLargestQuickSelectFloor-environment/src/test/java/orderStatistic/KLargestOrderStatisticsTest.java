package orderStatistic;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderStatisticsTest {

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public KLargest<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new KLargestOrderStatisticsImpl<Integer>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

    public void genericTest(Integer[] array, int k) {
		Integer[] copy1 = {};
        Integer[] copy2 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.getKLargest(array, k);
		Arrays.sort(copy1);
        copy2 = Arrays.copyOfRange(copy1, array.length-k, array.length);
		Assert.assertArrayEquals(copy2, array);
	}

    @Test
	public void testSort01() {
		genericTest(vetorTamPar, 3);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar, 5);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio, 0);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais, 0);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos, 0);
	}


   /*  public KLargest<Integer> kLargest;
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
       assertArrayEquals(result, KLargest.getKLargest(vetorTamPar, 3));
    }
    */

}
