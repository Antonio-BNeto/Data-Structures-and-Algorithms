package adt.bst;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {
    
    private SimpleBSTManipulationImpl<Integer> implementation;

    private BSTImpl<Integer> tree1;
    private BSTImpl<Integer> tree2;
    private BSTImpl<Integer> tree3;

    private Integer[] array1;
    private Integer[] array2;
    private Integer[] array3;

    @Before
    private void setUp(){
        this.implementation = new SimpleBSTManipulationImpl<>();
        this.tree1 = new BSTImpl<Integer>();
        this.tree2 = new BSTImpl<Integer>();
        this.tree3 = new BSTImpl<Integer>();

        this.array1 = new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        this.array2 = new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
    }

    private BSTImpl<Integer> fillTree(Integer[] array){
        BSTImpl<Integer> tree = new BSTImpl<>();

        for(int i : array){
            tree.insert(i);
        }

        return tree;
    }

    @Test
    public void equalsTest01(){
        this.tree1 = null;
        this.tree2 = null;
        assertFalse(this.implementation.equals(tree1, tree2));
    }
}
