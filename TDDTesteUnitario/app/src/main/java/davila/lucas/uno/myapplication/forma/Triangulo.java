package davila.lucas.uno.myapplication.forma;

public class Triangulo extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO = 3;

    /*public Triangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Triangulo(){
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO);
    }

    @Override
    public double area() {
        double perimetro = getMedida(0) + getMedida(1) + getMedida(2);

        double semiPerimetro = perimetro / 2;

        double area = semiPerimetro * (semiPerimetro - getMedida(0)) *
                (semiPerimetro - getMedida(1)) *
                (semiPerimetro - getMedida(2));

        return Math.sqrt(area);
    }
}
