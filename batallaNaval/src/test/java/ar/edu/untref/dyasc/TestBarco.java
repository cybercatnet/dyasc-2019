package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.Enums.ResultadoDisparo;

public class TestBarco {

    @Test
    public void CreamosUnBarcoCon0PosicionesYConsultamosLaCantidadDePosicionesQueTiene() {
        Barco barco = new Barco(0, 0, 0);

        int cantidadPosiciones = barco.getPosiciones().size();

        Assert.assertEquals(0, cantidadPosiciones);
    }

    @Test
    public void CreamosUnBarcoCon3PosicionesYConsultamosLaCantidadDePosicionesQueTiene() {
        Barco barco = new Barco(0, 0, 3);

        int cantidadPosiciones = barco.getPosiciones().size();

        Assert.assertEquals(3, cantidadPosiciones);
    }

    @Test
    public void CreamosUnBarcoCon3PosicionesYConsultamosLaLasCoordenadasDeLaTerceraPosicion() {
        Barco barco = new Barco(0, 0, 3);

        Posicion terceraPosicion = barco.getPosiciones().get(2);

        Assert.assertEquals(0, terceraPosicion.x);
        Assert.assertEquals(2, terceraPosicion.y);
    }

    @Test
    public void CreamosUnBarcoCon3PosicionesYLeDisparamosAUnaPosicionDevolviendoTocado() {
        Barco barco = new Barco(0, 0, 3);

        ResultadoDisparo resultado = barco.disparar(0, 0);

        Assert.assertEquals(ResultadoDisparo.TOCADO, resultado);
    }

}