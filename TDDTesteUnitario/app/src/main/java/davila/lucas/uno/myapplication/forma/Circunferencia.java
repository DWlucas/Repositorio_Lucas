package davila.lucas.uno.myapplication.forma;

public class Circunferencia extends Forma{
    private static final int TAMANHO_ARRAY_INFO_CALCULO_AEREA = 1;
    private static final int POSICAO_ZERO                     = 0;
    private static final double EXPOENTE_2                    = 2;


    public Circunferencia() {
        super(TAMANHO_ARRAY_INFO_CALCULO_AEREA);
    }
    public int getTamanhoArrayInfoCalculoAerea(){
        return TAMANHO_ARRAY_INFO_CALCULO_AEREA;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getMedida(POSICAO_ZERO), EXPOENTE_2);
    }
}
