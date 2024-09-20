package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationImplTest {
    
    private SimpleBSTManipulationImpl<Integer> implementation;

    BSTImpl<Integer> tree1;
    BSTImpl<Integer> tree2;

    @Before
    public void setUp(){
        this.implementation = new SimpleBSTManipulationImpl<>();
    }

    private BSTImpl<Integer> fillTree(Integer[] array){
        BSTImpl<Integer> tree = new BSTImpl<>();
        for(Integer value: array){
            tree.insert(value);
        }

        return tree;
    }

    //Testando o metodo equals.

    @Test
    public void equalsTest01(){
        this.tree1 = null;
        this.tree2 = null;
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest02(){
        this.tree1 = new BSTImpl<>();
        this.tree2 = new BSTImpl<>();
        assertTrue(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest03(){
        this.tree1 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        this.tree2 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        assertTrue(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest04(){
        this.tree1 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        this.tree2 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -4});//Ultimo elemento do array é diferente
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest05(){
        this.tree1 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        this.tree2 = this.fillTree(new Integer[]{6});
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest06(){
        this.tree1 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        this.tree2 = new BSTImpl<>();
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest07(){
        this.tree1 = this.fillTree(new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        this.tree2 = null;
        assertFalse(this.implementation.equals(tree1, tree2));
    }

    @Test
    public void equalsTest08(){
        this.tree1 = this.fillTree(new Integer[]{});
        this.tree2 = this.fillTree(new Integer[]{});
        assertTrue(this.implementation.equals(tree1, tree2));
    }

    //Testes para o metodo isSimilar

    @Test
    public void isSimilarTest01(){
        this.tree1 = null;
        this.tree2 = null;
        assertFalse(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void isSimilarTest02(){
        this.tree1 = new BSTImpl<>();
        this.tree2 = new BSTImpl<>();
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void isSimilarTest03(){
        this.tree1 = this.fillTree(new Integer[]{1, 2});
        this.tree2 = this.fillTree(new Integer[]{1, 0});
        assertFalse(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void isSimilarTest04(){
        this.tree1 = this.fillTree(new Integer[]{1, 2, 3});
        this.tree2 = this.fillTree(new Integer[]{3, 4, 6});
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    @Test
    public void isSimilarTest05() {
        this.tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        this.tree2 = this.fillTree(new Integer[] { 5, 22, -35, 4, 8, 1, -1, 75, 11, 66, 231, -41 });
        assertTrue(this.implementation.isSimilar(tree1, tree2));
    }

    //Testes para o metodo orderStatistic

    @Test
    public void orderStatisticTest01(){
        this.tree1 = null;
        assertNull(this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void orderStatisticTest02(){
        this.tree1 = new BSTImpl<>();
        assertNull(this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void orderStatisticTest03(){
        this.tree1 = this.fillTree(new Integer[]{});
        assertNull(this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void orderStatisticTest04(){
        this.tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        Integer expected = -40;
        assertEquals(expected, this.implementation.orderStatistic(tree1, 1));
    }

    @Test
    public void orderStatisticTest05(){
        this.tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        Integer expected = 232;
        assertEquals(expected, this.implementation.orderStatistic(tree1, 12));
    }

    @Test
    public void orderStatisticTest06(){
        this.tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertNull(this.implementation.orderStatistic(tree1, 0));
    }
    @Test
    public void orderStatisticTest07(){
        this.tree1 = this.fillTree(new Integer[] { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertNull(this.implementation.orderStatistic(tree1, 13));
    }

}