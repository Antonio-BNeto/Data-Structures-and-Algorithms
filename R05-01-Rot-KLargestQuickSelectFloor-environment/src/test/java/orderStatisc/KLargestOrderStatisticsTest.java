package orderStatisc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class KLargestOrderStatisticsTest {
    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorUnitario;

	public KLargestOrderStatisticsImpl<Integer> implementation;

	@Before
	public void setUp() {
		this.implementation = new KLargestOrderStatisticsImpl<Integer>();
		this.vetorTamPar = new Integer[]{30, 28, 29, 7, 11, 4};
		this.vetorTamImpar = new Integer[]{6, 41, 32, 7, 4};
		this.vetorUnitario = new Integer[]{18};
	}

	/*TESTES PARA CALCULAR A ESTATISTICA DE ORDEM*/

	/*VETOR COM TAMANHO PAR */

    @Test
	public void firsEstatiscsOrderVetorTamPar() {
		Integer test = implementation.orderStatistics(vetorTamPar, 1);
		Integer expected = 4;
		assertEquals(expected, test);
	}

	@Test
	public void lastEstatiscsOrderVetorTamPar() {
		Integer test = implementation.orderStatistics(vetorTamPar, 6);
		Integer expected = 30;
		assertEquals(expected, test);
	}

	@Test
	public void middleEstatiscsOrderVetorTamPar(){
		Integer test = implementation.orderStatistics(vetorTamPar, 3);
		Integer expected = 11;
		assertEquals(expected, test);
	}

	@Test
	public void aboveOrderEstatiscsVetorTamPar(){
		Integer test = implementation.orderStatistics(vetorTamPar, 7);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void	bellowOrderEstatiscsVetorTamPar(){
		Integer test = implementation.orderStatistics(vetorTamPar, 0);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void secondOrderStatiscsVetorTamPar(){
		Integer test = implementation.orderStatistics(vetorTamPar, 2);
		Integer expected = 7;
		assertEquals(expected, test);
	}

	@Test
	public void penultimateStatiscsOrderVetorTamPar(){
		Integer test = implementation.orderStatistics(vetorTamPar, 5);
		Integer expected = 29;
		assertEquals(expected, test);
	}

	/**VETOR TAMANHO IMPAR*/

	@Test
	public void firsEstatiscsOrderVetorTamImpar() {
		Integer test = implementation.orderStatistics(vetorTamImpar, 1);
		Integer expected = 4;
		assertEquals(expected, test);
	}

	@Test
	public void lastEstatiscsOrderVetorTamImpar() {
		Integer test = implementation.orderStatistics(vetorTamImpar, 5);
		Integer expected = 41;
		assertEquals(expected, test);
	}

	@Test
	public void middleEstatiscsOrderVetorTamImpar(){
		Integer test = implementation.orderStatistics(vetorTamImpar, 3);
		Integer expected = 7;
		assertEquals(expected, test);
	}

	@Test
	public void aboveOrderEstatiscsVetorTamImpar(){
		Integer test = implementation.orderStatistics(vetorTamImpar, 6);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void	bellowOrderEstatiscsVetorTamImpar(){
		Integer test = implementation.orderStatistics(vetorTamImpar, 0);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void secondOrderStatiscsVetorTamImpar(){
		Integer test = implementation.orderStatistics(vetorTamImpar, 2);
		Integer expected = 6;
		assertEquals(expected, test);
	}

	@Test
	public void penultimateStatiscsOrderVetorTamImpar(){
		Integer test = implementation.orderStatistics(vetorTamImpar, 4);
		Integer expected = 32;
		assertEquals(expected, test);
	}

	/*VETOR UNITÁRIO*/
	
	@Test
	public void statiscsOrderVetorUnitario(){
		Integer test = implementation.orderStatistics(vetorUnitario, 1);
		Integer expected = 18;
		assertEquals(expected, test);
	}

	@Test
	public void aboveStatiscsOrderVetorUnitario(){
		Integer test = implementation.orderStatistics(vetorUnitario, 2);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void bellowStatiscsOrderVetorUnitario(){
		Integer test = implementation.orderStatistics(vetorUnitario, 0);
		Integer expected = null;
		assertEquals(expected, test);
	}

	/*TESTES PARA VETOR VAZIO */

	@Test
	public void statiscsOrderVetorVazio01(){
		Integer test = implementation.orderStatistics(vetorVazio, 1);
		Integer expected = null;
		assertEquals(expected, test);
	}

	@Test
	public void statiscsOrderVetorVazio02(){
		Integer test = implementation.orderStatistics(vetorVazio, 0);
		Integer expected = null;
		assertEquals(expected, test);
	}


	/*TESTES PARA CALCULAR OS KMAIORES ELEMENTOS DO VETOR */

	/*VETOR TAMANHO PAR*/
	@Test
	public void firsKLargestVetorTamPar() {
		Comparable[] expected = new Comparable[]{30};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamPar, 1));
	}

	@Test
	public void lastKLargestVetorTamPar(){
		Comparable[] expected = new Comparable[]{30, 29, 28, 11, 7, 4};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamPar, 6));
	}

	@Test
	public void kAboveVetorTamPar(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamPar, 7));
	}

	@Test
	public void kBellowVetorTamPar(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamPar, 0));
	}

	/*VETOR TAMANHO IMPAR*/

	@Test
	public void firsKLargestVetorTamImpar() {
		Comparable[] expected = new Comparable[]{41};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamImpar, 1));
	}

	@Test
	public void lastKLargestVetorTamImpar(){
		Comparable[] expected = new Comparable[]{41, 32, 7, 6, 4};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamImpar, 5));
	}

	@Test
	public void kAboveVetorTamImpar(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamImpar, 6));
	}

	@Test
	public void kBellowVetorTamImpar(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamImpar, 0));
	}

	/*TESTES PARA VETOR UNITARIO*/

	@Test
	public void firsKLargestVetorUnitario(){
		Comparable[] expected = new Comparable[]{18};
		assertArrayEquals(expected, implementation.getKLargest(vetorUnitario, 1));
	} 

	@Test
	public void kAboveVetorUnitario(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorUnitario, 2));
	}

	@Test
	public void kBellowVetorUnitario(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorUnitario, 0));
	}

	/*TESTES PARA ARRAY VAZIO*/

	@Test
	public void largestOrderStatisticsVetorVazio01(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorVazio, 1));
	}

	@Test
	public void largestOrderStatisticsVetorVazio02(){
		Comparable[] expected = new Comparable[]{};
		assertArrayEquals(expected, implementation.getKLargest(vetorVazio, 0));
	}
}
