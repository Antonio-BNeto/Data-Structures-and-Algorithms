package forma;

public class Triangulo implements Forma{
    private float base;
    private float altura;

    public Triangulo (float base, float altura){
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calculaArea(){
        return base*altura/2;
    }
}
