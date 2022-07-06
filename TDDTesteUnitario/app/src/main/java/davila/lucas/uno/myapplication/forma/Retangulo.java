package davila.lucas.uno.myapplication.forma;

public class Retangulo extends Forma {
    /*private static double P = 8;
    private static double A = 4;
    private static final double BASE = 2;
    private static final double ALTURA = 2;*/

    private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO = 2;

    /*public Retangulo(int numMedidas) {
        super(numMedidas);
    }*/

    public Retangulo() {
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_RETANGULO);
    }

    @Override
    public double area() {
        return getMedida(0) * getMedida(1);
    }
}


