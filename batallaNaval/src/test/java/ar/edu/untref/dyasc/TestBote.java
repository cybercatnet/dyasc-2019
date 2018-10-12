package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TestBote {

    @Test
    public void CreamosUnBoteYConsultamosLaLasCoordenadasDeLaUnicaPosicionQuePosee() {
        Bote bote = new Bote(1, 3);
        
        Posicion posicion = bote.getPosiciones().get(0);
        
        Assert.assertEquals(1, posicion.x);
        Assert.assertEquals(3, posicion.y);
    }
}