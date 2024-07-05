package forma;

public class Retangulo implements Forma {
    private float base;
    private float altura;

    public Retangulo(float base, float altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return base*altura;
    }
    
}
