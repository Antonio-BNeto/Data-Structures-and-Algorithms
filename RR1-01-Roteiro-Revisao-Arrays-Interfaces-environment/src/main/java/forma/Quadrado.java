package forma;

public class Quadrado implements Forma {
    private float lado;

    public Quadrado(float lado){
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return lado*lado;
    }
    
}
