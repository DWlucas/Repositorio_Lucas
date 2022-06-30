package davila.lucas.uno.myapplication.forma;

public class Retangulo extends Forma{
    private double base   = 3;
    private double altura = 3;

    public Retangulo(int numMedidas) {
        super(numMedidas);
    }

    @Override
    public double area() {
        return 0;
    }

    //return base * altura;
    return 2* (base + altura);

}
