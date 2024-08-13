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

	public KLargestOrderStatisticsImpl<Integer> implementation;

	@Before
	public void setUp() {
		this.implementation = new KLargestOrderStatisticsImpl<Integer>();
		this.vetorTamPar = new Integer[]{30, 28, 29, 7, 11, 4};
		this.vetorTamImpar = new Integer[]{6, 41, 32, 7, 4};

		
	}

    @Test
	public void testSort01() {
		Integer test = implementation.orderStatistics(vetorTamPar, 1);
		Integer expected = 30;
		assertEquals(expected, test);
	}

	@Test
	public void testSort02() {
		Integer test = implementation.orderStatistics(vetorTamPar, 6);
		Integer expected = 4;
		assertEquals(expected, test);
	}

	@Test
	public void testSort03() {
		Integer[] expected = {28, 29, 30};
		assertArrayEquals(expected, implementation.getKLargest(vetorTamPar, 3));
	}


}
