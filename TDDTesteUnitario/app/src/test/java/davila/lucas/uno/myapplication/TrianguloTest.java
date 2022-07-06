package davila.lucas.uno.myapplication;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import davila.lucas.uno.myapplication.forma.Triangulo;

public class TrianguloTest {
    private Triangulo triangulo;
    double DIFERENCA_ACEITAVEL = 0.0001;


    @Before
    public void instanciarObjeto (){
        triangulo = new Triangulo();
    }

    @Test
    public void calcularAreaDoTriangulo(){
        double areaPapel = 9.9216;

        triangulo.setMedida(0, 4);
        triangulo.setMedida(1, 5);
        triangulo.setMedida(2, 6);

        double perimetro = triangulo.getMedida(0) + triangulo.getMedida(1) +
                triangulo.getMedida(2);

        double semiPerimetro = perimetro / 2;


        double area1 = semiPerimetro * (semiPerimetro - triangulo.getMedida(0)) *
                (semiPerimetro - triangulo.getMedida(1)) *
                (semiPerimetro - triangulo.getMedida(2));

        double areaFinal = Math.sqrt(area1);

        assertEquals("A area do triangulo é: ", areaPapel, areaFinal, DIFERENCA_ACEITAVEL);

    }

}
