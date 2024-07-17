package vetor.test.java.vetor;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.BeforeEach;
import vetor.Vetor;

public class TestVetor {
    @BeforeEach
    public void setup(){
        Vetor vetor = new Vetor(10);
        vetor.inserir(0);
        vetor.inserir(1);
        vetor.inserir(2);
        vetor.inserir(3);
        vetor.inserir(4);
        assertEquals(0, vetor.procurar(0));
    }
    
    @Test
    public void inserindoObjeto(){
        
    }
}
