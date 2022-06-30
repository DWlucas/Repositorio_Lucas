package davila.lucas.uno.myapplication;

import org.junit.Test;

import davila.lucas.uno.myapplication.forma.Retangulo;

public class RetanguloTest {
    private static Retangulo retangulo = new Retangulo();

    RetanguloTest(){
        retangulo.setMedida(3,2);
    }

    @Test
    public void areaEPerimetroDoRetangulo(){
        retangulo.setMedida(3, 3);

        double base   = retangulo.getMedida(3);
        double altura = retangulo.getMedida(3);


        boolean x = base;
        boolean y = altura;

        assertTrue(x,y);
    }
}
