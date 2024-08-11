package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import problems.FloorBinarySearchImpl;

public class FloorBinarySearchTest {
    private static final int Integer = 0;
    private FloorBinarySearchImpl implementation;
    private Integer[] array;
    private Integer[] arrayVazio;

    @Before
    public void setUp(){
        this.implementation = new FloorBinarySearchImpl();
        this.array = new Integer[] { -3, 18, 4, 15, 11, 40, 45, 21, 13, 12 };
        this.arrayVazio = new Integer[] {};
    }

    // Casos Válidos
    @Test
    public void testProblems00() {
        assertEquals(this.implementation.floor(this.array, -2), (Integer) -3);
    }

    @Test
    public void testProblems01() {
        assertEquals(this.implementation.floor(this.array, 21), (Integer) 21);
    }

    @Test
    public void testProblems02() {
        assertEquals(this.implementation.floor(this.array, 22), (Integer) 21);
    }

    @Test
    public void testProblems03() {
        assertEquals(this.implementation.floor(this.array, 14), (Integer) 13);
    }
    // Casos Inválidos

    // Quando o elemento passado é null
    @Test
    public void testProblems04() {
        assertEquals(this.implementation.floor(this.array, null), null);
    }

    // Quando o array passado é null
    @Test
    public void testProblems05() {
        assertEquals(this.implementation.floor(null, 2), null);
    }

    // Quando o array é vazio
    @Test
    public void testProblems06() {
        assertEquals(this.implementation.floor(this.arrayVazio, 2), null);
    }

    // Quando não tem um elemento menor que o passado no parâmetro, no array
    @Test
    public void testProblems07() {
        assertEquals(this.implementation.floor(this.array, -4), null);
    }
}
