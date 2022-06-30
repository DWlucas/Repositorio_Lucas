package davila.lucas.uno.myapplication.forma;

//a classe abstrata possui um ou mais métodos abstratos
public abstract class Forma {
    private double[] numeroDeMedidas;
    private int TAMANHO_MAXIMO = 3;

    public Forma(int numMedidas) {
        numeroDeMedidas = new double[numMedidas]; // aloca array de medidas
    }

    public double getMedida(int posicao) {
        if(posicao >=0 && posicao <= TAMANHO_MAXIMO){
            return numeroDeMedidas[posicao];
        } else {
            throw new RuntimeException("Número inválido para cálculo de área.");
        }
    }

    public void setMedida(int posicao, double medida) {
        numeroDeMedidas[posicao] = medida;

    }

    //método abstrato - implica na impossibilidade de instanciação de objetos da classe
    //as subclasses SÓ podem ser instanciadas quando todos os métodos abstratos forem implementados
    //método abstrato deve ser público - não possui {}
    public abstract double area();

    //tentar instanciar um obj de uma classe abstrata gera erro de compilação
}