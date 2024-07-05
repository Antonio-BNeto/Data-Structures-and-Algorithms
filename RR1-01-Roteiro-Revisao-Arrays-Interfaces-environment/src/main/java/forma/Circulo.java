package forma;

public class Circulo implements Forma{
    private float raio;

    public Circulo(float raio){
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return Math.PI*raio*raio;
    }
    
}
