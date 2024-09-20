package adt.bst.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilBSTimplTest {
    private FloorCeilBSTImpl floorCeilBST;

    @Before
    public void setUp(){
        this.floorCeilBST = new FloorCeilBSTImpl();
    }

    public void floorVerification(Integer[] array, Integer number, Integer returnExpected){
        assertEquals(returnExpected, floorCeilBST.floor(array, number));
    }

    public void ceilVerification(Integer[] array, Integer number, Integer returnExpected){
        assertEquals(returnExpected, floorCeilBST.ceil(array, number));
    }

    //Testes do metodo Floor

    @Test
    public void floorTest(){
        Integer[] array = new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        Integer[] arrayNulo = null;

        floorVerification(arrayNulo, -40, null);


        floorVerification(array, -41, null); // número abaixo do limite
        floorVerification(array, -40, -40); // número no limite inferior
        floorVerification(array, 6, 6);
        floorVerification(array,  -39, -40);
        floorVerification(array, 0, 0);
        floorVerification(array, 10, 9); // floor se encontra na faixa mas o número não
        floorVerification(array, 232, 232); // número no limite superior
        floorVerification(array, 300, 232); // número acima do limite superior
    }


    //Testes do metodo ceil
    @Test
    public void ceilTest(){
        Integer[] array = new Integer[]{6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer[] arrayNulo = null;

        ceilVerification(arrayNulo, -40, null);

        ceilVerification(array, 233, null); // número acima do limite
        ceilVerification(array, -41, -40); // Ceil de um número abaixo do limite
        ceilVerification(array, -100, -40);
        ceilVerification(array, 8, 9); // ceil de um número na faixa mas o número não existe
        ceilVerification(array, 23, 23);
        ceilVerification(array, 231, 232);
    }
    
}
